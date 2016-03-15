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
package org.whole.lang.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.ICloneContext;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractBinaryVisitor<V extends IVisitor> extends AbstractUnaryVisitor<V> implements IBinaryVisitor {
	private V visitor2;
	protected boolean lazyCloneVisitor2;
	
	public AbstractBinaryVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1);
		wSetVisitor2(visitor2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractBinaryVisitor<V> visitor = (AbstractBinaryVisitor<V>) super.clone(cc);
		visitor.lazyCloneVisitor2 = lazyCloneVisitor2 = visitor2 != null;
		return visitor;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyCloneVisitor2 && super.isLazyCloneEmpty();
	}

    public V wGetVisitor2() {
		if (lazyCloneVisitor2) {
			wSetVisitor2(getCloneContext().clone(visitor2));
			visitor2.setBindings(bindings);
		}
		return visitor2;
	}
	@SuppressWarnings("unchecked")
	public void wSetVisitor2(IVisitor visitor) {
		this.visitor2 = (V) visitor;
		lazyCloneVisitor2 = false;
		updateCloneContext();
    }

    @Override
    public void setBindings(IBindingManager bm) {
    	if (bindings != bm) {
    		super.setBindings(bm);
    		if (!lazyCloneVisitor2)
    			wGetVisitor2().setBindings(bm);
    	}
    }
}
