package enjine.core.GUI.Components

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
 * @param _isOffset - Should this be offset by world.xOffset/yOffset
 * @param _calculateSize - Should this calculate its own size based on the text or
 *
 */
class GUITextObjTracker(var evaluator:()=> Any,
                        private val _font: TrueTypeFont,
                        private val _transform: Transform,
                        private val _color: Color3d,
                        private val _isOffset: Boolean = false,
                        private val _calculateSize: Boolean= true)
  extends GUIText (evaluator (), _font, _transform, _color, _isOffset = _isOffset, calculateSize = _calculateSize) with Updateable{

  //TODO: Make obj tracking more elegant - FABRI 0.2
  //TODO: All types clickable

  /**
   * Update the text each tick
   */
  override def update (): Unit = {
    text = evaluator().toString
    if (calculateSize) {
      transform.xSize = font.getWidth(evaluator().toString)
      transform.ySize = font.getHeight(evaluator().toString)
    }
  }

}
