/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.environment.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class EnvironmentGenericBuilderAdapter extends GenericIdentityBuilder {
    private IEnvironmentBuilder specificBuilder;

    public EnvironmentGenericBuilderAdapter(IEnvironmentBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public EnvironmentGenericBuilderAdapter(IEnvironmentBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.BooleanData_ord :
            specificBuilder.BooleanData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.ByteData_ord :
            specificBuilder.ByteData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.CharData_ord :
            specificBuilder.CharData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.DoubleData_ord :
            specificBuilder.DoubleData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.FloatData_ord :
            specificBuilder.FloatData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.IntData_ord :
            specificBuilder.IntData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.LongData_ord :
            specificBuilder.LongData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.ShortData_ord :
            specificBuilder.ShortData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.StringData_ord :
            specificBuilder.StringData(value);
            break;
            case EnvironmentEntityDescriptorEnum.Id_ord :
            specificBuilder.Id(value);
            break;
            case EnvironmentEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.DateData_ord :
            specificBuilder.DateData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.ObjectData_ord :
            specificBuilder.ObjectData(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple();
            break;
            case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord :
            specificBuilder.ContainmentTuple();
            break;
            case EnvironmentEntityDescriptorEnum.Void_ord :
            specificBuilder.Void();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder.Binding();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_();
            break;
            case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord :
            specificBuilder.ContainmentTuple_();
            break;
            case EnvironmentEntityDescriptorEnum.Void_ord :
            specificBuilder.Void_();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder.Binding_();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord :
            specificBuilder.ContainmentTuple_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_(initialCapacity);
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.Tuple_ord :
            specificBuilder._Tuple();
            break;
            case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord :
            specificBuilder._ContainmentTuple();
            break;
            case EnvironmentEntityDescriptorEnum.Void_ord :
            specificBuilder._Void();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder._Bindings();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder._Binding();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case EnvironmentFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case EnvironmentFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, IEntity value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.Value_ord :
            specificBuilder.Value(value);
            break;
        }
    }
}
