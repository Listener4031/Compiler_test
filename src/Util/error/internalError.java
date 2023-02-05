package Util.Error;

import Util.position;

public class internalError extends MxError {
	public internalError(String msg, position pos) {
		super("internalError: " + msg, pos);
	}
}
