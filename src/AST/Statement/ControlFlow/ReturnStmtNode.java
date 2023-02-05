package AST.Statement.ControlFlow;

import AST.ASTVisitor;
import AST.Expression.ExprNode;
import AST.Statement.StmtNode;
import Util.position;

public class ReturnStmtNode extends StmtNode {
	public ExprNode value;
	public ReturnStmtNode(ExprNode value, position pos) {
		super(pos);
		this.value = value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
