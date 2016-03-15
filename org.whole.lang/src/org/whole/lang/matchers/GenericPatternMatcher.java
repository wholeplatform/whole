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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.visitors.ITraversalFilter;

/**
 * TODO specialize AbstractEntityResolver for matching composite patterns
 * having children at selected indexes
 * 
 * @author Riccardo Solmi
 */
public class GenericPatternMatcher extends GenericMatcher {	
    public GenericPatternMatcher() {
		super();
	}
	public GenericPatternMatcher(IBindingManager bindings, ITraversalFilter traversalFilter) {
		super(bindings, traversalFilter);
	}
	public GenericPatternMatcher(IBindingManager bindings) {
		super(bindings);
	}

	public void matchCompositeEntity(IEntity pattern, IEntity model) {
		if (!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor()))
			throw new MatchException(pattern, model, bindings);

		int patternIndex=0;
		for (int i=0, size=model.wSize(); i<size; i++)
			try {
				pattern.wGet(patternIndex).wAccept(this, model.wGet(i));
				if (++patternIndex == pattern.wSize())
					return;
			} catch (MatchException e) {
			}

		throw new MatchException(pattern, patternIndex, model, bindings);		
    }

	public void matchEntityResolver(IEntity pattern, IEntity model) {
		for (FeatureDescriptor fd : pattern.wGetEntityDescriptor().getEntityFeatureDescriptors()) {	
			if (!model.wContains(fd))
				throw new MatchException(pattern, model, bindings);
			pattern.wGet(fd).wAccept(this, model.wGet(fd));
		}
	}
}
