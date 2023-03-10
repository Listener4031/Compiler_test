package AST.Expression.Atom;

import AST.ASTVisitor;
import IR.Value.Global.Function;
import Util.position;

public class VarExprNode extends AtomExprNode {
	public boolean isFunc = false;
	public String id;

	public Function classFunc = null;

	public VarExprNode(String id, position pos) {
		super(pos);
		this.id = id;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
