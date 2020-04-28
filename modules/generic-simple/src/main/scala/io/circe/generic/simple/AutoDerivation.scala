package io.circe013.generic.simple

import io.circe013.{ Decoder, Encoder }
import io.circe013.export.Exported
import io.circe013.generic.simple.decoding.DerivedDecoder
import io.circe013.generic.simple.encoding.DerivedAsObjectEncoder
import io.circe013.generic.simple.util.macros.ExportMacros
import scala.language.experimental.macros

/**
 * Fully automatic codec derivation.
 *
 * Extending this trait provides [[io.circe013.Decoder]] and [[io.circe013.Encoder]]
 * instances for case classes (if all members have instances), "incomplete" case classes, sealed
 * trait hierarchies, etc.
 */
trait AutoDerivation {
  implicit def exportDecoder[A]: Exported[Decoder[A]] = macro ExportMacros.exportDecoder[DerivedDecoder, A]
  implicit def exportEncoder[A]: Exported[Encoder.AsObject[A]] =
    macro ExportMacros.exportEncoder[DerivedAsObjectEncoder, A]
}
