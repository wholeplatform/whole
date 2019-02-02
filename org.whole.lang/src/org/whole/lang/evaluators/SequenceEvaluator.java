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

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SequenceEvaluator extends BlockEvaluator {
	protected IBindingScope lastEntityScope;

	public SequenceEvaluator(IExecutable... executables) {
		super(executables);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		lastEntityScope = null;
	}

	public IEntity evaluateNext() {
		IEntity result = null;

		if (lastEntity != null) {
			lastEntityScope = selfEntityScope.clone();
			selfEntityScope.wClear();
		}

		try {
			getBindings().wEnterScope(executorScope(), true);

			while (isValidProducer()) {
				result = getProducer().evaluateNext();

				if (result != null || isLastProducer())
					break;

				if (lastEntityScope != null)
					accumulatedScope.wAddAll(lastEntityScope);

				selectFollowingProducer();
			}
		} finally {
//TODO ? alternate semantics with effects of all producers
//			getBindings().wExitScope(result != null);
			getBindings().wExitScope();
			if (result != null)
				getBindings().wAddAll(selfEntityScope);
		}

		return lastEntity = result;
	}
}

