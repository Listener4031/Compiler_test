package AST.Definition;

import AST.ASTVisitor;
import AST.Statement.BlockStmtNode;
import Util.position;

public class ConstructorDefNode extends DefNode {
	public String id;
	public BlockStmtNode body;

	public ConstructorDefNode(String id, BlockStmtNode body, position pos) {
		super(pos);
		this.id = id;
		this.body = body;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
