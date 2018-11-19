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

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.resources.FunctionLibraryRegistry;

/**
 * @author Riccardo Solmi
 */
public class FunctionApplicationEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected String functionUri;

	@SuppressWarnings("unchecked")
	public FunctionApplicationEvaluator(String functionUri) {
		super((IExecutable<IEntity>) null);
		this.functionUri = functionUri;
	}

	@Override
	public IExecutable<IEntity> clone(ICloneContext cc) {
		FunctionApplicationEvaluator result = (FunctionApplicationEvaluator) super.clone(cc);

		//FIXME workaround
		if (producers[0] == null) {
			producersNeedClone.clear(0);
			result.producersNeedClone.clear(0);
		}

		return result;
	}

	public void reset(IEntity entity) {
		producers[0] = null;
		super.reset(entity);
	}

	@Override
	protected boolean isValidResultProducer() {
		return producers[0] != null;
	}

	@Override
	public IExecutable<IEntity> getProducer(int index) {
		if (producers[0] == null)
			try {
				producers[0] = FunctionLibraryRegistry.instance().getFunctionCode(functionUri, true, getBindings());
			} catch (Exception e) {
				throw new WholeIllegalArgumentException("Unknown function application: "+functionUri, e).withSourceEntity(selfEntity).withBindings(getBindings());
			}

		return super.getProducer(index);
	}

	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			executorScope.wClear();
		}
	}

	public IEntity evaluateNext() {
		return lastEntity = scopedEvaluateNext();
	}

	public IEntity evaluateRemaining() {
		return lastEntity = scopedEvaluateRemaining();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(functionUri);
    	sb.append("()");
    }
}
