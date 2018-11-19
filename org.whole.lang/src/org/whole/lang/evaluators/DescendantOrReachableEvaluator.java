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

import org.whole.lang.executables.DistinctScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class DescendantOrReachableEvaluator<E extends IEntity> extends AbstractTransitiveClosureEvaluator<E> {
	protected DistinctScope<E> distinctScope;

	public DescendantOrReachableEvaluator(boolean includeSelf, DistinctScope<E> distinctScope) {
		super(includeSelf);

		this.distinctScope = distinctScope;
	}

	@Override
	public IExecutable<E> clone(ICloneContext cc) {
		DescendantOrReachableEvaluator<E> iterator = (DescendantOrReachableEvaluator<E>) super.clone(cc);
		iterator.distinctScope = cc.clone(distinctScope);
		return iterator;
	}

    protected boolean isRelationNotEmpty(IEntity entity) {
		return entity.wSize()+entity.wAdjacentSize() > 0;
	}
    
    protected IExecutable<E> createRelationExecutable() {
    	return executableFactory().createFilter(executableFactory().<E>createChildOrAdjacent(), distinctScope.distinctExecutable());
    }

    public void toString(StringBuilder sb) {
		sb.append(includeSelf ? "descendantOrReachableOrSelf()" : "descendantOrReachable()");
    }
}
