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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericCloneVisitor extends AbstractVisitor {
	protected Map<IEntity, IEntity> entityCloneMap = new HashMap<IEntity, IEntity>(1024);

	public IEntity getClone(IEntity entity) {
		return entityCloneMap.get(entity);
	}
	public void setClone(IEntity entity, IEntity entityClone) {
		entityCloneMap.put(entity, entityClone);
	}

	public void stagedVisitIfNeeded(IEntity entity) {
		IEntity entityClone = getClone(entity);
		if (entityClone != null)
			setResult(entityClone);
		else
			stagedVisit(entity);
	}

	public void visit(IEntity entity) {
		applyClone(entity);
	}

	public void applyClone(IEntity entity) {
		IEntity entityClone = ((InternalIEntity) entity).wShallowClone();
		setClone(entity, entityClone);
		setChildrenAndAspects(entity, entityClone);
		setResult(entityClone);
	}

	protected void setChildrenAndAspects(IEntity entity, IEntity entityClone) {
		setChildren(entity, entityClone);
		setAspects(entity, entityClone);
	}
	protected void setChildren(IEntity entity, IEntity entityClone) {
		IEntity oldSelfEntity2 = getBindings().wGet("self");

		for (int index=0; index<entity.wSize(); index++) {
    		int resultSize = entityClone.wSize();
    		stagedVisitIfNeeded(entityClone.wGet(index));
//was			applyIfNeeded(entity.wGet(index));
			int nextResultSize = entityClone.wSize();
			index += (nextResultSize - resultSize);
			
			if (isResultIterator()) {
				IEntityIterator<?> iterator = getResultIterator();
				setResultIterator(null);
				IEntity selfEntity = getBindings().wGet("self");
	        	if (selfEntity != oldSelfEntity2)
	        		getBindings().wDef("self", selfEntity = oldSelfEntity2);
				iterator.reset(selfEntity);
				FeatureDescriptor resultChildDescriptor = entityClone.wGetFeatureDescriptor(index);
				if (EntityUtils.isComposite(entityClone)) {
					entityClone.wRemove(index--);
    				if (iterator.hasNext()) {
    					ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
    					resultSize = entityClone.wSize();
	    				for (IEntity value : iterator) {
	    					nextResultSize = entityClone.wSize();
	    					index += (nextResultSize - resultSize);
	    					if (BindingManagerFactory.instance.isVoid(value))
	    						resultSize = nextResultSize;
	    					else {
	    						entityClone.wAdd(++index, EntityUtils.convertCloneIfReparenting(value, resultChildDescriptor));
		    					resultSize = entityClone.wSize();
	    					}
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
				} else {
					IEntity value = null;
    				if (iterator.hasNext()) {
    					ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
    					getBindings().wEnterScope(resettableScope);
	    				for (IEntity r : iterator) {
	    					if (!BindingManagerFactory.instance.isVoid(r))
		    					value = r;
	    					resettableScope.commit();
	    				}
    					resettableScope.rollback();
	    				getBindings().wExitScope();
    				}
					if (value != null)
						entityClone.wSet(index, EntityUtils.convertCloneIfReparenting(value, resultChildDescriptor));
					else
						entityClone.wRemove(index);
				}				
			} else {
				IEntity value = getResult();
				if (value != null && !BindingManagerFactory.instance.isVoid(value)) {
					FeatureDescriptor resultChildDescriptor = entityClone.wGetFeatureDescriptor(index);
					entityClone.wSet(index, EntityUtils.convertCloneIfReparenting(value, resultChildDescriptor));
    			}  else
    				entityClone.wRemove(index);
				
			}
		}
	}
	protected void setAspects(IEntity entity, IEntity entityClone) {
		IEntity oldSelfEntity2 = getBindings().wGet("self");

		for (FeatureDescriptor fd : entity.wGetAspectualFeatureDescriptors())
			if (!fd.isReference()) {
				stagedVisitIfNeeded(entityClone.wGet(fd));
//was			applyIfNeeded(entity.wGet(fd));
				if (isResultIterator()) {
					IEntityIterator<?> iterator = getResultIterator();
					setResultIterator(null);
					IEntity selfEntity = getBindings().wGet("self");
		        	if (selfEntity != oldSelfEntity2)
		        		getBindings().wDef("self", selfEntity = oldSelfEntity2);
					iterator.reset(selfEntity);
					if (iterator.hasNext()) {
						IEntity value = null;

						ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
						getBindings().wEnterScope(resettableScope);
	    				for (IEntity r : iterator) {
	    					if (!BindingManagerFactory.instance.isVoid(r))
		    					value = r;
	    					resettableScope.commit();
	    				}
						resettableScope.rollback();
	    				getBindings().wExitScope();

	    				if (value != null)
							entityClone.wSet(fd, EntityUtils.convertCloneIfReparenting(value, fd));
					}
				} else {
					IEntity value = getResult();
					if (value != null && !BindingManagerFactory.instance.isVoid(value))
						entityClone.wSet(fd, value);
				}
			}
	}

	public void updateAdjacencyGraph() {
		for (Map.Entry<IEntity, IEntity> entry : entityCloneMap.entrySet()) {
			IEntity entity = entry.getKey();
			IEntity entityClone = entry.getValue();

			for (int i=entity.wSize(), size=i+entity.wAdjacentSize(); i<size; i++) {
				IEntity adjacentEntity = entity.wGet(i);
				IEntity adjacentClone = entityCloneMap.get(adjacentEntity);
				
				if (adjacentClone != null)
					entityClone.wSet(i, adjacentClone);
				else
					entityClone.wRemove(i);//TODO enforce shallow copy removal semantics 
			}

			for (FeatureDescriptor fd : entity.wGetAspectualFeatureDescriptors())
				if (fd.isReference()) {
					IEntity adjacentEntity = entity.wGet(fd);
					IEntity adjacentClone = entityCloneMap.get(adjacentEntity);
					
					if (adjacentClone != null)
						entityClone.wSet(fd, adjacentClone);
					else
						entityClone.wRemove(fd);//TODO enforce shallow copy removal semantics 
				}
		}
	}
}
