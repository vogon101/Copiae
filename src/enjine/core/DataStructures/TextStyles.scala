package enjine.core.DataStructures

import java.awt.Font

import org.newdawn.slick.TrueTypeFont

/**
 * Created by Freddie on 23/05/2015.
 *
 * Use this to hold any fonts you use in your game
 * The instance of this is held in GUIController, change it to one you have overridden to use your own fonts
 *
 */
class TextStyles {

  var JFont : Font = null
  var STANDARD: TrueTypeFont = null


  /**
   * Initialise the fonts, called once at start of game by GUIController
   */
  def init(): Unit = {
    JFont = new Font("Consolas", Font.BOLD, 24)
    STANDARD = new TrueTypeFont(JFont, false)
  }

}
