package enjine.core

import enjine.core.DataStructures.Color3d
import enjine.core.Settings.GameSettings
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}

/**
 * Created by Freddie on 19/05/2015.
 *
 * RenderControl is used to control all of the basic rendering for the scene
 *
 * @param _gameSettings The settings to run from
 */
class RenderControl (_gameSettings: GameSettings) {

  //TODO: Make rendering of BG modular (Pass Unit)
  //TODO: Add option for users to render their own objects (Pass Unit)

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
   * Main update function calls the entire render process
   * Should be called once per tick
   */
  def render(world: World) {
    setCamera()

    drawBG()

    world.render()

    //print("hi")

    drawGUI()
    Display.sync(30)
    Display.update()



    if (Display.isCloseRequested)
      System.exit(0)
  }

  private def drawGUI (): Unit = {

  }


  @throws(classOf[LWJGLException])
  private def initGL() {
    Display.setDisplayMode(new DisplayMode(gameSettings.SCREEN_WIDTH, gameSettings.SCREEN_HEIGHT))
    Display.create()
    Display setTitle "TankWar"
  }

  private def setCamera() {
    GL11.glClearColor(1f, 1f, 1f, 1.0f)
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, gameSettings.SCREEN_WIDTH, 0, gameSettings.SCREEN_HEIGHT, -1, 1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glLoadIdentity()
    GL11.glViewport(0, 0, gameSettings.SCREEN_WIDTH, gameSettings.SCREEN_HEIGHT)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, Display.getWidth, 0, Display.getHeight, 1, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glLoadIdentity()
  }








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

object R {
  def glTranslateT (transform: Transform): Unit = {
    GL11.glTranslated(transform.x, transform.y, transform.z)
  }

  def glQuad (transform: Transform, color: Color3d): Unit = {

    GL11.glPushMatrix ()
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
