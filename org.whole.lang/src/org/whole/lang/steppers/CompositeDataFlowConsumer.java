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

import java.util.BitSet;

import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class CompositeDataFlowConsumer extends AbstractCompositeDataFlowConsumer {
	protected BitSet consumersNeedClone;

	public CompositeDataFlowConsumer(IDataFlowConsumer... consumers) {
		super(consumers);
		consumersNeedClone = new BitSet(consumers.length);
		consumersNeedClone.set(0, consumers.length, false);
	}

	public IDataFlowConsumer getAdded(IDataFlowConsumer consumer) {
		return new CompositeDataFlowConsumer(getAddedArray(consumer));
	}

	@Override
	public IDataFlowConsumer clone(ICloneContext cc) {
		consumersNeedClone.set(0, consumersNeedClone.size(), true);

		CompositeDataFlowConsumer consumer = (CompositeDataFlowConsumer) super.clone();
		consumer.consumersNeedClone = (BitSet) consumersNeedClone.clone();
		return consumer;
	}

	public IDataFlowConsumer getConsumer(int index) {
		if (consumersNeedClone.get(index)) {
			consumersNeedClone.clear(index);
			consumers[index] = consumers[index].clone(getCloneContext());
		}

		return consumers[index];
	}
}
