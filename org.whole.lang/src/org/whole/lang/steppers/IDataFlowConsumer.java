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

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;

/**
 * @author Riccardo Solmi
 */
public interface IDataFlowConsumer extends ICloneable {
	public static final IDataFlowConsumer IDENTITY = new IDataFlowConsumer() {
		public IDataFlowConsumer getAdded(IDataFlowConsumer consumer) {
			return consumer;
		}

		public IDataFlowConsumer clone() {
			return this;
		}
		public IDataFlowConsumer clone(ICloneContext cc) {
			return this;
		}

		public IDifferentiationContext getCloneContext() {
			return null;
		}

		public void accept(IEntity entity) {
		}

		public void done() {
		}		
	};

	public IDataFlowConsumer getAdded(IDataFlowConsumer consumer);

	public IDataFlowConsumer clone();
	public IDataFlowConsumer clone(ICloneContext cc);
	public IDifferentiationContext getCloneContext();

	public void accept(IEntity entity);
	public void done();
}

