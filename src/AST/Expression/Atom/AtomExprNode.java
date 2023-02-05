package AST.Expression.Atom;

import AST.Expression.ExprNode;
import Util.position;

public abstract class AtomExprNode extends ExprNode {
	public AtomExprNode(position pos) {
		super(pos);
	}
}
