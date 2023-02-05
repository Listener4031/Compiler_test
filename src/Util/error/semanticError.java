package Util.Error;

import Util.position;

public class semanticError extends MxError {
	public semanticError(String msg, position pos) {
		super("semanticError: " + msg, pos);
	}
}
