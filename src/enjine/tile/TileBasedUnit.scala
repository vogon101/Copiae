package enjine.tile

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.{Game, Transform, GameObject}
import enjine.tile.data.UnitType
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 25/05/2015.
 *
 * A unit that exists on a tile based map
 *
 * @param _transform Where in pixels it it
 * @param unitType Contains important data about the unit
 * @param _x The tile x position of the unit (In the grid of tiles)
 * @param _y The tile y position of the unit (In the grid of tiles)
 */
class TileBasedUnit(private val _transform: Transform,
                    val unitType: UnitType,
                    private var _x: Int,
                    private var _y: Int)
  extends GameObject(_transform, unitType.color, unitType.texture){

  transform.z = 1

  /**
   * @return The tile x position of the unit (In the grid of tiles)
   */
  def x = _x

  /**
   * @return The tile y position of the unit (In the grid of tiles)
   */
  def y = _y

  /**
   * Move to a set of coordinates (In tiles)
   * @param nx The new tile x position (In the grid of tiles)
   * @param ny The new tile x position (In the grid of tiles)
   */
  def moveTo (nx:Int, ny:Int) {
    _x = nx
    _y = ny

    transform.x = x*Game.g.world.asInstanceOf[TileWorld].TILE_SIZE
    transform.y = y*Game.g.world.asInstanceOf[TileWorld].TILE_SIZE
  }

  /**
   * Move to a tile
   * @param tile The tile to move to
   */
  def moveTo (tile: Tile): Unit = moveTo(tile.x, tile.y)

  /**
   * Render the unit
   */
  def render= R.glQuad(transform, color, texture)

  /**
   * Update the unit
   */
  def update(): Unit = {

  }

}
