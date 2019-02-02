/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.function.IntSupplier;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FeatureByIndexEvaluator extends AbstractPureConditionalSupplierEvaluator {
	protected IntSupplier indexSupplier;
	protected int index;

	public FeatureByIndexEvaluator(int relativeIndex) {
		indexSupplier = () -> relativeIndex >= 0 ? relativeIndex : selfEntity.wSize()-1 + relativeIndex+1;
	}
	public FeatureByIndexEvaluator(IntSupplier indexSupplier) {
		this.indexSupplier = indexSupplier;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		index = indexSupplier.getAsInt();
	}

	public boolean hasNext() {
		return super.hasNext() && selfEntity.wContains(index);
    }

    public IEntity get() {
    	return selfEntity.wGet(index);
    }

    @Override
    public void set(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wSet(index, value);
    }
    @Override
    public void add(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wAdd(index, value);
    }
    @Override
    public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wRemove(index);
    	lastEntity = null;
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append("[");
		sb.append(index);
		sb.append("]");
    }
}
