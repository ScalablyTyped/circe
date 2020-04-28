package io.circe013.no_java_time

import io.circe013.{ Decoder, Encoder, Json }
import org.scalatest.funsuite.AnyFunSuite

class NoJavaTimeTest extends AnyFunSuite {
  test("Using Decoder should not throw linking errors") {
    assert(Decoder[List[String]].decodeJson(Json.arr()) === Right(Nil))
  }

  test("Using Encoder should not throw linking errors") {
    assert(Encoder[List[String]].apply(Nil) === Json.arr())
  }
}
