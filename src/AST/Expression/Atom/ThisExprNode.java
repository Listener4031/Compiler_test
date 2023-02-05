package AST.Expression.Atom;

import AST.ASTVisitor;
import Util.position;

public class ThisExprNode extends AtomExprNode {
	public ThisExprNode(position pos) {
		super(pos);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
