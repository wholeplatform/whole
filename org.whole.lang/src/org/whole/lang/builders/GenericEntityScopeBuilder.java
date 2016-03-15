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
package org.whole.lang.builders;

import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class GenericEntityScopeBuilder extends GenericForwardStrategyBuilder {
    private int nestingCount = -1; // -1 initial state; 0 final state; >0 nested state

    public GenericEntityScopeBuilder(IBuilder entityStrategy) {
    	super(entityStrategy);
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
		if (nestingCount++ == -1)
			builderContext.wPushBuilderStrategy(this);
    	super.wEntity_(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		if (nestingCount++ == -1)
			builderContext.wPushBuilderStrategy(this);
    	super.wEntity_(entityDesc, initialCapacity);
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    	if (nestingCount < 0)
    		throw new IllegalStateException();
    	super._wEntity(entityDesc);
    	if (nestingCount-- == 0) {
    		builderContext.wPopBuilderStrategy();
    		builderContext._wEntity(entityDesc);
    	}
    }
}
