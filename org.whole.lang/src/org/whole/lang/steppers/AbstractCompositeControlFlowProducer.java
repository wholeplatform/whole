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

import java.util.Arrays;
import java.util.function.Consumer;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCompositeControlFlowProducer extends AbstractControlFlowProducer {
	protected IControlFlowProducer[] producers;

	public AbstractCompositeControlFlowProducer(IControlFlowProducer... producers) {
		this.producers = producers;
	}

	public IControlFlowProducer[] getAddedArray(IControlFlowProducer producer) {
		IControlFlowProducer[] newProducers = Arrays.copyOf(producers, producers.length+1);
		newProducers[producers.length] = producer;
		return newProducers;
	}

	@Override
	public IControlFlowProducer clone(ICloneContext cc) {
		cloneContext = cc.getPrototypeCloneContext();

		AbstractCompositeControlFlowProducer producer = (AbstractCompositeControlFlowProducer) super.clone();
		//FIXME lazy clone
		producer.producers = producers.clone();
		return producer;
	}

	public IControlFlowProducer getProducer(int index) {
		return producers[index];
	}

	public void forEachExecutableProducer(Consumer<IControlFlowProducer> c) {
		for (int i=0; i<producers.length; i++)
			getProducer(i).forEachExecutableProducer(c);
	}

	public void forEach(Consumer<IControlFlowProducer> f) {
		for (int i=0; i<producers.length; i++)
			f.accept(getProducer(i));
	}

	public void reset(IEntity entity) {
		forEach(p -> p.reset(entity));
	}

	public void call() {
		forEach(p -> p.call());
	}


	@Override
	public void toString(StringBuilder sb) {
		sb.append(toStringPrefix());
    	
		for (int i=0; i<producers.length; i++) {
			if (i>0)
				sb.append(toStringSeparator());
			
			if (producers[i] != null)
				producers[i].toString(sb);
//FIXME add prototype
//			else
//				prototype.getProducer(i).toString(sb);
		}

    	sb.append(toStringSuffix());
    }
	protected String toStringPrefix() {
		return "(";
	}
	protected String toStringSeparator() {
		return ", ";
	}
	protected String toStringSuffix() {
		return ")";
	}

}
