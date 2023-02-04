package AST.Expression;

import AST.ASTVisitor;
import Util.Position;

public class SuffixExprNode extends ExprNode {
	public ExprNode value;
	public String op;

	public SuffixExprNode(ExprNode value, String op, Position pos) {
		super(pos);
		this.value = value;
		this.op = op;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
