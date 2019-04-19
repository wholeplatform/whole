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
package org.whole.lang.evaluators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.AbstractExecutable;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEvaluator extends AbstractExecutable {
	protected IBindingScope executorScope;

	@Override
    public IExecutable clone(ICloneContext cc) {
		AbstractEvaluator executor = (AbstractEvaluator) super.clone(cc);
		executor.executorScope = executorScope != null ? executorScope.clone() : null;
		return executor;
    }

    public void reset(IEntity entity) {
		super.reset(entity);
		clearExecutorScope();
   }

	protected IBindingScope executorScope() {
		if (executorScope == null)
			executorScope = BindingManagerFactory.instance.createSimpleScope();
		return executorScope;
	}
	protected void clearExecutorScope() {
		if (executorScope != null) {
			executorScope.wClear();
		}
	}
	protected void clearProducerScope() {
		clearExecutorScope();
	}

	public void call() {
		if (evaluateRemaining() != null)
			getAction().accept(ExecutableFactory.instance.createEmpty());
	}
}

