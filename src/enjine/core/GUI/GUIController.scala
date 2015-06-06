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
  //TODO: All renderables rendered in one (done by z index) 0.2

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
    elements.foreach(e => if (e.renderEnabled)e.render())
  }

  /**
   * Add a GUIElement to the list
   * @param guiElement The GUIElement to add
   * @return The index of the GUIElement just added
   */
  def addElement (guiElement: GUIElement): Int = {elements.append(guiElement); elements.indexOf(guiElement)}

  /**
   * Get a GUIElement by index from the ArrayBuffer
   * @param i - The index of the element
   * @return The GUIElement
   */
  def element (i: Int) = elements.apply(i)

}
