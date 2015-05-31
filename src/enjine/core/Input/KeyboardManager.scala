package enjine.core.Input

import org.lwjgl.input.Keyboard

import enjine.core.Updateable

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 26/05/2015.
 *
 * Class to manage all keyboard input, has an array buffer of KeyboardListeners which can listen for keyboard events
 *
 */
class KeyboardManager extends Updateable{

  //DONE: Implement keyboard

  /**
   * The ArrayBuffer of listeners
   */
  val keyBoardListeners = new ArrayBuffer[KeyboardListener]()

  /**
   * Add a listener to the list
   * @param keyboardListener The Listener to add
   */
  def addListener (keyboardListener: KeyboardListener) = keyBoardListeners.append(keyboardListener)

  /**
   * Update the keyboard ie poll for input. Called once per frame by the Game
   */
  def update (): Unit = {

    while (Keyboard.next()) {
      keyBoardListeners.foreach(k => if(k.eventDriven)k.checkEvent(Keyboard.getEventKey, Keyboard.getEventKeyState))
    }

    keyBoardListeners.foreach(k => if(!k.eventDriven)k.update())

  }

}