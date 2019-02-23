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
package org.whole.lang.steppers;

import java.util.function.Consumer;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;

/**
 * @author Riccardo Solmi
 */
public interface IControlFlowProducer extends ICloneable {
	public static final IControlFlowProducer IDENTITY = new IControlFlowProducer() {
		public IControlFlowProducer clone() {
			return this;
		}
		public IControlFlowProducer clone(ICloneContext cc) {
			return this;
		}
		public IDifferentiationContext getDifferentiationContext() {
			return null;
		}

		public IControlFlowProducer getAdded(IControlFlowProducer producer) {
			return producer;
		}

		public void forEachExecutableProducer(Consumer<IControlFlowProducer> c) {
		}

		public void reset(IEntity entity) {
		}

		public void callNext() {
		}		
		public void callRemaining() {
		}

		public void toString(StringBuilder sb) {
			// TODO Auto-generated method stub
		}		
	};
	public IControlFlowProducer clone();
	public IControlFlowProducer clone(ICloneContext cc);
	public IDifferentiationContext getDifferentiationContext();

	public default IControlFlowProducer getAdded(IControlFlowProducer producer) {
		throw new UnsupportedOperationException();
	}

	public void forEachExecutableProducer(Consumer<IControlFlowProducer> c);

	public void reset(IEntity entity);
	public void callNext();
	public void callRemaining();

	public void toString(StringBuilder sb);
}
