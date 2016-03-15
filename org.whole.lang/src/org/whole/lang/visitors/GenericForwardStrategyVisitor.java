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
package org.whole.lang.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class GenericForwardStrategyVisitor<V extends IVisitor> extends AbstractLazyCloneableVisitor {
	private List<V> strategies;
	protected BitSet lazyClone;

	public GenericForwardStrategyVisitor(V... strategies) {
		this.strategies = new ArrayList<V>(Arrays.asList(strategies));
		lazyClone = new BitSet(this.strategies.size());
		lazyClone.clear(0, this.strategies.size());
	}

	@SuppressWarnings("unchecked")
	@Override
	public IVisitor clone(ICloneContext cc) {
		GenericForwardStrategyVisitor<V> visitor = (GenericForwardStrategyVisitor<V>) super.clone(cc);
		visitor.strategies = new ArrayList<V>(visitor.strategies);
		visitor.lazyClone = new BitSet(strategies.size());
		visitor.lazyClone.set(0, strategies.size());
		lazyClone.set(0, strategies.size());
		return visitor;
	}

	protected boolean isLazyCloneEmpty() {
		return lazyClone.isEmpty();
	}

	public V wGetStrategy(int index) {
		if (lazyClone.get(index)) {
			wSetStrategy(index, getCloneContext().clone(strategies.get(index)));
			strategies.get(index).setBindings(bindings);
		}
		return strategies.get(index);
	}
	public void wSetStrategy(int index, V strategy) {
		strategies.set(index, strategy);
		lazyClone.clear(index);
		updateCloneContext();
	}

	public V wGetStrategy() {
		return wGetStrategy(strategies.size()-1);
	}
	public void wSetStrategy(V strategy) {
		wSetStrategy(strategies.size()-1, strategy);
	}

	public void wPushStrategy(V strategy) {
		strategies.add(strategy);
	}
	public V wPopStrategy() {
		return strategies.remove(strategies.size()-1);
	}

	public void visit(IEntity entity) {
		wGetStrategy().visit(entity);
	}

	@Override
	public void setBindings(IBindingManager bm) {
		super.setBindings(bm);
		for (int i=0; i<strategies.size(); i++)
			if (!lazyClone.get(i))
				strategies.get(i).setBindings(bm);
	}
}
