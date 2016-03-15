/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.parsers;

import org.whole.lang.exceptions.IWholeFrameworkException;

/**
 * @author Enrico Persiani
 */
public class ParseException extends RuntimeException implements IWholeFrameworkException {
	private static final long serialVersionUID = 1L;
	
	private final Lexer lexer;

	public ParseException(Lexer lexer, String message, Throwable cause) {
		super(message+", "+lexer.toString(), cause);
		this.lexer = lexer;
	}
	public ParseException(Lexer lexer, String message) {
		super(message+", "+lexer.toString());
		this.lexer = lexer;
	}
	public ParseException(Lexer lexer) {
		super(lexer.toString());
		this.lexer = lexer;
	}

	public Lexer getLexer() {
		return lexer;
	}
}
