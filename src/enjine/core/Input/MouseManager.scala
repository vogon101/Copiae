package enjine.core.Input

import enjine.core.Updateable
import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 29/05/2015.
 *
 */
class MouseManager extends Updateable{

  val listeners: ArrayBuffer[MouseListener] = new ArrayBuffer[MouseListener]()

  def update(): Unit = {
    while(Mouse.next()) {
      if (Mouse.getEventButton != -1) {
        val x = Input.XtoOffset(Mouse.getEventX)
        val y = Input.YtoOffset(Mouse.getEventY)
        val b = Mouse.getEventButton
        listeners.foreach(u => u.checkClick(x, y, b))
      }
    }
  }

  def addListener (mouseListener: MouseListener): Int = {listeners.append(mouseListener); listeners.indexOf(mouseListener)}

  def listener(i: Int): MouseListener = listeners.apply(i)

}
