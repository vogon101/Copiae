package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.Graphics.R
import enjine.core.Transform
import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class GUIText(var text: String, var font: TrueTypeFont, var transform: Transform) extends GUIElement{

  def this (obj: Object, font: TrueTypeFont, transform: Transform) {
    this (obj.toString, font, transform)
  }

  def render (): Unit = {R.glDrawText(text, font,transform)}
}
