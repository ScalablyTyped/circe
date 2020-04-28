package io.circe013

import scala.collection.mutable.Builder

private[circe013] abstract class CompatBuilder[A, C] extends Builder[A, C] {
  def addOne(elem: A): this.type

  final def +=(elem: A): this.type = addOne(elem)
}
