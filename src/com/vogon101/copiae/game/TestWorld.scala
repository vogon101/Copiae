package com.vogon101.copiae.game

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.{GUIText, ButtonControl}
import enjine.core.{Game, Transform, World}
import enjine.tile.Tile
import enjine.tile.data.TileType

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class TestWorld extends World{

  override def start (): Unit = {

    gameObjects.append(new Tile(new TileType(new Color3d(0,1,0), "Grass") ,new Transform(10,10,10,10, 0)))
    Game.g.GUIController.buttons.append(new ButtonControl(new Transform(100,100,100,100), (mb:Int) => {println(mb)}, Color3d.RED))
    Game.g.GUIController.elements.append(new GUIText("Banter", Game.g.GUIController.textStyles.STANDARD, new Transform(300,300,10,10)))

  }

}
