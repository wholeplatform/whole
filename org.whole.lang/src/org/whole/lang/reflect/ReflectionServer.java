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
package org.whole.lang.reflect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ReflectionServer {
	//TODO add backend persistence and pidProvider

	private Long nextPid = 0L;
	public Serializable getFreshPid() {
		return nextPid++;
	}

	private Set<IEntity> rootEntities = new HashSet<IEntity>();
	private Map<Serializable, IEntity> pidEntityMap = new HashMap<Serializable, IEntity>();

	public Set<IEntity> getRootEntities() {
		//TODO replace with early code in wSetParent
		rootEntities.removeIf(e -> EntityUtils.hasParent(e));

		return rootEntities;
	}

	public <E extends IEntity> E createEntity(EntityDescriptor<E> ed) {
		IEntityFactory ef = GenericEntityFactory.instance;
		E entity = ef.create(ed);
		
		//TODO add reflectionServer to entity compound model
		//TODO ? set pid and put in pidInstanceMap or put in rootInstances and lazy set pid in AbstractEntiy
		getPid(entity);

		return entity;
	}

	public Serializable getPid(IEntity entity) {
		Serializable pid = entity.wGetPid();
		if (pid == null) {
			pid = getFreshPid();
			((InternalIEntity) entity).wSetPid(pid);
			pidEntityMap.put(pid, entity);
			if (!EntityUtils.hasParent(entity))
				rootEntities.add(entity);
		}
		return pid;
	}
	public IEntity getEntity(Serializable pid) {
		pid = Long.valueOf((String) pid);//FIXME move
		IEntity entity = pidEntityMap.get(pid);
		if (entity == null)
			throw new IllegalArgumentException("Instance with given id doesn't exists");
		return entity;
	}


	public IEntity removeEntity(IEntity targetEntity) {
		return EntityUtils.remove(targetEntity);
	}

	public IEntity cloneEntity(IEntity targetEntity) {
		return EntityUtils.clone(targetEntity);
	}

	public IEntity replaceEntity(IEntity targetEntity, IEntity sourceEntity) {
		//FIXME move pid from old to newChild ?
		((InternalIEntity) sourceEntity).wSetPid(targetEntity.wGetPid());
		//TODO replace opposite references

		//add as arguments
		IEntity parentEntity = targetEntity.wGetParent();
		int index = parentEntity.wIndexOf(targetEntity);
		
		parentEntity.wSet(index, sourceEntity);
		return sourceEntity;
	}

	//TODO String.. sourceIds
	public IEntity insertAround(IEntity targetEntity, IEntity sourceEntity) {
		//add as arguments
		IEntity parentEntity = targetEntity.wGetParent();
		int index = parentEntity.wIndexOf(targetEntity);

		parentEntity.wSet(index, sourceEntity);
		return sourceEntity;
	}

	//TODO String.. sourceIds
	public IEntity insertBefore(IEntity targetEntity, IEntity sourceEntity) {
		//add as arguments
		IEntity parentEntity = targetEntity.wGetParent();
		int index = parentEntity.wIndexOf(targetEntity);

		parentEntity.wAdd(index, sourceEntity);
		return sourceEntity;
	}

	//TODO String.. sourceIds
	public IEntity insertAfter(IEntity targetEntity, IEntity sourceEntity) {
		//add as arguments
		IEntity parentEntity = targetEntity.wGetParent();
		int index = parentEntity.wIndexOf(targetEntity);

		parentEntity.wAdd(index+1, sourceEntity);
		return sourceEntity;
	}

	//TODO String.. sourceIds
	public IEntity insertLastChild(IEntity parentEntity, IEntity sourceEntity) {
		parentEntity.wAdd(sourceEntity);
		return sourceEntity;
	}

}
