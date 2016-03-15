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
package org.whole.lang.operations;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVisitorOperation extends AbstractOperation implements IVisitor {
	private IEntity sourceEntity;
	public AbstractVisitorOperation withSourceEntity(IEntity entity) {
		sourceEntity = entity;
		return this;
	}
	public IEntity getSourceEntity() {
		return sourceEntity;
	}

	private IBindingManager bindings;

	public AbstractVisitorOperation(String name, IBindingManager args, IBindingScope optResultsScope) {
		super(name, args, optResultsScope);
	}

	public IVisitor clone() {
		return clone(new CloneContext());
	}

	public IVisitor clone(ICloneContext cc) {
		try {
			AbstractVisitorOperation visitor = (AbstractVisitorOperation) super.clone();
			cc.putClone(this, visitor);
			return visitor;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public final IOperation getOperation() {
        return this;
    }
    public void setOperation(IOperation operation) {
    	if (this != operation)
    		throw new IllegalArgumentException();
    }

	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = getOperationEnvironment();
		return bindings;
	}
	public void setBindings(IBindingManager bm) {
		this.bindings = bm;
	}

	protected void handleCancelRequest() {
		if (isCanceled())
			throw new OperationCanceledException();
	}

	public static <E extends IEntity> E filterAdapter(E entity) {
		return entity.wIsAdapter() ? null : entity;
	}
	public boolean visitAdapter(IEntityAdapter entity) {
		return CommonsInterpreterVisitor.evaluateAdapter(entity, getOperation());
	}
	public void visit(IEntity entity) {
	}

	@Override
	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		return this;
	}

}
