package enjine.core.Utils

import java.util.Calendar

/**
 * Created by Freddie on 23/05/2015.
 *
 * Contains various values about the timing of the game
 *
 */
object Time {

  private var lastTime: Long = Calendar.getInstance().getTimeInMillis.toInt

  /**
   * Time since the last tick
   */
  var deltaTime: Long = 0

  /**
   * Update the times, called once a tick
   */
  def update(): Unit = {

    deltaTime = Calendar.getInstance().getTimeInMillis - lastTime
    lastTime = Calendar.getInstance().getTimeInMillis

  }

}
