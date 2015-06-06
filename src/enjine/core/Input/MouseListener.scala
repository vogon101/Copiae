package enjine.core.Input

import enjine.core.{Game, Transform}

/**
 * Created by Freddie on 29/05/2015.
 *
 */
class MouseListener (val transform: Transform, var action: (Int, Int, Int) => Unit, val mb: Int = 0, val mouseManager: MouseManager = Game.w.mouseManager, val isOffset: Boolean = true){

  mouseManager.addListener(this)

  /**
   * Check a click and run the action if appropriate
   * @param mx Click's X position
   * @param my Click's Y position
   * @param cmb Mouse button
   */
  def checkClick (mx:Int, my: Int, cmb: Int): Boolean = {
    if (transform.pointInside(mx,my) && cmb == mb)
      return true
    false
  }

  def runClick (mx:Int, my: Int, cmb: Int) = action(mx,my,mb)

  /**
   * The index of this listener in the ArrayBuffer of listeners found in Game.w.mouseManager.listeners
   * @return The index
   */
  def index = Game.w.mouseManager.listeners.indexOf(this)

  def removeFomList() = {println(index);if (Game.w.mouseManager.listeners.contains(this))Game.w.mouseManager.listeners.remove(index)}

}
