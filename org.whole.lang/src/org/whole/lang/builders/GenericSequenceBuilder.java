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
public class GenericSequenceBuilder implements IBuilder {
    protected IBuilder builder1;
    protected IBuilder builder2;

    public GenericSequenceBuilder() {
    	this(new GenericIdentityBuilder(), new GenericIdentityBuilder());
    }
    public GenericSequenceBuilder(IBuilder builder1, IBuilder builder2) {
    	this.builder1 = builder1;
    	this.builder2 = builder2;
    }

	public void wSetBuilderContext(IBuilderContext context) {
        builder1.wSetBuilderContext(context);
        builder2.wSetBuilderContext(context);
	}
	public void wSetEntityContext(IEntityContext context) {
		builder1.wSetEntityContext(context);
		builder2.wSetEntityContext(context);
	}
	public void wSetBuilderStrategy(IBuilder strategy) {
        builder2 = strategy;
	}

	public void wDefault() {
        builder1.wDefault();
        builder2.wDefault();
    }
    public void wEntity() {
        builder1.wEntity();
        builder2.wEntity();
    }
    public void wEntity_() {
        builder1.wEntity_();
        builder2.wEntity_();
    }
    public void _wEntity() {
        builder1._wEntity();
        builder2._wEntity();
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        builder1.wEntity(entityDesc);
        builder2.wEntity(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
        builder1.wEntity_(entityDesc);
        builder2.wEntity_(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        builder1.wEntity_(entityDesc, initialCapacity);
        builder2.wEntity_(entityDesc, initialCapacity);
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
        builder1._wEntity(entityDesc);
        builder2._wEntity(entityDesc);
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
        builder1.wEntity(entityDesc, value);
        builder2.wEntity(entityDesc, value);
    }
	
	public void wFeature(int index) {
		builder1.wFeature(index);
		builder2.wFeature(index);
	}
	public void wFeature(FeatureDescriptor feature) {
		builder1.wFeature(feature);		
		builder2.wFeature(feature);		
	}
	public void wFeature(ITemplate pattern) {
		builder1.wFeature(pattern);
		builder2.wFeature(pattern);
	}
}
