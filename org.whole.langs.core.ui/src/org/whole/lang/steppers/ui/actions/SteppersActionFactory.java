/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.steppers.ui.actions;

import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class SteppersActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final SteppersActionFactory instance = new SteppersActionFactory();
	}
	public static SteppersActionFactory instance() {
		return SingletonHolder.instance;
	}
	private SteppersActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
			{ pf.assignableTo(SteppersEntityDescriptorEnum.Expression), SteppersEntityDescriptorEnum.StepperDeclaration, "Stepper Declaration", wrapIn(5)},
			{ pf.assignableTo(SteppersEntityDescriptorEnum.Expression), SteppersEntityDescriptorEnum.Scope, "Scope", wrapIn(1)},
			{ pf.assignableTo(SteppersEntityDescriptorEnum.CallFlow), SteppersEntityDescriptorEnum.CallBranch, "Calls with arguments", wrapIn0},
			{ pf.assignableTo(SteppersEntityDescriptorEnum.ActionFlow), SteppersEntityDescriptorEnum.ActionBranch, "Actions with arguments", wrapIn0},
		};
	};
}
