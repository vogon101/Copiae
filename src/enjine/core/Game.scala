package enjine.core

import enjine.core.DataStructures.TextStyles
import enjine.core.GUI.GUIController
import enjine.core.Graphics.RenderControl
import enjine.core.Settings.GameSettings

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 19/05/2015.
 *
 * The main class that runs everyting
 *
 */
class Game {

  /**
   * The render that is in charge of all rendering
   */
  val renderer: RenderControl = new RenderControl(new GameSettings)

  /**
   * Is the game running
   * Controls mainloop
   */
  var running: Boolean = false

  /**
   * The current loaded world
   */
  var world:World = null

  /**
   * The GUIController to uses
   */
  var GUIController = new GUIController(new TextStyles)

  //var paused: Boolean = true


  /**
   * Start the game
   * inits opengl, GUI and world then starts the mainloop
    */
  def start (): Unit = {
    renderer.init()
    running = true

    GUIController.init()

    Game.init(this, GUIController)
    world.start()

    mainloop()
  }

  /**
   * Main loop that runs update() once a tick
   */
  protected def mainloop (): Unit = {

    if (world == null)
      throw new Exception("World instance not set")

    while (running)
      update()

  }

  /**
   * Runs all the per-tick functions like rendering
   */
  protected def update(): Unit = {
    renderer.render(world)
    world.update()
    GUIController.update()

  }

}

/**
 * Static object for getting singleton instances of crucial classes
 */
object Game {
  private var _g:Game = null
  private var _gui:GUIController = null

  /**
   * @return The current game instance
   */
  def g = _g

  /**
   *
   * @return The current GUIController instance
   */
  def gui = _gui

  def init (game: Game, GUIController: GUIController) {if (g==null)_g = game; if (gui == null)_gui = GUIController}
}
