package enjine.core.GUI

import enjine.core.DataStructures.Color3d
import enjine.core.{Transform, Updateable}
import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 24/05/2015.
 *
 * This class is for GUIText that needs to update every tick, pass a Unit to be evaluated as the text
 *
 * @param evaluator The Unit that returns the text each tick
 * @param _font The font to use
 * @param _transform The position of the text
 * @param _color The colour of the text
 *
 */
class GUITextObjTracker(var evaluator:()=> Any, private val _font: TrueTypeFont, private val _transform: Transform, private val _color: Color3d) extends GUIText (evaluator(), _font, _transform, _color) with Updateable{

  //TODO: Make obj tracking more elegant - FABRI

  /**
   * Update the text each tick
   */
  override def update (): Unit = text = evaluator().toString

}
