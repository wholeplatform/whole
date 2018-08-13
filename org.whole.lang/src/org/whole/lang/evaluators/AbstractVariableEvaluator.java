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

import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVariableEvaluator<E extends IEntity> extends AbstractPureConditionalSupplierEvaluator<E> {
	protected String varName;

	protected AbstractVariableEvaluator(String varName) {
		this.varName = varName;
	}

	protected abstract boolean isSetVariable();
	protected abstract E getVariable();
	protected abstract void setVariable(E entity);

	public E get() {
		E value = getVariable();
		if (value == null)
			throw new MissingVariableException(varName).withSourceEntity(getSourceEntity()).withBindings(getBindings());
		return value;
	}

	@Override
	public boolean hasNext() {
		return !isEvaluated && isSetVariable();
	}

	@Override
	public void set(E entity) {
		super.set(entity);
		setVariable(entity);
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("$");
		sb.append(varName);
	}
}
