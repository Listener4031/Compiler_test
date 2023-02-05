package AST.Expression;

import AST.ASTVisitor;
import IR.Value.Value;
import Util.position;

public class MemberExprNode extends ExprNode {
	public ExprNode base;
	public String id;
	public boolean isFunc = false;
	public boolean isArray = false, isStr = false;

	public Value basePointer = null;


	public MemberExprNode(ExprNode base, String id, position pos) {
		super(pos);
		this.base = base;
		this.id = id;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
