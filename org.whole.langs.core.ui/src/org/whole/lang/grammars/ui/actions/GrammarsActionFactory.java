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
package org.whole.lang.grammars.ui.actions;

import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class GrammarsActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final GrammarsActionFactory instance = new GrammarsActionFactory();
	}
	public static GrammarsActionFactory instance() {
		return SingletonHolder.instance;
	}
	protected GrammarsActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.Optional, "Optional", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.Production, "Production", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.As, "As", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.Repeat, "Repeat", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.When, "When", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Rule), GrammarsEntityDescriptorEnum.Split, "Split", wrapIn(GrammarsFeatureDescriptorEnum.rule)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Predicate), GrammarsEntityDescriptorEnum.And, "And 1", wrapIn(GrammarsFeatureDescriptorEnum.predicate1)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Predicate), GrammarsEntityDescriptorEnum.And, "And 2", wrapIn(GrammarsFeatureDescriptorEnum.predicate2)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Predicate), GrammarsEntityDescriptorEnum.Or, "Or 1", wrapIn(GrammarsFeatureDescriptorEnum.predicate1)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Predicate), GrammarsEntityDescriptorEnum.Or, "Or 2", wrapIn(GrammarsFeatureDescriptorEnum.predicate2)},
				{ pf.assignableTo(GrammarsEntityDescriptorEnum.Predicate), GrammarsEntityDescriptorEnum.Not, "Not", wrapIn(GrammarsFeatureDescriptorEnum.predicate)},
		};
	};
}
