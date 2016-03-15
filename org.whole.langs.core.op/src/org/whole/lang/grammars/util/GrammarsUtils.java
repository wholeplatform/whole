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
package org.whole.lang.grammars.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.codebase.IGrammarProvider;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.DataType;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.TargetLanguage;
import org.whole.lang.grammars.parsers.GenericPredictiveParser;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.GrammarBasedUnparserVisitor;
import org.whole.lang.grammars.visitors.Grammars2ModelsVisitor;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class GrammarsUtils {
	public static Model deriveModel(Grammar g, boolean normalizeGrammar) {
		Grammars2ModelsVisitor v = new Grammars2ModelsVisitor(normalizeGrammar);
		v.visit(g);
		return (Model) v.getResult();
	}

	public static String getLanguageURI(Grammar grammar) {
		TargetLanguage targetLanguage = grammar.getTargetLanguage();
		return Matcher.match(GrammarsEntityDescriptorEnum.URI, targetLanguage) ?
				targetLanguage.wStringValue() : ((LanguageDescriptor) targetLanguage).getUri().getValue();
	}

	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E parse(CharSequence source, String grammarUri) {
		ModelBuilderOperation mop = new ModelBuilderOperation();
		parse(source, grammarUri, mop);
		return (E) mop.wGetResult();
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E parse(CharSequence source, String grammarUri, String nt) {
		ModelBuilderOperation mop = new ModelBuilderOperation();
		parse(source, grammarUri, mop, nt);
		return (E) mop.wGetResult();
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E parse(CharSequence source, String grammarUri, EntityDescriptor<?> ed) {
		ModelBuilderOperation mop = new ModelBuilderOperation();
		parse(source, grammarUri, mop, ed);
		return (E) mop.wGetResult();
	}
	public static void parse(CharSequence source, String grammarUri, IBuilderOperation op) {
		new GenericPredictiveParser(source, grammarUri, op).wParse();
	}
	public static void parse(CharSequence source, String grammarUri, IBuilderOperation op, String nt) {
		new GenericPredictiveParser(source, grammarUri, op).wParse(nt);
	}
	public static void parse(CharSequence source, String grammarUri, IBuilderOperation op, EntityDescriptor<?> ed) {
		new GenericPredictiveParser(source, grammarUri, op).wParse(ed);
	}

//	public static <E extends IEntity> E parse(Readable source, Grammar g) {
//	}
//	public static <E extends IEntity> E parse(Readable source, Grammar g, String nt) {
//	}
//	public static <E extends IEntity> E parse(Readable source, Grammar g, EntityDescriptor<E> ed) {
//	}

	public static void unparse(IEntity e, Appendable appendable, String grammarUri) {
		unparse(e, appendable, grammarUri, BindingManagerFactory.instance.createBindingManager());
	}
	public static void unparse(IEntity e, Appendable appendable, String grammarUri, IBindingManager bm) {
		Grammar g = GrammarsRegistry.instance().getGrammar(grammarUri);
		if (g == null)
			throw new IllegalArgumentException("Grammar not deployed: "+grammarUri);
		new GrammarBasedUnparserVisitor(e, appendable, bm).visit(g);
	}

	private static final String[] DATA_TYPES = new String[] {
		"boolean","byte","char","double","float","int","long","short","String","java.util.Date"
	};
	public static String getDataType(DataType dataType) {
		return DATA_TYPES[dataType.getValue().getOrdinal()];
	}

	public static String getGrammarUri(IBindingManager bm) {
		String grammarUri = null;
		boolean grammarFromBindings = bm.wIsSet("grammar");
		if (grammarFromBindings) {
			Grammar grammar = (Grammar) bm.wGet("grammar");
			InterpreterOperation.interpret(grammar, bm);
			grammarUri = grammar.getUri().getValue();
		} else if (bm.wIsSet("grammarURI"))
			grammarUri = bm.wStringValue("grammarURI");

		if (grammarUri == null && bm.wIsSet("grammarProvider")) {
			IGrammarProvider provider = (IGrammarProvider) bm.wGetValue("grammarProvider");
			grammarUri = provider.getGrammarUri(null);
		}
		return grammarUri;
	}

	public static void ensureCompiledPatterns(Grammar grammar) {
		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.RegExp);
		i.reset(grammar);

		while (i.hasNext()) {
			IEntity pattern = i.next();
			if (EntityUtils.isNotResolver(pattern)) {
				if (Matcher.match(GrammarsEntityDescriptorEnum.CompiledPattern, pattern))
					return;
				else {
					i.reset(grammar);
					break;
				}
			}
		}

		while (i.hasNext()) {
			IEntity e = i.next();
			i.set(GrammarsEntityFactory.instance.createCompiledPattern(java.util.regex.Pattern.compile(e.wStringValue())));
		}
	}
}
