package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.Input.MouseListener
import enjine.core.Utils.Time
import enjine.core.{Transform, Updateable}

/**
 * Created by Freddie on 23/05/2015.
 *
 * Button that only runs action once  per minTime
 *
 * IE ignores any clicks that happen too quickly
 *
 */
class GUITimedButtonControl(val _transform: Transform, private val _action: (Int, Int, Int)=> Unit, private val _color: Color3d, var minTime: Int)
  extends GUIButtonControl (_transform, _action, _color)
  with Updateable{

  private var currentTime: Int  = minTime

  override def update (): Unit = {

    currentTime += Time.deltaTime.toInt

  }


}
