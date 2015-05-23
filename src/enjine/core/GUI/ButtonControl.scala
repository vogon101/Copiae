package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.{R, Renderable}
import enjine.core.Input.Clickable
import enjine.core.Transform

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class ButtonControl (val transform: Transform, private val _action: (Int)=> Unit, private val _color: Color3d) extends GUIElement with Clickable {

  //TODO:Add timing on buttons

  color = _color
  var action = _action

  override def render (): Unit = {R.glQuad(transform,color)}

  override def checkClick (mx: Int, my: Int, mb:Int): Unit = {
    if (transform.pointInside(mx,my))
      action(mb)
  }

}
