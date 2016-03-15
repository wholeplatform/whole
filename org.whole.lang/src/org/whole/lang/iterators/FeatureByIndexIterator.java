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
public class FeatureByIndexIterator extends SelfIterator<IEntity> {
	protected int index;

	protected FeatureByIndexIterator(int index) {
		this.index = index;
	}

	public boolean hasNext() {
		return super.hasNext() && entity.wContains(index);
    }

    public IEntity lookahead() {
    	return hasNext() ? entity.wGet(index) : null;
    }

    @Override
    public void set(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	resetEntity.wSet(index, value);
    }
    @Override
    public void add(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	resetEntity.wAdd(index, value);
    }
    @Override
    public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	resetEntity.wRemove(index);
    	lastEntity = null;
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append("[");
		sb.append(index);
		sb.append("]");
    }
}
