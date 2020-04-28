package io.circe013.hygiene

import io.circe013.generic.auto._
import io.circe013.syntax._

sealed trait Foo
case class Bar(xs: scala.List[java.lang.String]) extends Foo
case class Qux(i: scala.Int, d: scala.Option[scala.Double]) extends Foo

/**
 * Compilation tests for macro hygiene.
 *
 * Fake definitions suggested by Jason Zaugg.
 */
object HygieneTests {
  val foo: Foo = Bar(scala.List("abc", "def", "ghi"))
  val json = foo.asJson.noSpaces
}
