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

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.resources.CompoundResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDynamicVisitor extends AbstractVisitor {
	protected CompoundResourceRegistry<?> registry;
	protected String functionUri;
	protected IEntityIterator<?> functionIterator;

	public AbstractDynamicVisitor(CompoundResourceRegistry<?> registry, String functionUri) {
		this.registry = registry;
		this.functionUri = functionUri;
	}

	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractDynamicVisitor visitor = (AbstractDynamicVisitor) super.clone(cc);
		visitor.functionIterator = cc.clone(functionIterator);
		return visitor;
	}

	protected IEntityIterator<?> functionIterator() {
		if (functionIterator == null) {
			String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
			functionIterator = registry.getFunctionCode(functionUri, true, contextUri);
		}
		return functionIterator;
	}

	public void visit(IEntity entity) {
		IEntityIterator<?> iterator = functionIterator();
		iterator.setBindings(getBindings());
		iterator.reset(entity);
		apply(iterator);
	}

	protected abstract void apply(IEntityIterator<?> iterator);
}
