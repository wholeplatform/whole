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
public abstract class AbstractUnaryVisitor<V extends IVisitor> extends AbstractLazyCloneableVisitor implements IUnaryVisitor {
	private V visitor1;
	protected boolean lazyCloneVisitor1;

	public AbstractUnaryVisitor(IVisitor visitor) {
		wSetVisitor1(visitor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractUnaryVisitor<V> visitor = (AbstractUnaryVisitor<V>) super.clone(cc);
		visitor.lazyCloneVisitor1 = lazyCloneVisitor1 = visitor1 != null;
		return visitor;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyCloneVisitor1;
	}

    public V wGetVisitor1() {
		if (lazyCloneVisitor1) {
			wSetVisitor1(getCloneContext().clone(visitor1));
			visitor1.setBindings(bindings);
		}
		return visitor1;
	}
	@SuppressWarnings("unchecked")
	public void wSetVisitor1(IVisitor visitor) {
		this.visitor1 = (V) visitor;
		lazyCloneVisitor1 = false;
		updateCloneContext();
    }

    @Override
    public void setBindings(IBindingManager bm) {
    	if (bindings != bm) {
	    	super.setBindings(bm);
	    	if (!lazyCloneVisitor1)
	    		wGetVisitor1().setBindings(bm);
    	}
    }
}
