package enjine.core.Input

import enjine.core.Updateable
import org.lwjgl.input.Keyboard

/**
 * Created by Freddie on 26/05/2015.
 *
 * Class to listen for keyboard input, can be event driven, ie activated on a discrete press
 * or release or continuous, ie activated each frame when the key is down. If event driven
 * then it can be onPress or onRelease
 *
 * @param key The key to listen for, a static integer found in the LWJGL Keyboard class
 * @param action The code to run when activated
 * @param eventDriven If true then will only be activated on a discrete press/release otherwise it is every frame while the key is down
 * @param onPress If eventDriven then this determined if it should be activated onPress (T) or onRelease (F)
 *
 */
class KeyboardListener(val key: Int,
                       val action: () => Unit,
                       val eventDriven: Boolean = false,
                       val onPress: Boolean = true) extends Updateable{

  /**
   * Update the key if it is not eventDriven
   */
  def update(): Unit = {
    if (!eventDriven) {
      if (Keyboard.isKeyDown(key))
        action()
    }
  }

  /**
   * Check the key on an event if it is eventDriven
   * @param eKey The key integer of the event
   * @param isPress True if the event is a press, false if it is a release
   */
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
