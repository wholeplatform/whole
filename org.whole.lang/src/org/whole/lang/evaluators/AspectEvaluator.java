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
package org.whole.lang.evaluators;

import java.util.Iterator;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class AspectEvaluator extends AbstractEvaluator {
	protected IEntity selfEntity;
	protected Iterator<FeatureDescriptor> aspectualFeatureDescriptorIterator;
    protected FeatureDescriptor lastFeatureDescriptor;

    public AspectEvaluator() {
    }

	@Override
	public IExecutable clone(ICloneContext cc) {
		AspectEvaluator evaluator = (AspectEvaluator) super.clone(cc);
		evaluator.aspectualFeatureDescriptorIterator = null;
		evaluator.lastFeatureDescriptor = null;
		return evaluator;
	}

	public void reset(IEntity entity) {
		selfEntity = entity;
		aspectualFeatureDescriptorIterator = entity.wGetAspectualFeatureDescriptors().iterator();
    	lastFeatureDescriptor = null;
    }

	@Override
	public IEntity evaluateNext() {
		return lastEntity = aspectualFeatureDescriptorIterator.hasNext() ?
				selfEntity.wGet(lastFeatureDescriptor = aspectualFeatureDescriptorIterator.next()) : null;
	}

	@Override
	public IEntity evaluateRemaining() {
		if (aspectualFeatureDescriptorIterator.hasNext()) {
			IEntity lastEntity = null;
			do {
				lastEntity = selfEntity.wGet(lastFeatureDescriptor = aspectualFeatureDescriptorIterator.next());
			} while (aspectualFeatureDescriptorIterator.hasNext());
			return lastEntity;			
		} else
			return null;
	}

	public void prune() {
	}

    public void set(IEntity entity) {
    	if (lastFeatureDescriptor == null)
    		throw new IllegalStateException();

    	selfEntity.wSet(lastFeatureDescriptor, entity);
    }
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
    public void remove() {
    	if (lastFeatureDescriptor == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wRemove(lastFeatureDescriptor);
		lastFeatureDescriptor = null;
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append("aspect()");
    }
}
