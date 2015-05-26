package enjine.tile.data

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.Textures
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 25/05/2015.
 *
 */
class UnitType(val name:String,
               val color: Color3d,
               val texture: Texture) {
  require(color != null || texture != null)
}

object UnitType {
  val BASIC = new UnitType("Basic Unit", null, Textures.UNIT)
}