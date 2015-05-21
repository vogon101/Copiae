package enjine.core

/**
 * Created by Freddie on 20/05/2015.
 *
 *
 */
abstract  class GameObject (val transform: Transform) extends Renderable{

  require(transform != null)

}
