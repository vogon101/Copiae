package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Input.Clickable
import enjine.core.Transform
import org.newdawn.slick.TrueTypeFont

//TODO: Background for text
//TODO: Calculate size not ask from user?

/**
 * Created by Freddie on 24/05/2015.
 *
 * Text that acts like a button, can be clicked on within it's transform area
 */
class GUITextClickable(var _text: String,
                       var _font: TrueTypeFont,
                       var _transform: Transform,
                       private val _color: Color3d,
                       override var action: (Int) => Unit)
  extends GUIText(_text, _font, _transform, _color)
  with Clickable {

  /**
   * Checks if the click is within the clickable area, if so, runs the action
   * @param mx - Mouse X
   * @param my - Mouse Y
   * @param mb - Mouse Button
   */
  def checkClick(mx: Int, my: Int, mb: Int): Unit = {
    if (transform.pointInside(mx, my)) {
      action(mb)
    }
  }

}
