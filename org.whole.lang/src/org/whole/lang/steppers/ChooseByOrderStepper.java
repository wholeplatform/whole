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
public class ChooseByOrderStepper<E extends IEntity> extends AbstractDelegatingNestedStepper<E> {
	protected boolean choosen;

	@SuppressWarnings("unchecked")
	public ChooseByOrderStepper(IEntityIterator<? extends E>... steppers) {
		super(steppers);
	}

	public void callNext() {
		nextEntity = null;//FIXME workaround

		if (choosen)
			getProducer().callNext();
		else while (!choosen && isValidProducer()) {
			getProducer().callNext();
		}
		if (nextEntity == null)
			super.doEnd();
	}

	public void callRemaining() {
		//FIXME
		throw new UnsupportedOperationException();
	}

	@Override
	public void doNext(IEntity entity) {
		choosen = true;
		super.doNext(entity);
	}

	@Override
	public void doEnd() {
		if (!choosen && isValidProducer()) {
			producerIndex += 1;
			nextEntity = null;
		}
	}

    @Override
	protected String toStringName() {
		return "chooseByOrder";
	}
    @Override
	protected String toStringSeparator() {
		return ",\n";
	}
}

