package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.{R, Renderable}
import enjine.core.Transform

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class ButtonControl (val transform: Transform, action: (Int)=> Unit, private val _color: Color3d) extends Renderable {

  //TODO:Add timing on buttons

  color = _color

  override def render (): Unit = {R.glQuad(transform,color); println("should be rendering")}

  def checkClick (mx: Int, my: Int, mb:Int): Unit = {
    println("CLICKED")
    if (transform.pointInside(mx,my))
      action(mb)
  }

}
