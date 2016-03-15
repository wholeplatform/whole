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
package org.whole.lang.grammars.parsers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.CompiledPattern;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.parsers.Lexer;
import org.whole.lang.parsers.Lexer.Memento;
import org.whole.lang.parsers.ParseException;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractPredictiveParser {
	private ILanguageKit languageKit;
	private EntityDescriptorEnum edEnum;
	private FeatureDescriptorEnum fdEnum;

	protected Lexer lexer;
	protected Grammar grammar;

	public AbstractPredictiveParser(Lexer lexer, String grammarUri) {
		this.lexer = lexer;		
		this.grammar = GrammarsRegistry.instance().getGrammar(grammarUri);
		this.languageKit = ReflectionFactory.getLanguageKit(GrammarsUtils.getLanguageURI(grammar), false, null);
		this.edEnum = languageKit.getEntityDescriptorEnum();
		this.fdEnum = languageKit.getFeatureDescriptorEnum();

		LiteralTerminal delimiter = this.grammar.getDelimiter();
		if (EntityUtils.isNotResolver(delimiter)) {
			CompiledPattern pattern = (CompiledPattern) delimiter.getPattern();
			lexer.withDelimiter(pattern.getValue());
		}	
	}

	protected Grammar normalize(Grammar grammar) {
		grammar = EntityUtils.clone(grammar);
		NormalizerOperation.normalize(grammar);
		return grammar;
	}

	protected final IEntity create(String edName) {
		return create(ed(edName));
	}
	protected final IEntity create(EntityDescriptor<?> ed) {
		return GenericEntityFactory.instance.create(ed);
	}
	protected final void setValue(IEntity entity, String token) {
		DataTypeUtils.setFromPersistenceString(entity, token);
	}
	protected EntityDescriptor<?> ed(String name) {
		return edEnum.valueOf(name);
	}
	protected FeatureDescriptor fd(String name) {
		return fdEnum.valueOf(name);
	}

	protected ParseException createParseError(String errorMessage) throws ParseException {
		return new ParseException(lexer, errorMessage);
	}
	protected String nextToken(String regExp) {
		return nextToken(java.util.regex.Pattern.compile(regExp));
	}
	protected String nextToken(java.util.regex.Pattern compiledPattern) {
		lexer.withPattern(compiledPattern);
		if (lexer.hasNext())
			return lexer.next();

		throw createParseError("missing terminal");
	}

	protected static final int NO_MATCH = Integer.MIN_VALUE;
	protected static final int NON_CONSUMING_MATCH = -1;
	protected static final boolean isMatch(int predictResult) {
		return predictResult != NO_MATCH;
	}
	protected static final boolean isConsumingMatch(int predictResult) {
		return predictResult >= 0;
	}
	protected static final int nonConsumingMatch(int predictResult) {
		return -predictResult -1;
	}
	protected static final int indexOfMatch(int predictResult) {
		return predictResult >= 0 ? predictResult : nonConsumingMatch(predictResult);
	}

	protected int wPredict(String location) {
		return wPredict((Rule) EntityUtils.getEntity(grammar, location));
	}
	protected int wPredict(Rule rule) {
		int prediction = NO_MATCH;
		Lexer.Memento memento = mark();
		try {
			prediction = wMatch(rule);
			if (isSame(memento))
				prediction = nonConsumingMatch(prediction);
		} catch (Exception e) {
		}
		reset(memento);
		return prediction;
	}

	protected int wMatch(Rule rule) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String lookaheadMethodName = "match"+((Production) rule).getName().getValue();
		Method method = getClass().getMethod(lookaheadMethodName, new Class<?>[0]);
		return (Integer) method.invoke(this, new Object[0]);
	}

	public void wParse() {
		wParseStartSymbol();
		if (!lexer.hitEnd())
			throw createParseError("end of input expected");
	}

	public abstract void wParseStartSymbol();

	/* Lexer delegate methods */
	protected boolean isSame(Memento memento) {
		return lexer.isSame(memento);
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
	protected int moveHorizonByDelimiter(java.util.regex.Pattern compiledPattern, int endPosition) {
		try {
			return lexer.moveHorizonByDelimiter(compiledPattern, endPosition);
		} catch (IndexOutOfBoundsException e) {
			throw createParseError(e.getLocalizedMessage());
		}
	}
	protected int setHorizonByDelimiter(String regExp) {
		return setHorizonByDelimiter(java.util.regex.Pattern.compile(regExp));
	}
	protected int setHorizonByDelimiter(java.util.regex.Pattern compiledPattern) {
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

}
