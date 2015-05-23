package com.vogon101.copiae.game

import enjine.core.DataStructures.Color3d
import enjine.core.{Transform, World}
import enjine.tile.Tile
import enjine.tile.data.TileType

/**
 * Created by Freddie on 23/05/2015.
 */
class TestWorld extends World{

  override def start (): Unit = {

    gameObjects.append(new Tile(new TileType(new Color3d(0,1,0), "Grass") ,new Transform(10,10,10,10, 0)))

  }

}
