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
package org.whole.lang.iterators;

import org.whole.lang.executables.AbstractExecutableIteratingEvaluatingStepper;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractLazyCloneableIterator<E extends IEntity> extends AbstractExecutableIteratingEvaluatingStepper<E> {
	private ICloneContext cloneContext;
	protected IEntity selfEntity;

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractLazyCloneableIterator<E> iterator = (AbstractLazyCloneableIterator<E>) super.clone(cc);
		iterator.cloneContext = cc;
		cloneContext = cc.getPrototypeCloneContext();
		return iterator;
	}

	protected ICloneContext getCloneContext() {
		return cloneContext;
	}
	protected void updateCloneContext() {
		if (isLazyCloneEmpty())
			cloneContext = null;
	}
	protected abstract boolean isLazyCloneEmpty();
}
