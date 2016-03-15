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
package org.whole.lang.patterns.ui.actions;

import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class PatternsActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final PatternsActionFactory instance = new PatternsActionFactory();
	}
	public static PatternsActionFactory instance() {
		return SingletonHolder.instance;
	}
	private PatternsActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.ScopePoint, "Scope Point", wrapIn(1)},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.ResultPoint, "Result Point", wrapIn(1)},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.JoinPoint, "Join Point", wrapIn(1)},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.ConditionPoint, "Condition Point", wrapIn(1)},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.IterationPoint, "Iteration Point", wrapIn(1)},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.InlinePoint, "Inline Point", wrapIn0},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.Template), PatternsEntityDescriptorEnum.TemplatePoint, "Template Point", wrapIn0},
				{ pf.assignableTo(PatternsEntityDescriptorEnum.PathExpression), PatternsEntityDescriptorEnum.DerivationPoint, "Derivation Point", wrapIn0},
		};
	};
}
