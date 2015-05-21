package enjine.core

import enjine.core.Settings.GameSettings

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 19/05/2015.
 *
 */
class Game {

  val settings: GameSettings = new GameSettings
  val renderer: RenderControl = new RenderControl(settings)

  var running: Boolean = false

  val gameObjects: ArrayBuffer[GameObject] = new ArrayBuffer[GameObject]()
  //var paused: Boolean = true



  def start (): Unit = {
    renderer.init()
    running = true

    mainloop()
  }

  private def mainloop (): Unit = {

    while (running)
      update()

  }

  private def update(): Unit = {
    renderer.update()
  }

}

object Game {
  //TODO: Make singleton instance of game
}
