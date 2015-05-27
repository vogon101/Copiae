package enjine.core.Input

import org.lwjgl.input.Keyboard

import enjine.core.Updateable

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Freddie on 26/05/2015.
 *
 */
class KeyboardManager extends Updateable{

  //DONE: Implement keyboard

  val keyBoardListeners = new ArrayBuffer[KeyboardListener]()

  def addListener (keyboardListener: KeyboardListener) = keyBoardListeners.append(keyboardListener)

  def update (): Unit = {

    while (Keyboard.next()) {
      keyBoardListeners.foreach(k => if(k.eventDriven)k.checkEvent(Keyboard.getEventKey, Keyboard.getEventKeyState))
    }

    keyBoardListeners.foreach(k => if(!k.eventDriven)k.update())

  }

}
