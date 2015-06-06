package enjine.core.Input

import enjine.core.Game

/**
 * Created by Freddie on 23/05/2015.
 *
 * Denotes something that is clickable
 *
 */
trait Clickable  {

  /**
   * The mouse listener for this object
   */
  protected var _listener: MouseListener

  /**
   * @return This tile's current MouseListener
   */
  def listener = _listener

  /**
   * Set the listener, adds it to the list and removes the old one
   * @param mouseListener The new MouseListener
   */
  def listener_= (mouseListener: MouseListener): Unit = {
    listener.removeFomList()
    _listener = mouseListener
    Game.w.mouseManager.addListener(listener)
  }

}
