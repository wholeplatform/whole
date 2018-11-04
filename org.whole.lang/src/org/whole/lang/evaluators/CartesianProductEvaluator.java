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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class CartesianProductEvaluator extends AbstractCartesianEvaluator {
	@SuppressWarnings("unchecked")
	public CartesianProductEvaluator(IExecutable<IEntity>... executables) {
		super(executables);
	}

	@Override
	protected void initProducer(IExecutable<?> p, int index) {
		p.setBindings(getBindings());
		p.reset(selfEntity);
	}

	protected IEntity evaluateNestedResults() {
		return isLastProducer() ? BindingManagerFactory.instance.createTuple(nestedResults) : null;
	}

	@Override
	public void prune() {
	}

	public void set(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void remove() {
		for (IExecutable<IEntity> p : producers)
			p.remove();
	}

	protected String toStringSeparator() {
		return " x ";
	}
}
