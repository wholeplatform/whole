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

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SequenceStepper extends AbstractDelegatingNestedStepper {
	@SuppressWarnings("unchecked")
	public SequenceStepper(IExecutable... steppers) {
		super(steppers);
	}

	protected AbstractFilterScope sequenceScope = BindingManagerFactory.instance.createExcludeFilterSimpleScope();
	protected void clearSequenceScope() {
		if (sequenceScope != null) {
			sequenceScope.setFilterEnabled(false);
			for (String name : sequenceScope.wLocalNames())
				getBindings().wUnset(name);
			sequenceScope.wClear();
			sequenceScope.getFilterNames().clear();
			sequenceScope.setFilterEnabled(true);
		}
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		clearSequenceScope();
	}

	public void callNext() {
		while (isValidProducer()) {
			sequenceScope.setFilterEnabled(false);
			for (String name : sequenceScope.wLocalNames())
				getBindings().wUnset(name);
			scopedCallNext(sequenceScope);
			sequenceScope.setFilterEnabled(true);
			getBindings().wAddAll(sequenceScope);
			sequenceScope.getFilterNames().addAll(sequenceScope.wLocalNames());
			
			//getProducer().callNext();
			if (nextEntity != null)
				return;
		}
		super.done();
	}

	public void callRemaining() {
		while (isValidProducer()) {
			sequenceScope.setFilterEnabled(false);
			scopedCallRemaining(sequenceScope);
			sequenceScope.setFilterEnabled(true);
			getBindings().wAddAll(sequenceScope);

			//getProducer().callRemaining();
		}
		super.done();
	}

	@Override
	public void done() {
		if (isValidProducer()) {
			producerIndex += 1;
			nextEntity = null;
		}
	}
}

