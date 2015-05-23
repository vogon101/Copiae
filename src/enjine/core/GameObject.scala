package enjine.core

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.Renderable

/**
 * Created by Freddie on 20/05/2015.
 *
 * Main class for objects that are in the game -  Untextured
 * Is renderable
 *
 * @param transform - The position and scale of the object
 * @param _color - The color of the object
 *
 */
abstract  class GameObject (val transform: Transform, private val _color: Color3d) extends Renderable{

  color = _color

  def this (transform: Transform) {
    this(transform, Color3d.RED)
  }

  require(transform != null)

  /**
   * update the GameObject once per tick
   */
  def update ()

}
