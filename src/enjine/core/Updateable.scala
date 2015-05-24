package enjine.core

/**
 * Created by Freddie on 24/05/2015.
 *
 * Something that should be updated each tick
 */
trait Updateable {

  //DONE: Implement isActive

  var active: Boolean = true

  def update()

}
