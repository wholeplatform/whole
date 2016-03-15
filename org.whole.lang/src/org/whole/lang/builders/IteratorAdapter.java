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
package org.whole.lang.builders;

import java.util.Iterator;

import org.whole.lang.contexts.AbstractEntityContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class IteratorAdapter implements Iterator<IEntity> {
	IEntityContext modelContext;

	public IteratorAdapter(IEntityContext modelContext) {
		this.modelContext = modelContext;
	}

	public boolean hasNext() {
		return modelContext.wHasNext();
	}
	public IEntity next() {
		modelContext.wNext();
		return ((AbstractEntityContext) modelContext).wGetEntity();
	}

	public void remove() {
//		modelContext.wRemove
	}
}
