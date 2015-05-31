package enjine.core

import enjine.core.DataStructures.TextStyles
import enjine.core.GUI.GUIController
import enjine.core.Graphics.RenderControl
import enjine.core.Input.KeyboardManager
import enjine.core.Settings.GameSettings
import enjine.core.Utils.Time

/**
 * Created by Freddie on 19/05/2015.
 *
 * The main class that runs everyting
 *
 */
class Game (val gameSettings: GameSettings){

  /**
   * The render that is in charge of all rendering
   */
  val renderer: RenderControl = new RenderControl(gameSettings)

  /**
   * Is the game running
   * Controls mainloop
   */
  var running: Boolean = false


  private var _world:World = null

  /**
   * The current loaded world
   */
  def world = _world

  /**
   * Set the world, updates the static instance in Game
   * @param nworld The new world object
   */
  def world_= (nworld: World): Unit = {
    _world = nworld
    Game.setWorld(nworld)
  }

  /**
   * The GUIController to uses
   */
  var GUIController = new GUIController(new TextStyles)

  /**
   * The current keyboard manager to run all keyboard input
   */
  val keyboardManager: KeyboardManager = new KeyboardManager

  //var paused: Boolean = true


  /**
   * Start the game
   * inits opengl, GUI and world then starts the mainloop
    */
  def start (): Unit = {
    Time.update()

    renderer.init()
    running = true

    GUIController.init()

    Game.init(this, renderer, GUIController, world)
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
    Time.update()
    renderer.render(world)
    keyboardManager.update()
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
  private var _renderControl:RenderControl = null
  private var _world:World = null

  /**
   * @return The current world instance
   */
  def w = _world

  /**
   * @return The current RenderControl
   */
  def r = _renderControl

  /**
   * Set the world in both the current game instance and in the Game static object
   * @param world The object to set it to
   */
  def w_= (world: World) = {_world = world; _g.world = world}

  /**
   * @return The current game instance
   */
  def g = _g

  /**
   *
   * @return The current GUIController instance
   */
  def gui = _gui

  //DONE: Make sure that when world changes, this changes
  def init (game: Game, renderControl: RenderControl, GUIController: GUIController, world: World) {
    if (g == null) _g = game
    if (gui == null) _gui = GUIController
    if (r == null) _renderControl = renderControl
    _world = world
  }

  /**
   * Change the world
   * @param world New world object
   */
  def setWorld (world: World) = _world = world
}
