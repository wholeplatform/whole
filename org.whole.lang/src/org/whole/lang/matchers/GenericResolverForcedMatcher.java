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
package org.whole.lang.matchers;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.ITraversalFilter;

/**
 * @author Enrico Persiani
 */
public class GenericResolverForcedMatcher extends AbstractGenericForcedMatcher {

	public GenericResolverForcedMatcher() {
	}
	public GenericResolverForcedMatcher(IBindingManager bindings) {
		super(bindings);
	}
	public GenericResolverForcedMatcher(IBindingManager bindings, ITraversalFilter traversalFilter) {
		super(bindings, traversalFilter);
	}

	protected void forceMatch(IEntity pattern, IEntity model) {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			throw new MatchException(pattern, model, bindings);
		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createResolver(ed));
	}
}
