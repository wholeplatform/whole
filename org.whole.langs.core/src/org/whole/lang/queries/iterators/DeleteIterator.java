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
package org.whole.lang.queries.iterators;

import org.whole.lang.iterators.AbstractDelegatingIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class DeleteIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	protected DeleteIterator(IEntityIterator<E> valuesIterator) {
		super(valuesIterator);
	}

	public E next() {
		E result = super.next();
		remove();
		return result;
	}
}
