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
class Tile(val tileType:TileType, transform: Transform) extends GameObject(transform, tileType.color){

  /**
   * Render the tile
   */
  override def render(): Unit = R.glQuad(transform, color)

  /**
   * Update the tile
   */
  override def update (): Unit = {



  }


}
