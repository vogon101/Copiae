package enjine.tile

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.{Game, Transform, GameObject}
import enjine.tile.data.UnitType
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class TileBasedUnit(private val _transform: Transform,
                    val unitType: UnitType,
                    private var _x: Int,
                    private var _y: Int)
  extends GameObject(_transform, unitType.color, unitType.texture){

  def x = _x
  def y = _y

  def moveTo (nx:Int, ny:Int) {
    _x = nx
    _y = ny

    transform.x = x*Game.g.world.asInstanceOf[TileWorld].TILE_SIZE
    transform.y = y*Game.g.world.asInstanceOf[TileWorld].TILE_SIZE
  }

  def moveTo (tile: Tile): Unit = moveTo(tile.x, tile.y)

  def render() = R.glQuad(transform, color, texture)

  def update(): Unit = {

  }

}
