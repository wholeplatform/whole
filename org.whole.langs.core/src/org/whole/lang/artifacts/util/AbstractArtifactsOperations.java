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
package org.whole.lang.artifacts.util;

import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractArtifactsOperations<T> implements IArtifactsOperations<T> {
	public T getDescendant(T resource, IEntity descendant) {
		if (descendant == null || !EntityUtils.hasParent(descendant))
			return resource;

		ExecutableFactory ef = ExecutableFactory.instance;
		IExecutable executable = ef.createFilter(
				ef.createAncestorOrSelfReverse(),
				ef.createSome(ef.createIsFragment(), ef.createHasKind(EntityKinds.COMPOSITE)));

		T parentContext = getParent(resource);
		executable.reset(descendant);
		for (IEntity e = executable.evaluateNext(); e != null; e = executable.evaluateNext())
			parentContext = getChild(parentContext, e);
		
		return parentContext;
	}

	public void deleteChild(T resource, IEntity child) {
		delete(getChild(resource, child));
	}
}
