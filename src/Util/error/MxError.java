package Util.Error;

import Util.position;

public abstract class MxError extends RuntimeException {
	private final position pos;
	private final String message;

	public MxError (String msg, position pos) {
		this.pos = pos;
		this.message = msg;
	}

	public String toString() {
		return message + ": " + pos.toString();
	}
}
