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

  /**
   * @return The index of this element in the Game.gui.elements list
   */
  def index = Game.gui.elements.indexOf(this)

}
