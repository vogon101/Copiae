package enjine.core

/**
 * Created by Freddie on 20/05/2015.
 *
 * Class that represents the location and scale of an object
 *
 */
class Transform (var x: Double, var y: Double, var xSize: Double, var ySize:Double, var z: Double = 0){

  //DONE: MoveTowards
  //TODO: Make move-towards more elegant
  //TODO: Make sure max step is total for x+y not separate

  /**
   * Move towards another Transform
   * @param target The target transform
   * @param maxStep The maximum step in pixels
   * @return True if they are now in the same place
   */
  def moveTowards (target: Transform, maxStep :Int): Boolean = {


    if (x < target.x) {
      if (x + maxStep < target.x) {
        x += maxStep
      }
      else {
        x = target.x
      }
    }
    if (x > target.x) {
      if (x - maxStep > target.x) {
        x -= maxStep
      }
      else {
        x = target.x
      }
    }
    if (y < target.y) {
      if (y + maxStep < target.y) {
        y += maxStep
      }
      else {
        y = target.y
      }
    }

    if (y > target.y) {
      if (y - maxStep > target.y) {
        y -= maxStep
      }
      else {
        y = target.y
      }
    }

    if (x == target.x && y == target.y) return true

    false
  }

  /**
   * See if a point is inside the box made by the transform
   * @param px The x position of the point
   * @param py The y position of the point
   * @return True if point is within box
   */
  def pointInside (px: Double, py:Double): Boolean = {
    if (px>x && px < x+xSize) {
      if (py > y && py < y+ySize) {
        return true
      }
    }
    false
  }

  /**
   * See if two transforms overlap
   * @param transform The transform to check
   * @return True if the overlap
   */
  def overlaps (transform: Transform) : Boolean = {
    if (x+xSize < transform.x) return false // a is left of b
    if (x > transform.x+transform.xSize) return false // a is right of b
    if (y+ySize < transform.y) return false// a is above b
    if (y > transform.y + transform.ySize) return false // a is below b
    true // boxes overlap
  }

}
