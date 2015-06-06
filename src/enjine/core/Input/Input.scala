package enjine.core.Input

import enjine.core.Game
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display

/**
 * Created by Freddie on 23/05/2015.
 *
 * Static class for getting input from user
 */
object Input {

  //DONE: Offset mouse clicks

  /**
   * Get the mouse X position
   * @return mouse X position
   */
  def mx =Mouse.getX

  /**
   * Get the adjusted mouse Y position (0,0 in top right)
   * @return mouse Y position
   */
  def my =Display.getHeight-  Mouse.getY

  def mxo = mx + Game.w.xOffset
  def myo = my + Game.w.yOffset

  def YtoUseable(y: Int) = Display.getHeight -y

  def XtoOffset (x: Int) = x+Game.w.xOffset
  def YtoOffset (y: Int) = Display.getHeight -y+Game.w.yOffset

}
