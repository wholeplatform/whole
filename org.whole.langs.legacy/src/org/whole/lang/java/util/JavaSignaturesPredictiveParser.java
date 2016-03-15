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
package org.whole.lang.java.util;

import java.lang.reflect.Array;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.whole.lang.parsers.*;
import org.whole.lang.parsers.Lexer.Memento;
import org.whole.lang.util.StringUtils;

/**
 * @generator Whole
 * 
 * Modified to make it grammar independent
 */
public class JavaSignaturesPredictiveParser {
	protected Lexer lexer;
	protected ClassLoader loader;
	protected boolean isVarArgs;

	private static final String WHITESPACE = "\\p{javaWhitespace}";
	private static final String IDENTIFIER_START = "\\p{javaJavaIdentifierStart}";
	private static final String IDENTIFIER_PART = "\\p{javaJavaIdentifierPart}";

	public JavaSignaturesPredictiveParser(Lexer lexer, ClassLoader loader) {
		this.lexer = lexer;
		this.loader = loader;
		this.lexer.withDelimiter(java.util.regex.Pattern.compile(WHITESPACE+"*"));
	}
	public JavaSignaturesPredictiveParser(CharSequence text, ClassLoader loader) {
		this(Lexer.createLexer(text), loader);
	}

	/* BEGIN copied from abstract predictive parser */
	protected ParseException createParseError(String errorMessage) throws ParseException {
		return new ParseException(lexer, errorMessage);
	}
	protected String nextToken(String regExp) {
		return nextToken(java.util.regex.Pattern.compile(regExp));
	}
	protected String nextToken(Pattern compiledPatern) {
		lexer.withPattern(compiledPatern);
		if (lexer.hasNext())
			return lexer.next();

		throw createParseError("missing terminal");
	}

	protected Lexer.Memento mark() {
		return lexer.mark();
	}
	protected void reset(Lexer.Memento memento) {
		lexer.reset(memento);
	}
	protected boolean hitEnd() {
		return lexer.hitEnd();
	}
	protected int getHorizonPosition() {
		return lexer.getHorizonPosition();
	}
	protected int setHorizonPosition(int position, boolean force) {
		return lexer.setHorizonPosition(position, force);
	}
	protected int setHorizonBySize(int length) {
		try {
			return lexer.setHorizonBySize(length);
		} catch (IndexOutOfBoundsException e) {
			throw createParseError(e.getLocalizedMessage());
		}
	}
	protected int moveHorizonByDelimiter(String regExp, int endPosition) {
		return moveHorizonByDelimiter(java.util.regex.Pattern.compile(regExp), endPosition);
	}
	protected int moveHorizonByDelimiter(Pattern compiledPattern, int endPosition) {
		try {
			return lexer.moveHorizonByDelimiter(compiledPattern, endPosition);
		} catch (IndexOutOfBoundsException e) {
			throw createParseError(e.getLocalizedMessage());
		}
	}
	protected int setHorizonByDelimiter(String regExp) {
		return setHorizonByDelimiter(java.util.regex.Pattern.compile(regExp));
	}
	protected int setHorizonByDelimiter(Pattern compiledPattern) {
		try {
			return lexer.setHorizonByDelimiter(compiledPattern);
		} catch (IndexOutOfBoundsException e) {
			throw createParseError(e.getLocalizedMessage());
		}
	}
	protected int setHorizonByLines(int lines) {
		try {
			return lexer.setHorizonByLines(lines);
		} catch (IndexOutOfBoundsException e) {
			throw createParseError(e.getLocalizedMessage());
		}
	}
	/* END copied from abstract predictive parser */

	public List<JavaReflectUtils.JavaSignature> parseSignatures() {
		List<JavaReflectUtils.JavaSignature> signatures = new ArrayList<JavaReflectUtils.JavaSignature>();
		int count = 0;
		while (true) {
			if (count == 0 && !hasSignature() || count > 0 && !hasToken())
				break;
			if (count > 0)
				matchToken();
			isVarArgs = false;
			signatures.add(parseSignature());
			count++;
		}
		return signatures;
	}

	public JavaReflectUtils.JavaSignature parseSignature() {
		String name = parseName();
		matchToken1();
		int horizon1 = setHorizonByDelimiter("\\)");
		List<Class<?>> types = parseTypes();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken2();
		return JavaReflectUtils.create(name, types.toArray(new Class<?>[0]), isVarArgs);
	}

	public String parseName() {
		return nextToken(IDENTIFIER_START+IDENTIFIER_PART+"*");
	}

