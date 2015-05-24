package enjine.core

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 * The class to contain all of the data about the current loaded world
 *
 */
class World {

  /**
   * The ArrayBuffer of GameObjects, these are rendered and updated here
   */
  val gameObjects: ArrayBuffer[GameObject] = new ArrayBuffer[GameObject]()

  /**
   * Initialise the world
   */
  def start (): Unit = {

  }

  /**
   * Render all the gameobjects
   */
  def render (): Unit  = {gameObjects.foreach(go => if (go.renderEnabled)go.render())}

  /**
   * Update all the gameobjects in the screen
   */
  def update () {gameObjects.foreach(go => if (go.active)go.update()); addUpdate()}

  /**
   * Override this to add additional update functionality
   */
  def addUpdate (): Unit = {

  }

}
