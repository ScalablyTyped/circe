package io.circe013.literal

import io.circe013.{ Decoder, Encoder }
import org.scalatest.funspec.AnyFunSpec
import shapeless.Witness

class LiteralInstancesSuite extends AnyFunSpec {
  describe("A literal String codec") {
    it("should round-trip values") {
      val w = Witness("foo")

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Double codec") {
    it("should round-trip values") {
      val w = Witness(0.0)

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Float codec") {
    it("should round-trip values") {
      val w = Witness(0.0f)

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Long codec") {
    it("should round-trip values") {
      val w = Witness(0L)

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Int codec") {
    it("should round-trip values") {
      val w = Witness(0)

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Char codec") {
    it("should round-trip values") {
      val w = Witness('a')

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }

  describe("A literal Boolean codec") {
    it("should round-trip values") {
      val w = Witness(true)

      assert(Decoder[w.T].apply(Encoder[w.T].apply(w.value).hcursor) === Right(w.value))
    }
  }
}
