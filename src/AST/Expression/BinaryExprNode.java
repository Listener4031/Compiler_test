package AST.Expression;

import AST.ASTVisitor;
import Util.position;

public class BinaryExprNode extends ExprNode {
	public ExprNode left, right;
	public String op;

	public BinaryExprNode(ExprNode left, ExprNode right, String op, position pos) {
		super(pos);
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
