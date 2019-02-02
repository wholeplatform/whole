/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.ITraversalFilter;
import org.whole.lang.visitors.TraverseAllFilter;

/**
 * @author Riccardo Solmi
 */
public class GenericMatcher {
	private IBindingManager bindings;
	private ITraversalFilter traversalFilter = TraverseAllFilter.instance;
	protected Map<EntityDescriptor<?>, IMatchStrategy> matchStrategyMap = new HashMap<>();
	protected IMatchStrategy mismatchStrategy = IMatchStrategy.ThrowMatchException;

	public GenericMatcher() {
		withPatternMatching();
	}

	public GenericMatcher withAsIsMatching() {
		withMatchStrategy(IMatchStrategy.ResolverAsIs, CommonsEntityDescriptorEnum.Resolver);
		withMatchStrategy(IMatchStrategy.VariableAsIs,
				CommonsEntityDescriptorEnum.Variable, CommonsEntityDescriptorEnum.InlineVariable);
		return this;
	}
	public GenericMatcher withPatternMatching() {
		withMatchStrategy(IMatchStrategy.ResolverPattern, CommonsEntityDescriptorEnum.Resolver);
		withMatchStrategy(IMatchStrategy.VariablePattern,
				CommonsEntityDescriptorEnum.Variable, CommonsEntityDescriptorEnum.InlineVariable);
		return this;
	}
	

	public GenericMatcher withBindings(IBindingManager bindings) {
		this.bindings = bindings;
		return this;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = BindingManagerFactory.instance.createBindingManager();
		return bindings;
	}

	public GenericMatcher withTraversalFilter(ITraversalFilter traversalFilter) {
		this.traversalFilter = traversalFilter;
		return this;
	}
	public ITraversalFilter getTraversalFilter() {
		return traversalFilter;
	}

	public GenericMatcher withMatchStrategies(Map<EntityDescriptor<?>, IMatchStrategy> matchStrategyMap) {
		matchStrategyMap.putAll(matchStrategyMap);
		return this;
	}
	public GenericMatcher withMatchStrategy(IMatchStrategy matchStrategy, EntityDescriptor<?>... eds) {
		for (EntityDescriptor<?> ed : eds)
			matchStrategyMap.put(ed, matchStrategy);
		return this;
	}
	
	public GenericMatcher withMismatchStrategy(IMatchStrategy mismatchStrategy) {
		this.mismatchStrategy = mismatchStrategy;
		return this;
	}


	public void match(IEntity pattern, IEntity model) {
		IEntity patternAdaptee = pattern.wGetAdaptee(false);
		IMatchStrategy matchStrategy = matchStrategyMap.get(patternAdaptee.wGetEntityDescriptor());
		if (matchStrategy != null)
			matchStrategy.apply(patternAdaptee, model, this);
		else
	        switch(pattern.wGetEntityKind()) {
	        case SIMPLE:
	        	matchSimpleEntity(pattern, model);
	        	break;
	        case COMPOSITE:
	        	matchCompositeEntity(pattern, model);
	        	break;
	        case DATA:
	        	matchDataEntity(pattern, model);
	        	break;
	        }
	}

	public void mismatch(IEntity pattern, IEntity model) {
		mismatchStrategy.apply(pattern, model, this);
	}

	public void matchSimpleEntity(IEntity pattern, IEntity model) {
		if (!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()) ||
				model.wSize() < pattern.wSize()) {
			mismatch(pattern, model);
			return;
		}
		
		for (int i=0, size=pattern.wSize(); i<size; i++)
			if (traversalFilter.include(model, i))
				match(pattern.wGet(i), model.wGet(i));
	}

	public void matchCompositeEntity(IEntity pattern, IEntity model) {
		if (!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()) ||
				(pattern.wSize() != model.wSize() && !(pattern.wIsEmpty() && model.wIsEmpty()))) {
			mismatch(pattern, model);
			return;
		}

		if (!pattern.wIsEmpty())
			for (int i=0, size=pattern.wSize(); i<size; i++)
				if (traversalFilter.include(model, i))
					match(pattern.wGet(i), model.wGet(i));
	}

	public void matchDataEntity(IEntity pattern, IEntity model) {
    	if (!EntityUtils.isData(model) || !pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor())) {
    		mismatch(pattern, model);
    		return;
    	}
		
    	Object patternValue = pattern.wGetValue();
		Object modelValue = model.wGetValue();
		if (patternValue != modelValue && (patternValue == null || !patternValue.equals(modelValue)))
			mismatch(pattern, model);
    }
}
