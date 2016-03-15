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

import java.util.Comparator;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;

/**
 * @author Riccardo Solmi
 */
public interface IEntityComparator<T extends IEntity> extends Comparator<T>, ICloneable {
	public IEntityComparator<T> clone();
	public IEntityComparator<T> clone(ICloneContext cc);

	public void setBindings(IBindingManager bm);

	public boolean canOrder();
	public boolean equals(T o1, T o2);
	public boolean contains(IEntity container, T e);
	public IEntity get(IEntity container, T e);
//	public Collection<IEntity> getAll(IEntity container, T e);
}
