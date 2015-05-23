package enjine.core.Input

/**
 * Created by Freddie on 23/05/2015.
 *
 */
trait Clickable  {

  var action: (Int) => Unit

  def checkClick (mx:Int, my:Int, mv:Int)

}
