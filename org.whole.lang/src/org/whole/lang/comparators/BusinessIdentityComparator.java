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
package org.whole.lang.comparators;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class BusinessIdentityComparator<T extends IEntity> extends AbstractEqualityComparator<T> {
	public static final BusinessIdentityComparator<IEntity> instance = new BusinessIdentityComparator<IEntity>();

	@Override
	public IEntityComparator<T> clone(ICloneContext cc) {
		return this;
	}

//	protected EntityDescriptor<E> ed;
//
//	public BusinessIdentityComparator(EntityDescriptor<E> ed) {
//		this.ed = ed;
//	}

//	public int compare(T o1, T o2) {
//	return o1.wCompareTo(o2);
//}

	public boolean equals(T o1, T o2) {
		return o1.wEquals(o2);
	}

	public boolean contains(IEntity container, T e) {
		return container.wContains(e);
	}

	public IEntity get(IEntity container, T e) {
		return container.wGet(e);
	}
}
