package com.vogon101.copiae.game

import enjine.core.{Transform, Game}
import enjine.tile.data.UnitType
import enjine.tile.{TileBasedUnit, TileWorld}

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class TestWorld2 extends TileWorld{

  //TODO: Gameobjects know their index in array and it tracks when that changes6

  override def addStart (): Unit = {

    gameObjects.append(new TileBasedUnit(new Transform(0,0,50,50), UnitType.BASIC, 0,0))

  }

  override def addUpdate(): Unit = {
    //gameObjects.apply(0).asInstanceOf[TileBasedUnit].moveTo(gameObjects.apply(0).asInstanceOf[TileBasedUnit].x+1, gameObjects.apply(0).asInstanceOf[TileBasedUnit].y+1)
  }


}
