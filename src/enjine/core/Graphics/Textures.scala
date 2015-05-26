package enjine.core.Graphics

import java.io.File

import org.newdawn.slick.opengl.{TextureLoader, Texture}
import org.newdawn.slick.util.ResourceLoader

/**
 * Created by Freddie on 26/05/2015.
 *
 */
object Textures {

  val GRASS: Texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("./res/grass.jpg"))
  val UNIT: Texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/unit.png"))
  val dir1 = new File (".")
  val dir2 = new File ("..")

  System.out.println ("Current dir : " + dir1.getCanonicalPath)
  System.out.println ("Parent  dir : " + dir2.getCanonicalPath)


}
