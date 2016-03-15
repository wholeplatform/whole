/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;

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
            case EnvironmentEntityDescriptorEnum.Index_ord :
            specificBuilder.Index(value);
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
            case EnvironmentEntityDescriptorEnum.ContextViewModel_ord :
            specificBuilder.ContextViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.SampleViewModel_ord :
            specificBuilder.SampleViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.DebugViewModel_ord :
            specificBuilder.DebugViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.Jobs_ord :
            specificBuilder.Jobs();
            break;
            case EnvironmentEntityDescriptorEnum.Job_ord :
            specificBuilder.Job();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionStack_ord :
            specificBuilder.ExecutionStack();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionFrame_ord :
            specificBuilder.ExecutionFrame();
            break;
            case EnvironmentEntityDescriptorEnum.VariablesViewModel_ord :
            specificBuilder.VariablesViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments();
            break;
            case EnvironmentEntityDescriptorEnum.Environment_ord :
            specificBuilder.Environment();
            break;
            case EnvironmentEntityDescriptorEnum.ScopedBindings_ord :
            specificBuilder.ScopedBindings();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder.Binding();
            break;
            case EnvironmentEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope();
            break;
            case EnvironmentEntityDescriptorEnum.Names_ord :
            specificBuilder.Names();
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
            case EnvironmentEntityDescriptorEnum.ContextViewModel_ord :
            specificBuilder.ContextViewModel_();
            break;
            case EnvironmentEntityDescriptorEnum.SampleViewModel_ord :
            specificBuilder.SampleViewModel_();
            break;
            case EnvironmentEntityDescriptorEnum.DebugViewModel_ord :
            specificBuilder.DebugViewModel_();
            break;
            case EnvironmentEntityDescriptorEnum.Jobs_ord :
            specificBuilder.Jobs_();
            break;
            case EnvironmentEntityDescriptorEnum.Job_ord :
            specificBuilder.Job_();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionStack_ord :
            specificBuilder.ExecutionStack_();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionFrame_ord :
            specificBuilder.ExecutionFrame_();
            break;
            case EnvironmentEntityDescriptorEnum.VariablesViewModel_ord :
            specificBuilder.VariablesViewModel_();
            break;
            case EnvironmentEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments_();
            break;
            case EnvironmentEntityDescriptorEnum.Environment_ord :
            specificBuilder.Environment_();
            break;
            case EnvironmentEntityDescriptorEnum.ScopedBindings_ord :
            specificBuilder.ScopedBindings_();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder.Binding_();
            break;
            case EnvironmentEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope_();
            break;
            case EnvironmentEntityDescriptorEnum.Names_ord :
            specificBuilder.Names_();
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
            case EnvironmentEntityDescriptorEnum.Jobs_ord :
            specificBuilder.Jobs_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionStack_ord :
            specificBuilder.ExecutionStack_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.ScopedBindings_ord :
            specificBuilder.ScopedBindings_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_(initialCapacity);
            break;
            case EnvironmentEntityDescriptorEnum.Names_ord :
            specificBuilder.Names_(initialCapacity);
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
            case EnvironmentEntityDescriptorEnum.ContextViewModel_ord :
            specificBuilder._ContextViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.SampleViewModel_ord :
            specificBuilder._SampleViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.DebugViewModel_ord :
            specificBuilder._DebugViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.Jobs_ord :
            specificBuilder._Jobs();
            break;
            case EnvironmentEntityDescriptorEnum.Job_ord :
            specificBuilder._Job();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionStack_ord :
            specificBuilder._ExecutionStack();
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionFrame_ord :
            specificBuilder._ExecutionFrame();
            break;
            case EnvironmentEntityDescriptorEnum.VariablesViewModel_ord :
            specificBuilder._VariablesViewModel();
            break;
            case EnvironmentEntityDescriptorEnum.Environments_ord :
            specificBuilder._Environments();
            break;
            case EnvironmentEntityDescriptorEnum.Environment_ord :
            specificBuilder._Environment();
            break;
            case EnvironmentEntityDescriptorEnum.ScopedBindings_ord :
            specificBuilder._ScopedBindings();
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            specificBuilder._Bindings();
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            specificBuilder._Binding();
            break;
            case EnvironmentEntityDescriptorEnum.Scope_ord :
            specificBuilder._Scope();
            break;
            case EnvironmentEntityDescriptorEnum.Names_ord :
            specificBuilder._Names();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case EnvironmentFeatureDescriptorEnum.environments_ord :
            specificBuilder.environments();
            break;
            case EnvironmentFeatureDescriptorEnum.bindings_ord :
            specificBuilder.bindings();
            break;
            case EnvironmentFeatureDescriptorEnum.behavior_ord :
            specificBuilder.behavior();
            break;
            case EnvironmentFeatureDescriptorEnum.result_ord :
            specificBuilder.result();
            break;
            case EnvironmentFeatureDescriptorEnum.focusJob_ord :
            specificBuilder.focusJob();
            break;
            case EnvironmentFeatureDescriptorEnum.jobs_ord :
            specificBuilder.jobs();
            break;
            case EnvironmentFeatureDescriptorEnum.focusFrame_ord :
            specificBuilder.focusFrame();
            break;
            case EnvironmentFeatureDescriptorEnum.executionStack_ord :
            specificBuilder.executionStack();
            break;
            case EnvironmentFeatureDescriptorEnum.sourceFragment_ord :
            specificBuilder.sourceFragment();
            break;
            case EnvironmentFeatureDescriptorEnum.sourceEntity_ord :
            specificBuilder.sourceEntity();
            break;
            case EnvironmentFeatureDescriptorEnum.environmentManager_ord :
            specificBuilder.environmentManager();
            break;
            case EnvironmentFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case EnvironmentFeatureDescriptorEnum.filter_ord :
            specificBuilder.filter();
            break;
            case EnvironmentFeatureDescriptorEnum.bindingManager_ord :
            specificBuilder.bindingManager();
            break;
            case EnvironmentFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
            case EnvironmentFeatureDescriptorEnum.scope_ord :
            specificBuilder.scope();
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

    public void wEntity(EntityDescriptor<?> entityDesc, IEnvironmentManager value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.EnvironmentManager_ord :
            specificBuilder.EnvironmentManager(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, IBindingManager value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.BindingManager_ord :
            specificBuilder.BindingManager(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, IBindingScope value) {
        switch (entityDesc.getOrdinal()) {
            case EnvironmentEntityDescriptorEnum.BindingScope_ord :
            specificBuilder.BindingScope(value);
            break;
        }
    }
}
