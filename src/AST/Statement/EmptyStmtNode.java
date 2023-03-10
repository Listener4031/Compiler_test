package AST.Statement;

import AST.ASTVisitor;
import Util.position;

public class EmptyStmtNode extends StmtNode {
	public EmptyStmtNode(position pos) {
		super(pos);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
