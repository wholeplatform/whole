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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class RecursiveFunctionApplicationIterator extends AbstractCloneableIterator<IEntity> {
	private IBindingManager bindings;
	private IEntity nextEntity = null;
	private IEntity resetEntity = null;

	protected IEntity currentOperationStagedVisit() {
		if (resetEntity != null) {
			bindings.wGetEnvironmentManager().getCurrentOperation().stagedVisit(resetEntity, 0);
			resetEntity = null;
		}
		return bindings.getResult();
	}

	public boolean hasNext() {
		return resetEntity != null && bindings != null;
	}

	public IEntity next() {
		IEntity result = lookahead();
		nextEntity = null;
		return result;
	}
	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (resetEntity == null)
			return null;

		return nextEntity = currentOperationStagedVisit();
	}

	public void set(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		nextEntity = null;
	}

    public void setBindings(IBindingManager bindings) {
    	this.bindings = bindings;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public IBindingScope lookaheadScope() {
		return NullScope.instance;
	}

	public void prune() {
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("stagedVisit(self, 0)");
    }
}
