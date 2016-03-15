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
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ConstantIterator<E extends IEntity> extends SelfIterator<E> {
	protected E constant;
    protected E nextConstant;
    protected boolean useClone;

	protected ConstantIterator(E constant, boolean useClone) {
		this.useClone = useClone;
		if (useClone) {
			this.constant = EntityUtils.cloneIfParented(constant);
			this.nextConstant = EntityUtils.clone(constant);
		} else
			this.nextConstant = this.constant = constant;
	}

	protected void resetNextConstant() {
		nextConstant = useClone ? EntityUtils.clone(constant) : constant;
	}

	@Override
	public boolean hasNext() {
		return nextConstant != null;
	}

	@Override
	public E lookahead() {
		return hasNext() ? nextConstant : null;
	}
	@Override
	public E next() {
		E result = super.next();
		nextConstant = null;
		return result;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		resetNextConstant();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("constant(");
		sb.append(constant.toString());
		sb.append(")");
    }
}
