package io.circe013.testing

import io.circe013.JsonNumber

private[testing] trait ArbitraryJsonNumberTransformer {
  def transformJsonNumber(n: JsonNumber): JsonNumber = n
}
