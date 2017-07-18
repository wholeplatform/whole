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
import java.util.Set;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
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
public interface MatchStrategy {
	public void apply(IEntity pattern, IEntity model, GenericMatcher matcher);


// Match strategies

	public static MatchStrategy EntityResolver = (pattern, model, matcher) -> {
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

	public static MatchStrategy EntityVariable = (pattern, model, matcher) -> {
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
        		if (type.isPlatformSupertypeOf(value.wGetEntityDescriptor()))//was AsIsFrom(
        			matcher.match(value, model);
				else
					matcher.mismatch(pattern, model);
     		}
    	} else {
			if (type.isPlatformSupertypeOf(//was AsIsFrom(
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

	public static MatchStrategy ForceEntityVariable = (pattern, model, matcher) -> {
		if (!EntityUtils.isVariable(model) ||
				!pattern.wGet(CommonsFeatureDescriptorEnum.varType).wEquals(model.wGet(CommonsFeatureDescriptorEnum.varType)) ||
				!pattern.wGet(CommonsFeatureDescriptorEnum.varName).wEquals(model.wGet(CommonsFeatureDescriptorEnum.varName)))
			matcher.mismatch(pattern, model);
	};

	public static MatchStrategy bindVariables(Set<String> boundNames) {
		return (pattern, model, matcher) -> {
			if (EntityUtils.isVariable(model)) {
				IEntity varName = pattern.wGet(CommonsFeatureDescriptorEnum.varName);
				IEntity varType = pattern.wGet(CommonsFeatureDescriptorEnum.varType);
				if (varName.wEquals(model.wGet(CommonsFeatureDescriptorEnum.varName)) &&
						varType.wEquals(model.wGet(CommonsFeatureDescriptorEnum.varType)))
					boundNames.add(varName.wStringValue());
			}
		};
	}


// Mismatch strategies

	public static final MatchStrategy ThrowMatchException = (pattern, model, matcher) -> {
		throw new MatchException(pattern, model, matcher.getBindings());
	};

	public static final MatchStrategy IgnoreSubtree = (pattern, model, matcher) -> {
	};

	public static final MatchStrategy ReplaceWithClone = (pattern, model, matcher) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, matcher);

		parent.wSet(model, EntityUtils.clone(pattern));
	};

	public static final MatchStrategy ReplaceWithResolver = (pattern, model, matcher) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, matcher);

		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createResolver(ed));
	};

	@SuppressWarnings("unchecked")
	public static final MatchStrategy ReplaceWithVariable = (pattern, model, matcher) -> {
		IEntity parent = model.wGetParent();
		if (EntityUtils.isNull(parent))
			ThrowMatchException.apply(pattern, model, matcher);

		IBindingManager bindings = matcher.getBindings();
		if (!bindings.wIsSet("fnGen"))
			bindings.wDefValue("fnGen", bindings.wIsSet("boundNames") ?
					new FreshNameGenerator((Collection<String>) bindings.wGetValue("boundNames")) : new FreshNameGenerator());
		FreshNameGenerator fnGen = (FreshNameGenerator) bindings.wGetValue("fnGen");

		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(model);
		FeatureDescriptor fd = parent.wGetFeatureDescriptor(model);
		parent.wSet(model, CommonsEntityAdapterFactory.createVariable(ed, fnGen.nextFreshName(fd.getName())));
	};
	
}
