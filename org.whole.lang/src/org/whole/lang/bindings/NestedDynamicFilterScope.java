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
package org.whole.lang.bindings;

import java.util.Set;

/**
 * @author Riccardo Solmi
 */
public class NestedDynamicFilterScope extends NestedDynamicScope {

	protected NestedDynamicFilterScope(IBindingScope targetScope, Set<String> names, boolean asFreshNames) {
		super(targetScope);

		enclosingScope = (asFreshNames ?
				BindingManagerFactory.instance.createExcludeFilterScope(names) :
				BindingManagerFactory.instance.createIncludeFilterScope(names)).wWithEnclosingScope(enclosingScope);
	}

	@Override
	public AbstractFilterScope wFilteringEnclosingScope() {
		return (AbstractFilterScope) enclosingScope;
	}

	@Override
	public IBindingScope wEnclosingScope() {
		return wFilteringEnclosingScope().wEnclosingScope();
	}

	@Override
	public INestableScope wWithEnclosingScope(IBindingScope enclosingScope) {
		wFilteringEnclosingScope().wWithEnclosingScope(enclosingScope);
		resultScope = null;
		return this;
	}

	//TODO toString
}

