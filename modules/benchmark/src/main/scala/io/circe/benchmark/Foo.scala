package io.circe013.benchmark

import cats.kernel.Eq
import io.circe013.{ Decoder, Encoder }
import io.circe013.generic.semiauto._

case class Foo(s: String, d: Double, i: Int, l: Long, bs: List[Boolean])

object Foo {
  implicit val decodeFoo: Decoder[Foo] = deriveDecoder
  implicit val encodeFoo: Encoder[Foo] = deriveEncoder

  implicit val eqFoo: Eq[Foo] = Eq.fromUniversalEquals[Foo]
}
