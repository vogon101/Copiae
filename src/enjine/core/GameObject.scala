package enjine.core

import enjine.core.DataStructures.Color3d

/**
 * Created by Freddie on 20/05/2015.
 *
 *
 */
abstract  class GameObject (val transform: Transform, private val _color: Color3d) extends Renderable{

  color = _color

  def this (transform: Transform) {
    this(transform, Color3d.RED)
  }

  require(transform != null)

  def update ()

}
