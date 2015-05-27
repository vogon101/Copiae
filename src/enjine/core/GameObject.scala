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
 *
 */
abstract  class GameObject (val transform: Transform, private val _color: Color3d, private val _texture: Texture) extends Renderable with Updateable{

  color = _color
  texture = _texture

  require(color != null || texture != null)

  //TODO:Check for changes in array and update accordingly
  /**
   * The index of the object in the array buffer of gameobjects
   */
  protected var _index = Game.g.world.gameObjects.indexOf(this)
  /**
   * The index of the GO in the gameObjects array in the world
   */
  def index = _index

  def this (transform: Transform) {
    this(transform, Color3d.RED, null)
  }

  require(transform != null)



}
