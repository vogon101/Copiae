package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.Input.{MouseListener, Clickable}
import enjine.core.Transform
import org.lwjgl.input.Mouse
import org.newdawn.slick.TrueTypeFont

//DONE: Background for text
//DONE: Calculate size not ask from user?
//DONE: Offsetable text

/**
 * Created by Freddie on 24/05/2015.
 *
 * Text that acts like a button, can be clicked on within it's transform area
 */
class GUITextClickable(var _text: String,
                       var _font: TrueTypeFont,
                       var _transform: Transform,
                       private val _color: Color3d,
                       private val _action: (Int, Int, Int) => Unit,
                       val mb: Int = 0,
                       bgColor: Color3d = null,
                       bgEnabled: Boolean = false,
                       private val _isOffset: Boolean = false)
  extends GUIText(_text, _font, _transform, _color, bgColor, bgEnabled, _isOffset)
  with Clickable {

  protected var _listener = new MouseListener(transform, _action, mb, isOffset = false)

}
