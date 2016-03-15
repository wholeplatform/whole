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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.GenericCloneVisitor;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCloneBasedOperation extends AbstractOperation {
	protected GenericCloneVisitor defaultCloneVisitor = createCloneVisitor();

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E clone(E entity) {
		//TODO disable undo history on entityClone
		stagedVisit(entity);
		defaultCloneVisitor.updateAdjacencyGraph();

		return (E) defaultCloneVisitor.getClone(entity);
	}
	@SuppressWarnings("unchecked")
	public <E extends IEntity> Collection<E> cloneAll(Collection<E> entities) {
		//TODO disable undo history on entityClone
		for (E entity : entities)
			stagedVisit(entity);
		defaultCloneVisitor.updateAdjacencyGraph();

		Collection<E> clonedEntities = new ArrayList<E>(entities.size());
	    for (E entity : entities)
	    	 clonedEntities.add((E) defaultCloneVisitor.getClone(entity));
		return clonedEntities;
	}

	protected AbstractCloneBasedOperation(String name, IBindingManager args, boolean resultsInArgs) {
		super(name, args, resultsInArgs);
	}
	protected AbstractCloneBasedOperation(String name, IBindingManager args, IBindingScope resultsScope) {
		super(name, args, resultsScope);
	}

	@Override
	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		return defaultCloneVisitor;
	}
	protected GenericCloneVisitor createCloneVisitor() {
		return new GenericCloneVisitor();
	}
}
