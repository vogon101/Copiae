package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Transform
import jdk.internal.org.objectweb.asm.commons.CodeSizeEvaluator
import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 23/05/2015.
 *
 * Class for rendering Text to the screen as part of the GUI
 *@param _text - The object.toString to render
 *@param font - The font to use
 *@param _transform - Where to render it
 *@param _color - The color to use for the text - UNIMPLEMENTED
 *
 *
 */
class GUIText(private val _text: Any,
              var font: TrueTypeFont,
              private val _transform: Transform,
              private val _color: Color3d,
              bgColor: Color3d = null,
              bgEnabled: Boolean = false,
              private val _isOffset: Boolean = false)
  extends GUIElement(_transform, _isOffset){

  var text = _text.toString

  //Done:Clickable text

  //TODO: Integrate different types of text into one class?
  //TODO: Take in no size transform?
  //DONE: GUI panels block clicks?
  //DONE: Click priority by z
  //DONE: Give elements their index in array
  //DONE: On change of array check element's index

  require( (!bgEnabled) || (bgEnabled && bgColor != null), "Please pass a background colour" )

  transform.xSize = font.getWidth(text)
  transform.ySize = font.getHeight(text)

  color = _color



  //DONE: Implement colour

  /**
   * Render the text
   */
  override def render: Unit = {
    if (bgEnabled) {
      R.glQuad(transform, bgColor, null, isOffset = isOffset)
    }
    R.glDrawText(text, font,transform, color, isOffset = isOffset)
  }
}

object GUIText {

  val TEXT = 0
  val TEXT_CLICKABLE = 1
  val TEXT_TRACKER = 2

  //TODO: IMPLEMENT BUILDER
  def newText (textType: String, transform: Transform, color: Color3d, action: (Int, Int, Int) => Unit = null, evaluator: () => Unit): Unit = ???

}
