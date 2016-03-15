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
package org.whole.lang.semantics.ui.actions;

import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/**
 * @author Riccardo Solmi
 */
public class SemanticsActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final SemanticsActionFactory instance = new SemanticsActionFactory();
	}
	public static SemanticsActionFactory instance() {
		return SingletonHolder.instance;
	}
	private SemanticsActionFactory() {}

	public Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.EntityType), SemanticsEntityDescriptorEnum.SubtypeType, "Subtype Type", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Category), SemanticsEntityDescriptorEnum.SupertypeType, "Supertype Type", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Signature), SemanticsEntityDescriptorEnum.SequenceType, "Sequence Type", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Signature), SemanticsEntityDescriptorEnum.TypedVariable, "Typed Variable", wrapIn(3)},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Variable), SemanticsEntityDescriptorEnum.StructuredVariable, "Structured Variable", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Expression), SemanticsEntityDescriptorEnum.InlineTemplate, "Inline Template", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Expression), SemanticsEntityDescriptorEnum.IfDefTemplate, "Ifdef Template", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Expression), SemanticsEntityDescriptorEnum.IfTemplate, "If Template", wrapIn0},
				{ pf.assignableTo(SemanticsEntityDescriptorEnum.Expression), SemanticsEntityDescriptorEnum.WhereTemplate, "Where Template", wrapIn0},
		};
	};
}
