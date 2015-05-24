package enjine.core.GUI

import enjine.core.Game
import enjine.core.Graphics.Renderable

/**
 * Created by Freddie on 23/05/2015.
 *
 * Basic class for GUI content
 *
 */
abstract class GUIElement extends Renderable{

  private var _index = Game.gui.elements.indexOf(this)

  /**
   * @return The index of this element in the world.gameobjects list
   */
  def index = _index

}
