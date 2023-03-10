package AST.Type;


import Util.Error.semanticError;
import Util.position;

import java.util.HashMap;

public class ClassType extends Type {
	public final String name;
	public HashMap<String, Type> var = new HashMap<>();
	public HashMap<String, FuncType> func = new HashMap<>();
	public FuncType constructor = null;

	public ClassType(String name) {
		super(TypeEnum.CLASS);
		this.name = name;
	}

	public void addVar(String name, Type t, position pos) {
		if (var.containsKey(name)) {
			throw new semanticError("Variable redefine", pos);
		}
		var.put(name, t);
	}

	public Type getVarType(String name, position pos) {
		if (var.containsKey(name)) {
			return var.get(name);
		} else {
			throw new semanticError("Variable not found: " + name, pos);
		}
	}

	public void addFunc(String name, FuncType type, position pos) {
		if (func.containsKey(name)){
			throw new semanticError("Member func already defined " + name, pos);
		}
		func.put(name, type);
	}


	public FuncType getFuncType(String name, position pos) {
		if (func.containsKey(name)) {
			return func.get(name);
		} else {
			throw new semanticError("Function not found: " + name, pos);
		}
	}

	public boolean equals(Object rhs) {
		return super.equals(rhs) && name.equals(((ClassType)rhs).name);
	}
}
