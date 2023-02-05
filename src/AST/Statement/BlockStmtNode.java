package AST.Statement;

import AST.ASTVisitor;
import Util.position;

import java.util.ArrayList;

public class BlockStmtNode extends StmtNode {
	public ArrayList<StmtNode> body;
	public BlockStmtNode(ArrayList<StmtNode> body, position pos) {
		super(pos);
		this.body = body;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
