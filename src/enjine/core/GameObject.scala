package enjine.core

import enjine.Transform

/**
 * Created by Freddie on 20/05/2015.
 *
 *
 */
abstract  class GameObject (val transform: Transform) {

  require(transform != null)

}
