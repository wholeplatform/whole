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
package org.whole.lang.iterators;

import java.util.Iterator;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.reflect.ISourceable;

/**
 * @author Riccardo Solmi
 */
public interface IEntityIterator<E extends IEntity> extends Iterator<E>, Iterable<E>, ICloneable, ISourceable {
	public IEntityIterator<E> withSourceEntity(IEntity entity);

	public IEntityIterator<E> clone();
	public IEntityIterator<E> clone(ICloneContext cc);

	public void reset(IEntity entity);
	public void setBindings(IBindingManager bindings);

	public E next();
	public E lookahead();
	public IBindingScope lookaheadScope();
	public void prune();

	public void set(E entity);
	public void add(E entity);
}
