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
package org.whole.lang.math.ui.actions;

import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class MathActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final MathActionFactory instance = new MathActionFactory();
	}
	public static MathActionFactory instance() {
		return SingletonHolder.instance;
	}
	private MathActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Subtraction, "Subtraction", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Division, "Division", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Quotient, "Quotient", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Remainder, "Remainder", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Exponentiation, "Exponentiation", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Root, "Root", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Minus, "Minus", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.AbsoluteValue, "AbsoluteValue", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Floor, "Floor", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Ceiling, "Ceiling", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.Not, "Not", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.NotEquals, "NotEquals", wrapIn0},
				{ pf.assignableTo(MathEntityDescriptorEnum.Expression), MathEntityDescriptorEnum.ApproximatelyEqual, "ApproximatelyEqual", wrapIn0},
		};
	};
}
