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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public class SingleValuedRunnableIterator<E extends IEntity> extends AbstractSingleValuedRunnableIterator<E> {
	protected IRunnable runnable;

	protected SingleValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		super(argsIterators);
		this.runnable = runnable;
	}
	protected SingleValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		super(optionalArgsIndexes, argsIterators);
		this.runnable = runnable;
	}

	public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
		try {
			runnable.run(selfEntity, bm, arguments);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, getSourceEntity(), bm);
		}
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(runnable.toString());
		super.toString(sb);
	}
}
