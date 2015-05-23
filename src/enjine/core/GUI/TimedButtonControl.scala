package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Transform

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class TimedButtonControl(val _transform: Transform, private val _action: (Int)=> Unit, private val _color: Color3d) extends ButtonControl (_transform, _action, _color){




}
