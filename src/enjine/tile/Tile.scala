package enjine.tile

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.{GameObject, Transform}
import enjine.tile.data.TileType
import org.lwjgl.opengl.GL11

/**
 * Created by Freddie on 20/05/2015.
 *
 * Class for a tile in a tile-based map
 *
 */
class Tile(val tileType:TileType, private val _transform: Transform, val x: Int, val y: Int) extends GameObject(_transform, tileType.color, tileType.texture){

  texture = tileType.texture
  transform.z = 0


  /**
   * Render the tile
   */
  override def render: Unit = R.glDrawQuadTextured(transform, texture)

  /**
   * Update the tile
   */
  override def update (): Unit = {



  }


}
