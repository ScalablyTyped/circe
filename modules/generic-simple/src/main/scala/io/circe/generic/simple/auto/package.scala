package io.circe013.generic.simple

/**
 * Fully automatic codec derivation.
 *
 * Importing the contents of this package object provides [[io.circe013.Decoder]] and [[io.circe013.Encoder]]
 * instances for case classes (if all members have instances), "incomplete" case classes, sealed
 * trait hierarchies, etc.
 */
package object auto extends AutoDerivation
