package enjine.core.GUI

import enjine.core.DataStructures.TextStyles
import enjine.core.Input.{Clickable, Input}
import enjine.core.Updateable
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
   * Updates any elements that implement Updateable
   */
  def update(): Unit = {

    //This runs an update function on all those elements that implement Updateable
    elements.foreach({
        case e: Updateable => if (e.active) e.update()
        case _ =>
    })
  }

  /**
   * Render the GUI
   * Both elements and buttons rendered
   */
  def render(): Unit = {
    elements.foreach(e => if (e.renderEnabled)e.render)
  }

  def addElement (guiElement: GUIElement): Int = {elements.append(guiElement); elements.indexOf(guiElement)}

  def element (i: Int) = elements.apply(i)

}
