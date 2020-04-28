package io.circe013.benchmark

import io.circe013.Json
import io.circe013.syntax._

class ExampleData {
  val ints: List[Int] = (0 to 1000).toList
  val booleans: List[Boolean] = ints.map(_ % 2 == 0)

  val foos: Map[String, Foo] = List
    .tabulate(100) { i =>
      ("b" * i) -> Foo("a" * i, (i + 2.0) / (i + 1.0), i, i * 1000L, (0 to i).map(_ % 2 == 0).toList)
    }
    .toMap

  val intsJson: Json = ints.asJson
  val booleansJson: Json = booleans.asJson
  val foosJson: Json = foos.asJson
  val helloWorldJson: Json = Json.obj("message" -> Json.fromString("Hello, World!"))
}
