package enjine.core.Input

import enjine.core.Updateable
import org.lwjgl.input.Mouse

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 29/05/2015.
 *
 */
class MouseManager {

  /**
   * ArrayBuffer of MouseListener
   */
  val listeners: ArrayBuffer[MouseListener] = new ArrayBuffer[MouseListener]()

  def update(): Unit = {
    //Go through all the mouse events
    while(Mouse.next()) {
      if (Mouse.getEventButton != -1) {
        //Get the mouse values
        val xOffset = Input.XtoOffset(Mouse.getEventX)
        val yOffset = Input.YtoOffset(Mouse.getEventY)
        val x = Mouse.getEventX
        val y = Input.YtoUseable(Mouse.getEventY)
        val b = Mouse.getEventButton

        println(y)

        //TODO: FIX GUI NO-OFFSET
        //Array buffer of listeners
        val clicks = new ArrayBuffer[MouseListener]()

        //Go through all the listeners and those that want a click, append it to the ArrayBuffer
        listeners.foreach(u => {
          if (u.isOffset) {
            if (u.checkClick(xOffset, yOffset, b)) clicks.append(u)
          }
          else {
            if (u.checkClick(x, y, b)) clicks.append(u)
          }

        })

        //Go through all the clicks and get the one on top
        var maxZ: Double = -10
        if (clicks.isEmpty)
          return
        var currentClick = clicks.apply(0)

        clicks.foreach(u => if (u.transform.z > maxZ) {
                                maxZ = u.transform.z
                                currentClick = u
        })

        //Run the correct click
        currentClick.runClick(x,y,b)

      }
    }
  }

  /**
   * Add a mouse listener to the list
   * @param mouseListener The mouse listener to add
   * @return The index of the listener in the list
   */
  def addListener (mouseListener: MouseListener): Int = {listeners.append(mouseListener); listeners.indexOf(mouseListener)}

  /**
   * Get a listener
   * @param i The index of the listener to get
   * @return The listener
   */
  def listener(i: Int): MouseListener = listeners.apply(i)

}
