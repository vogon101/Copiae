package enjine.core.GUI

import enjine.core.DataStructures.TextStyles
import enjine.core.Input.Input
import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class GUIController {

  val buttons: ArrayBuffer[ButtonControl] = new ArrayBuffer[ButtonControl]()
  val elements: ArrayBuffer[GUIElement] = new ArrayBuffer[GUIElement]()

  val textStyles = new TextStyles

  def init(): Unit = {
    textStyles.init()
  }

  def run (): Unit = {
    println("Running...")
    render()
    update()
  }

  def update(): Unit = {

    if (Mouse.isButtonDown(0)) {
      val mx = Input.mx
      val my = Input.my

      buttons.foreach(b => b.checkClick(mx, my, 0))
    }
  }

  def render(): Unit = {

    buttons.foreach(b => if (b.renderEnabled)b.render())
    elements.foreach(e => if (e.renderEnabled)e.render())

  }

}
