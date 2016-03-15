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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperation;
import org.whole.lang.resources.CompoundResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public class DynamicInterpreterVisitor extends AbstractDynamicVisitor {
	public DynamicInterpreterVisitor(CompoundResourceRegistry<?> registry, String functionUri) {
		super(registry, functionUri);
	}

	public static IVisitorFactory createVisitorFactory(final CompoundResourceRegistry<?> registry, final String functionUri, final boolean stage0Only) {
		return new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage0Only && stage != 0)
					return null;
				return new DynamicInterpreterVisitor(registry, functionUri);
			}
		};
	}

	protected void apply(IEntityIterator<?> iterator) {
		IBindingManager bm = getBindings();
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		for (IEntity e : iterator) {
			bm.setResult(e);
			resettableScope.commit();
		}
		resettableScope.rollback();
		bm.wExitScope();
	}
}
