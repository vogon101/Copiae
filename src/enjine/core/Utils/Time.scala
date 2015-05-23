package enjine.core.Utils

import java.util.Calendar

/**
 * Created by Freddie on 23/05/2015.
 *
 */
object Time {

  private var lastTime: Long = Calendar.getInstance().getTimeInMillis.toInt
  var deltaTime: Long = 0

  def update(): Unit = {

    //TODO: INIT time so that first run isn't huge

    deltaTime = Calendar.getInstance().getTimeInMillis - lastTime
    lastTime = Calendar.getInstance().getTimeInMillis

  }

}
