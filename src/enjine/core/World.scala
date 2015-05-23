package enjine.core

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class World {

  val gameObjects: ArrayBuffer[GameObject] = new ArrayBuffer[GameObject]()

  def start (): Unit = {

  }

  def render (): Unit  = {gameObjects.foreach(go => go.render())}

  def update (){

    gameObjects.foreach(go => go.update())

  }

}
