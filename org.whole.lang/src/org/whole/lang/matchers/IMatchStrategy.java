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

import java.util.Set;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.model.AbstractEntityResolver;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;

/**
 * @author Riccardo Solmi
 */
@FunctionalInterface
public interface IMatchStrategy {
	public void apply(IEntity pattern, IEntity model, GenericMatcher matcher);


	// Match strategies

	public static IMatchStrategy ResolverPattern = (pattern, model, matcher) -> {
		if (pattern.wSize() != model.wSize() || model.wGetEntityKind().equals(EntityKinds.DATA)) {
			matcher.mismatch(pattern, model);
			return;
		}

		for (FeatureDescriptor fd : pattern.wGetEntityDescriptor().getEntityFeatureDescriptors()) {
			if (pattern.wContains(fd))
				if (model.wContains(fd))
					matcher.match(pattern.wGet(fd), model.wGet(fd));
				else {
					matcher.mismatch(pattern, model);
					return;
				}
		}
	};

	public static IMatchStrategy VariablePattern = (pattern, model, matcher) -> {
		EntityDescriptor<?> type = (EntityDescriptor<?>) pattern.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue();
		String name = pattern.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue();

		if (matcher.getBindings().wIsSet(name)) {
			IEntity value = matcher.getBindings().wGet(name);

			if (EntityUtils.isVariable(value)) {
				if (!EntityUtils.isVariable(model) ||
						!value.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue().equals(model.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue()) ||
						!value.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue().equals(model.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue()))
					matcher.mismatch(pattern, model);
			} else {
				if (type.isExtendedLanguageSupertypeOf(value.wGetEntityDescriptor()))//WAS isPlatformSupertypeOf(value.wGetEntityDescriptor()))
					matcher.match(value, model);
				else
					matcher.mismatch(pattern, model);
			}
		} else {
			if (type.isExtendedLanguageSupertypeOf(//WAS isPlatformSupertypeOf(
					EntityUtils.isVariable(model) ?
							(EntityDescriptor<?>) model.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue()
							: model.wGetEntityDescriptor()))
				matcher.getBindings().wDef(name, model);
			else if (EntityUtils.isResolver(model)) //TODO workaround waiting for a dynamic entity descriptor for resolvers 
				matcher.getBindings().wDef(name, model);
			else
				matcher.mismatch(pattern, model);
		}
	};

	public static IMatchStrategy ResolverAsIs = (pattern, model, matcher) -> {
		if (!EntityUtils.isResolver(model) || pattern.wSize() != model.wSize()) {
			matcher.mismatch(pattern, model);
			return;
		}

		Set<FeatureDescriptor> fset = ((AbstractEntityResolver) pattern).getFeatureDescriptorSet();
		if (fset.isEmpty()) {
			for (int i=0, size=pattern.wSize(); i<size; i++)
				matcher.match(pattern.wGet(i), model.wGet(i));
		} else {
			for (FeatureDescriptor fd : fset)
				if (model.wContains(fd))
					matcher.match(pattern.wGet(fd), model.wGet(fd));
				else {
					matcher.mismatch(pattern, model);
					return;
				}
		}
	};

	public static IMatchStrategy VariableAsIs = (pattern, model, matcher) -> {
		matcher.matchSimpleEntity(pattern, model);
	};

	public static IMatchStrategy CollectVariableNames(Set<String> names) {
		return (pattern, model, matcher) -> {
			matcher.matchSimpleEntity(pattern, model);

			names.add(pattern.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue());
		};
	}


	// Mismatch strategies

	public static final IMatchStrategy ThrowMatchException = (pattern, model, matcher) -> {
		throw new MatchException(pattern, model, matcher.getBindings());
	};

	public static final IMatchStrategy IgnoreSubtree = (pattern, model, matcher) -> {
	};

	public static final IMatchStrategy ReplaceWithClone = (pattern, model, matcher) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, matcher);

		parent.wSet(model, EntityUtils.clone(pattern));
	};

	public static final IMatchStrategy ReplaceWithResolver = (pattern, model, matcher) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, matcher);

		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createResolver(ed));
	};

	public static IMatchStrategy ReplaceWithVariable(FreshNameGenerator fng) {
		return (pattern, model, matcher) -> {
			IEntity parent = model.wGetParent();
			if (EntityUtils.isNull(parent))
				ThrowMatchException.apply(pattern, model, matcher);

			EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
			FeatureDescriptor fd = parent.wGetFeatureDescriptor(model);
			parent.wSet(model, CommonsEntityAdapterFactory.createVariable(ed, fng.nextFreshName(fd.getName())));
		};
	}
}
