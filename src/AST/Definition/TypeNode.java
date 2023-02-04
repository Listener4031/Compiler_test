package AST.Definition;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Type.TypeEnum;
import Util.position;

public class TypeNode extends ASTNode {

	public TypeEnum type;
	public String identifier;
	public int dim;

	public IR.Type.Type irType = null;

	public TypeNode(TypeEnum type, String identifier, int dim, position pos) {
		super(pos);
		this.type = type;
		this.identifier = identifier;
		this.dim = dim;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
