package enjine.core

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.Renderable
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 20/05/2015.
 *
 * Main class for objects that are in the game -  Untextured
 * Is renderable and updateable
 *
 * @param transform - The position and scale of the object
 * @param _color - The color of the object
 * @param _texture The texture of the object
 *
 */
abstract  class GameObject (val transform: Transform, private val _color: Color3d, private val _texture: Texture) extends Renderable with Updateable{

  color = _color
  texture = _texture

  require(color != null || texture != null)

  /**
   * The index of the GO in the gameObjects array in the world
   */
  def index = Game.w.gameObjects.indexOf(this)

  def this (transform: Transform) {
    this(transform, Color3d.RED, null)
  }

  require(transform != null)



}
