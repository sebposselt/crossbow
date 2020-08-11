package com.audienceproject.crossbow.expr

trait BaseOps {

  self: Expr =>

  def ===(other: Expr): Expr = BaseOps.EqualTo(this, other)

  def =!=(other: Expr): Expr = BaseOps.EqualTo(this, other).not()

}

private object BaseOps {

  case class EqualTo(lhs: Expr, rhs: Expr) extends BinaryExpr(lhs, rhs) {
    override def typeSpec(lhsOperand: Specialized[_], rhsOperand: Specialized[_]): Specialized[_] =
      specialize[Any, Any, Any](lhsOperand, rhsOperand, _ == _)
  }

}
