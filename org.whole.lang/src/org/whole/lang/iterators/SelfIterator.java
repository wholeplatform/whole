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
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SelfIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
    protected E entity;
    protected E resetEntity;
    protected E lastEntity;

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public boolean hasNext() {
        return entity != null && !EntityUtils.isNull(entity);
    }
	public E next() {
    	E result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	entity = null;
    	return lastEntity = result;
	}

    public E lookahead() {
    	return hasNext() ? entity : null;
    }

    @SuppressWarnings("unchecked")
	public void reset(IEntity entity) {
        this.entity = resetEntity = (E) entity;
		lastEntity = null;
    }

    public void setBindings(IBindingManager bindings) {
	}

    public void prune() {
    }

    public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
    }
	public void add(E value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity)) {
    		IEntity lastEntityParent = lastEntity.wGetParent();
    		lastEntityParent.wAdd(lastEntityParent.wIndexOf(lastEntity), value);
    	}
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	if (EntityUtils.hasParent(lastEntity))
    		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("self()");
    }
}
