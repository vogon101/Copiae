package enjine.core.GUI

import enjine.core.DataStructures.TextStyles
import enjine.core.Input.Input
import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 * Class to control the GUI
 * @param textStyles - The text styles to be used
 *
 */
class GUIController (var textStyles: TextStyles) {

  //TODO: Merge buttons into elements then allow clickable elements that are not buttons

  /**
   * The ArrayBuffer of buttons - these are checked for clicks
   */
  val buttons: ArrayBuffer[ButtonControl] = new ArrayBuffer[ButtonControl]()
  /**
   * The ArrayBuffer of GUIElements - these are not checked for clicks but just rendered
   */
  val elements: ArrayBuffer[GUIElement] = new ArrayBuffer[GUIElement]()


  /**
   * Initialise the GUI
   * Initialises the textStyles
   */
  def init(): Unit = {
    textStyles.init()
  }

  /**
   * Update the GUI
   * Checks for clicks on buttons
   */
  def update(): Unit = {

    if (Mouse.isButtonDown(0)) {
      val mx = Input.mx
      val my = Input.my

      buttons.foreach(b => b.checkClick(mx, my, 0))
    }
  }

  /**
   * Render the GUI
   * Both elements and buttons rendered
   */
  def render(): Unit = {

    buttons.foreach(b => if (b.renderEnabled)b.render())
    elements.foreach(e => if (e.renderEnabled)e.render())

  }

}
