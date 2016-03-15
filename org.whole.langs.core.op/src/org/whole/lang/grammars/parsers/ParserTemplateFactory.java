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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Concatenate;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Optional;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.parsers.Lexer;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ParserTemplateFactory<E extends IEntity> extends AbstractTemplateFactory<E> {
	private Grammar grammar;
	private NonTerminal startSymbol;
	private List<ActivationState> currentStates = new ArrayList<ActivationState>();
	private Lexer lexer;
	private Lexer.Memento lexerMemento;
	private int lookaheadLevel;
	private ILanguageKit languageKit;
	private EntityDescriptorEnum edEnum;
	private EntityDescriptor<? extends IEntity> ed;
	private IBuilderOperation operation;
	private IBuilder builder;

	public ParserTemplateFactory(Lexer lexer, Grammar grammar) {
		this(lexer, grammar, grammar.getStartSymbol());
	}
	public ParserTemplateFactory(Lexer lexer, Grammar grammar, String startSymbol) {
		this(lexer, grammar, GrammarsEntityFactory.instance.createNonTerminal(startSymbol));
	}
	public ParserTemplateFactory(Lexer lexer, Grammar grammar, NonTerminal startSymbol) {
		this.lexer = lexer;
		this.grammar = normalize(grammar);
		this.startSymbol = startSymbol;
		this.languageKit = ReflectionFactory.getLanguageKit(GrammarsUtils.getLanguageURI(grammar), false, null);
		this.edEnum = languageKit.getEntityDescriptorEnum();
	}

	public void apply(IBuilderOperation operation) {
		this.operation = operation;

		builder = operation.wGetBuilder(GrammarsLanguageKit.URI);//FIXME workaround to get a generic builder
		currentStates.add(new ActivationState(null, createActiveRule(startSymbol)));
		
		//TODO && currentStates contains a terminal state
		while (!lexer.hitEnd()) {
			propagateActivation();//TODO return terminalSet
			completeProductions(filterActivation(matchTerminals()));
		}
	}

	public void enterLookaheadMode() {
		if (++lookaheadLevel == 1) {
			lexerMemento = lexer.mark();
			disableActions();
		}
	}
	protected void disableActions() {
		
	}

	public void exitLookaheadMode() {
		if (--lookaheadLevel == 0) {
			lexer.reset(lexerMemento);
			enableActions();
		}
	}
	protected void enableActions() {
		
	}

	/*
	 * For every ActiveRule in currentStates starting with a NonTerminal
	 * add its production to the current state.
	 * For each current state, calculate the set of productions added
	 * and mark with the recursive flag rules performing a recursive call.
	 */
	public Set<ActiveRule> propagateActivation() {
		Set<ActiveRule> terminalSet = new HashSet<ActiveRule>();

		for (ActivationState as : currentStates) {
			Set<NonTerminal> recursiveSet = new HashSet<NonTerminal>();
			ListIterator<ActiveRule> activeRules = as.getActiveRules().listIterator();
			while (activeRules.hasNext()) {
				propagateActivation(terminalSet, recursiveSet, activeRules, activeRules.next());
			}
		}
		
		return terminalSet;
	}
	protected void propagateActivation(Set<ActiveRule> terminalSet, Set<NonTerminal> recursiveSet, ListIterator<ActiveRule> activeRules, ActiveRule ar) {
		Rule dotRule = ar.getDotRule();
		switch (dotRule.wGetEntityOrd()) {
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
			terminalSet.add(ar);
			break;
		case GrammarsEntityDescriptorEnum.NonTerminal_ord:
			NonTerminal nt = (NonTerminal) dotRule;
			if (recursiveSet.add(nt)) {
				activeRules.add(ar = createActiveRule(nt));
				propagateActivation(terminalSet, recursiveSet, activeRules, ar);
			} else
				ar.setRecursive(true);
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			Concatenate c = (Concatenate) dotRule;
			if (c.wSize() > 0) {
				ar.setDotRule((Rule) c.wGet(0));
				propagateActivation(terminalSet, recursiveSet, activeRules, ar);
			}
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
			Optional o = (Optional) dotRule;
			ar.setDotRule(o.getRule());
			propagateActivation(terminalSet, recursiveSet, activeRules, ar);
			//TODO add also the rule after the optional
			break;
		case GrammarsEntityDescriptorEnum.Repeat_ord:
			Repeat r = (Repeat) dotRule;
			//TODO check lower bound and split active state for repeat continuation if 0
			ar.setDotRule(r.getRule());
			propagateActivation(terminalSet, recursiveSet, activeRules, ar);
			break;
		case GrammarsEntityDescriptorEnum.As_ord:
			As as = (As) dotRule;
			ar.setDotRule(as.getRule());
			propagateActivation(terminalSet, recursiveSet, activeRules, ar);
			break;
		}
	}

	protected ActiveRule createActiveRule(NonTerminal nt) {
		Production p = getProduction(nt);
		ed = edEnum.valueOf(nt.getValue());//FIXME mapping
		if (!ed.getEntityKind().isData())
			builder.wEntity_(ed);
		return new ActiveRule(p.getName(), p.getRule());
	}
	protected Production getProduction(NonTerminal nt) {
		//TODO cache in a map
		IEntityIterator<Production> pi = IteratorFactory.<Production>childIterator();
		pi.reset(grammar.getPhraseStructure());
		for (Production p : pi)
			if (p.getName().wEquals(nt))
				return p;
		IEntityIterator<Production> li = IteratorFactory.<Production>childIterator();
		li.reset(grammar.getLexicalStructure());
		for (Production p : li)
			if (p.getName().wEquals(nt))
				return p;

		throw new IllegalArgumentException("Production not found: "+nt);
	}

	/*
	 * For every ActiveRule in currentStates starting with a Terminal
	 * match it with the lexer and advance or remove it.
	 * 
	 */
	public Set<ActiveRule> matchTerminals() {
		Set<ActiveRule> matchSet = new HashSet<ActiveRule>();
		java.util.regex.Pattern pattern = null;
		for (ActivationState as : currentStates) {
			ListIterator<ActiveRule> activeRules = as.getActiveRules().listIterator();
			while (activeRules.hasNext()) {
				ActiveRule ar = activeRules.next();
				Rule dotRule = ar.getDotRule();
				switch (dotRule.wGetEntityOrd()) {
				case GrammarsEntityDescriptorEnum.DataTerminal_ord:
				case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
					java.util.regex.Pattern p = (java.util.regex.Pattern) dotRule.wGet(GrammarsFeatureDescriptorEnum.pattern).wGetValue();
					lexer.withPattern(p);
					if (lexer.hasNext()) {
						if (pattern == null || p.pattern().equals(pattern.pattern())) {
							pattern = p;
							matchSet.add(ar);
							String token = lexer.next();
							if (dotRule.wGetEntityDescriptor().equals(GrammarsEntityDescriptorEnum.DataTerminal))
								builder.wEntity(ed, token);
						} else
							throw new IllegalStateException("Backtracking is required for processing multiple matching patterns: ..., "+pattern.pattern());

					} else
						activeRules.remove();
				}
			}
		}
		return matchSet;
	}

	/*
	 * 
	 */
	public Set<ActiveRule> filterActivation(Set<ActiveRule> matchSet) {
		if (matchSet.isEmpty())
			throw new IllegalStateException("ParserException");//TODO ParserException
		
		Set<ActiveRule> completeSet = new HashSet<ActiveRule>();
		
		//TODO filter rules not advanced from the matchSet
		for (ActiveRule ar : matchSet) {
			updateRule(completeSet, ar);
		}
		
		return completeSet;
	}

	protected void updateRule(Set<ActiveRule> completeSet, ActiveRule ar) {
		updateRule(completeSet, ar, ar.getDotRule());
	}
	protected void updateRule(Set<ActiveRule> completeSet, ActiveRule ar, Rule dotRule) {
		Rule dotRuleParent = (Rule) dotRule.wGetParent();
		switch (dotRuleParent.wGetEntityOrd()) {
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			int dotRuleIndex = dotRuleParent.wIndexOf(dotRule);
			if (dotRuleIndex+1 < dotRuleParent.wSize())
				ar.setDotRule((Rule) dotRuleParent.wGet(dotRuleIndex+1));
			else
				updateRule(completeSet, ar, dotRuleParent);
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
		case GrammarsEntityDescriptorEnum.As_ord:
			updateRule(completeSet, ar, dotRuleParent);
			break;
		case GrammarsEntityDescriptorEnum.Production_ord:
			ar.setDotRule(dotRuleParent);
			completeSet.add(ar);
			break;
		//TODO repeat behavior
		}
	}

	/*
	 * For every empty ActiveRule in currentStates
	 * remove it and advance rules waiting on the production NonTerminal
	 */
	public void completeProductions(Set<ActiveRule> completeSet) {
		if (completeSet.isEmpty())
			return;

		for (ActivationState as : currentStates) {
			ListIterator<ActiveRule> activeRules = as.getActiveRules().listIterator();
			while (activeRules.hasNext()) {
				ActiveRule ar = activeRules.next();
				
				if (completeSet.contains(ar)) {
					EntityDescriptor<? extends IEntity> ed = edEnum.valueOf(ar.getNt().getValue());//FIXME mapping
					if (!ed.getEntityKind().isData())
						builder._wEntity(ed);
					activeRules.remove();
				} else {
					Rule dotRule = ar.getDotRule();
					if (dotRule.wGetEntityDescriptor().equals(GrammarsEntityDescriptorEnum.NonTerminal))
						for (ActiveRule cr : completeSet)
							if (cr.getNt().wEquals(dotRule))
								updateRule(completeSet, ar, dotRule); //TODO use another completeSet
				}
			}
		}
	}

	public static Grammar normalize(Grammar grammar) {
		grammar = EntityUtils.clone(grammar);
		NormalizerOperation.normalize(grammar);
		GrammarsUtils.ensureCompiledPatterns(grammar);
		return grammar;
	}

	@Override
	public String toString() {
		return currentStates.toString();
	}
}
