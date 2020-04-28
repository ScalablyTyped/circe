package io.circe013.generic.util.macros

import io.circe013.{ Decoder, Encoder }
import io.circe013.export.Exported
import io.circe013.generic.decoding.DerivedDecoder
import io.circe013.generic.encoding.DerivedAsObjectEncoder
import scala.reflect.macros.blackbox

class ExportMacros(val c: blackbox.Context) {
  import c.universe._

  final def exportDecoder[D[x] <: DerivedDecoder[x], A](
    implicit
    D: c.WeakTypeTag[D[_]],
    A: c.WeakTypeTag[A]
  ): c.Expr[Exported[Decoder[A]]] = {
    val target = appliedType(D.tpe.typeConstructor, A.tpe)

    c.typecheck(q"_root_.shapeless.lazily[$target]", silent = true) match {
      case EmptyTree => c.abort(c.enclosingPosition, s"Unable to infer value of type $target")
      case t =>
        c.Expr[Exported[Decoder[A]]](
          q"new _root_.io.circe013.export.Exported($t: _root_.io.circe013.Decoder[$A])"
        )
    }
  }

  final def exportEncoder[E[x] <: DerivedAsObjectEncoder[x], A](
    implicit
    E: c.WeakTypeTag[E[_]],
    A: c.WeakTypeTag[A]
  ): c.Expr[Exported[Encoder.AsObject[A]]] = {
    val target = appliedType(E.tpe.typeConstructor, A.tpe)

    c.typecheck(q"_root_.shapeless.lazily[$target]", silent = true) match {
      case EmptyTree => c.abort(c.enclosingPosition, s"Unable to infer value of type $target")
      case t =>
        c.Expr[Exported[Encoder.AsObject[A]]](
          q"new _root_.io.circe013.export.Exported($t: _root_.io.circe013.Encoder.AsObject[$A])"
        )
    }
  }
}
