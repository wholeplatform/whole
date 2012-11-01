/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class LocalVariableIterator<E extends IEntity> extends SelfIterator<E> {
	private IBindingManager bindings;
	protected String varName;
	protected boolean useVar = true;

	protected LocalVariableIterator(String varName) {
		this.varName = varName;
	}

	@Override
	public boolean hasNext() {
		return useVar && getBindings().wIsSet(varName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E lookahead() {
		return hasNext() ? (E) getBindings().wGet(varName) : null;
	}
	@Override
	public E next() {
		try {
			E result = super.next();
			useVar = false;
			return result;
		} catch (NoSuchElementException e) {
			e.initCause(new MissingVariableException(varName));
			throw e;
		}
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		useVar = true;
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
			super.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	@Override
	public void set(E entity) {
		super.set(entity);
		getBindings().wSet(varName, entity);
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("$");
		sb.append(varName);
	}
}
