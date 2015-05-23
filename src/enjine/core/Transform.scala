package enjine.core

/**
 * Created by Freddie on 20/05/2015.
 *
 */
class Transform (var x: Double, var y: Double, var xSize: Double, var ySize:Double, var z: Double = 0){

  def moveTowards (target: Transform, maxStep :Int) = ???

  def pointInside (px: Double, py:Double): Boolean = {
    if (px>x && px < x+xSize) {
      if (py > y && py < y+ySize) {
        return true
      }
    }
    false
  }

  def overlaps (transform: Transform) : Boolean = {
    if (x+xSize < transform.x) return false // a is left of b
    if (x > transform.x+transform.xSize) return false // a is right of b
    if (y+ySize < transform.y) return false// a is above b
    if (y > transform.y + transform.ySize) return false // a is below b
    true // boxes overlap
  }

}
