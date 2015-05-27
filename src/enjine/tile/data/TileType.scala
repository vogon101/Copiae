package enjine.tile.data

import enjine.core.DataStructures.Color3d
import enjine.core.Game
import enjine.core.Graphics.Textures
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 23/05/2015.
 *
 * Contains the basic information about a tile (ie name or colour)
 */
class TileType ( val texture: Texture,
                 val name:String,
                 val walkable: Boolean,
                 val color: Color3d ) {
  require(color != null || texture != null)
}

//TODO: Tile map world
//TODO: More specific abilities for tiles

object TileType {

  val GRASS = new TileType(Textures.GRASS, "Grass", true, null)
  val MOUNTAIN = new TileType(null, "Mountain", true, Color3d.LIGHT_GREY)

}
