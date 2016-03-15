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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class CloneOperation {
	protected Map<IEntity, IEntity> entityCloneMap = new HashMap<IEntity, IEntity>(1024);

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E clone(E entity) {
		//TODO disable undo history on entityClone
		E entityClone = (E) applyRules(entity);
		updateAdjacencyGraph();
		return entityClone;
	}
	@SuppressWarnings("unchecked")
	public <E extends IEntity> Collection<E> cloneAll(Collection<E> entities) {
		//TODO disable undo history on entityClone
		Collection<E> clonedEntities = new ArrayList<E>(entities.size());
	     for (E entity : entities)
	    	 clonedEntities.add((E) applyRules(entity));
		updateAdjacencyGraph();
		return clonedEntities;
	}

	protected IEntity applyRules(IEntity entity) {
		return applyClone(entity);
	}
	protected IEntity applyClone(IEntity entity) {
		IEntity entityClone = ((InternalIEntity) entity).wShallowClone();
		setCopy(entity, entityClone);
		setChildrenAndAspects(entity, entityClone);
		return entityClone;
	}

	protected void setCopy(IEntity entity, IEntity entityClone) {
		entityCloneMap.put(entity, entityClone);
	}
	protected void setChildrenAndAspects(IEntity entity, IEntity entityClone) {
		setChildren(entity, entityClone);
		setAspects(entity, entityClone);
	}
	protected void setChildren(IEntity entity, IEntity entityClone) {
		for (int index=0; index<entity.wSize(); index++)
			entityClone.wSet(index, applyIfNeeded(entity.wGet(index)));
	}
	protected void setAspects(IEntity entity, IEntity entityClone) {
		for (FeatureDescriptor fd : entity.wGetAspectualFeatureDescriptors())
			if (!fd.isReference())
				entityClone.wSet(fd, applyIfNeeded(entityClone.wGet(fd)));
	}
	protected IEntity applyIfNeeded(IEntity entity) {
		IEntity entityClone = entityCloneMap.get(entity);
		if (entityClone == null)
			entityClone = applyRules(entity);
		return entityClone;
	}

	protected void updateAdjacencyGraph() {
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
