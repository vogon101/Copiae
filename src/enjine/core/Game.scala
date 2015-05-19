package enjine.core

import enjine.core.RenderControl
import enjine.core.Settings.GameSettings

/**
 * Created by Freddie on 19/05/2015.
 */
class Game {

  val settings: GameSettings = new GameSettings
  val renderer: RenderControl = new RenderControl(settings)

  var running: Boolean = false
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
