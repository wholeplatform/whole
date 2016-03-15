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
package org.whole.lang.grammars.visitors;

import static org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum.As;
import static org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum.Grammar;
import static org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum.Name;
import static org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum.NonTerminal;
import static org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum.Production;
import static org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum.name;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.KindTestEnum;
import org.whole.lang.queries.model.Path;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class GrammarsContentAssistVisitor extends GrammarsIdentityVisitor {
	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}
	protected IEntity getSelectedEntity() {
		return getOperation().getSelectedEntity();
	}

	public static Set<String> calculateNonTerminalValues(IEntity e) {

		Grammar grammar = Matcher.findAncestor(Grammar, e);
		if (grammar != null) {
			Set<String> names = new HashSet<String>();
			IEntity parent = e.wGetParent();

			ILanguageKit languageKit = getLanguageKitIfExists(grammar);
			if (languageKit != null) {
				if (!grammar.getLexicalStructure().equals(parent.wGetParent()))
					names.addAll(languageKit.getEntityDescriptorEnum().names());

				if (!parent.wGetFeatureDescriptor(e).equals(name)) {
					QueriesEntityFactory qef = QueriesEntityFactory.instance;
					Path allTokenNames = qef.createPath(
							qef.createSequence(
									qef.createFeatureStep("lexicalStructure"),
									qef.createFeatureStep("phraseStructure")),
							qef.createChildStep(), qef.createFilter(
									qef.createFeatureStep("name"),
									qef.createKindTest(KindTestEnum.IMPL)));
					for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(allTokenNames, grammar))
						names.add(nt.getValue());
				}
			} else {
				AbstractPatternFilterIterator<NonTerminal> i = IteratorFactory.<NonTerminal>descendantOrSelfMatcherIterator().withPattern(NonTerminal);
				i.reset(grammar);
				for (NonTerminal nt : i)
					if (EntityUtils.isNotResolver(nt))
						names.add(nt.getValue());
			}
			return names;
		}
		return Collections.emptySet();
	}

	public static Set<String> calculateAsNameValues(IEntity e) {
		Grammar grammar = Matcher.findAncestor(Grammar, e);
		if (grammar != null) {
			Production production = Matcher.findAncestor(Production, e);
			String entityName = production.getName().getValue();
			
			ILanguageKit languageKit = getLanguageKitIfExists(grammar);
			if (languageKit != null) {
				EntityDescriptor<?> ed = languageKit.getEntityDescriptorEnum().valueOf(entityName);
				if (ed != null) {
					Set<String> names = new HashSet<String>();
					for (FeatureDescriptor fd : ed.getEntityFeatureDescriptors())
						names.add(fd.getName());
					return names;
				}
			}
		}
		return Collections.emptySet();
	}
	public static ILanguageKit getLanguageKitIfExists(Grammar grammar) {
		String languageURI = GrammarsUtils.getLanguageURI(grammar);
		return ReflectionFactory.hasLanguageKit(languageURI, false, null) ? 
				ReflectionFactory.getLanguageKit(languageURI, false, null) : null;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		if (Matcher.match(NonTerminal, entity))
			getOperation().setResult(calculateNonTerminalValues(entity), NonTerminal);
		else if (Matcher.match(Name, entity) && Matcher.match(As, entity.wGetParent()))
			getOperation().setResult(calculateAsNameValues(entity), Name);
		return false;
	}

	@Override
	public void visit(NonTerminal entity) {
		getOperation().setResult(calculateNonTerminalValues(entity), NonTerminal);
	}

	@Override
	public void visit(Name entity) {
		if (Matcher.match(As, entity.wGetParent()))
			getOperation().setResult(calculateAsNameValues(entity), Name);
	}
}
