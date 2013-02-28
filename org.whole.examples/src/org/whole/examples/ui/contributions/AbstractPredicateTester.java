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
package org.whole.examples.ui.contributions;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.actions.ui.contributions.PredicateExpression;
import org.whole.lang.queries.model.Predicate;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractPredicateTester extends PropertyTester {
	protected static final String PROPERTY_MATCH_PREFIX = "match";
	protected Expression expression;

	public AbstractPredicateTester(Predicate predicate) {
		this.expression = new PredicateExpression(predicate);
	}

	protected String getPropertyName() {
		return PROPERTY_MATCH_PREFIX+getPropertySuffix();
	}

	protected abstract String getPropertySuffix();

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		String propertyName = getPropertyName();
		if (!propertyName.equals(property) || !(receiver instanceof ISelection))
			return false;

		IEvaluationContext context = new EvaluationContext(null, ((ISelection) receiver));
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, context.getDefaultVariable());

		try {
			IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			context.addVariable(ISources.ACTIVE_EDITOR_NAME, activeEditor);
		} catch (Exception e) {
		}

		try {
			return expression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			throw new IllegalStateException();
		}
	}
}
