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
package org.whole.lang.commons.ui.actions;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class CommonsActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final CommonsActionFactory instance = new CommonsActionFactory();
	}
	public static CommonsActionFactory instance() {
		return SingletonHolder.instance;
	}
	protected CommonsActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.SameStageFragment, "SameStageFragment", wrapIn0 },
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.StageDownFragment, "StageDownFragment", wrapIn0 },
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.StageUpFragment, "StageUpFragment", wrapIn0 },
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.TemplateFragment, "TemplateFragment", wrapIn(1) },
				{ pf.alwaysTrue(), CommonsEntityDescriptorEnum.BaseFragment, "BaseFragment", wrapIn(1) }
		};
	}
}
