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
package org.whole.examples.lang.imp.ui.actions;

import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/** 
 * @author Riccardo Solmi
 */
public class ImpActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final ImpActionFactory instance = new ImpActionFactory();
	}
	public static ImpActionFactory instance() {
		return SingletonHolder.instance;
	}
	private ImpActionFactory() {
	}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(ImpEntityDescriptorEnum.Expression), ImpEntityDescriptorEnum.Addition, "Addition 1", wrapIn0},
				{ pf.assignableTo(ImpEntityDescriptorEnum.Expression), ImpEntityDescriptorEnum.Addition, "Addition 2", wrapIn(ImpFeatureDescriptorEnum.exp2)}
		};
	};
}
