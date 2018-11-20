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

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.InterpreterOperation;

/**
 * @author Riccardo Solmi
 */
public class TemplateInterpreterEvaluator extends AbstractDelegatingNestedEvaluator {
	protected IEntity template;

	public TemplateInterpreterEvaluator(IEntity template) {
		super((IExecutable) null);
		this.template = template;
	}

	public IExecutable clone(ICloneContext cc) {
		TemplateInterpreterEvaluator result = (TemplateInterpreterEvaluator) super.clone(cc);

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
	public IExecutable getProducer(int index) {
		if (producers[0] == null) {
			getBindings().enforceSelfBinding(selfEntity);
			IBindingScope results = InterpreterOperation.lazyInterpretOnSelfBinding(template, getBindings(), true);
			producers[0] = results.getExecutableResult();
			if (results.isExecutableResult())
				results.setExecutableResult(null);
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
		sb.append("eval(");
		sb.append(template.toString());
		sb.append(")");
    }
}
