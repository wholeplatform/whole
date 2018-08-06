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
package org.whole.lang.reusables.operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.Placement;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneOperationOld;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class EvaluateCloneOperation extends CloneOperationOld {
	protected IOperation operation;
	protected Predicate<IEntity> shouldEvaluate;
	protected boolean updateAdjacencyGraph;

	public EvaluateCloneOperation(IOperation operation, Predicate<IEntity> shouldEvaluate) {
		this.operation = operation;
		this.shouldEvaluate = shouldEvaluate;
		this.updateAdjacencyGraph = true;
	}

	protected IBindingManager getBindings() {
		return operation.getOperationEnvironment();
	}
	protected void resetSelfEntity(IEntity selfEntity) {
		if (getBindings().wGet(IBindingManager.SELF) != selfEntity)
			if (getBindings().wIsSet(IBindingManager.SELF))
				getBindings().wSet(IBindingManager.SELF, selfEntity);
			else
				getBindings().wDef(IBindingManager.SELF, selfEntity);	
	}
	@Override
	protected void cloneAndUpdate(IEntity entityClone, int index) {
		IEntity child = entityClone.wGet(index);
		if (shouldEvaluate.test(child)) {
			IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
			IEntityIterator<?> iterator = BehaviorUtils.lazyEvaluateOnSelfBinding(child, 0, getBindings());
//			IEntityIterator<?> iterator = DynamicCompilerOperation.compile(child, getBindings()).getResultIterator();
			if (EntityUtils.isSimple(entityClone)) {
				iterator = IteratorFactory.instance.composeIterator(IteratorFactory.instance.singleValuedRunnableIterator(
						(self, bm, arguments) -> entityClone.wSet(index, self)
				),	iterator);
			} else {
				if (index == entityClone.wSize()-1)
					iterator = IteratorFactory.instance.cartesianInsertIterator(iterator, 
							IteratorFactory.instance.selfIterator(), Placement.INTO);
				else
					iterator = IteratorFactory.instance.cartesianInsertIterator(iterator, 
							IteratorFactory.instance.childIterator(index+1), Placement.BEFORE);
			}
			if (EntityUtils.isSimple(entityClone))
				entityClone.wRemove(index);
			iterator.evaluate(entityClone, getBindings());
			if (EntityUtils.isComposite(entityClone))
				entityClone.wRemove(index);
			resetSelfEntity(selfEntity);
		} else
			super.cloneAndUpdate(entityClone, index);
	}
	@Override
	protected void cloneAndUpdate(IEntity entityClone, FeatureDescriptor fd) {
		IEntity child = entityClone.wGet(fd);
		if (shouldEvaluate.test(child)) {
			IEntity selfEntity = getBindings().wGet(IBindingManager.SELF);
			IEntityIterator<?> iterator = BehaviorUtils.lazyEvaluateOnSelfBinding(child, 0, getBindings());
//			IEntityIterator<?> iterator = DynamicCompilerOperation.compile(child, getBindings()).getResultIterator();
			iterator = IteratorFactory.instance.composeIterator(IteratorFactory.instance.singleValuedRunnableIterator(
					(self, bm, arguments) -> entityClone.wSet(fd, self)
			),	iterator);
			entityClone.wRemove(fd);
			iterator.evaluate(entityClone, getBindings());
			resetSelfEntity(selfEntity);
		} else
			super.cloneAndUpdate(entityClone, fd);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E clone(E entity) {
		//TODO disable undo history on entityClone
		if (updateAdjacencyGraph) {
			updateAdjacencyGraph = false;
			return super.clone(entity);
		} else
			return (E) cloneDescendantTree(entity);
	}
	@SuppressWarnings("unchecked")
	public <E extends IEntity> Collection<E> cloneAll(Collection<E> entities) {
		//TODO disable undo history on entityClone
		if (updateAdjacencyGraph) {
			updateAdjacencyGraph = false;
			return super.cloneAll(entities);
		} else {
			Collection<E> clonedEntities = new ArrayList<E>(entities.size());
			entities.forEach(entity -> clonedEntities.add((E) cloneDescendantTree(entity)));
			return clonedEntities;
		}
	}
}
