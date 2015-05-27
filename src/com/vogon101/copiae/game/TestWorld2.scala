package com.vogon101.copiae.game

import enjine.core.Input.KeyboardListener
import enjine.core.{Transform, Game}
import enjine.tile.data.UnitType
import enjine.tile.{TileBasedUnit, TileWorld}
import org.lwjgl.input.Keyboard

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class TestWorld2 extends TileWorld{

  override def addStart (): Unit = {

    gameObjects.append(new TileBasedUnit(new Transform(0,0,50,50), UnitType.BASIC, 0,0))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_W, () => {Game.w.yOffset += 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_S, () => {Game.w.yOffset -= 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_A, () => {Game.w.xOffset += 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_D, () => {Game.w.xOffset -= 5;}))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_Y, () => {println("Key Pressed")}, true, true))
    Game.g.keyboardManager.addListener(new KeyboardListener(Keyboard.KEY_Y, () => {println("Key Released")}, true, false))

  }

  override def addUpdate(): Unit = {
    //gameObjects.apply(0).asInstanceOf[TileBasedUnit].moveTo(gameObjects.apply(0).asInstanceOf[TileBasedUnit].x+1, gameObjects.apply(0).asInstanceOf[TileBasedUnit].y+1)
  }


}
