package com.vogon101.copiae.game

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.Components.{GUITimedButtonControl, GUITextObjTracker, GUITextClickable}
import enjine.core.GUI._
import enjine.core.{Game, Transform, World}



/**
 * Created by Freddie on 23/05/2015.
 *
 * This is an example class to show how one would extend the World object
 *
 */
class TestWorld extends World{

  var number: Int = 0

  //DONE: Nicer appends to game ArrayBuffers
  //TODO: Gen docs?

  /**
   * Override the addStart method to create your own game init
   */
  override def addStart (): Unit = {

    // gameObjects.append(new Tile(new TileType(new Color3d(0,1,0), "Grass") ,new Transform(10,10,10,10, 0)))
    Game.g.GUIController.elements.append(
      new GUITimedButtonControl(
        new Transform(100,100,100,100),
        (mx:Int, my:Int, mb:Int) => {println(mb)},
        Color3d.RED,
        500))

    Game.g.GUIController.elements.append(
      new GUITextObjTracker(() => number,
        Game.g.GUIController.textStyles.STANDARD,
        new Transform(300,300,10,10),
        Color3d.BLUE))

    Game.gui.elements.append(
      new GUITextClickable("Banter",
        Game.gui.textStyles.STANDARD,
        new Transform(400,400,100,100),
        Color3d.RED,
        (mx:Int, my:Int, mb:Int) => {println("I am clickable")}, _isOffset = true))

    val a: BanterObject = new BanterObject(new Transform(200,100,30,10), Color3d.RED, null)
    val b: BanterObject = new BanterObject(new Transform(900,400,30,10), Color3d.WHITE, null)

    gameObjects.append(a)
    gameObjects.append(b)

    a.target = b

  }

  override def addUpdate (): Unit = {
    number+= 1
  }

}
