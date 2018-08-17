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

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDelegatingNestedStepper<E extends IEntity> extends AbstractNestedStepper<E> {
	protected int producerIndex = 0;

	@SuppressWarnings("unchecked")
	public AbstractDelegatingNestedStepper(IEntityIterator<? extends E>... steppers) {
		super(steppers);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		producerIndex = 0;
	}

	protected boolean isFirstProducer() {
		return producerIndex == 0;
	}
	protected boolean isLastProducer() {
		return producerIndex == producersSize()-1;
	}
	protected boolean isValidProducer() {
		return producerIndex < producersSize();
	}
	protected IEntityIterator<?> getProducer() {
		return getProducer(producerIndex);
	}

	@Override
	public void prune() {
		if (isValidProducer())
			getProducer().prune();
	}

	@SuppressWarnings("unchecked")
	public void set(E entity) {
    	if (!isValidProducer())
    		throw new IllegalStateException();

    	((IEntityIterator<? super E>) getProducer()).set(entity);
	}
	@SuppressWarnings("unchecked")
	public void add(E entity) {
    	if (!isValidProducer())
    		throw new IllegalStateException();

		((IEntityIterator<? super E>) getProducer()).add(entity);
	}

	public void remove() {
    	if (!isValidProducer())
    		throw new IllegalStateException();

		getProducer().remove();
	}
}

