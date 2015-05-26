package enjine.tile

import enjine.core.{Transform, GameObject, World}
import enjine.tile.data.TileType

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class TileWorld extends World{

  val MAP_WIDTH = 100
  val MAP_HEIGHT = 100
  val TILE_SIZE = 50

  val tiles = Array.ofDim[Tile](MAP_WIDTH, MAP_HEIGHT)

  override def start (): Unit = {
    genWorld()
    super.start()
  }



  override def render (): Unit = {
    for (x <- tiles.indices) {
      for (y <- tiles.indices) {
        tiles(x)(y).render()
      }
    }

    super.render()
  }

  def genWorld(): Unit = {
    for (x <- tiles.indices) {
      for (y <- tiles.indices) {
        tiles(x)(y) = new Tile(TileType.GRASS, new Transform (x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE), x, y)
      }
    }
  }


}
