package com.vogon101.copiae.game

import enjine.core.Input.{MouseManager, MouseListener}
import enjine.core.{Game, Transform}

/**
 * Created by Freddie on 05/06/2015.
 *
 */
class TestML(private val _transform: Transform, private val _action: (Int, Int, Int) => Unit, private val _mb: Int = 0, private val isO: Boolean) extends MouseListener(_transform, _action, isOffset = isO){

  override def checkClick (mx: Int, my: Int, mb: Int): Boolean = {

    println("-------"+mx)
    super.checkClick(mx, my, mb)
  }

}
