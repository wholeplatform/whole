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

import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractControlFlowProducer implements IControlFlowProducer {
	protected ICloneContext cloneContext;

	public IDifferentiationContext getDifferentiationContext() {
		//FIXME lazy init
		return (IDifferentiationContext) cloneContext;
	}

	public IControlFlowProducer getAdded(IControlFlowProducer producer) {
		return new CompositeControlFlowProducer(this, producer);
	}

	public IControlFlowProducer clone() {
		return clone(new CloneContext());
	}

	public IControlFlowProducer clone(ICloneContext cc) {
		try {
			AbstractControlFlowProducer producer = (AbstractControlFlowProducer) super.clone();
			cc.setClone(this, producer);
			producer.cloneContext = cc;
			return producer;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}
}
