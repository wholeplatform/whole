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
package org.whole.lang.executables;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractExecutableIteratingEvaluatingStepper<E extends IEntity> extends AbstractExecutableEvaluatingStepper<E> {
	public final E evaluateNext() {
		return hasNext() ? next() : null;
	}

	public final E evaluateRemaining() {
		E result = null;
		IBindingManager bm = getBindings();
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		try {
			while (hasNext()) {
				bm.setResult(result = next());
				resettableScope.commit();
			}
		} finally {
			resettableScope.rollback();
			bm.wExitScope();
		}
		return result;
	}

	public final E evaluateSingleton() {
		E result = null;
		IBindingManager bm = getBindings();
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		try {
			if (hasNext()) {
				bm.setResult(result = next());
				resettableScope.commit();
			}
			if (result == null || hasNext())
				throw new IllegalArgumentException("The result is not a singleton");
		} finally {
			resettableScope.rollback();
			bm.wExitScope();
		}
		return result;
	}
}
