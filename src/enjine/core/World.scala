package enjine.core

import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class World {

  val gameObjects: ArrayBuffer[GameObject] = new ArrayBuffer[GameObject]()

  def start (): Unit = {

  }

  def render (): Unit  = {gameObjects.foreach(go => if (go.renderEnabled)go.render())}

  def update (){

    gameObjects.foreach(go => go.update())


  }

}
