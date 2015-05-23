package enjine.core

import enjine.core.GUI.GUIController
import enjine.core.Graphics.RenderControl
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

  var world:World = null
  val GUIController = new GUIController()

  //var paused: Boolean = true



  def start (): Unit = {
    renderer.init()
    running = true

    Game.init(this)
    world.start()

    mainloop()
  }

  private def mainloop (): Unit = {

    if (world == null)
      throw new Exception("World instance not set")

    while (running)
      update()

  }

  private def update(): Unit = {
    renderer.render(world)
    world.update()
    GUIController.update()

  }

}

object Game {
  private var _g:Game = null

  def g = _g

  def init (game: Game) {if (g==null)_g = game}
}
