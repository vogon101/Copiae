package enjine.core.Input

import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display

/**
 * Created by Freddie on 23/05/2015.
 *
 */
object Input {

  def mx =Mouse.getX
  def my =Display.getHeight-  Mouse.getY

}
