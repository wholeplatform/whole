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
package org.whole.lang.ui.commands;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.AbstractGenericForcedMatcher;
import org.whole.lang.matchers.MatchException;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.TraverseAllFilter;

/**
 * @author Enrico Persiani
 */
public class MergeModelsTransactionCommand extends ModelTransactionCommand {
	public MergeModelsTransactionCommand() {
	}
	public MergeModelsTransactionCommand(IEntity model) {
		super(model);
	}
	public MergeModelsTransactionCommand(IEntity model, String label) {
		super(model, label);
	}

	public void mergeWith(IEntity entity) {
		begin();
		try {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			entity.wAccept(new AbstractGenericForcedMatcher(bm, TraverseAllFilter.instance) {
				protected void forceMatch(IEntity pattern, IEntity model) {
					IEntity parent = model.wGetParent();
					if (EntityUtils.isNull(parent))
						throw new MatchException(pattern, model, bindings);
					parent.wSet(model, EntityUtils.clone(pattern));
				}
			}, getModel());
			commit();
		} catch (RuntimeException e) {
			rollbackIfNeeded();
			throw e;
		}
	}
}
