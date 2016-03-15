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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 * 
 * sequence(
 *   traverseAllChildren(collect(model, map)),
 *   traverseAllAdjacents(ifThenElse(isNotMapped(map), nullify, identity)))
 */
public class RemoveOperation {
	protected Set<IEntity> descendantOrSelfSet = new HashSet<IEntity>(1024);

	public <E extends IEntity> E remove(E entity) {
		collectDescendantTree(entity);
		splitAdjacencyGraph();
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent))
			parent.wRemove(entity);
		return entity;
	}
	public <E extends IEntity> Collection<E> removeAll(Collection<E> entities) {
		for (E entity : entities)
			collectDescendantTree(entity);
		splitAdjacencyGraph();
		for (E entity : entities) {
			IEntity parent = entity.wGetParent();
			if (!EntityUtils.isNull(parent) && !descendantOrSelfSet.contains(parent))
				parent.wRemove(entity);
		}
		return entities;
	}

	protected void collectDescendantTree(IEntity entity) {
		if (descendantOrSelfSet.add(entity)) {
			for (int i=0; i<entity.wSize(); i++)
				collectDescendantTree(entity.wGet(i));
			
			for (FeatureDescriptor fd : entity.wGetAspectualFeatureDescriptors())
				if (!fd.isReference())
					collectDescendantTree(entity.wGet(fd));
		}
	}
	protected void splitAdjacencyGraph() {
		for (IEntity entity : descendantOrSelfSet) {
			for (int i=entity.wSize(), size=i+entity.wAdjacentSize(); i<size; i++)
				if (!descendantOrSelfSet.contains(entity.wGet(i)))
					entity.wRemove(i);

			for (FeatureDescriptor fd : entity.wGetAspectualFeatureDescriptors())
				if (fd.isReference() && !descendantOrSelfSet.contains(entity.wGet(fd)))
					entity.wRemove(fd);

			for (IEntity inverseAdjacent : entity.wInverseAdjacents())
				if (!descendantOrSelfSet.contains(inverseAdjacent))
					inverseAdjacent.wRemove(entity);				
		}
	}
}
