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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.resources.CompoundResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDynamicVisitor extends AbstractVisitor {
	protected CompoundResourceRegistry<?> registry;
	protected String functionUri;
	protected IExecutable<?> functionExecutable;

	public AbstractDynamicVisitor(CompoundResourceRegistry<?> registry, String functionUri) {
		this.registry = registry;
		this.functionUri = functionUri;
	}

	@Override
	public IVisitor clone(ICloneContext cc) {
		AbstractDynamicVisitor visitor = (AbstractDynamicVisitor) super.clone(cc);
		visitor.functionExecutable = cc.clone(functionExecutable);
		return visitor;
	}

	protected IExecutable<?> functionExecutable() {
		if (functionExecutable == null) {
			functionExecutable = registry.getFunctionCode(functionUri, true, getBindings());
		}
		return functionExecutable;
	}

	public void visit(IEntity entity) {
		IExecutable<?> iterator = functionExecutable();
		iterator.setBindings(getBindings());
		iterator.reset(entity);
		apply(iterator);
	}

	protected abstract void apply(IExecutable<?> iterator);
}
