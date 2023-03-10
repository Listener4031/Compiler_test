package AST.Expression;

import AST.ASTVisitor;
import AST.Statement.BlockStmtNode;
import AST.Statement.VarDefSubStmtNode;
import Util.position;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode {
	public ArrayList<VarDefSubStmtNode> paramList;
	public BlockStmtNode body;
	public boolean isCapture;

	public LambdaExprNode(ArrayList<VarDefSubStmtNode> param, boolean isCapture, BlockStmtNode body, position pos) {
		super(pos);
		this.paramList = param;
		this.isCapture = isCapture;
		this.body = body;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
