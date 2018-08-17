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
 * Iterator that returns all immediate children of a given IEntity in order.
 *
 * @author Riccardo Solmi
 */
public class ChildIterator<E extends IEntity> extends AbstractByIndexIterator<E> {
    protected ChildIterator(boolean forward) {
    	super(forward);
    }
    protected ChildIterator(boolean forward, int relativeFirstIndex) {
        super(forward, relativeFirstIndex);
    }

    @Override
    protected final int startIndex() {
    	return 0;
    }
    @Override
    protected final int endIndex() {
    	return selfEntity.wSize()-1;
    }

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("child");
		sb.append(forward ? "()" : "-reverse()");
    }
}
