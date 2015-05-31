package enjine.core.DataStructures

import org.lwjgl.opengl.GL11
import org.newdawn.slick.Color

/**
 * Created by Freddie on 19/05/2015.
 *
 * Class to hold a 3-Double colour nicely
 *
 */
class Color3d (val r:Double = 0, val g:Double = 0, val b:Double = 0) {


  /**
   * Use this to bind opengl to the color (glColor3d(r,g,b))
   */
  def bind (): Unit = {
    GL11.glColor3d(r,g,b)
  }

  /**
   * @return This colour as a Slick2D color
   */
  def toSlickColor  : Color = new Color(r.toFloat, g.toFloat, b.toFloat)

}

/**
 * Holds constants that represent common colours
 */
object Color3d {
  val RED = new Color3d(1,0,0)
  val GREEN = new Color3d(0,1,0)
  val BLUE = new Color3d(0,0,1)
  val BLACK = new Color3d(0,0,0)
  val LIGHT_GREY = new Color3d(0.8,0.8,0.8)
  val DARK_GREY = new Color3d(0.2,0.2,0.2)
  val WHITE = new Color3d(1,1,1)

}
