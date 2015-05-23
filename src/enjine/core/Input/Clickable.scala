package enjine.core.Input

/**
 * Created by Freddie on 23/05/2015.
 *
 * Denotes something that is clickable
 *
 */
trait Clickable  {

  /**
   * The onclick action Unit
   */
  var action: (Int) => Unit

  /**
   * Allows checking for a click
   * @param mx - Mouse X
   * @param my - Mouse Y
   * @param mb - Mouse Button
   */
  def checkClick (mx:Int, my:Int, mb:Int)

}
