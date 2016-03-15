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
public class GenericMatchBuilder extends AbstractBuilder {
	protected IBuilder mismatchStrategy;
	
	public GenericMatchBuilder(IBuilder mismatchStrategy) {
		this.mismatchStrategy = mismatchStrategy;
    }

	public void wSetBuilderContext(IBuilderContext context) {
        super.wSetBuilderContext(context);
        mismatchStrategy.wSetBuilderContext(context);
	}
	public void wSetEntityContext(IEntityContext context) {
		super.wSetEntityContext(context);
		mismatchStrategy.wSetEntityContext(context);
	}

	public void wFeature(int index) {
    	//TODO
	}
	public void wFeature(FeatureDescriptor feature) {
    	//TODO
	}
	public void wFeature(ITemplate pattern) {
    	//TODO
	}

	public void wDefault() {
    	//TODO
    }
    public void wEntity() {
    	//TODO
    }
    public void wEntity_() {
    	//TODO
    }
    public void _wEntity() {
    	//TODO
    }

	public void wEntity(EntityDescriptor<?> entityDesc) {
    	//TODO
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
    	if (entityContext.wCurrentGet().wGetEntityOrd() != entityDesc.getOrdinal())
    		mismatchStrategy.wEntity_(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
    	if (entityContext.wCurrentGet().wGetEntityOrd() != entityDesc.getOrdinal())
    		mismatchStrategy.wEntity_(entityDesc, initialCapacity);
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
    	if (entityContext.wHasNext())
    		mismatchStrategy._wEntity(entityDesc);
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
    	if (entityContext.wCurrentGet().wBooleanValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
    	if (entityContext.wCurrentGet().wByteValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
    	if (entityContext.wCurrentGet().wCharValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
    	if (entityContext.wCurrentGet().wDoubleValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
    	if (entityContext.wCurrentGet().wFloatValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
    	if (entityContext.wCurrentGet().wIntValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
    	if (entityContext.wCurrentGet().wLongValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
    	if (entityContext.wCurrentGet().wShortValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
    	if (!entityContext.wCurrentGet().wStringValue().equals(value))
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
    	if (!entityContext.wCurrentGet().wDateValue().equals(value))
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
    	if (!entityContext.wCurrentGet().wEnumValue().equals(value))
    		mismatchStrategy.wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
    	if (entityContext.wCurrentGet().wGetValue() != value)
    		mismatchStrategy.wEntity(entityDesc, value);
    }
}
