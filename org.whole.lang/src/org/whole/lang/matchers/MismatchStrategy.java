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

import java.util.Collection;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;

/**
 * @author Riccardo Solmi
 */
@FunctionalInterface
public interface MismatchStrategy {
	public void apply(IEntity pattern, IEntity model, IBindingManager bindings);


	public static final MismatchStrategy ThrowMatchException = (pattern, model, bindings) -> {
		throw new MatchException(pattern, model, bindings);
	};

	public static final MismatchStrategy IgnoreSubtree = (pattern, model, bindings) -> {
	};

	public static final MismatchStrategy ReplaceWithClone = (pattern, model, bindings) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, bindings);

		parent.wSet(model, EntityUtils.clone(pattern));
	};

	public static final MismatchStrategy ReplaceWithResolver = (pattern, model, bindings) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, bindings);

		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createResolver(ed));
	};

	@SuppressWarnings("unchecked")
	public static final MismatchStrategy ReplaceWithVariable = (pattern, model, bindings) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, bindings);

		if (!bindings.wIsSet("fnGen"))
			bindings.wDefValue("fnGen", bindings.wIsSet("boundNames") ?
					new FreshNameGenerator((Collection<String>) bindings.wGetValue("boundNames")) : new FreshNameGenerator());
		FreshNameGenerator fnGen = (FreshNameGenerator) bindings.wGetValue("fnGen");

		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		FeatureDescriptor fd = parent.wGetFeatureDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createVariable(ed, fnGen.nextFreshName(fd.getName())));
	};
}
