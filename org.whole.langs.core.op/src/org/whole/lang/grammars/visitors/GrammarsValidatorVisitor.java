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

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.IGrammarsEntity;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.RegExp;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IDecorationManager;
import org.whole.lang.operations.ValidatorOperation;

/**
 * @author Riccardo Solmi
 */
public class GrammarsValidatorVisitor extends GrammarsIdentityDefaultVisitor {
	private IDecorationManager decorationManager;
	public IDecorationManager getDecorationManager() {
		if (decorationManager == null)
			decorationManager = ((ValidatorOperation) getOperation()).getDecorationManager();
		return decorationManager;
	}

	@Override
	public void visit(IGrammarsEntity entity) {
		Grammar g = Matcher.findAncestor(GrammarsEntityDescriptorEnum.Grammar, entity);
		if (g != null)
			visit(g);
	}
	@Override
	public void visit(Grammar entity) {
		resolverAnalisys(entity);
		defUseAnalisys(entity);
		checkPatterns(entity);
		checkFormats(entity);
	}

	public static void resolverAnalisys(Grammar entity) {
		//TODO
	}

	public void checkPatterns(Grammar entity) {
		AbstractPatternFilterIterator<RegExp> i = IteratorFactory.<RegExp>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.RegExp);
		i.reset(entity);
		for (RegExp regex : i) {
			try {
				Pattern.compile(regex.getValue());
			} catch (PatternSyntaxException e) {
				getDecorationManager().addError(regex, e.toString(), regex.getValue());
			}
		}
	}

	public static void checkFormats(Grammar entity) {
		//TODO
//		for (Format format : IteratorFactory.<Format>topDownMatcherIterator(entity).usePattern(GrammarsEntityDescriptorEnum.Format)) {
//			new Formatter().format(format, args)
//		}
	}

	public void defUseAnalisys(Grammar entity) {
		Set<String> ntDefs = new HashSet<String>();
		Set<String> ntUses = new HashSet<String>();
		Set<NonTerminal> nts = new HashSet<NonTerminal>();
		
		AbstractPatternFilterIterator<NonTerminal> i = IteratorFactory.<NonTerminal>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.NonTerminal);
		i.reset(entity);
		for (NonTerminal nt : i) {
			IEntity parent = nt.wGetParent();
			if (Matcher.match(GrammarsEntityDescriptorEnum.Production, parent) && parent.wGet(GrammarsFeatureDescriptorEnum.name) == nt)
				ntDefs.add(nt.getValue());
			else {
				ntUses.add(nt.getValue());
				nts.add(nt);
			}
		}

		Set<String> ntNotUsed = new HashSet<String>(ntDefs);
		ntNotUsed.removeAll(ntUses);
		Set<String> ntNotDef = new HashSet<String>(ntUses);
		ntNotDef.removeAll(ntDefs);
		
		for (NonTerminal nt : nts)
			if (!ntDefs.contains(nt.getValue()))
				getDecorationManager().addError(nt, "Production not defined", nt.getValue());//TODO location with production

		AbstractPatternFilterIterator<Production> i2 = IteratorFactory.<Production>childMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
		i2.reset(entity.getPhraseStructure());
		for (Production p : i2)
			if (!ntUses.contains(p.getName().wGetValue()))
				getDecorationManager().addInfo(p, "Production not used", p.getName().getValue());				
	}
}
