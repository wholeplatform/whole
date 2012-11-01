/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.actions.ui.contributions;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class PredicateExpression extends Expression {
	protected IEntity predicate;

	public PredicateExpression(IEntity predicate) {
		this.predicate = predicate;
	}

	public EvaluationResult evaluate(IEvaluationContext context) {
		switch (UIUtils.calculateSelectionKind(context)) {
		case ENTITY_PART:
			ISelection selection = (ISelection) context.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);

			IBindingManager bm = BindingManagerFactory.instance.createArguments();
			ResourceUtils.defineResourceBindings(bm, UIUtils.getActiveEditorInput(context));
			UIUtils.defSelectedEntities(bm, selection);

			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			IEntity model = EntityUtils.getCompoundRoot(((IEntityPart) firstElement).getModelEntity());

			bm.wDef("self", model);
			return BehaviorUtils.evaluatePredicate(predicate, 0, bm) ?
					EvaluationResult.TRUE : EvaluationResult.FALSE;

		case WORKSPACE_FILE:
		case EDITOR_INPUT_FILE:
			return EvaluationResult.TRUE;

		default:
			return EvaluationResult.FALSE;
		}
	}
}
