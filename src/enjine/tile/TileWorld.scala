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
class TileWorld extends World {

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
        tiles(x)(y).render
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
        tiles(x)(y) = new ClickableTile(TileType.GRASS,
          new Transform (x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE),
          x, y,
          (mx: Int, my: Int, mb:Int) =>
            { println(x)
              println(y)
              println(mb)
              println("______________")
            })
      }
    }
  }

  /**
   * Get which tile a set of coordinates are in
   * @param x The x coordinate
   * @param y The y coordinate
   * @return The tile
   */
  def tileP (x: Int, y: Int): Tile =tiles(Math.floorDiv(x,TILE_SIZE))(Math.floorDiv(y,TILE_SIZE))

  /**
   * Get a tile by it's (x,y) position in the grid (Tile precision)
   * @param x The x position in tile precision
   * @param y The y position in tile precision
   * @return The tile
   */
  def tileC (x: Int, y: Int): Tile = tiles(x)(y)

}
