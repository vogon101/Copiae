package enjine.core

/**
 * Created by Freddie on 24/05/2015.
 *
 * Something that should be updated each tick
 */
trait Updateable {

  //DONE: Implement isActive

  /**
   * Should the update() be run every frame
   */
  var active: Boolean = true

  /**
   * Update the object
   */
  def update()

}
