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
 *@param bgColor - The colour of the background of this tetx
 *@param bgEnabled - Should a background be drawn
 *@param _isOffset - Should this be offset by world.xOffset/yOffset
 *@param calculateSize - Should this calculate its own size or use the one in the transform
 */
class GUIText(private val _text: Any,
              var font: TrueTypeFont,
              private val _transform: Transform,
              private val _color: Color3d,
              bgColor: Color3d = null,
              bgEnabled: Boolean = false,
              private val _isOffset: Boolean = false,
              val calculateSize: Boolean = true )
  extends GUIElement(_transform, _isOffset){

  var text = _text.toString

  //Done:Clickable text

  //TODO: Integrate different types of text into one class? - 0.2
  //DONE: GUI panels block clicks?
  //DONE: Click priority by z
  //DONE: Give elements their index in array
  //DONE: On change of array check element's index

  require( (!bgEnabled) || (bgEnabled && bgColor != null), "Please pass a background colour" )

  if (calculateSize) {
    transform.xSize = font.getWidth(text)
    transform.ySize = font.getHeight(text)
  }
  color = _color



  //DONE: Implement colour

  /**
   * Render the text
   */
  override def render(): Unit = {
    if (bgEnabled) {
      R.glQuad(transform, bgColor, null, isOffset = isOffset)
    }
    R.glDrawText(text, font,transform, color, isOffset = isOffset)
  }
}