	public List<Class<?>> parseTypes() {
		List<Class<?>> typeList = new ArrayList<Class<?>>();
		int count = 0;
		while (true) {
			if (count == 0 && predictType() == -1 || count > 0 && !hasToken3())
				break;
			if (count > 0) {
				if (isVarArgs)
					throw createParseError("varArgs must be the last type parameter");
				matchToken3();
			}
			typeList.add(parseType());
			count++;
		}
		return typeList;
	}

	public Class<?> parseType() {
		Class<?> type;
		switch (predictType()) {
		case 0 :
			type = parseArrayType();
			break;
		case 1 :
			type = parseParameterizedType();
			break;
		case 2 :
			type = parseVarArgType();
			break;
		case 3 :
			type = parseWildcardType();
			break;
		case 4 :
			type = parsePrimitiveType();
			break;
		case 5 :
			type = parseQualifiedType();
			break;
		default :
			throw createParseError("missing choose step");
		}
		return type;
	}

	public Class<?> parseWildcardType() {
		matchToken4();
		return WildcardType.class;
	}

	public Class<?> parseArrayType() {
		int horizon1 = setHorizonByDelimiter("\\[");

		Lexer.Memento memento;
		while (true) {
			memento = mark();
			try {
				matchType();
				if (hitEnd())
					break;
				reset(memento);
			} catch (ParseException e) {
			}
			moveHorizonByDelimiter("\\[", horizon1);
		}
		int lastHorizon;
		while (true) {
			lastHorizon = getHorizonPosition();
			try {
				moveHorizonByDelimiter("\\[", horizon1);
				matchType();
			} catch (ParseException e) {
				break;
			}
		}
		reset(memento);
		setHorizonPosition(lastHorizon, false);

		Class<?> componentType = parseType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		int dimensions =  parseDimensions();
		return Array.newInstance(componentType, new int[dimensions]).getClass();
	}

	public int parseDimensions() {
		return nextToken("((\\[\\])+)").length() / 2;
	}

	public Class<?> parseParameterizedType() {
		int horizon1 = setHorizonByDelimiter("<");
		Class<?> baseType = parseType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken5();
		parseTypeParameters();
		matchToken6();
		return baseType;
	}

	public Class<?> parseVarArgType() {
		isVarArgs = true;
		int horizon1 = setHorizonByDelimiter("\\.\\.\\.");
		Class<?> componentType = parseType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken7();
		return Array.newInstance(componentType, 0).getClass();
	}

	public List<Class<?>> parseTypeParameters() {
		List<Class<?>> typeList = new ArrayList<Class<?>>();
		int count = 0;
		while (count < 1) {
			if (count > 0)
				matchToken3();
			typeList.add(parseType());
			count++;
		}
		while (true) {
			if (count == 0 && predictType() == -1 || count > 0 && !hasToken3())
				break;
			if (count > 0)
				matchToken3();
			typeList.add(parseType());
			count++;
		}
		return typeList;
	}

	public Class<?> parsePrimitiveType() {
		return StringUtils.primitiveClass(nextToken("char|boolean|byte|short|int|long|float|double"));
	}

	public Class<?> parseQualifiedType() {
		String qtype = nextToken("("+IDENTIFIER_START+IDENTIFIER_PART+"*(\\."+IDENTIFIER_START+IDENTIFIER_PART+"*)*)");
		qtype = StringUtils.isAmbiguous(qtype) ? "java.lang."+ qtype : qtype;
		try {
			return JavaReflectUtils.forName(qtype, loader);
		} catch (IllegalArgumentException e) {
			int index = qtype.lastIndexOf('.');
			try {
				return JavaReflectUtils.forName(qtype.substring(0, index)+"$"+qtype.substring(index+1), loader);
			} catch (IllegalArgumentException x) {
				throw e;
			}
		}
	}

	public int matchSignatures() {
		int prediction = 0;
		while (true) {
			boolean added = false;
			try {
				matchSignature();
				prediction++;
				added = true;
				matchToken();
			} catch (ParseException e) {
				if (!added && prediction > 0)
					throw createParseError("cannot apply repeat rule");
				if (prediction < 0)
					throw createParseError("lower bound not reached in repeat rule");
				break;
			}
		}
		return prediction;
	}

	public boolean hasSignature() {
		Memento memento = mark();
		try {
			matchSignature();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			reset(memento);
		}
	}
	public int matchSignature() {
		int prediction = 0;
		matchName();
		matchToken1();
		int horizon1 = setHorizonByDelimiter("\\)");
		matchTypes();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken2();
		return prediction;
	}

	public int matchName() {
		int prediction = 0;
		nextToken(IDENTIFIER_START+IDENTIFIER_PART+"*");
		return prediction;
	}

