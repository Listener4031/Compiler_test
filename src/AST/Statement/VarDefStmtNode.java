package AST.Statement;

import AST.ASTVisitor;
import Util.position;

import java.util.ArrayList;

public class VarDefStmtNode extends StmtNode {
	public ArrayList<VarDefSubStmtNode> varList;

	public VarDefStmtNode(ArrayList<VarDefSubStmtNode> varList, position pos) {
		super(pos);
		this.varList = varList;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
