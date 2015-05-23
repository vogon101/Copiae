package enjine.core.GUI

import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class GUIController {

  val buttons: ArrayBuffer[ButtonControl] = new ArrayBuffer[ButtonControl]()

  def run (): Unit = {
    println("Running...")
    render()
    update()
  }

  def update(): Unit = {

    if (Mouse.isButtonDown(0)) {
      val mx = Mouse.getX
      val my = Mouse.getY

      buttons.foreach(b => b.checkClick(mx, my, 0))
    }
  }

  def render(): Unit = {

    buttons.foreach(b => b.render())

  }

}
