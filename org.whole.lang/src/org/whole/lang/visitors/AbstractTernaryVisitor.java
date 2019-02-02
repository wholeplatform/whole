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
package org.whole.lang.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTernaryVisitor<V extends IVisitor> extends AbstractBinaryVisitor<V> implements ITernaryVisitor {
	private V visitor3;
	private boolean lazyCloneVisitor3;
	
	public AbstractTernaryVisitor(IVisitor visitor1, IVisitor visitor2, IVisitor visitor3) {
		super(visitor1, visitor2);
		wSetVisitor3(visitor3);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractTernaryVisitor<V> visitor = (AbstractTernaryVisitor<V>) super.clone(cc);
		visitor.lazyCloneVisitor3 = lazyCloneVisitor3 = visitor3 != null;
		return visitor;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyCloneVisitor3 && super.isLazyCloneEmpty();
	}

    protected V wGetVisitor3() {
		if (lazyCloneVisitor3) {
			wSetVisitor3(getCloneContext().differentiate(visitor3));
			visitor3.setBindings(bindings);
		}
		return visitor3;
	}
	@SuppressWarnings("unchecked")
	public void wSetVisitor3(IVisitor visitor) {
		this.visitor3 = (V) visitor;
		lazyCloneVisitor3 = false;
		updateCloneContext();
    }

    @Override
    public void setBindings(IBindingManager bm) {
    	if (bindings != bm) {
    		super.setBindings(bm);
    		if (!lazyCloneVisitor3)
    			wGetVisitor3().setBindings(bm);
    	}
    }
}
