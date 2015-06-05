package enjine.core.GUI

import enjine.core.{Transform, Game}
import enjine.core.Graphics.{R, Renderable}

/**
 * Created by Freddie on 23/05/2015.
 *
 * Basic class for GUI content
 *
 */
class GUIElement (val transform: Transform) extends Renderable{

  transform.z = 2

  /**
   * @return The index of this element in the Game.gui.elements list
   */
  def index = Game.gui.elements.indexOf(this)

  def render = R.glQuad(transform,color, texture, isOffset = false)

}
