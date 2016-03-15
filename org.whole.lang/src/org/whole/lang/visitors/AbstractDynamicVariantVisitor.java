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
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.util.BehaviorUtils;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDynamicVariantVisitor extends AbstractVisitor implements IDynamicVariantVisitor {
	protected String uri;
	protected IDynamicVariantVisitor superVisitor;

	
	@Override
	public void setOperation(IOperation operation) {
		super.setOperation(operation);
		if (superVisitor != null)
			superVisitor.setOperation(operation);
	}

    @Override
    public void setBindings(IBindingManager bm) {
    	super.setBindings(bm);
		if (superVisitor != null)
			superVisitor.setBindings(bm);
    }

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	public IDynamicVariantVisitor getSuperVisitor() {
		return superVisitor;
	}
	public void setSuperVisitor(IDynamicVariantVisitor visitor) {
		superVisitor = visitor;
	}

	public IDynamicVariantVisitor getSuperVisitor(String uri) {
		if (superVisitor == null)
			return null;
		else if (uri.equals(superVisitor.getUri()))
			return superVisitor;
		else
			return superVisitor.getSuperVisitor(uri);
	}
	public void removeSuperVisitor(String uri) {
		if (superVisitor == null)
			return;
		else if (uri.equals(superVisitor.getUri()))
			superVisitor = superVisitor.getSuperVisitor();
		else
			superVisitor.removeSuperVisitor(uri);
	}

	public void addVisit(String edUri, final IEntity entity) {
		addVisit(
				CommonsDataTypePersistenceParser.parseEntityDescriptor(edUri),
				new BehaviorVisitor(this, entity));
	}
	protected class BehaviorVisitor implements IVisitor {
		private IEntity sourceEntity;
		public IVisitor withSourceEntity(IEntity entity) {
			sourceEntity = entity;
			return this;
		}
		public IEntity getSourceEntity() {
			return sourceEntity;
		}

		protected IVisitor contextVisitor;
		protected IEntity behavior;
		
		public BehaviorVisitor(IVisitor contextVisitor, IEntity behavior) {
			this.contextVisitor = contextVisitor;
			this.behavior = behavior;
		}

		public IVisitor clone() {
			return clone(new CloneContext());
		}

		public IVisitor clone(ICloneContext cc) {
			try {
				BehaviorVisitor visitor = (BehaviorVisitor) super.clone();
				cc.putClone(this, visitor);
				visitor.contextVisitor = null;
				return visitor;
			} catch (CloneNotSupportedException e) {
				throw new InternalError();
			}
		}

		public IOperation getOperation() {
			return contextVisitor.getOperation();
		}
		public void setOperation(IOperation operation) {
			contextVisitor.setOperation(operation);
		}

		public IBindingManager getBindings() {
			return contextVisitor.getBindings();
		}
		public void setBindings(IBindingManager bm) {
			contextVisitor.setBindings(bm);
		}

		public int getStage() {
			return /*contextVisitor*/getOperation().getStage();
		}
		public void stagedVisit(IEntity entity, int relativeStage) {
			/*contextVisitor*/getOperation().stagedVisit(entity, relativeStage);
		}

		public boolean visitAdapter(IEntityAdapter entity) {
			return contextVisitor.visitAdapter(entity);
		}

		public void visit(IEntity entity) {
			getBindings().wDef("self", entity);
			setResultIterator(
					BehaviorUtils.lazyEvaluate(behavior, 0, getBindings()));
		}
	}
}
