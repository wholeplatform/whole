/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class IteratorVisitor extends AbstractVisitor {
    protected IEntityIterator<?> iterator;
    protected IVisitor visitor;

    public IteratorVisitor(IEntityIterator<?> iterator, IVisitor visitor) {
        this.iterator = iterator;
        this.visitor = visitor;
    }

	@Override
	public IVisitor clone(ICloneContext cc) {
		IteratorVisitor visitor = (IteratorVisitor) super.clone(cc);
		visitor.iterator = cc.clone(this.iterator);
		visitor.visitor = cc.clone(this.visitor);
		return visitor;
	}

    public IteratorVisitor setVisitor(IVisitor visitor) {
        this.visitor = visitor;
        return this;
    }

    @Override
    public void setBindings(IBindingManager bm) {
    	super.setBindings(bm);
    	iterator.setBindings(bm);
    	visitor.setBindings(bm);
    }

	public void visit(IEntity entity) {
		iterator.reset(entity);
	    while (iterator.hasNext())
	    	visitor.visit(iterator.next());
	}
}
