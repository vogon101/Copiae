package enjine.core.Input

import enjine.core.Updateable
import org.lwjgl.input.Keyboard

/**
 * Created by Freddie on 26/05/2015.
 *
 */
class KeyboardListener(val key: Int,
                       val action: () => Unit,
                       val eventDriven: Boolean = false,
                       val onPress: Boolean = true) extends Updateable{

  def update(): Unit = {
    if (!eventDriven) {
      if (Keyboard.isKeyDown(key))
        action()
    }
  }

  def checkEvent (eKey: Int, isPress: Boolean): Unit = {
    //If this listener is event driven and not continuous polling
    if (eventDriven){
      //If the event is the right type (release/press)
      if(isPress == onPress) {
        //If it is the right key
        if (eKey == key) {
          action()
        }
      }
    }
  }

}
