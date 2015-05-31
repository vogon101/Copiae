package enjine.core.Input

import enjine.core.Transform

/**
 * Created by Freddie on 29/05/2015.
 *
 */
class MouseListener (val transform: Transform, var action: (Int, Int, Int) => Unit, val mb: Int = 0){
  def checkClick (mx:Int, my: Int, cmb: Int): Unit = {
    if (transform.pointInside(mx,my) && cmb == mb)
      action(mx, my, mb)
  }

}
