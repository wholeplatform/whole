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

import java.util.BitSet;

import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class CompositeControlFlowProducer extends AbstractCompositeControlFlowProducer {
	protected BitSet producersNeedClone;

	public CompositeControlFlowProducer(IControlFlowProducer... producers) {
		super(producers);
		producersNeedClone = new BitSet(producers.length);
		producersNeedClone.set(0, producers.length, false);
	}

	public IControlFlowProducer getAdded(IControlFlowProducer producer) {
		return new CompositeControlFlowProducer(getAddedArray(producer));
	}

	@Override
	public IControlFlowProducer clone(ICloneContext cc) {
		producersNeedClone.set(0, producersNeedClone.size(), true);

		CompositeControlFlowProducer producer = (CompositeControlFlowProducer) super.clone();
		producer.producersNeedClone = (BitSet) producersNeedClone.clone();
		return producer;
	}

	public IControlFlowProducer getProducer(int index) {
		if (producersNeedClone.get(index)) {
			producersNeedClone.clear(index);
			producers[index] = producers[index].clone(getCloneContext());
		}

		return producers[index];
	}
}
