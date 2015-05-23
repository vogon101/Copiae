package enjine.core

import enjine.core.DataStructures.Color3d

/**
 * Created by Freddie on 21/05/2015.
 *
 */
trait Renderable {

  var color : Color3d = null
  var renderEnabled : Boolean = true

  def render()

}
