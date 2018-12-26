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

import java.util.Arrays;
import java.util.function.Consumer;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCompositeDataFlowConsumer extends AbstractDataFlowConsumer {
	protected IDataFlowConsumer[] consumers;

	public AbstractCompositeDataFlowConsumer(IDataFlowConsumer... consumers) {
		this.consumers = consumers;
	}

	protected final IDataFlowConsumer[] getAddedArray(IDataFlowConsumer consumer) {
		IDataFlowConsumer[] newConsumers = Arrays.copyOf(consumers, consumers.length+1);
		newConsumers[consumers.length] = consumer;
		return newConsumers;
	}

	@Override
	public IDataFlowConsumer clone(ICloneContext cc) {
		cloneContext = cc.getPrototypeCloneContext();

		AbstractCompositeDataFlowConsumer consumer = (AbstractCompositeDataFlowConsumer) super.clone();
		consumer.consumers = consumers.clone();
		return consumer;
	}

	public IDataFlowConsumer getConsumer(int index) {
		return consumers[index];
	}

	public void forEach(Consumer<IDataFlowConsumer> f) {
		for (int i=0; i<consumers.length; i++)
			f.accept(getConsumer(i));
	}

	public void accept(IEntity entity) {
		forEach(c -> c.accept(entity));
	}

	public void done() {
		forEach(c -> c.done());
	}
}
