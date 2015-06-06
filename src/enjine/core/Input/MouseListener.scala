package enjine.core.Input

import enjine.core.{Game, Transform}

/**
 * Class that listens for a press on a specific screen region and runs an action if so
 *
 * action structure = (mouse-x: Int, mouse-y: Int, mouse-button: Int)
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

  /**
   * Run the action of the listener
   * @param mx - Mouse x position
   * @param my - Mouse y position
   * @param cmb - Mouse button
   */
  def runClick (mx:Int, my: Int, cmb: Int) = action(mx,my,mb)

  /**
   * The index of this listener in the ArrayBuffer of listeners found in Game.w.mouseManager.listeners
   * @return The index
   */
  def index = Game.w.mouseManager.listeners.indexOf(this)

  /**
   * Remove this listener from the list in Game.w.mouseManager.listeners
   */
  def removeFomList(): Unit = {if (Game.w.mouseManager.listeners.contains(this))Game.w.mouseManager.listeners.remove(index)}

}
