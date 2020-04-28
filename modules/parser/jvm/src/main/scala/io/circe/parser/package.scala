package io.circe013

import io.circe013.jawn.JawnParser

package object parser extends Parser {
  private[this] val parser = new JawnParser

  def parse(input: String): Either[ParsingFailure, Json] = parser.parse(input)
}