	public int matchTypes() {
		int prediction = 0;
		while (true) {
			boolean added = false;
			try {
				matchType();
				prediction++;
				added = true;
				matchToken3();
			} catch (ParseException e) {
				if (!added && prediction > 0)
					throw createParseError("cannot apply repeat rule");
				if (prediction < 0)
					throw createParseError("lower bound not reached in repeat rule");
				break;
			}
		}
		return prediction;
	}

	public int predictType() {
		Memento memento = mark();
		try {
			return matchType();
		} catch (Exception e) {
			return -1;
		} finally {
			reset(memento);
		}
	}
	public int matchType() {
		int prediction = 0;
		Lexer.Memento memento = mark();
		while (true) {
			try {
				matchArrayType();
				prediction = 0;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			try {
				matchParameterizedType();
				prediction = 1;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			try {
				matchVarArgType();
				prediction = 2;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			try {
				matchWildcardType();
				prediction = 3;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			try {
				matchPrimitiveType();
				prediction = 4;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			try {
				matchQualifiedType();
				prediction = 5;
				break;
			} catch (ParseException e) {
				reset(memento);
			}
			throw createParseError("cannot apply choose rule");
		}
		return prediction;
	}

	public int matchWildcardType() {
		int prediction = 0;
		matchToken4();
		return prediction;
	}

	public int matchArrayType() {
		int prediction = 0;
		int horizon1 = setHorizonByDelimiter("\\[");

		Lexer.Memento memento;
		while (true) {
			memento = mark();
			try {
				matchType();
				if (hitEnd())
					break;
				reset(memento);
			} catch (ParseException e) {
			}
			moveHorizonByDelimiter("\\[", horizon1);
		}
		int lastHorizon;
		while (true) {
			lastHorizon = getHorizonPosition();
			try {
				moveHorizonByDelimiter("\\[", horizon1);
				matchType();
			} catch (ParseException e) {
				break;
			}
		}
		reset(memento);
		setHorizonPosition(lastHorizon, false);

		matchType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchDimensions();
		return prediction;
	}

	public int matchDimensions() {
		int prediction = 0;
		nextToken("((\\[\\])+)");
		return prediction;
	}

	public int matchParameterizedType() {
		int prediction = 0;
		int horizon1 = setHorizonByDelimiter("<");
		matchType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken5();
		matchTypeParameters();
		matchToken6();
		return prediction;
	}

	public int matchVarArgType() {
		int prediction = 0;
		int horizon1 = setHorizonByDelimiter("\\.\\.\\.");
		matchType();
		if (hitEnd())
			setHorizonPosition(horizon1, true);
		else
			throw createParseError("bad horizon constraint");
		matchToken7();
		return prediction;
	}

	public int matchTypeParameters() {
		int prediction = 0;
		while (true) {
			boolean added = false;
			try {
				matchType();
				prediction++;
				added = true;
				matchToken3();
			} catch (ParseException e) {
				if (!added && prediction > 0)
					throw createParseError("cannot apply repeat rule");
				if (prediction < 1)
					throw createParseError("lower bound not reached in repeat rule");
				break;
			}
		}
		return prediction;
	}

	public int matchPrimitiveType() {
		int prediction = 0;
		nextToken("char|boolean|byte|short|int|long|float|double");
		return prediction;
	}

	public int matchQualifiedType() {
		int prediction = 0;
		nextToken("("+IDENTIFIER_START+IDENTIFIER_PART+"*(\\."+IDENTIFIER_START+IDENTIFIER_PART+"*)*)");
		return prediction;
	}

	public boolean hasToken() {
		Memento memento = mark();
		try {
			matchToken();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			reset(memento);
		}
	}
	public int matchToken() {
		int prediction = 0;
		nextToken(";");
		return prediction;
	}

	public int matchToken1() {
		int prediction = 0;
		nextToken("\\(");
		return prediction;
	}

	public int matchToken2() {
		int prediction = 0;
		nextToken("\\)");
		return prediction;
	}

	public boolean hasToken3() {
		Memento memento = mark();
		try {
			matchToken3();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			reset(memento);
		}
	}
	public int matchToken3() {
		int prediction = 0;
		nextToken(",");
		return prediction;
	}

	public int matchToken4() {
		int prediction = 0;
		nextToken("\\Q?\\E");
		return prediction;
	}

	public int matchToken5() {
		int prediction = 0;
		nextToken("<");
		return prediction;
	}

	public int matchToken6() {
		int prediction = 0;
		nextToken(">");
		return prediction;
	}

	public int matchToken7() {
		int prediction = 0;
		nextToken("\\.\\.\\.");
		return prediction;
	}
}
