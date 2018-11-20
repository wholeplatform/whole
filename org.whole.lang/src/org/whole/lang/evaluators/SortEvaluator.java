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

import java.util.TreeSet;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class SortEvaluator extends CollectionEvaluator {
	protected IExecutable executable;
	protected IEntityComparator<? super IEntity> comparator;

	public SortEvaluator(IExecutable executable) {
		this(executable, BusinessIdentityComparator.instance);
	}
	public SortEvaluator(IExecutable executable, IEntityComparator<? super IEntity> comparator) {
		this.executable = executable;
		this.comparator = comparator;
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		SortEvaluator evaluator = (SortEvaluator) super.clone(cc);
		evaluator.executable = cc.clone(this.executable);
		evaluator.comparator = cc.clone(comparator);
		return evaluator;
	}

	@Override
	protected Iterable<?> getCollectionIterable(IEntity entity) {
		executable.reset(entity);

		TreeSet<IEntity> treeSet = new TreeSet<IEntity>(comparator);
		for (IEntity e : executable)
			treeSet.add(e);
		return treeSet;
	}

	protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		executable.setBindings(bindings);
		comparator.setBindings(bindings);
	}
}
