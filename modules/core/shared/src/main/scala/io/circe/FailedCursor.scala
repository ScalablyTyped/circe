package io.circe013

import cats.Applicative

final class FailedCursor(lastCursor: HCursor, lastOp: CursorOp) extends ACursor(lastCursor, lastOp) {

  /**
   * Indicates whether the last operation failed because the type of the focus
   * was wrong.
   */
  def incorrectFocus: Boolean =
    (lastOp.requiresObject && !lastCursor.value.isObject) || (lastOp.requiresArray && !lastCursor.value.isArray)

  def succeeded: Boolean = false
  def success: Option[HCursor] = None

  def focus: Option[Json] = None
  def top: Option[Json] = None

  def withFocus(f: Json => Json): ACursor = this
  def withFocusM[F[_]](f: Json => F[Json])(implicit F: Applicative[F]): F[ACursor] = F.pure(this)

  def values: Option[Iterable[Json]] = None
  def keys: Option[Iterable[String]] = None

  def downArray: ACursor = this
  def downField(k: String): ACursor = this
  def downN(n: Int): ACursor = this
  def leftN(n: Int): ACursor = this
  def rightN(n: Int): ACursor = this
  def up: ACursor = this

  def left: ACursor = this
  def right: ACursor = this
  def first: ACursor = this
  def last: ACursor = this

  def delete: ACursor = this

  def field(k: String): ACursor = this
}
