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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.AbstractEntityResolver;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.ITraversalFilter;

/**
 * @author Riccardo Solmi
 */
public class GenericLearningPatternMatcher extends GenericPatternMatcher {
	protected Map<IEntity, IEntity> resolverLearningMap = new HashMap<IEntity, IEntity>(); //pattern to resolver model
	protected Map<IEntity, IEntity> compositeLarningMap = new HashMap<IEntity, IEntity>(); //pattern to composite model
	
	

	public GenericLearningPatternMatcher() {
		super();
	}
	public GenericLearningPatternMatcher(IBindingManager bindings, ITraversalFilter traversalFilter) {
		super(bindings, traversalFilter);
	}
	public GenericLearningPatternMatcher(IBindingManager bindings) {
		super(bindings);
	}

	public void matchCompositeEntity(IEntity pattern, IEntity model) {
		if (pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor())) {
			try {
				super.matchCompositeEntity(pattern, model);
			} catch(MatchException e) {
				for (int i=e.patternIndex, size=pattern.wSize(); i<size; i++)
					compositeLarningMap.put(pattern.wGet(i), model);
			}
		}
		
		if (model instanceof AbstractEntityResolver)
			resolverLearningMap.put(pattern, model);
	}
	public void matchEntityResolver(IEntity pattern, IEntity model) {
		// TODO Auto-generated method stub
		super.matchEntityResolver(pattern, model);
	}
	public void matchEntityVariable(Variable pattern, IEntity model) {
		// TODO Auto-generated method stub
		super.matchEntityVariable(pattern, model);
	}
	public void matchDataEntity(IEntity pattern, IEntity model) {
		if (pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()))
			super.matchDataEntity(pattern, model);
		
		if (model instanceof AbstractEntityResolver)
			resolverLearningMap.put(pattern, model);
	}
	public void match(IEntity pattern, IEntity model) {
		if (pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()))
			super.match(pattern, model);
		
		if (model instanceof AbstractEntityResolver)
			resolverLearningMap.put(pattern, model);
	}
}
