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
package org.whole.lang.evaluators;

import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPointwiseEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected IEntity[] nestedResults;

	@SuppressWarnings("unchecked")
	public AbstractPointwiseEvaluator(IExecutable<IEntity>... executables) {
		super(executables);
	}

	@Override
	protected IEntity scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		IEntity result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	public IEntity evaluateNext() {
		try {
			getBindings().wEnterScope(executorScope(), true);

			nestedResults = new IEntity[producersSize()];
			for (int i=0; i<producersSize(); i++) {
				nestedResults[i] = getProducer(i).evaluateNext();
				if (nestedResults[i] == null && stopOnNullNestedResult(i)) {
					executorScope().wClear();
					return lastEntity = null;
				}
			}

			return lastEntity = evaluateNestedResults();
		} catch(Exception e) {
			throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), getBindings());
		} finally {
			getBindings().wExitScope(mergeLookaheadScope && lastEntity != null);
		}
	}
	protected boolean stopOnNullNestedResult(int i) {
		return true;
	}
	protected abstract IEntity evaluateNestedResults();
}
