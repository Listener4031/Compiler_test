package Util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class position {
	private final int row, column;

	public position() {
		this.row = 0;
		this.column = 0;
	}

	public position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public position(Token token) {
		this.row = token.getLine();
		this.column = token.getCharpositionInLine();
	}

	public position(TerminalNode terminal) {
		this(terminal.getSymbol());
	}

	public position(ParserRuleContext ctx) {
		this(ctx.getStart()); //?
	}

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}

	public String toString() {
		return row + ", " + column;
	}
}
