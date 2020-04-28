package io.circe013.cursor

import io.circe013.{ ACursor, CursorOp, HCursor, Json }

private[circe013] final class TopCursor(val value: Json)(
  lastCursor: HCursor,
  lastOp: CursorOp
) extends HCursor(lastCursor, lastOp) {
  def replace(newValue: Json, cursor: HCursor, op: CursorOp): HCursor = new TopCursor(newValue)(cursor, op)
  def addOp(cursor: HCursor, op: CursorOp): HCursor = new TopCursor(value)(cursor, op)

  def up: ACursor = fail(CursorOp.MoveUp)
  def delete: ACursor = fail(CursorOp.DeleteGoParent)

  def left: ACursor = fail(CursorOp.MoveLeft)
  def right: ACursor = fail(CursorOp.MoveRight)
  def first: ACursor = fail(CursorOp.MoveFirst)

  def field(k: String): ACursor = fail(CursorOp.Field(k))
}
