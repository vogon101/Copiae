package enjine.core.Graphics

import enjine.core.DataStructures.Color3d
import enjine.core.Settings.GameSettings
import enjine.core.{Game, Transform, World}
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import org.newdawn.slick.TrueTypeFont
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 19/05/2015.
 *
 * RenderControl is used to control all of the basic rendering for the scene
 *
 * @param _gameSettings The settings to run from
 */
class RenderControl (_gameSettings: GameSettings) {

  //DONE:Make additional render Unit based
  //DONE:Make DrawBG Unit based
  //DONE:Allow texture rendering

  /**
   * Use this to render additional background
   */
  var bgRenderer: () => Unit = null


  /**
   * The settings that were used to initialise the display (i.e. SCREEN_HEIGHT)
   * @return the settings
   */
  def gameSettings = _gameSettings

  /**
   * Used to initialise the rendering (ie screen)
   *
   */
  def init () {

    try {
      initGL()
    }
    catch  {
      case e : LWJGLException => println("Could not start Graphics"); System exit 1
    }

    setCamera()
  }

  /**
   * Used to render extra things before the GUI
   */
  var addRender: () => Unit = null

  /**
   * Main update function calls the entire render process
   * Should be called once per tick
   */
  def render(world: World) {

    R.glEnableDraw()

    drawBG()
    if (bgRenderer != null)
      bgRenderer()

    world.render()
    if (addRender != null)
      addRender()
    drawGUI()
    Display.sync(30)
    Display.update()



    if (Display.isCloseRequested)
      System.exit(0)
  }

  /**
   * Draw the GUI
   */
  private def drawGUI (): Unit = {
    Game.g.GUIController.render()
  }


  /**
   * Initialise the openGL
   * call once at start
    */
  private def initGL() {
    Display.setDisplayMode(new DisplayMode(gameSettings.SCREEN_WIDTH, gameSettings.SCREEN_HEIGHT))
    Display.create()
    Display setTitle "TankWar"
    setCamera()
  }

  /**
   * Sets up the camera
   */
  private def setCamera() {

    GL11.glClearColor(1f, 1f, 1f, 1.0f)
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, gameSettings.SCREEN_WIDTH, 0, gameSettings.SCREEN_HEIGHT, 5, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glLoadIdentity()
    GL11.glViewport(0, 0, gameSettings.SCREEN_WIDTH, gameSettings.SCREEN_HEIGHT)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0,gameSettings.SCREEN_WIDTH,gameSettings.SCREEN_HEIGHT, 0, 5, -5)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glLoadIdentity()
  }

  /**
   * Draw the background
   */
  private def drawBG() {
    GL11.glPushMatrix ()
    GL11.glTranslated(0, 0, 0)
    GL11.glColor3d(0, 0, 0)
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2d(0, 0)
    GL11.glVertex2d(0, gameSettings.SCREEN_HEIGHT)
    GL11.glVertex2d(gameSettings.SCREEN_WIDTH, gameSettings.SCREEN_HEIGHT)
    GL11.glVertex2d(gameSettings.SCREEN_WIDTH, 0)
    GL11.glEnd()
    GL11.glPopMatrix()
  }
  //



}

//TODO: ALL GUI ELEMENTS NO OFFSET!!!

/**
 * Contains static methods to make rendering easier
 */
object R {

  private val rSettings = Game.g.renderer.gameSettings


  /**
   * Wrapper for glTranslated (x,y,x) for a Transform
   * @param transform The transform to translate to
   */
  def glTranslateT (transform: Transform): Unit = {
    GL11.glTranslated(transform.x, transform.y, transform.z)
  }

  /**
   * Wrapper for glTranslated (x,y,z) for a transform, taking into account the offset found in the current world, allows map moving
   * @param transform The transform to translate to
   */
  def glTranslateTOffset (transform: Transform): Unit = {
    GL11.glTranslated(transform.x-Game.w.xOffset, transform.y-Game.w.yOffset, transform.z)
  }

  /**
   * Draw a quad, can be textured or not, will draw as textured if the texture argument is not null
   * @param transform - Where to draw it
   * @param color3d - The colour to draw it
   * @param texture - The texture to draw it
   */
  def glQuad (transform: Transform, color3d: Color3d, texture: Texture, isOffset: Boolean = true): Unit = {
    if (texture != null) {
      glDrawQuadTextured(transform,texture,color3d, isOffset)
    }
    else {
      glDrawQuadUntextured(transform, color3d, isOffset)
    }
  }

  /**
   * Draw an untextured quad
   * @param transform - The box to draw
   * @param color - The colour to draw it
   */
  def glDrawQuadUntextured (transform: Transform, color: Color3d, offset:Boolean): Unit = {

    GL11.glPushMatrix ()
      if (offset)
        glTranslateTOffset(transform)
      else
        glTranslateT(transform)

      if (color != null)
        color.bind()
      else Color3d.RED.bind()

      GL11.glBegin(GL11.GL_QUADS)
        GL11.glVertex2d(0, 0)
        GL11.glVertex2d(0, transform.ySize)
        GL11.glVertex2d(transform.xSize, transform.ySize)
        GL11.glVertex2d(transform.xSize, 0)
      GL11.glEnd()
    GL11.glPopMatrix()

  }


