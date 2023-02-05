package AST.Statement.ControlFlow;

import AST.ASTVisitor;
import AST.Expression.ExprNode;
import AST.Statement.StmtNode;
import Util.position;

public class IfStmtNode extends StmtNode {
	public ExprNode condition;
	public StmtNode thenStmt, elseStmt;

	public IfStmtNode(ExprNode condition, StmtNode thenStmt, StmtNode elseStmt, position pos) {
		super(pos);
		this.condition = condition;
		this.thenStmt = thenStmt;
		this.elseStmt = elseStmt;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
