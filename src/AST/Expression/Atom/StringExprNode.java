package AST.Expression.Atom;

import AST.ASTVisitor;
import Util.position;

public class StringExprNode extends AtomExprNode {
	public String value;

	public StringExprNode(String value, position pos) {
		super(pos);
		this.value = value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
