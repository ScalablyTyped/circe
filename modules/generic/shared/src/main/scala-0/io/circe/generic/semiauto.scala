package io.circe013.generic

import io.circe013.{ Codec, Decoder, Encoder }
import scala.deriving.Mirror

/**
 * Semi-automatic codec derivation.
 *
 * This object provides helpers for creating [[io.circe013.Decoder]] and [[io.circe013.ObjectEncoder]]
 * instances for case classes, "incomplete" case classes, sealed trait hierarchies, etc.
 *
 * Typical usage will look like the following:
 *
 * {{{
 *   import io.circe013._, io.circe013.generic.semiauto._
 *
 *   case class Foo(i: Int, p: (String, Double))
 *
 *   object Foo {
 *     implicit val decodeFoo: Decoder[Foo] = deriveDecoder[Foo]
 *     implicit val encodeFoo: Encoder.AsObject[Foo] = deriveEncoder[Foo]
 *   }
 * }}}
 */
object semiauto {
  inline final def deriveDecoder[A](given inline A: Mirror.Of[A]): Decoder[A] = Decoder.derived[A]
  inline final def deriveEncoder[A](given inline A: Mirror.Of[A]): Encoder.AsObject[A] = Encoder.AsObject.derived[A]
  inline final def deriveCodec[A](given inline A: Mirror.Of[A]): Codec.AsObject[A] = Codec.AsObject.derived[A]
}
