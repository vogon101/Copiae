package enjine.core.Graphics

import enjine.core.DataStructures.Color3d
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 21/05/2015.
 *
 * Designates something that can be rendered
 *
 */
trait Renderable {

  /**
   * The colour of the object (Color3d)
   */
  var color : Color3d = null
  /**
   * The texture of the object
   */
  var texture: Texture = null
  /**
   * Should this be rendered
   */
  var renderEnabled : Boolean = true

  /**
   * Render the object
   */
  def render ()

}
