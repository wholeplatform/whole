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
public class ObjectIdentityComparator<T extends IEntity> extends AbstractEqualityComparator<T> {
	public static final ObjectIdentityComparator<IEntity> instance = new ObjectIdentityComparator<IEntity>();

	@Override
	public IEntityComparator<T> clone(ICloneContext cc) {
		return this;
	}

	public boolean equals(T o1, T o2) {
		return o1.equals(o2);
	}

	public boolean contains(IEntity container, T e) {
		for (int i=0, size=container.wSize(); i<size; i++)
			if (container.wGet(i).equals(e))
				return true;
		return false;
	}

	public IEntity get(IEntity container, T e) {
		for (int i=0, size=container.wSize(); i<size; i++) {
			IEntity e0 = container.wGet(i);
			if (e0.equals(e))
				return e0;
		}
		return null;
	}
}
