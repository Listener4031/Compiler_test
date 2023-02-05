package Util.Error;

import Util.position;

public class SemanticError extends MxError {
	public SemanticError(String msg, position pos) {
		super("SemanticError: " + msg, pos);
	}
}
