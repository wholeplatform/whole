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
import java.util.function.Consumer;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;

/**
 * @author Riccardo Solmi
 */
public interface IEntityIterator<E extends IEntity> extends Iterator<E>, IExecutable<E> {//TODO replace IExecutable with Iterable<E>, ICloneable, ISourceable {
//	public IBindingManager getBindings();
//	public void setBindings(IBindingManager bindings);
//	public void reset(IEntity entity);

	public E lookahead();
	public IBindingScope lookaheadScope();

//	public void prune();
//
//	public void set(E entity);
//	public void add(E entity);
//	public void remove();
//
//	public void toString(StringBuilder sb);

	//TODO workaround to avoid conflict with the default method inherited
	default void remove() {
        throw new UnsupportedOperationException("remove");
    }
	//TODO workaround to avoid duplicate default methods inherited
	default void forEachRemaining(Consumer<? super E> action) {
        do { } while (tryAdvance(action));
    }

	public default boolean skipTo(EntityDescriptor<?> descriptor) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.isAssignableAsIsFrom(descriptor, lookahead())))
			next();
		return found;
	}
	public default boolean skipTo(EntityKinds kind) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.match(kind, lookahead())))
			next();
		return found;
	}
	public default boolean skipToSame(IEntity entity) {
		boolean found = false;
		while (hasNext() && !(found = (entity == lookahead())))
			next();
		return found;
	}
	public default boolean skipTo(IEntity pattern) {
		return skipTo(pattern, getBindings()); //FIXME previous bindings interference
	}
	public default boolean skipTo(IEntity pattern, IBindingManager bindings) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.match(pattern, lookahead(), bindings)))
			next();
		return found;
	}
}
