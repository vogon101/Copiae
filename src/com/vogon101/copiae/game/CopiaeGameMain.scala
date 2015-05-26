package com.vogon101.copiae.game

import enjine.core.{World, Game}
import enjine.tile.TileWorld

/**
 * Created by Freddie on 19/05/2015.
 *
 * This is an example class to show how one would start a Copiae game
 *
 */
object CopiaeGameMain {

  private val game: Game  = new Game()

  def main (args: Array[String]) {

    //Set the game world to a custom class extending World
    game.world = new TestWorld2()

    //Start the game
    game.start()

  }

}
