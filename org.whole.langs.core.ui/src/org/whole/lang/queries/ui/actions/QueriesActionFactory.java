/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.ui.actions;

import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class QueriesActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final QueriesActionFactory instance = new QueriesActionFactory();
	}
	public static QueriesActionFactory instance() {
		return SingletonHolder.instance;
	}
	private QueriesActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(QueriesEntityDescriptorEnum.PathExpression), QueriesEntityDescriptorEnum.Scope, "Scope", wrapIn(1)},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.PathExpression), QueriesEntityDescriptorEnum.Block, "Block", wrapIn(1)},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.StepExpression), QueriesEntityDescriptorEnum.Filter, "Filter", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.PathExpression), QueriesEntityDescriptorEnum.ExpressionTest, "ExpressionTest", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.PathExpression), QueriesEntityDescriptorEnum.Singleton, "Singleton", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.Predicate), QueriesEntityDescriptorEnum.Prune, "Prune", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.Predicate), QueriesEntityDescriptorEnum.Not, "Not", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.NamesExpression), QueriesEntityDescriptorEnum.AddNames, "Add Names", wrapIn0},
				{ pf.assignableTo(QueriesEntityDescriptorEnum.NamesExpression), QueriesEntityDescriptorEnum.RemoveNames, "Remove Names", wrapIn0},
		};
	};
}
