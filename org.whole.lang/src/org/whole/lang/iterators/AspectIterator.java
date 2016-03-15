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
import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class AspectIterator extends AbstractCloneableIterator<IEntity> {
	protected IEntity entity;
	protected Iterator<FeatureDescriptor> aspectualFeatureDescriptorIterator;
	protected FeatureDescriptor nextFeatureDescriptor;
    protected FeatureDescriptor lastFeatureDescriptor;

	@Override
	public IEntityIterator<IEntity> clone(ICloneContext cc) {
		AspectIterator iterator = (AspectIterator) super.clone(cc);
		iterator.aspectualFeatureDescriptorIterator = null;
		return this;
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public boolean hasNext() {
		return nextFeatureDescriptor != null || aspectualFeatureDescriptorIterator.hasNext();
	}

    public IEntity lookahead() {
    	return lookaheadFeatureDescriptor() == null ? null : entity.wGet(nextFeatureDescriptor);
    }
    protected FeatureDescriptor lookaheadFeatureDescriptor() {
    	return nextFeatureDescriptor != null ? nextFeatureDescriptor : nextFeatureDescriptor();
    }
    protected FeatureDescriptor nextFeatureDescriptor() {
    	return nextFeatureDescriptor = aspectualFeatureDescriptorIterator.hasNext() ?
    			aspectualFeatureDescriptorIterator.next() : null;
    }

	public IEntity next() {
    	IEntity result = lookahead();
    	if (result == null)
        	throw new NoSuchElementException();

    	lastFeatureDescriptor = nextFeatureDescriptor;
    	nextFeatureDescriptor = null;
    	return result;
	}

	public void reset(IEntity entity) {
		this.entity = entity;
		aspectualFeatureDescriptorIterator = entity.wGetAspectualFeatureDescriptors().iterator();
    	nextFeatureDescriptor = null;
    	lastFeatureDescriptor = null;
	}

	public void setBindings(IBindingManager bindings) {
	}

    public void prune() {
    }

    public void set(IEntity entity) {
    	if (lastFeatureDescriptor == null)
    		throw new IllegalStateException();
    	
    	this.entity.wSet(lastFeatureDescriptor, entity);
    }
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
    public void remove() {
    	if (lastFeatureDescriptor == null)
    		throw new IllegalStateException();
    	
    	entity.wRemove(lastFeatureDescriptor);
		lastFeatureDescriptor = null;
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append("aspect()");
    }
}
