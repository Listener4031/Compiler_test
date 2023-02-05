package Util.Error;

import Util.position;

public class SyntaxError extends MxError {
	public SyntaxError(String msg, position pos) {
		super("SyntaxError: " + msg, pos);
	}
}
