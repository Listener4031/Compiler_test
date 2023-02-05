package AST.Expression;

import AST.ASTVisitor;
import Util.position;

public class BinaryBoolExprNode extends BinaryExprNode{
	public BinaryBoolExprNode(ExprNode left, ExprNode right, String op, position pos) {
		super(left, right, op, pos);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
