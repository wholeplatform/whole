/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.expressions;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.whole.lang.bindings.IBindingManager;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class AbstractSelectionConstrainedVisibleWhen extends Expression {
	public AbstractSelectionConstrainedVisibleWhen() {
	}

	@Override
	public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
		ESelectionService selectionService = (ESelectionService) context.getVariable(ESelectionService.class.getName());
		Object selection = selectionService.getSelection();
		if (selection instanceof IBindingManager) {
			if (isVisible((IBindingManager) selection))
				return EvaluationResult.TRUE;
		}
		return EvaluationResult.FALSE;
	}

	public abstract boolean isVisible(IBindingManager bm);
}