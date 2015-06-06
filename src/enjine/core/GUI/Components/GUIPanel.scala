package enjine.core.GUI.Components

import enjine.core.DataStructures.Color3d
import enjine.core.GUI.GUIElement
import enjine.core.Graphics.R
import enjine.core.Input.MouseListener
import enjine.core.{Game, Transform}
import org.newdawn.slick.opengl.Texture

/**
 * Created by Freddie on 02/06/2015.
 *
 * Panel to act as basic background for GUI components
 *
 * @param _transform The area to draw it in
 * @param _color The color to draw it
 * @param blocksClicks - T => If a click in this panel, it will not trigger lower down elements
 * @param _isOffset - Should this be offset by world.xOffset/yOffset
 * @param _texture - The texture to draw
 *
 */
class GUIPanel(private val _transform: Transform,
               private val _color: Color3d,
               val blocksClicks: Boolean = true,
               private val _isOffset: Boolean = false,
               private val _texture: Texture = null )
  extends GUIElement(_transform, _isOffset){

  color = _color
  texture = _texture

  //Add a listener to block clicks below it if requested
  if (blocksClicks)
    Game.w.mouseManager.addListener(new MouseListener(
        transform,
        (a:Int, b:Int, c:Int) => {},
        isOffset = isOffset
    ))


}
