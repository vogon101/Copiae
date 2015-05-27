package enjine.core.Input

import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display

/**
 * Created by Freddie on 23/05/2015.
 *
 * Static class for getting input from user
 */
object Input {

  //TODO: Offset mouse clicks

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

}
