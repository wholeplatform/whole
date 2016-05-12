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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class Lexer implements Iterator<String> {
	protected CharSequence source;
	protected int position;
	protected int horizonPosition = -1;
	protected Matcher matcher;
	protected Pattern tokenPattern;
	protected Pattern delimPattern;
	protected boolean delimited = false;
	protected String lookahead;
	protected int lookaheadPosition = -1;

	public static Lexer createLexer(CharSequence source) {
		return new Lexer(source);
	}

	public Lexer(CharSequence source) {
		tokenPattern = Pattern.compile("(?s).*");
		matcher = tokenPattern.matcher(this.source = source);
	}

	public Lexer withPattern(Pattern pattern) {
		matcher.usePattern(tokenPattern = pattern);
		lookahead = null;
		lookaheadPosition = -1;
		return this;
	}

	public Lexer withDelimiter(Pattern pattern) {
		delimPattern = pattern;
		lookahead = null;
		lookaheadPosition = -1;
		return this;
	}

	public boolean hitEnd() {
		int endPosition = position;
		if (delimited) { 
			matcher.usePattern(delimPattern);
			if (!matcher.region(position, getEndPosition()).lookingAt())
				return false;
			else
				endPosition = matcher.end();
		}
		return endPosition == getEndPosition();
	}

	public static class Memento {
		public final int position;
		public final int horizonPosition;
		
		public Memento(int position, int horizonPosition) {
			this.position = position;
			this.horizonPosition = horizonPosition;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Memento))
				return false;
			Memento other = (Memento) obj;
			return position == other.position && horizonPosition == other.horizonPosition;
		}
	}

	public boolean isSame(Memento memento) {
		return position == memento.position && horizonPosition == memento.horizonPosition;
	}
	public Memento mark() {
		return new Memento(position, horizonPosition);
	}
	public void reset(Memento memento) {
		position = memento.position;
		horizonPosition = memento.horizonPosition;
		lookahead = null;
		lookaheadPosition = -1;
	}

//	public boolean find() {
//		return matcher.region(position, getEndPosition()).find();
//	}

	public String lookahead() {
		if (lookahead != null)
			return lookahead;
		
		try {
			if (delimPattern != null) {
				matcher.usePattern(delimPattern);
				if (!matcher.region(position, getEndPosition()).lookingAt())
					return null;
	
				int tokenStart = matcher.end();
				matcher.region(tokenStart, getEndPosition());
				boolean foundNextDelim = matcher.find();
				if (!foundNextDelim)
					return null;
				
				if (matcher.end() == tokenStart) {
					if (!matcher.usePattern(tokenPattern).lookingAt())
						return null;
				} else {
					int tokenEnd = matcher.start();
		            if (!matcher.usePattern(tokenPattern).region(tokenStart, tokenEnd)
		            		.matches())
		            	return null;
				}

				delimited = true;
	 		} else if (!matcher.usePattern(tokenPattern).region(position, getEndPosition()).lookingAt())
				return null;
		} catch (Exception e) {
			return null;
		}

		lookaheadPosition = matcher.end();
		for (int g=1, groupCount = matcher.groupCount(); g<=groupCount; g++) {
			String group = matcher.group(g);
			if (group != null)
				return group;
		}
		return lookahead = matcher.group();
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public String next() {
		String token = lookahead();
		if (token == null)
			throw new NoSuchElementException();
		
		position = lookaheadPosition;
		lookahead = null;
		lookaheadPosition = -1;
		return token;
	}

	protected int findHorizonPosition(int startPosition, Pattern pattern) {
		return findHorizonPosition(startPosition, horizonPosition ,pattern);
	}
	protected int findHorizonPosition(int startPosition, int endPosition ,Pattern pattern) {
		matcher.usePattern(pattern);
		if (!matcher.region(startPosition, getEndPosition(endPosition)).find())
			throw new ParseException(this, "Unable to find the new horizon position");

		final int groupCount = matcher.groupCount();
		for (int g=1; g<=groupCount; g++) {
			String group = matcher.group(g);
			if (group != null)
				return matcher.start(g);
		}
		return matcher.start();
	}

	public int getHorizonPosition() {
		return horizonPosition;
	}
	public int setHorizonPosition(int position, boolean force) {
		if (!force && position > getEndPosition())
			throw new ParseException(this, "The new horizon position is over the current one");

		int oldHorizonPosition = horizonPosition;
		horizonPosition = position;
		lookahead = null;
		lookaheadPosition = -1;
		return oldHorizonPosition;
	}
	public int setHorizonBySize(int length) {
		return setHorizonPosition(position + length, false);
	}
	public int setHorizonByDelimiter(Pattern pattern) {
		return setHorizonPosition(findHorizonPosition(position, pattern), false);
	}
	public int moveHorizonByDelimiter(Pattern pattern, int endPosition) {
		return setHorizonPosition(findHorizonPosition(horizonPosition+1, endPosition, pattern), false);
	}
	public int setHorizonByLines(int lines) {
		if (lines <= 0)
			throw new ParseException(this, "bad horizon lines number");
		
		int position = this.position;
		for (int i=0; i<lines; i++)
			position = findHorizonPosition(position, StringUtils.EOL_PATTERN);
		return setHorizonPosition(position, false);
	}

	public void unsetHorizon() {
		horizonPosition = -1;
		lookahead = null;
		lookaheadPosition = -1;
	}
//	public int getPosition() {
//	return position;
//	}
	protected int getEndPosition() {
		return getEndPosition(horizonPosition);
	}
	protected int getEndPosition(int endPosition) {
		return endPosition == -1 ? source.length() : endPosition;
	}

	private static final int CHARS_TO_PRINT = 30;
	public String toString() {
		int start = Math.max(0, position-CHARS_TO_PRINT);
		int end = Math.min(source.length(), position+CHARS_TO_PRINT);

		StringBuilder sb = new StringBuilder();
		if (start < end) {
			sb.append("after input '[...]");
			sb.append(StringUtils.escapeString(
					source.subSequence(start, position).toString(), false, true));
			sb.append("' got, at offset ");
			sb.append(position);
			sb.append(", '");
			sb.append(StringUtils.escapeString(source.subSequence(position, end).toString(), false, true));
			sb.append("[...]'");
		} else {
			sb.append("got '' at offset ");
			sb.append(position);
		}
		return sb.toString();
	}
}
