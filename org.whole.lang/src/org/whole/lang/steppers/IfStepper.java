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
package org.whole.lang.steppers;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class IfStepper extends AbstractDelegatingNestedStepper<IEntity> {
	protected boolean conditionValue;
	protected boolean isFirstValue;

	@SuppressWarnings("unchecked")
	public IfStepper(IExecutable<IEntity> conditionStepper, IExecutable<IEntity> doStepper) {
		super(conditionStepper, doStepper);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		isFirstValue = true;
	}

	@Override
	protected void initProducer(IExecutable<?> p, int index) {
		if (index == 0) {
			p.setBindings(getBindings());
			p.reset(selfEntity);
		} else
			super.initProducer(p, index);
	}

	public void callNext() {
		if (isFirstProducer()) {
			conditionValue = scopedEvaluateAsBooleanOrFail(true);
			producerIndex += 1;
		}

		if (conditionValue)
			getProducer().callNext();
		else
			done();
	}

	public void callRemaining() {
		if (isFirstProducer()) {
			conditionValue = scopedEvaluateAsBooleanOrFail(true);
			producerIndex += 1;				
		}

		if (conditionValue)
			getProducer().callRemaining();
		else
			done();
	}

	@Override
	public void done() {
		if (isFirstValue) {
			isFirstValue = false;
			accept(BindingManagerFactory.instance.createVoid());
		} else
			super.done();
	}

}

