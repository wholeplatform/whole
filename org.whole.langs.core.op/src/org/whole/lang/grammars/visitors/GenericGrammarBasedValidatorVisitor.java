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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.CompiledPattern;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IDecorationManager;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;

/**
 * @author Enrico Persiani
 */
public class GenericGrammarBasedValidatorVisitor extends GenericIdentityVisitor {

	public GenericGrammarBasedValidatorVisitor() {
	}

	private IDecorationManager decorationManager;
	public IDecorationManager getDecorationManager() {
		if (decorationManager == null)
			decorationManager = ((ValidatorOperation) getOperation()).getDecorationManager();
		return decorationManager;
	}

	protected DataTerminal getDataTerminal(EntityDescriptor<?> ed) {
		return dataTerminals.get(ed);
	}

	protected void validateDataTerminal(IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		if (ed.getDataKind().isEnumValue())
			return;

		String value =  DataTypeUtils.getAsPersistenceString(entity);
		DataTerminal dataTerminal = getDataTerminal(ed);
		if (dataTerminal != null) { 
			Pattern pattern = ((CompiledPattern) dataTerminal.getPattern()).getValue();
	
			if (!pattern.matcher(value).matches())
				getDecorationManager().addError(entity,
						"the data entity doesn't match the pattern: "+pattern.toString(),
						EntityUtils.getLocation(entity));
		} else
			getDecorationManager().addError(entity,
					"the data entity is unknonwn",
					EntityUtils.getLocation(entity));
	}

	private Map<EntityDescriptor<?>, DataTerminal> dataTerminals;
	private void calculateDataTerminals(Grammar grammar) {
		this.dataTerminals = new HashMap<EntityDescriptor<?>, DataTerminal>();
		
		//TODO ensure grammar normalized
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
				if(!ed.getDataKind().isEnumValue()) {
					DataTerminal dataTerminal = Matcher.find(GrammarsEntityDescriptorEnum.DataTerminal, production, false);
					if (dataTerminal == null) {
						NonTerminal nonTerminal = Matcher.find(GrammarsEntityDescriptorEnum.NonTerminal, production, false);
						dataTerminal = Matcher.find(GrammarsEntityDescriptorEnum.DataTerminal, lexicon.get(nonTerminal.getValue()), false);
					}
					dataTerminals.put(ed, EntityUtils.clone(dataTerminal));
				}
			}
	}

	@Override
	public void visit(IEntity entity) {
		Collection<Grammar> grammars = GrammarsRegistry.instance().getGrammarsFor(entity);
		if (grammars.isEmpty())
			throw new IllegalArgumentException("cannot find a suitable grammar to unparse the entity");
		Grammar grammar = grammars.iterator().next();

		calculateDataTerminals(grammar);

		IEntityIterator<IEntity> iterator = IteratorFactory.descendantOrSelfMatcherIterator().withPattern(EntityKinds.DATA);
		iterator.reset(entity);
		while (iterator.hasNext())
			validateDataTerminal(iterator.next());
	}
}
