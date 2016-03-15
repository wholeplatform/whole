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

import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class MatcherIterator<E extends IEntity> extends AbstractPatternFilterIterator<E> {
	protected MatcherIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	protected IVisitor defaultPattern() {
		return GenericTraversalFactory.instance.identity();
	}

	protected E patternFilteredLookahead() {
		boolean found = false;
		E lookahead = null;
		while (iterator.hasNext() && !(found = Matcher.match(pattern(), lookahead = iterator.lookahead()))) {
			lookaheadScope().wClear();
			iterator.next();
		}
		if (!found)
			lookahead = null;
		return lookahead;
	}

	@SuppressWarnings("unchecked")
	public <T extends IEntity> T next(EntityDescriptor<T> descriptor) {
		IEntity entity = iterator.next();
		if (!Matcher.isAssignableAsIsFrom(descriptor, entity))
			throw new NoSuchElementException(descriptor.toString());

		return (T) entity;
	}

	public boolean skipTo(EntityDescriptor<?> descriptor) {
		boolean found = false;
		while (iterator.hasNext() && !(found = Matcher.isAssignableAsIsFrom(descriptor, iterator.lookahead())))
			iterator.next();
		return found;
	}
	public boolean skipTo(EntityKinds kind) {
		boolean found = false;
		while (iterator.hasNext() && !(found = Matcher.match(kind, iterator.lookahead())))
			iterator.next();
		return found;
	}
	public boolean skipTo(IEntity pattern) {
		return skipTo(pattern, getBindings()); //FIXME previous bindings interference
	}
	public boolean skipToSame(IEntity entity) {
		boolean found = false;
		while (iterator.hasNext() && !(found = (entity == iterator.lookahead())))
			iterator.next();
		return found;
	}
	public boolean skipTo(IEntity pattern, IBindingManager bindings) {
		boolean found = false;
		while (iterator.hasNext() && !(found = Matcher.match(pattern, iterator.lookahead(), bindings)))
			iterator.next();
		return found;
	}
	public boolean skipTo(IVisitor matcherVisitor) {
		boolean found = false;
		while (iterator.hasNext() && !(found = Matcher.match(matcherVisitor, iterator.lookahead())))
			iterator.next();
		return found;
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append(iterator.toString());
    	sb.append("[");
    	sb.append(pattern().toString());
    	sb.append("]");
    }
}
