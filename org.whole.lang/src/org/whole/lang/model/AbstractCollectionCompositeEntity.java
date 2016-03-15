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
package org.whole.lang.model;

import java.util.Collection;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractCollectionCompositeEntity<E extends IEntity> extends AbstractOrderedCompositeEntity<E> implements Collection<E> {
	public boolean wSet(IEntity oldChild, IEntity newChild) {
		int index = wIndexOf(oldChild);
		if (index >= 0) {
		    wSet(index, newChild);
		    return true; //FIXME
		}
		return false;
	}

	public void/*boolean*/ wSet(int index, IEntity child) {
	    if (index < elements.size())
			set(index, adaptElement(child));
	    else {
	        elementsFill(index);
	        wAdd(child);
	    }
		/*return true;*/
	}
	protected void elementsFill(int uptoSize) {
		if (elements.size() < uptoSize) {
			EntityDescriptor<?> ed = wGetEntityDescriptor(0);
			do {
				wAdd(GenericEntityFactory.instance.create(ed));			
			} while (elements.size() < uptoSize);
		}
	}

	public boolean remove(Object o) {
		return o instanceof IEntity ? wRemove((IEntity) o) : false;
	}

	public boolean removeAll(Collection<?> c) {
		boolean modified = false;

		for (Object o : c)
			modified |= remove(o);
		
		return modified;
	}
}
