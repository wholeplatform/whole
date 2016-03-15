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
package scheme.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

class SchemeScanner {
    static public final int EOF = 0;
    static public final int BOOL = 1;
    static public final int INT = 2;
    static public final int STRING = 3;
    static public final int OPEN = 10;
    static public final int CLOSE = 11;
    static public final int ID = 12;

    private BufferedReader source;
    private int line;
    private int ch;
    private int toBeRead;
    private int token;
    private String value;

    public SchemeScanner(InputStream s) throws java.io.IOException {
	source = new BufferedReader(new InputStreamReader(s));
	line = 1;
	ch = 0;
	toBeRead = 1;
	nextToken();
    }

    private static boolean isInitialIdChar(char ch) {
	return Character.isLetter(ch) || "!$%&*/:<=>?^_~+-".indexOf(ch) >= 0;
    }

    private static boolean isSubsequentIdChar(char ch) {
	return isInitialIdChar(ch) || Character.isDigit(ch) || ".@".indexOf(ch) >= 0;
    }

    public boolean more() throws java.io.IOException {
	return ch >= 0;
    }

    private char getChar() throws java.io.IOException {
	while (ch >= 0 && toBeRead > 0) {
	    ch = source.read();
	    if (ch == '\n') line++;
	    toBeRead--;
	}
	return (char) ch;
    }

    private void nextChar() {
	toBeRead++;
    }

    private void skipSpaces() throws java.io.IOException {
	while (true) {
	    while (more() && Character.isWhitespace(getChar()))
		nextChar();
	    if (getChar() == ';')
		while (more() && getChar() != '\n')
		    nextChar();
	    else
		break;
	}
    }

    private void setToken(int t, String v) {
	token = t;
	value = v;
    }

    private void setToken(int t) {
	setToken(t, "");
    }

    public int getToken() {
	return token;
    }

    public String getValue() {
	return value;
    }

    public int getLine() {
	return line;
    }

    public void printToken() {
	switch (getToken()) {
	case OPEN:
	    System.out.println("OPEN");
	    break;
	case CLOSE:
	    System.out.println("CLOSE");
	    break;
	case ID:
	    System.out.println("ID " + getValue());
	    break;
	case BOOL:
	    System.out.println("BOOL " + getValue());
	    break;
	case INT:
	    System.out.println("INT " + getValue());
	    break;
	case STRING:
	    System.out.println("STRING " + getValue());
	    break;
	}
    }

    public void nextToken() throws java.io.IOException {
	skipSpaces();
	if (more()) {
	    if (Character.isDigit(getChar())) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getChar());
		nextChar();
		while (more() && Character.isDigit(getChar())) {
		    buffer.append(getChar());
		    nextChar();
		}
		setToken(INT, buffer.toString());
	    } else if (isInitialIdChar(getChar())) {
		StringBuffer buffer = new StringBuffer();
		while (more() && isSubsequentIdChar(getChar())) {
		    buffer.append(getChar());
		    nextChar();
		}
		setToken(ID, buffer.toString());		
	    } else {
		switch (getChar()) {
		case '#':
		    nextChar();
		    switch (getChar()) {
		    case 't': 
			nextChar();
			setToken(BOOL, "t");
			break;
		    case 'f':
			nextChar();
			setToken(BOOL, "f");
			break;
		    default:
			break; // error
		    }
		    break;
		case '(':
		    nextChar();
		    setToken(OPEN);
		    break;
		case ')':
		    nextChar();
		    setToken(CLOSE);
		    break;
		case '"':
		    nextChar();
		    StringBuffer buffer = new StringBuffer();
		    while (more() && getChar() != '"') {
			buffer.append(getChar());
			nextChar();
		    }
		    if (more()) nextChar();
		    else ; // error open string
		    setToken(STRING, buffer.toString());
		    break;
		default:
		    nextChar();
		    break; // error
		}
	    }
	} else
	    setToken(EOF);
    }

}
