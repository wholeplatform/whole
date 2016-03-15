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

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class PointwiseProductIterator extends AbstractTupleProductIterator {
	protected PointwiseProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		super(iterators);
	}

	@Override
	public IEntity[] nextTuple() {
		IEntity[] result = super.nextTuple();
		tupleUpdateIndex = 0;
		return result;
	}

	@Override
	protected boolean updateIterators() {
		if (tupleUpdateIndex >= iterators.length)
			return tupleUpdateIndex == iterators.length;

		getBindings().wEnterScope(lookaheadScope(), true);
		lookaheadScope().wClear();

		boolean hasNext = true;
		//FIXME accumulate lookahead scopes
		for (int i=0; i<iterators.length; i++)
			hasNext &= iterators[i].hasNext();

		if (hasNext)
			for (int i=0; i<iterators.length; i++)
				tuple[i] = iterators[i].next();
//			if (iterators[i].hasNext()) {
//				tuple[i] = iterators[i].next();
//				hasNext = true;
//			} else
//				tuple[i] = CommonsEntityFactory.instance.createResolver();
		
		getBindings().wExitScope();
		tupleUpdateIndex = iterators.length + (hasNext ? 0 : 1);
		return hasNext;
	}
}
