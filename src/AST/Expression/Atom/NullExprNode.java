package AST.Expression.Atom;

import AST.ASTVisitor;
import Util.position;

public class NullExprNode extends AtomExprNode {
	public NullExprNode(position pos) {
		super(pos);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
