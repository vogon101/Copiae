package enjine.core.Input

import enjine.core.Game
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display

/**
 * Created by Freddie on 23/05/2015.
 *
 * Static class for getting input from user
 * All offsets use Game.w.xOffset/yOffset
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

  /**
   * @return The offset mouse-x position
   */
  def mxo = mx + Game.w.xOffset

  /**
   * @return The offset mouse-y position
   */
  def myo = my + Game.w.yOffset

  /**
   * Turn a y with origin bottom left to one with origin top left
   * @param y The y coordinate to convert
   * @return The converted y value
   */
  def YtoUseable(y: Int) = Display.getHeight -y

  /**
   * Offset an x value
   * @param x The x to offset
   * @return The offseted x value
   */
  def XtoOffset (x: Int) = x+Game.w.xOffset

  /**
   * Offset an y value
   * @param y The y to offset
   * @return The offseted y value
   */
  def YtoOffset (y: Int) = Display.getHeight -y+Game.w.yOffset

}
