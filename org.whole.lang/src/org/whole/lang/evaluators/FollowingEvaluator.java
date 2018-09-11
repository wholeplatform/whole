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
package org.whole.lang.evaluators;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class FollowingEvaluator<E extends IEntity> extends AbstractTransitiveClosureEvaluator<E> {
	public FollowingEvaluator(boolean includeSelf) {
		super(includeSelf);
	}

	@Override
	protected void pushInitialIterators(IEntity entity) {
		if (entity == null || !EntityUtils.hasParent(entity))
			pushIterator(executableFactory().<E>createEmpty(), entity);
		else {
			IEntity parent = entity.wGetParent();
			pushInitialIterators(parent);
			pushIterator(createChildIterator(), entity);
		}
	}

	protected IExecutable<E> createChildIterator() {
		return includeSelf ? executableFactory().<E>createFollowingSiblingOrSelf() :
			executableFactory().<E>createFollowingSibling();
	}

	protected boolean isRelationNotEmpty(IEntity entity) {
		return entity.wSize() > 0;
	}

    protected IExecutable<E> createRelationIterator() {
    	return executableFactory().<E>createChild();
    }

	public void toString(StringBuilder sb) {
		sb.append(includeSelf ? "following-or-self()" : "following()");
	}
}