  /**
   * Draw text
   * @param text - The text to render
   * @param trueTypeFont - The font to use
   * @param transform - Where to draw it
   */
  def glDrawText (text:String, trueTypeFont: TrueTypeFont, transform: Transform, color: Color3d = Color3d.WHITE, isOffset: Boolean = false): Unit = {
    glEnableText()
    if (isOffset)
      throw new NotImplementedError("NOT DONE YET. Come back later...")
      //trueTypeFont.drawString(transform.x.toInt+Game.w.xOffset, transform.y.toInt+Game.w.yOffset, text, color.toSlickColor)
    else
      trueTypeFont.drawString(transform.x.toInt, transform.y.toInt, text, color.toSlickColor)
    glEnableDraw()
  }

  /**
   * Enable drawing after text or textures
   */
  def glEnableDraw (): Unit = {
    GL11.glDisable(GL11.GL_TEXTURE_2D)
    GL11.glDisable(GL11.GL_BLEND)
  }

  /**
   * Draw a textured quad
   * @param transform - Where to draw it
   * @param texture - What texture to draw it
   * @param color3d - What colour to draw it
   */
  def glDrawQuadTextured (transform: Transform, texture: Texture, color3d: Color3d = Color3d.WHITE, offset: Boolean = true): Unit = {

    GL11.glPushMatrix()

      glEnableText()
        texture.bind()
        if (color3d != null)
          color3d.bind()
        if (offset)
          glTranslateTOffset(transform)
        else
          glTranslateT(transform)

        GL11.glBegin(GL11.GL_QUADS)
          GL11.glTexCoord2f(0,0)
          GL11.glVertex2f(0,0)
          GL11.glTexCoord2f(0,1)
          GL11.glVertex2d(0, transform.ySize)
          GL11.glTexCoord2f(1,1)
          GL11.glVertex2d(transform.xSize, transform.ySize)
          GL11.glTexCoord2f(1,0)
          GL11.glVertex2d(transform.xSize, 0)
        GL11.glEnd()
      glEnableDraw()

    GL11.glPopMatrix()
  }

  //private def glEnableTexture (): Unit = {
  //  glEnableDraw()
  //  GL11.glEnable(GL11.GL_TEXTURE_2D)
  //}


  private def glEnableText (): Unit = {
    GL11.glEnable(GL11.GL_TEXTURE_2D)

    GL11.glClearColor(1f,1f,1f,1.0f)

    // enable alpha blending
    GL11.glEnable(GL11.GL_BLEND)
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
  }

}

/*
UNUSED CODE FOR REFERENCE

  private def drawTank(tank: Tank) {
    val size: Double = tank.boundary.asInstanceOf[Circle].radius
    val fitness: Double = new TankEvaluator().getFitness(tank, null)
    GL11.glPushMatrix()
    GL11.glTranslated(tank.position.x, tank.position.y, 0)
    GL11.glRotated(tank.rotation.t * 180 / Math.PI, 0, 0, 1)
    GL11.glColor3d(1, 2 * fitness / TankEvaluator.higherFitness(world), 0)
    GL11.glBegin(GL11.GL_TRIANGLES)

    GL11.glVertex2d(size, 0.0)
    GL11.glVertex2d(-0.866025 * size, 0.5 * size)
    GL11.glVertex2d(-0.866025 * size, -0.5 * size)

    GL11.glEnd()
    drawCircle(new Circle(Vector2D.origin, size))
    GL11.glColor3d(0.1, 0.1, 0.1)
    val sight: Double = world.max_sight
    drawCircle(new Circle(Vector2D.origin, sight))

    GL11.glPopMatrix()
  }


    private def drawBullet(bullet: Bullet) {
    val size: Double = bullet.boundary.asInstanceOf[Circle].radius
    GL11.glPushMatrix()
    GL11.glTranslated(bullet.position.x, bullet.position.y, 0)
    GL11.glColor3d(0, 0, 1)
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2d(-size, -size)
    GL11.glVertex2d(-size, size)
    GL11.glVertex2d(size, size)
    GL11.glVertex2d(size, -size)
    GL11.glEnd()
    GL11.glPopMatrix()
  }


   * Draws an approximate Circle Circle
   *
   * Draws a circle as a regular polygon with a specific number of edges
   * Ref: http://slabode.exofire.net/circle_draw.shtml
   *
   * @param circle The circle to draw

  private def drawCircle(circle: Circle) {
    val numSegments: Int = (circle.radius * 2.0 * Math.PI).toInt
    GL11.glBegin(GL11.GL_LINE_LOOP)
    var i: Int = 0
    while (i < numSegments) {
      val theta: Double = 2.0 * Math.PI * i.toDouble / numSegments.toDouble
      val x: Double = circle.radius * Math.cos(theta)
      val y: Double = circle.radius * Math.sin(theta)
      GL11.glVertex2f((x + circle.center.x).toFloat, (y + circle.center.y).toFloat)
      i += 1; i - 1
    }
    GL11.glEnd()
  }
 */
