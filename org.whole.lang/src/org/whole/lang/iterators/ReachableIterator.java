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

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ReachableIterator<E extends IEntity> extends AbstractTransitiveClosureIterator<E> {
	protected DistinctScope<E> distinctScope;

	protected ReachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		super(includeSelf);

		this.distinctScope = distinctScope;
	}

    @Override
	protected boolean isRelationNotEmpty(IEntity entity) {
		return entity.wAdjacentSize() > 0;
	}
    @Override
    protected IEntityIterator<E> createRelationIterator() {
    	return IteratorFactory.matcherIterator(
    			IteratorFactory.<E>adjacentIterator()).withPattern(distinctScope.distinctMatcher());
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append(includeSelf ? "reachableOrSelf()" : "reachable()");
    }
}
