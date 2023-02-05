package Util.Error;

import Util.position;

public class InternalError extends MxError {
	public InternalError(String msg, position pos) {
		super("InternalError: " + msg, pos);
	}
}
