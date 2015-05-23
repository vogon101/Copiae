package enjine.core.DataStructures

import java.awt.Font

import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 23/05/2015.
 *
 */
class TextStyles {

  var JFont : Font = null
  var STANDARD: TrueTypeFont = null


  def init(): Unit = {
    JFont = new Font("Consolas", Font.BOLD, 24)
    STANDARD = new TrueTypeFont(JFont, false)
  }


}
