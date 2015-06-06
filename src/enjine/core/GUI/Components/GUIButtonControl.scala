package enjine.core.GUI.Components

import com.vogon101.copiae.game.TestML
import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Input.{MouseListener, Clickable}
import enjine.core.Transform
import org.newdawn.slick.opengl.Texture


/**
 * Created by Freddie on 23/05/2015.
 *
 * Basic untextured button - is a GUIElement also extends Clickable
 *
 * @param _transform  - Where to draw the text (Size don't matter)
 * @param _action - Function to run onClick
 * @param _color - The colour to draw the button
 * @param mb - The mouse button to respond to
 * @param _isOffset - Should this be offset by world.xOffset/yOffset
 *
 */
class GUIButtonControl (private val _transform: Transform,
                        private val _action: (Int, Int, Int)=> Unit,
                        private val _color: Color3d,
                        val mb: Int = 0,
                        private val _isOffset: Boolean = false,
                        private val _texture: Texture = null)
  extends GUIElement(_transform, _isOffset) with Clickable {

  //DONE:Add timing on buttons

  texture = _texture

  color = _color
  /**
   * The OnClick function for the button
   */
  var action = _action

  //DONE: Gui elements other mbs

  /**
   * The mouse listener for this object
   */
  protected var _listener: MouseListener = new MouseListener(transform, action, mb, isOffset = isOffset)

  //DONE: Allow textured GUIElements


}
