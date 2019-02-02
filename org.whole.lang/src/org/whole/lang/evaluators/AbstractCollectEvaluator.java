/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCollectEvaluator extends AbstractDelegatingNestedSupplierEvaluator {
	protected IEntityComparator<IEntity> comparator;

	public AbstractCollectEvaluator(IExecutable... executables) {
		this(BusinessIdentityComparator.instance, executables);
	}
	public AbstractCollectEvaluator(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		super(executables);
		this.comparator = comparator;
	}

	public AbstractCollectEvaluator withComparator(IEntityComparator<IEntity> comparator) {
		this.comparator = comparator;
		return this;
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		AbstractCollectEvaluator evaluator = (AbstractCollectEvaluator) super.clone(cc);
		evaluator.comparator = cc.differentiate(comparator);
		return evaluator;
	}

	@Override
	protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		comparator.setBindings(bindings);
	}

	protected IEntity createResult() {
		return createResult(false);
	}
	protected IEntity createResult(boolean withContainment) {
		return BindingManagerFactory.instance.createTuple(withContainment);
	}

	public void prune() {
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
}
