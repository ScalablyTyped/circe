package io.circe013

import cats.laws.discipline.ContravariantTests
import io.circe013.tests.CirceSuite

class KeyEncoderSuite extends CirceSuite {
  checkAll("KeyEncoder[Int]", ContravariantTests[KeyEncoder].contravariant[Int, Int, Int])
}
