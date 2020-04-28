package io.circe013.parser

import io.circe013.Json
import io.circe013.testing.ParserTests
import io.circe013.tests.CirceSuite

class ParserSuite extends CirceSuite {
  checkAll("Parser", ParserTests(`package`).fromString)

  "parse and decode(Accumulating)" should "fail on invalid input" in forAll { (s: String) =>
    assert(parse(s"Not JSON $s").isLeft)
    assert(decode[Json](s"Not JSON $s").isLeft)
    assert(decodeAccumulating[Json](s"Not JSON $s").isInvalid)
  }
}
