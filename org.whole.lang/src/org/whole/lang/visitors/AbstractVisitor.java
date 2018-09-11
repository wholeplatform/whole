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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.iterators.ExecutableFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.AnonymousOperation;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVisitor implements IVisitor {
	private IEntity sourceEntity;
	public IVisitor withSourceEntity(IEntity entity) {
		sourceEntity = entity;
		return this;
	}
	public IEntity getSourceEntity() {
		return sourceEntity;
	}

	private IOperation operation;
	protected IBindingManager bindings;

	private ExecutableFactory iteratorFactory;
	public ExecutableFactory iteratorFactory() {
		if (iteratorFactory == null)
			iteratorFactory = bindings != null ? ExecutableFactory.instance(bindings) : ExecutableFactory.instance;
		return iteratorFactory;
	}

	public IVisitor clone() {
		return clone(new CloneContext());
	}

	public IVisitor clone(ICloneContext cc) {
		try {
			AbstractVisitor visitor = (AbstractVisitor) super.clone();
			cc.putClone(this, visitor);
			visitor.operation = null;
			return visitor;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public IOperation getOperation() {
		return operation != null ?
				operation : bindings != null ?
						bindings.wGetEnvironmentManager().getCurrentOperation() :
							(operation = new AnonymousOperation());
	}
	public void setOperation(IOperation operation) {
		this.operation = operation;
	}

	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = getOperation().getOperationEnvironment();
		return bindings;
	}
	public void setBindings(IBindingManager bm) {
		this.bindings = bm;
	}

	public boolean isExecutableResult() {
		return getBindings().isExecutableResult();
	}
	public <E extends IEntity> IExecutable<E> getExecutableResult() {
		return getBindings().getExecutableResult();
	}
	public void setExecutableResult(IExecutable<?> entityIterator) {
		getBindings().setExecutableResult(entityIterator);
	}
	public IEntity getResult() {
		return getBindings().getResult();
	}
	public void setResult(IEntity entity) {
		getBindings().setResult(entity);
	}
	protected void setResultValue(IEntity entity) {
		setResult(BindingManagerFactory.instance.createSpecificValue(entity));
	}	
	protected void setResultClone(IEntity entity) {
		setResult(EntityUtils.clone(entity));
	}	
	protected void setResultCopy(IEntity entity) {
		if (EntityUtils.isData(entity))
			setResultValue(entity);
		else
			setResultClone(entity);
	}

	protected void handleCancelRequest() {
		if (operation != null && operation.isCanceled())
			throw new OperationCanceledException();
	}

	public boolean isSelectedFeature(String name) {
		return getOperation().isSelectedFeature(name);
	}
	public IEntity setFeature(String name, boolean value) {
		return getOperation().setFeature(name, value);
	}
	public IEntity setFeature(String name, IEntity value) {
		return getOperation().setFeature(name, value);
	}

	public final int getStage() {
		return getOperation().getStage();
	}

	public final void stagedVisit(IEntity entity) {
		stagedVisit(entity, 0);
	}
	public final void stagedVisit(IEntity entity, int relativeStage) {
		getOperation().stagedVisit(entity, relativeStage);
	}
	public final void stagedVisit(IEntity entity, int relativeStage, String phase) {
		getOperation().stagedVisit(entity, relativeStage, phase);
	}
	public final void stagedDefaultVisit(IEntity entity, int relativeStage) {
		getOperation().stagedDefaultVisit(entity, relativeStage);
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		return CommonsInterpreterVisitor.evaluateAdapter(entity, getOperation());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb);
		return sb.toString();
	}
	public void toString(StringBuilder sb) {
	}
}
