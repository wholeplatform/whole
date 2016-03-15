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

import java.util.Date;

import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public class GenericForwardStrategyBuilder extends AbstractBuilder {
    protected IBuilder builderStrategy;

    public GenericForwardStrategyBuilder() {
    	this(new GenericIdentityBuilder());
    }
    public GenericForwardStrategyBuilder(IBuilder strategy) {
    	builderStrategy = strategy;
    }

	public void wSetBuilderContext(IBuilderContext context) {
        super.wSetBuilderContext(context);
        builderStrategy.wSetBuilderContext(context);
	}
	public void wSetEntityContext(IEntityContext context) {
		super.wSetEntityContext(context);
		builderStrategy.wSetEntityContext(context);
	}
	public void wSetBuilderStrategy(IBuilder strategy) {
        builderStrategy = strategy;
	}

	public void wDefault() {
        builderStrategy.wDefault();
    }
    public void wEntity() {
        builderStrategy.wEntity();
    }
    public void wEntity_() {
        builderStrategy.wEntity_();
    }
    public void _wEntity() {
        builderStrategy._wEntity();
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        builderStrategy.wEntity(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
        builderStrategy.wEntity_(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        builderStrategy.wEntity_(entityDesc, initialCapacity);
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
        builderStrategy._wEntity(entityDesc);
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
        builderStrategy.wEntity(entityDesc, value);
    }
	
	public void wFeature(int index) {
		builderStrategy.wFeature(index);
	}
	public void wFeature(FeatureDescriptor feature) {
		builderStrategy.wFeature(feature);		
	}
	public void wFeature(ITemplate pattern) {
		builderStrategy.wFeature(pattern);
	}
}
