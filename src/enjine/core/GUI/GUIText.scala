package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.Transform
import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 23/05/2015.
 *
 * Class for rendering Text to the screen as part of the GUI
 *@param text - The text to render
 *@param font - The font to use
 *@param transform - Where to render it
 *@param _color - The color to use for the text - UNIMPLEMENTED
 *
 *
 */
class GUIText(var text: String, var font: TrueTypeFont, var transform: Transform, private val _color: Color3d) extends GUIElement{

  //Done:Clickable text

  //TODO:Intergrate different types of text into one class?
  //TODO: Text static builder
  //DONE: Give elements their index in array
  //TODO: On change of array check element's index

  color = _color

  def this (obj: Any, font: TrueTypeFont, transform: Transform, color3d: Color3d) {
    this (obj.toString, font, transform, color3d)
  }

  //DONE: Implement colour

  /**
   * Render the text
   */
  def render (): Unit = {R.glDrawText(text, font,transform, color)}
}
