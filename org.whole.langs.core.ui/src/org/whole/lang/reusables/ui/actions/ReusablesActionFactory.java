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
package org.whole.lang.reusables.ui.actions;

import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class ReusablesActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final ReusablesActionFactory instance = new ReusablesActionFactory();
	}
	public static ReusablesActionFactory instance() {
		return SingletonHolder.instance;
	}
	private ReusablesActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(ReusablesEntityDescriptorEnum.Reusable), ReusablesEntityDescriptorEnum.Adapt, "Adapt", wrapIn0},
				{ pf.assignableTo(ReusablesEntityDescriptorEnum.PathExpression), ReusablesEntityDescriptorEnum.Reuse, "Reuse", wrapIn(2)},
		};
	};
}
