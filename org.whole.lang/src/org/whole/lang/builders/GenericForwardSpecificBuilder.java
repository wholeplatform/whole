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
public class GenericForwardSpecificBuilder extends AbstractBuilder {
    private IBuilderOperation builderOperation;

    public GenericForwardSpecificBuilder(IBuilderOperation builderOperation) {
    	setBuilderOperation(builderOperation);
    }

    protected void setBuilderOperation(IBuilderOperation builderOperation) {
		this.builderOperation = builderOperation;
	}
	protected IBuilder getBuilderStrategy(EntityDescriptor<?> ed) {
		return builderOperation.wGetBuilder(ed.getLanguageKit().getURI());
	}
	protected IBuilder getBuilderStrategy(FeatureDescriptor fd) {
		return builderOperation.wGetBuilder(fd.getLanguageKit().getURI());
	}
	protected IBuilder getBuilderStrategy() {
		return  builderOperation.wGetBuilder();//FIXME ?
	}

	public void wSetBuilderContext(IBuilderContext context) {
        super.wSetBuilderContext(context);
        getBuilderStrategy().wSetBuilderContext(context);//FIXME ?
	}
	public void wSetEntityContext(IEntityContext context) {
		super.wSetEntityContext(context);
		getBuilderStrategy().wSetEntityContext(context);//FIXME ?
	}

	public void wFeature(int index) {
		getBuilderStrategy().wFeature(index);//FIXME ?
	}
	public void wFeature(FeatureDescriptor fd) {
		getBuilderStrategy(fd).wFeature(fd);		
	}
	public void wFeature(ITemplate pattern) {
		getBuilderStrategy().wFeature(pattern);//FIXME ?
	}

	public void wDefault() {
        getBuilderStrategy().wDefault();//FIXME ?
    }
    public void wEntity() {
        getBuilderStrategy().wEntity();//FIXME ?
    }
    public void wEntity_() {
        getBuilderStrategy().wEntity_();//FIXME ?
    }
    public void _wEntity() {
        getBuilderStrategy()._wEntity();//FIXME ?
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc) {
        getBuilderStrategy(entityDesc).wEntity_(entityDesc);
    }
    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        getBuilderStrategy(entityDesc).wEntity_(entityDesc, initialCapacity);
    }
    public void _wEntity(EntityDescriptor<?> entityDesc) {
        getBuilderStrategy(entityDesc)._wEntity(entityDesc);
    }

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
        getBuilderStrategy(entityDesc).wEntity(entityDesc, value);
    }
}
