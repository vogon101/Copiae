package com.vogon101.copiae.game

import enjine.core.{World, Game}

/**
 * Created by Freddie on 19/05/2015.
 *
 */
object CopiaeGameMain {

  private val game: Game  = new Game()

  def main (args: Array[String]) {

    game.world = new TestWorld()

    game.start()

  }

}
