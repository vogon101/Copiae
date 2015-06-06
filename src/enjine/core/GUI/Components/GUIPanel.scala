package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Input.MouseListener
import enjine.core.{Game, Transform}

/**
 * Created by Freddie on 02/06/2015.
 *
 * Panel to act as basic background for GUI components
 *
 * @param _transform The area to draw it in
 * @param _color The color to draw it
 * @param blocksClicks - T => If a click in this panel, it will not trigger lower down elements
 *
 */
class GUIPanel(private val _transform: Transform,
               private val _color: Color3d,
               val blocksClicks: Boolean = true,
               private val _isOffset: Boolean = false)
  extends GUIElement(_transform, _isOffset){

  color = _color

  if (blocksClicks)
    Game.w.mouseManager.addListener(new MouseListener(
        transform,
        (a:Int, b:Int, c:Int) => {},
        isOffset = isOffset
    ))


}
