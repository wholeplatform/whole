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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammarbased.GrammarsToGrammarBasedQuery;
import org.whole.lang.grammarbased.ui.editparts.GrammarBasedPartFactory;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Enrico Persiani
 */
public class GrammarsUIInterpreterVisitor extends GrammarsInterpreterVisitor {
	@Override
	public void visit(Grammar entity) {
		super.visit(entity);

		// ensure grammar normalized
		entity = GrammarsRegistry.instance().getGrammar(entity.getUri().getValue());
		GrammarBasedPartFactory.instance().putConfigurations(
				entity.getUri().getValue(), createConfigurations(createGrammarBased(entity, getBindings())));
	}

	public static IEntity createGrammarBased(Grammar entity, IBindingManager bm) {
		Grammar g = entity;//FIXME ensure normalized: NormalizerOperation.normalize(entity);
		PathExpression pathExpression = new GrammarsToGrammarBasedQuery().create();
		IEntity grammarBased = BehaviorUtils.evaluateFirstResult(pathExpression, g, bm);
		return NormalizerOperation.normalize(grammarBased);
	}

	public static Map<String, IEntity> createConfigurations(IEntity grammarBased) {
		FeatureDescriptorEnum fdEnum = grammarBased.wGetLanguageKit().getFeatureDescriptorEnum();
		Map<String, IEntity> configurations = new HashMap<String, IEntity>();
		ScannerIterator<IEntity> i = IteratorFactory.childScannerIterator();
		i.reset(grammarBased);
		for (IEntity configuration : i) {
			IEntity name = configuration.wGet(fdEnum.valueOf("name"));
			configurations.put(name.wStringValue(), configuration);
		}
		return configurations;
	}
}
