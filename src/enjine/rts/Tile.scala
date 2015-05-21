package enjine.rts

import enjine.core.{GameObject, Transform}
import org.lwjgl.opengl.GL11

/**
 * Created by Freddie on 20/05/2015.
 *
 */
class Tile(transform: Transform) extends GameObject(transform){

  //TODO: GameObject should have a renderable trait

  override def render(): Unit = {

    GL11.glPushMatrix()



    GL11.glPopMatrix()

  }


}
