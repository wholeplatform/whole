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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.ITraversalFilter;
import org.whole.lang.visitors.TraverseAllFilter;

/**
 * @author Riccardo Solmi
 */
public class GenericMatcher {
	protected IBindingManager bindings;
	protected ITraversalFilter traversalFilter;
	
	public GenericMatcher() {
		this(BindingManagerFactory.instance.createBindingManager());
	}
	public GenericMatcher(IBindingManager bindings) {
		this(bindings, TraverseAllFilter.instance);
	}
	public GenericMatcher(IBindingManager bindings, ITraversalFilter traversalFilter) {
		this.bindings = bindings;
		this.traversalFilter = traversalFilter;
	}

	public void match(IEntity pattern, IEntity model) {
		IEntity patternAdaptee = pattern.wGetAdaptee(false);
		if (patternAdaptee.wGetLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (patternAdaptee.wGetEntityDescriptor().getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
	        	matchEntityResolver(pattern, model);
	        	return;
			case CommonsEntityDescriptorEnum.Variable_ord:
			case CommonsEntityDescriptorEnum.InlineVariable_ord:
				matchEntityVariable(pattern, model);
				return;
			case CommonsEntityDescriptorEnum.SameStageFragment_ord:
				matchAdapterFragmentEntity(pattern, model);
				return;
			case CommonsEntityDescriptorEnum.RootFragment_ord:
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
				matchBaseFragmentEntity(pattern, model);
				return;
			case CommonsEntityDescriptorEnum.StageUpFragment_ord:
				matchMetaFragmentEntity(pattern, model);
				return;
			}
		}
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

	public void matchAdapterFragmentEntity(IEntity pattern, IEntity model) {
		matchSimpleEntity(pattern, model);
	}
	public void matchBaseFragmentEntity(IEntity pattern, IEntity model) {
		matchSimpleEntity(pattern, model);
	}
	public void matchMetaFragmentEntity(IEntity pattern, IEntity model) {
		matchSimpleEntity(pattern, model);
	}

	public void matchSimpleEntity(IEntity pattern, IEntity model) {
		if (!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()) ||
				model.wSize() < pattern.wSize())
			throw new MatchException(pattern, model, bindings);
		
		for (int i=0, size=pattern.wSize(); i<size; i++)
			if (traversalFilter.include(model, i))
				pattern.wGet(i).wAccept(this, model.wGet(i));
	}

    public void matchCompositeEntity(IEntity pattern, IEntity model) {
		if ((!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor())
				&& !EntityUtils.isResolver(model) //TODO workaround for resolvers
				) || (pattern.wSize() != model.wSize() && !(pattern.wIsEmpty() && model.wIsEmpty())) )
			throw new MatchException(pattern, model, bindings);

		if (!pattern.wIsEmpty())
			for (int i=0, size=pattern.wSize(); i<size; i++)
				if (traversalFilter.include(model, i))
					pattern.wGet(i).wAccept(this, model.wGet(i));
	}

    public void matchDataEntity(IEntity pattern, IEntity model) {
    	if (!EntityUtils.isData(model) ||
    			!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()))
			throw new MatchException(pattern, model, bindings);
		
    	Object patternValue = pattern.wGetValue();
		Object modelValue = model.wGetValue();
		if (patternValue != modelValue && (patternValue == null || !patternValue.equals(modelValue)))
			throw new MatchException(pattern, model, bindings);
    }

	public void matchEntityResolver(IEntity pattern, IEntity model) {
		if (pattern.wSize() != model.wSize() || model.wGetEntityKind().equals(EntityKinds.DATA))
			throw new MatchException(pattern, model, bindings);

		for (FeatureDescriptor fd : pattern.wGetEntityDescriptor().getEntityFeatureDescriptors()) {
			if (pattern.wContains(fd))
				if (model.wContains(fd))
					pattern.wGet(fd).wAccept(this, model.wGet(fd));
				else
					throw new MatchException(pattern, model, bindings);
		}
	}

    public void matchEntityVariable(IEntity pattern, IEntity model) {
    	EntityDescriptor<?> type = (EntityDescriptor<?>) pattern.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue();
    	String name = pattern.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue();

    	if (bindings.wIsSet(name)) {
    		IEntity value = bindings.wGet(name);

    		if (EntityUtils.isVariable(value)) {
    			if (!EntityUtils.isVariable(model) ||
    					!value.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue().equals(model.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue()) ||
    					!value.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue().equals(model.wGet(CommonsFeatureDescriptorEnum.varName).wStringValue()))
    				throw new MatchException(pattern, model, bindings);
     		} else {
        		if (type.isPlatformSupertypeOf(value.wGetEntityDescriptor()))//was AsIsFrom(
            		value.wAccept(this, model);
        		else
        			throw new MatchException(pattern, model, bindings);
     		}
    	} else {
			if (type.isPlatformSupertypeOf(//was AsIsFrom(
					EntityUtils.isVariable(model) ?
							(EntityDescriptor<?>) model.wGet(CommonsFeatureDescriptorEnum.varType).wGetValue()
							: model.wGetEntityDescriptor()))
	    		bindings.wDef(name, model);
			else if (EntityUtils.isResolver(model)) //TODO workaround waiting for a dynamic entity descriptor for resolvers 
				bindings.wDef(name, model);
			else
				throw new MatchException(pattern, model, bindings);
    	}
    }
}
