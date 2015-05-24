package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.Input.Clickable
import enjine.core.Transform

/**
 * Created by Freddie on 23/05/2015.
 *
 * Basic untextured button - is a GUIElement also extends Clickable
 *
 * @param transform  - Where to draw the text (Size don't matter)
 * @param _action - Function to run onClick
 * @param _color - The colour to draw the button
 *
 */
class ButtonControl (val transform: Transform, private val _action: (Int)=> Unit, private val _color: Color3d) extends GUIElement with Clickable {

  //DONE:Add timing on buttons

  color = _color
  /**
   * The OnClick function for the button
   */
  var action = _action

  /**
   * Render the button
   */
  override def render (): Unit = {R.glQuad(transform,color)}

  /**
   * See if a click is in the button, if so run action
   * @param mx Mouse x position
   * @param my Mouse y position
   * @param mb Mouse button pressed
   */
  override def checkClick (mx: Int, my: Int, mb:Int): Unit = {
    if (transform.pointInside(mx,my))
      action(mb)
  }

}
