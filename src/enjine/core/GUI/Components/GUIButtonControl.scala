package enjine.core.GUI.Components

import com.vogon101.copiae.game.TestML
import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Input.{MouseListener, Clickable}
import enjine.core.Transform


/**
 * Created by Freddie on 23/05/2015.
 *
 * Basic untextured button - is a GUIElement also extends Clickable
 *
 * @param _transform  - Where to draw the text (Size don't matter)
 * @param _action - Function to run onClick
 * @param _color - The colour to draw the button
 * @param mb - The mouse button to respond to
 *
 */
class GUIButtonControl (private val _transform: Transform, private val _action: (Int, Int, Int)=> Unit, private val _color: Color3d, val mb: Int = 0) extends GUIElement(_transform) with Clickable {

  //DONE:Add timing on buttons



  color = _color
  /**
   * The OnClick function for the button
   */
  var action = _action

  //DONE: Gui elements other mbs

  //Mouse listener at transform, mb = 0, not offset
  protected var _listener: MouseListener = new MouseListener(transform, action, mb, isOffset = false)

  //TODO: Allow textured GUIElements


}
