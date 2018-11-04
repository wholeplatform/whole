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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.iterators.DistinctScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class FilterByDistinctEvaluator<E extends IEntity> extends AbstractDelegatingNestedEvaluator<E> implements DistinctScope<E> {
	protected Map<Object, Set<IEntity>> distinctSetMap;
	protected IEntityComparator<IEntity> comparator;

	public FilterByDistinctEvaluator() {
		this(BusinessIdentityComparator.instance);
	}
	@SuppressWarnings("unchecked")
	public FilterByDistinctEvaluator(IEntityComparator<IEntity> comparator) {
		super((IExecutable<IEntity>) null);
		this.comparator = comparator;
	}

	@Override
	public IExecutable<E> clone(ICloneContext cc) {
		FilterByDistinctEvaluator<E> iterator = (FilterByDistinctEvaluator<E>) super.clone(cc);
		if (distinctSetMap != null)
			iterator.distinctSetMap = new HashMap<Object, Set<IEntity>>(distinctSetMap);
		iterator.comparator = cc.clone(iterator.comparator);			
		return iterator;
	}

	public DistinctScope<E> withComparator(IEntityComparator<IEntity> comparator) {
		this.comparator = comparator;
		return this;
	}
	public IExecutable<E> withExecutable(IExecutable<E> executable) {
		producers[0] = (IExecutable<IEntity>) executable;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E evaluateNext() {
		return (E) getProducer().evaluateNext();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E evaluateRemaining() {
		return (E) getProducer().evaluateRemaining();
	}

	protected void setProducersBindings(IBindingManager bindings) {
		super.setProducersBindings(bindings);
		comparator.setBindings(bindings);
	}

	public IExecutable<IEntity> distinctExecutable() {
		return new AbstractNestedSupplierEvaluator<IEntity>(this) {
			@Override
			protected void resetProducers(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			@SuppressWarnings("unchecked")
			public E get() {
				return (E) BindingManagerFactory.instance.createValue(
						((FilterByDistinctEvaluator<?>) getProducer(0)).addDistinct(this, selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("distinct()");
			}
		};
	}

	protected boolean addDistinct(Object distinctSetKey,  IEntity value) {
		if (distinctSetMap == null)
			distinctSetMap = new HashMap<Object, Set<IEntity>>();
		
		Set<IEntity> distinctSet = distinctSetMap.get(distinctSetKey);

		if (distinctSet == null)
			distinctSetMap.put(distinctSetKey, distinctSet = new HashSet<IEntity>());		
		
		for (IEntity e : distinctSet)
			if (comparator.equals(e, value))
				return false;

		return distinctSet.add(value);
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		distinctSetMap = null;
	}

	@Override
	public void toString(StringBuilder sb) {
    	sb.append("distinctScope(");
    	super.toString(sb);
    	sb.append(")");
	}
}
