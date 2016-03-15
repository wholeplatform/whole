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

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ExceptIterator extends AbstractCollectIterator {
	public ExceptIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		super(iteratorChain);
	}

	protected IEntity collect(IEntityIterator<? extends IEntity>[] iteratorChain) {
		IEntity result = createResult();

		for (IEntity e : iteratorChain[0])
			result.wAdd(e);

		for (int i=1; i<iteratorChain.length; i++) {
			IEntityIterator<? extends IEntity> iterator = iteratorChain[i];
			for (IEntity e : iterator) {
				IEntity e0 = comparator.get(result, e);
				if (e0 != null)
					result.wRemove(e0);
			}
		}

		return result;
	}
}
