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
public abstract class AbstractQuantifiedVisitor extends AbstractLazyCloneableVisitor {
	private IVisitor[] visitors;
	protected int lazyCloneFrom;

	public AbstractQuantifiedVisitor(IVisitor... visitors) {
		this.visitors = visitors;
		lazyCloneFrom = visitors.length;
	}

	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractQuantifiedVisitor visitor = (AbstractQuantifiedVisitor) super.clone(cc);
		visitor.visitors = visitors != null ? visitors.clone() : null;
		visitor.lazyCloneFrom = lazyCloneFrom = 0;
		return visitor;
	}

	protected boolean isLazyCloneEmpty() {
		return lazyCloneFrom == visitors.length;
	}

	public int visitorsLength() {
		return visitors != null ?  visitors.length : 0;
	}

	public IVisitor getVisitor(int index) {
		while (lazyCloneFrom <= index) {
			visitors[lazyCloneFrom] = getCloneContext().clone(visitors[lazyCloneFrom]);
			visitors[lazyCloneFrom++].setBindings(bindings);
		}
		updateCloneContext();
		return visitors[index];
	}

	@Override
	public void setBindings(IBindingManager bm) {
		super.setBindings(bm);
		for (int i=0; i<lazyCloneFrom; i++)
			visitors[i].setBindings(bm);
	}

	public void toString(StringBuilder sb) {
		sb.append("(");
		for (int i=0; i<visitors.length; i++) {
			if (i>0)
				sb.append(", ");
			sb.append(visitors[i]);
		}
		sb.append(")");
	}
}
