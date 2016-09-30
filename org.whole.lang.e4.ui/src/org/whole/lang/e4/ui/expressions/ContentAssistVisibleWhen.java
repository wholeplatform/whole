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
package org.whole.lang.e4.ui.expressions;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Action;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.GroupAction;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.SeparatedAction;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.jobs.ContentAssistRunnable;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class ContentAssistVisibleWhen extends AbstractSelectionConstrainedVisibleWhen {
	@Override
	public boolean isVisible(IBindingManager bm) {
		if (!HandlersBehavior.isValidFocusEntityPart(bm))
			return false;

		IEclipseContext context = (IEclipseContext) bm.wGetValue("eclipseContext");
		ContentAssistRunnable runnable = new ContentAssistRunnable(context, bm);
		IEntity result = runnable.syncExec(3000).getResult();
		IEntity[] values = (IEntity[]) result.wGetValue();
		if (values == null)
			return false;
		else if (values.length == 1 && !EntityUtils.isData(values[0])) {
			IEntity value = Matcher.find(new IsConcreteAction(Action), values[0], false);
			return value != null;
		} else
			return values.length > 0;
	}

	protected static final class IsConcreteAction extends GenericMatcherFactory.IsLanguageSubtypeOfMatcher {
		private IsConcreteAction(EntityDescriptor<?> ed) {
			super(ed);
		}

		@Override
		public void visit(IEntity entity) {
			super.visit(entity);
			EntityDescriptor<?> entityDescriptor = entity.wGetEntityDescriptor();
			if (entityDescriptor.isLanguageSubtypeOf(GroupAction) ||
					entityDescriptor.equals(SeparatedAction))
				throw new VisitException();
		}
	}
}
