package enjine.tile

import enjine.core.{Transform, GameObject, World}
import enjine.tile.data.TileType

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 25/05/2015.
 *
 * A class to contain a map made up of Tiles
 *
 */
class TileWorld extends World{

  /**
   * The map width in tiles
   */
  val MAP_WIDTH = 100
  /**
   * The map height in tiles
   */
  val MAP_HEIGHT = 100
  /**
   * The tile size in pixels
   */
  val TILE_SIZE = 50

  /**
   * The array of tiles, initialised to the MAP_HEIGHT and MAP_WIDTH
   */
  val tiles = Array.ofDim[Tile](MAP_WIDTH, MAP_HEIGHT)


  /**
   * Initialise the map (calls super.start())
   */
  override def start (): Unit = {
    genWorld()
    super.start()
  }

  /**
   * Render the map (calls super.render())
   */
  override def render (): Unit = {
    for (x <- tiles.indices) {
      for (y <- tiles.indices) {
        tiles(x)(y).render()
      }
    }

    super.render()
  }

  /**
   * Generate the world, override to include your own world gen code, should populate the entire tile array
   */
  def genWorld(): Unit = {
    for (x <- tiles.indices) {
      for (y <- tiles.indices) {
        tiles(x)(y) = new Tile(TileType.GRASS, new Transform (x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE), x, y)
      }
    }
  }


}
