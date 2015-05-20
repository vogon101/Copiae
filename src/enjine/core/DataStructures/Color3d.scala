package enjine.core.DataStructures

/**
 * Created by Freddie on 19/05/2015.
 *
 */
class Color3d (val r:Double = 0, val g:Double = 0, val b:Double = 0) {}

object Color3d {
  val RED = new Color3d(1,0,0)
  val GREEN = new Color3d(0,1,0)
  val BLUE = new Color3d(0,0,1)
  val BLACK = new Color3d(0,0,0)
  val LIGHT_GREY = new Color3d(0.8,0.8,0.8)
  val DARK_GREY = new Color3d(0.2,0.2,0.2)
}
