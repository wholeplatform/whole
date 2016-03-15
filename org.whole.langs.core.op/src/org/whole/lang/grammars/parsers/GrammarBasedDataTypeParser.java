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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.ForwardStrategyDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class GrammarBasedDataTypeParser extends ForwardStrategyDataTypeParser {
	private String grammarURI;
	private String delimiter = "";
	private String space = " ";
	private String newLine = "\n";
	private String indent = "    ";
	private Locale locale;
	private Map<EntityDescriptor<?>, DataTerminal> dataTerminals;
	private Map<EnumValue, Rule> enumRules;

	public GrammarBasedDataTypeParser(String grammarUri) {
		this(grammarUri, Locale.getDefault());
	}
	public GrammarBasedDataTypeParser(String grammarUri, Locale locale) {
		this.grammarURI = grammarUri;

		Grammar grammar = GrammarsRegistry.instance().getGrammar(grammarUri);

		LiteralTerminal lt = grammar.getDelimiter();
		if (EntityUtils.isNotResolver(lt))
			delimiter = lt.getLiteral().getValue();
		space = EntityUtils.safeStringValue(grammar.getSpaceLiteral(), space);
		indent = EntityUtils.safeStringValue(grammar.getIndentLiteral(), indent);
		newLine = EntityUtils.safeStringValue(grammar.getNewLineLiteral(), newLine);

		this.locale = locale;
		this.dataTerminals = new HashMap<EntityDescriptor<?>, DataTerminal>();
		this.enumRules = new HashMap<EnumValue, Rule>();

		Map<String, Rule> productions = new HashMap<String, Rule>();
		IEntityIterator<Production> pi = IteratorFactory.<Production>childIterator();
		pi.reset(grammar.getPhraseStructure());
		for (Production p : pi)
			productions.put(p.getName().getValue(), p.getRule());

		Map<String, Rule> lexicon = new HashMap<String, Rule>();
		IEntityIterator<Production> li = IteratorFactory.<Production>childIterator();
		li.reset(grammar.getLexicalStructure());
		for (Production p : li)
			lexicon.put(p.getName().getValue(), p.getRule());

		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(GrammarsUtils.getLanguageURI(grammar), false, null);
		EntityDescriptorEnum edEnum = languageKit.getEntityDescriptorEnum();
		for (EntityDescriptor<?> ed : edEnum)
			if (EntityUtils.isData(ed)) {
				Rule production = productions.get(ed.getName());
				if(ed.getDataKind().isEnumValue()) {
					for (int i=0, size=production.wSize(); i<size; i++) {
						As as = EntityUtils.clone((As) production.wGet(i));
						IEntityIterator<Rule> iterator = IteratorFactory.<Rule>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.NonTerminal);
						iterator.reset(as);
						while (iterator.hasNext()) {
							NonTerminal nt = (NonTerminal) iterator.next();
							iterator.set(EntityUtils.clone(lexicon.get(nt.getValue())));
						}
						enumRules.put(ed.getDataEnumType().valueOf(as.getName().getValue()), as.getRule());
					}
				} else {
					DataTerminal dataTerminal = Matcher.find(GrammarsEntityDescriptorEnum.DataTerminal, production, false);
					if (dataTerminal == null) {
						NonTerminal nonTerminal = Matcher.find(GrammarsEntityDescriptorEnum.NonTerminal, production, false);
						dataTerminal = Matcher.find(GrammarsEntityDescriptorEnum.DataTerminal, lexicon.get(nonTerminal.getValue()), false);
					}
					dataTerminals.put(ed, EntityUtils.clone(dataTerminal));
				}
			}

		setStrategy(new GrammarsDefaultDataTypeParser(this));
	}

	public String getGrammarURI() {
		return grammarURI;
	}
	public String getDelimiter() {
		return delimiter;
	}
	public String getSpace() {
		return space;
	}
	public String getIndent() {
		return indent;
	}
	public String getNewLine() {
		return newLine;
	}
	public DataTerminal getDataTerminal(EntityDescriptor<?> ed) {
		return dataTerminals.get(ed);
	}
	public Rule getEnumRule(EnumValue value) {
		return enumRules.get(value);
	}

	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
