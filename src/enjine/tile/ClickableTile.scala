package enjine.tile

import enjine.core.Input.MouseListener
import enjine.core.{Game, Transform}
import enjine.tile.data.TileType

/**
 * Created by Freddie on 29/05/2015.
 *
 * A tile that automatically adds a MouseListener so it can be clicked
 *
 */
class ClickableTile(private val _tileType:TileType,
                    private val _transform: Transform,
                    private val _x: Int,
                    private val _y: Int,
                    val onClick: (Int, Int, Int) => Unit)
  extends Tile(_tileType,
    _transform,
    _x,
    _y){


  Game.w.mouseManager.addListener(new MouseListener(transform, onClick))


}
