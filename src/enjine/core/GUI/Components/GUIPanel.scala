package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Input.MouseListener
import enjine.core.{Game, Transform}

/**
 * Created by Freddie on 02/06/2015.
 *
 */
class GUIPanel(private val _transform: Transform, private val _color: Color3d, val blocksClicks: Boolean = true) extends GUIElement(_transform){

  color = _color

  //TODO: Mouse managers for all clicks (mbs)
  //TODO: |--> GUI Blocks all clicks

  if (blocksClicks)
    Game.w.mouseManager.addListener(new MouseListener(
        transform,
        (a:Int, b:Int, c:Int) => {},
        isOffset = false
    ))


}
