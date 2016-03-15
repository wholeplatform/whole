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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class FilterByDistinctIterator<E extends IEntity> extends AbstractDelegatingIterator<E> implements DistinctScope<E> {
	protected Map<Object, Set<IEntity>> distinctSetMap;
	protected IEntityComparator<IEntity> comparator;

	protected FilterByDistinctIterator() {
		this(BusinessIdentityComparator.instance);
	}
	protected FilterByDistinctIterator(IEntityComparator<IEntity> comparator) {
		super(null);
		this.comparator = comparator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		FilterByDistinctIterator<E> iterator = (FilterByDistinctIterator<E>) super.clone(cc);
		if (distinctSetMap != null)
			iterator.distinctSetMap = new HashMap<Object, Set<IEntity>>(distinctSetMap);
		iterator.comparator = cc.clone(iterator.comparator);			
		return iterator;
	}

	public DistinctScope<E> withComparator(IEntityComparator<IEntity> comparator) {
		this.comparator = comparator;
		return this;
	}

	public void setBindings(IBindingManager bindings) {
		if (getIterator() != null)
			super.setBindings(bindings);
		comparator.setBindings(bindings);
	}

	public IVisitor distinctMatcher() {
		return new DistinctMatcherVisitor(this);
	}

	public static class DistinctMatcherVisitor extends AbstractVisitor {
		private FilterByDistinctIterator<?> distinctScope;

		public DistinctMatcherVisitor(FilterByDistinctIterator<?> distinctScope) {
			this.distinctScope = distinctScope;
		}

		@Override
		public IVisitor clone(ICloneContext cc) {
			DistinctMatcherVisitor visitor = (DistinctMatcherVisitor) super.clone(cc);
			visitor.distinctScope = cc.clone(distinctScope);
			return visitor;
		}

		public void visit(IEntity entity) {
			if (!distinctScope.addDistinct(this, entity))
				throw new VisitException();
		}

		@Override
		public void setBindings(IBindingManager bm) {
			distinctScope.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("matchDistinct()");
		}
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
