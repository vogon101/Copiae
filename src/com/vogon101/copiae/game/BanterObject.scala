package com.vogon101.copiae.game

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.{GameObject, Transform}

/**
 * Created by Freddie on 24/05/2015.
 *
 */
class BanterObject(private val _transform: Transform, private val _color: Color3d, var target: BanterObject) extends GameObject (_transform, _color){

  def update (): Unit = {
    if (target != null)
      transform.moveTowards(target.transform, 1)
  }

  def render (): Unit = R.glQuad(transform, color)

}
