package com.vogon101.copiae.game

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.Components._
import enjine.core.Input.{MouseListener, Input, KeyboardListener}
import enjine.core.{Transform, Game}
import enjine.tile.data.UnitType
import enjine.tile.{ClickableTile, TileBasedUnit, TileWorld}
import org.lwjgl.input.{Mouse, Keyboard}

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class TestWorld2 extends TileWorld{

  var number = 0

  override def addStart (): Unit = {

    gameObjects.append(new TileBasedUnit(new Transform(0,0,50,50), UnitType.BASIC, 0,0))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_W, () => {Game.w.yOffset -= 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_S, () => {Game.w.yOffset += 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_A, () => {Game.w.xOffset -= 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_D, () => {Game.w.xOffset += 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_Y, () => {println("Key Pressed")}, true, true))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_Y, () => {println("Key Released")}, true, false))

    val y =mouseManager.addListener(new MouseListener(new Transform(0,0,100,100), (mx:Int, my:Int, mb: Int) => {println("click")}, 1))
    mouseManager.listener(y).checkClick(10,10,0)

    println(tiles(0)(0))
    tiles(0)(0).asInstanceOf[ClickableTile].listener = new MouseListener(tiles(0)(0).transform, (mx:Int, my:Int, mb: Int) => {println("This is tile 00")})
    tiles(0)(0).transform.z = 2

    Game.gui.addElement(new GUIPanel(
      new Transform(0,Game.r.gameSettings.SCREEN_HEIGHT-200,300,Game.r.gameSettings.SCREEN_HEIGHT),
      Color3d.LIGHT_GREY))

    Game.g.GUIController.elements.append(
      new GUITimedButtonControl(
        new Transform(100,100,100,100),
        (mx:Int, my:Int, mb:Int) => {println("Timedbutton")},
        Color3d.RED,
        500))

    Game.g.GUIController.elements.append(
      new GUITextObjTracker(() => number,
        Game.g.GUIController.textStyles.STANDARD,
        new Transform(300,300,10,10),
        Color3d.BLUE))

    Game.gui.elements.append(
      new GUIText("Banter",
        Game.gui.textStyles.STANDARD,
        new Transform(400,400,100,100),
        Color3d.RED,
        Color3d.BLACK,
        true))

  }

  //DONE: Priority clicks

  override def addUpdate(): Unit = {

    number += 1

    //println(Game.gui.element(0).transform.z)

    //println(mouseManager.listeners.length)

    //gameObjects.apply(0).asInstanceOf[TileBasedUnit].moveTo(gameObjects.apply(0).asInstanceOf[TileBasedUnit].x+1, gameObjects.apply(0).asInstanceOf[TileBasedUnit].y+1)

    //if (Mouse.isButtonDown(0)) {
    //  println(Input.myo)
      //println(Input.mx)
    //}

  }

  /*
  */

}
