package AST.Expression;

import AST.ASTVisitor;
import Util.position;

public class PrefixExprNode extends ExprNode {
	public ExprNode value;
	public String op;

	public PrefixExprNode(ExprNode value, String op, position pos) {
		super(pos);
		this.value = value;
		this.op = op;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
