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
package org.whole.lang.queries.iterators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CartesianInsertIterator<E extends IEntity> extends AbstractCartesianIterator<E> {
	protected Placement placement;

	protected CartesianInsertIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator, Placement placement) {
		super(valuesIterator, toIterator);
		this.placement = placement;
	}

	@SuppressWarnings("unchecked")
	protected E doLookahead(IEntity lastToEntity, E nextEntity) {
		EntityDescriptor<?> toEd;
		switch (placement) {
		case BEFORE:
			toEd = lastToEntity.wGetParent().wGetEntityDescriptor(lastToEntity);
			break;
		case INTO:
			toEd = lastToEntity.wGetEntityDescriptor(0);
			break;
		default:
			throw new IllegalArgumentException("unsupported placement");
		}
		return (E) EntityUtils.convertCloneIfParented(nextEntity, toEd);
	}

	protected void doNext(IEntity lastToEntity, E nextEntity) {
		if (BindingManagerFactory.instance.isVoid(nextEntity))
			return;

		switch (placement) {
		case BEFORE:
			add(nextEntity);
			break;
		case INTO:
			lastToEntity.wAdd(nextEntity);
			break;
		}
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("insert(");
    	super.toString(sb);
    	sb.append(" x= ");
    	sb.append(valuesIterator.toString());
    	sb.append(")");
    }
}
