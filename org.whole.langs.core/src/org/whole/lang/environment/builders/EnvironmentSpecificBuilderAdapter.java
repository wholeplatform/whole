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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;

/**
 *  @generator Whole
 */
public class EnvironmentSpecificBuilderAdapter extends GenericBuilderContext implements IEnvironmentBuilder {

    public EnvironmentSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public EnvironmentSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void scope() {
        wFeature(EnvironmentFeatureDescriptorEnum.scope);
    }

    public void value() {
        wFeature(EnvironmentFeatureDescriptorEnum.value);
    }

    public void bindingManager() {
        wFeature(EnvironmentFeatureDescriptorEnum.bindingManager);
    }

    public void filter() {
        wFeature(EnvironmentFeatureDescriptorEnum.filter);
    }

    public void name() {
        wFeature(EnvironmentFeatureDescriptorEnum.name);
    }

    public void environmentManager() {
        wFeature(EnvironmentFeatureDescriptorEnum.environmentManager);
    }

    public void sourceEntity() {
        wFeature(EnvironmentFeatureDescriptorEnum.sourceEntity);
    }

    public void sourceFragment() {
        wFeature(EnvironmentFeatureDescriptorEnum.sourceFragment);
    }

    public void executionStack() {
        wFeature(EnvironmentFeatureDescriptorEnum.executionStack);
    }

    public void focusFrame() {
        wFeature(EnvironmentFeatureDescriptorEnum.focusFrame);
    }

    public void jobs() {
        wFeature(EnvironmentFeatureDescriptorEnum.jobs);
    }

    public void focusJob() {
        wFeature(EnvironmentFeatureDescriptorEnum.focusJob);
    }

    public void result() {
        wFeature(EnvironmentFeatureDescriptorEnum.result);
    }

    public void behavior() {
        wFeature(EnvironmentFeatureDescriptorEnum.behavior);
    }

    public void bindings() {
        wFeature(EnvironmentFeatureDescriptorEnum.bindings);
    }

    public void environments() {
        wFeature(EnvironmentFeatureDescriptorEnum.environments);
    }

    public void visit() {
    }

    public void BooleanData() {
        wEntity(EnvironmentEntityDescriptorEnum.BooleanData);
    }

    public void BooleanData(boolean value) {
        wEntity(EnvironmentEntityDescriptorEnum.BooleanData, value);
    }

    public void ByteData() {
        wEntity(EnvironmentEntityDescriptorEnum.ByteData);
    }

    public void ByteData(byte value) {
        wEntity(EnvironmentEntityDescriptorEnum.ByteData, value);
    }

    public void CharData() {
        wEntity(EnvironmentEntityDescriptorEnum.CharData);
    }

    public void CharData(char value) {
        wEntity(EnvironmentEntityDescriptorEnum.CharData, value);
    }

    public void DoubleData() {
        wEntity(EnvironmentEntityDescriptorEnum.DoubleData);
    }

    public void DoubleData(double value) {
        wEntity(EnvironmentEntityDescriptorEnum.DoubleData, value);
    }

    public void FloatData() {
        wEntity(EnvironmentEntityDescriptorEnum.FloatData);
    }

    public void FloatData(float value) {
        wEntity(EnvironmentEntityDescriptorEnum.FloatData, value);
    }

    public void IntData() {
        wEntity(EnvironmentEntityDescriptorEnum.IntData);
    }

    public void IntData(int value) {
        wEntity(EnvironmentEntityDescriptorEnum.IntData, value);
    }

    public void LongData() {
        wEntity(EnvironmentEntityDescriptorEnum.LongData);
    }

    public void LongData(long value) {
        wEntity(EnvironmentEntityDescriptorEnum.LongData, value);
    }

    public void ShortData() {
        wEntity(EnvironmentEntityDescriptorEnum.ShortData);
    }

    public void ShortData(short value) {
        wEntity(EnvironmentEntityDescriptorEnum.ShortData, value);
    }

    public void StringData() {
        wEntity(EnvironmentEntityDescriptorEnum.StringData);
    }

    public void StringData(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.StringData, value);
    }

    public void DateData() {
        wEntity(EnvironmentEntityDescriptorEnum.DateData);
    }

    public void DateData(Date value) {
        wEntity(EnvironmentEntityDescriptorEnum.DateData, value);
    }

    public void DateData(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.DateData, value);
    }

    public void ObjectData() {
        wEntity(EnvironmentEntityDescriptorEnum.ObjectData);
    }

    public void ObjectData(Object value) {
        wEntity(EnvironmentEntityDescriptorEnum.ObjectData, value);
    }

    public void ObjectData(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.ObjectData, value);
    }

    public void Tuple() {
        wEntity(EnvironmentEntityDescriptorEnum.Tuple);
    }

    public void Tuple_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Tuple);
    }

    public void Tuple_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.Tuple, initialCapacity);
    }

    public void _Tuple() {
        _wEntity(EnvironmentEntityDescriptorEnum.Tuple);
    }

    public void ContainmentTuple() {
        wEntity(EnvironmentEntityDescriptorEnum.ContainmentTuple);
    }

    public void ContainmentTuple_() {
        wEntity_(EnvironmentEntityDescriptorEnum.ContainmentTuple);
    }

    public void ContainmentTuple_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.ContainmentTuple, initialCapacity);
    }

    public void _ContainmentTuple() {
        _wEntity(EnvironmentEntityDescriptorEnum.ContainmentTuple);
    }

    public void Void() {
        wEntity(EnvironmentEntityDescriptorEnum.Void);
    }

    public void Void_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Void);
    }

    public void _Void() {
        _wEntity(EnvironmentEntityDescriptorEnum.Void);
    }

    public void ContextViewModel() {
        wEntity(EnvironmentEntityDescriptorEnum.ContextViewModel);
    }

    public void ContextViewModel_() {
        wEntity_(EnvironmentEntityDescriptorEnum.ContextViewModel);
    }

    public void _ContextViewModel() {
        _wEntity(EnvironmentEntityDescriptorEnum.ContextViewModel);
    }

    public void SampleViewModel() {
        wEntity(EnvironmentEntityDescriptorEnum.SampleViewModel);
    }

    public void SampleViewModel_() {
        wEntity_(EnvironmentEntityDescriptorEnum.SampleViewModel);
    }

    public void _SampleViewModel() {
        _wEntity(EnvironmentEntityDescriptorEnum.SampleViewModel);
    }

    public void DebugViewModel() {
        wEntity(EnvironmentEntityDescriptorEnum.DebugViewModel);
    }

    public void DebugViewModel_() {
        wEntity_(EnvironmentEntityDescriptorEnum.DebugViewModel);
    }

    public void _DebugViewModel() {
        _wEntity(EnvironmentEntityDescriptorEnum.DebugViewModel);
    }

    public void Jobs() {
        wEntity(EnvironmentEntityDescriptorEnum.Jobs);
    }

    public void Jobs_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Jobs);
    }

    public void Jobs_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.Jobs, initialCapacity);
    }

    public void _Jobs() {
        _wEntity(EnvironmentEntityDescriptorEnum.Jobs);
    }

    public void Job() {
        wEntity(EnvironmentEntityDescriptorEnum.Job);
    }

    public void Job_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Job);
    }

    public void _Job() {
        _wEntity(EnvironmentEntityDescriptorEnum.Job);
    }

    public void ExecutionStack() {
        wEntity(EnvironmentEntityDescriptorEnum.ExecutionStack);
    }

    public void ExecutionStack_() {
        wEntity_(EnvironmentEntityDescriptorEnum.ExecutionStack);
    }

    public void ExecutionStack_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.ExecutionStack, initialCapacity);
    }

    public void _ExecutionStack() {
        _wEntity(EnvironmentEntityDescriptorEnum.ExecutionStack);
    }

    public void ExecutionFrame() {
        wEntity(EnvironmentEntityDescriptorEnum.ExecutionFrame);
    }

    public void ExecutionFrame_() {
        wEntity_(EnvironmentEntityDescriptorEnum.ExecutionFrame);
    }

    public void _ExecutionFrame() {
        _wEntity(EnvironmentEntityDescriptorEnum.ExecutionFrame);
    }

    public void VariablesViewModel() {
        wEntity(EnvironmentEntityDescriptorEnum.VariablesViewModel);
    }

    public void VariablesViewModel_() {
        wEntity_(EnvironmentEntityDescriptorEnum.VariablesViewModel);
    }

    public void _VariablesViewModel() {
        _wEntity(EnvironmentEntityDescriptorEnum.VariablesViewModel);
    }

    public void Environments() {
        wEntity(EnvironmentEntityDescriptorEnum.Environments);
    }

    public void Environments_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Environments);
    }

    public void Environments_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.Environments, initialCapacity);
    }

    public void _Environments() {
        _wEntity(EnvironmentEntityDescriptorEnum.Environments);
    }

    public void Environment() {
        wEntity(EnvironmentEntityDescriptorEnum.Environment);
    }

    public void Environment_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Environment);
    }

    public void _Environment() {
        _wEntity(EnvironmentEntityDescriptorEnum.Environment);
    }

    public void ScopedBindings() {
        wEntity(EnvironmentEntityDescriptorEnum.ScopedBindings);
    }

    public void ScopedBindings_() {
        wEntity_(EnvironmentEntityDescriptorEnum.ScopedBindings);
    }

    public void ScopedBindings_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.ScopedBindings, initialCapacity);
    }

    public void _ScopedBindings() {
        _wEntity(EnvironmentEntityDescriptorEnum.ScopedBindings);
    }

    public void Bindings() {
        wEntity(EnvironmentEntityDescriptorEnum.Bindings);
    }

    public void Bindings_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Bindings);
    }

    public void Bindings_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.Bindings, initialCapacity);
    }

    public void _Bindings() {
        _wEntity(EnvironmentEntityDescriptorEnum.Bindings);
    }

    public void Binding() {
        wEntity(EnvironmentEntityDescriptorEnum.Binding);
    }

    public void Binding_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Binding);
    }

    public void _Binding() {
        _wEntity(EnvironmentEntityDescriptorEnum.Binding);
    }

    public void Scope() {
        wEntity(EnvironmentEntityDescriptorEnum.Scope);
    }

    public void Scope_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Scope);
    }

    public void _Scope() {
        _wEntity(EnvironmentEntityDescriptorEnum.Scope);
    }

    public void Id() {
        wEntity(EnvironmentEntityDescriptorEnum.Id);
    }

    public void Id(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.Id, value);
    }

    public void Names() {
        wEntity(EnvironmentEntityDescriptorEnum.Names);
    }

    public void Names_() {
        wEntity_(EnvironmentEntityDescriptorEnum.Names);
    }

    public void Names_(int initialCapacity) {
        wEntity_(EnvironmentEntityDescriptorEnum.Names, initialCapacity);
    }

    public void _Names() {
        _wEntity(EnvironmentEntityDescriptorEnum.Names);
    }

    public void Name() {
        wEntity(EnvironmentEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.Name, value);
    }

    public void Index() {
        wEntity(EnvironmentEntityDescriptorEnum.Index);
    }

    public void Index(int value) {
        wEntity(EnvironmentEntityDescriptorEnum.Index, value);
    }

    public void Value() {
        wEntity(EnvironmentEntityDescriptorEnum.Value);
    }

    public void Value(IEntity value) {
        wEntity(EnvironmentEntityDescriptorEnum.Value, value);
    }

    public void Value(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.Value, value);
    }

    public void EnvironmentManager() {
        wEntity(EnvironmentEntityDescriptorEnum.EnvironmentManager);
    }

    public void EnvironmentManager(IEnvironmentManager value) {
        wEntity(EnvironmentEntityDescriptorEnum.EnvironmentManager, value);
    }

    public void EnvironmentManager(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.EnvironmentManager, value);
    }

    public void BindingManager() {
        wEntity(EnvironmentEntityDescriptorEnum.BindingManager);
    }

    public void BindingManager(IBindingManager value) {
        wEntity(EnvironmentEntityDescriptorEnum.BindingManager, value);
    }

    public void BindingManager(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.BindingManager, value);
    }

    public void BindingScope() {
        wEntity(EnvironmentEntityDescriptorEnum.BindingScope);
    }

    public void BindingScope(IBindingScope value) {
        wEntity(EnvironmentEntityDescriptorEnum.BindingScope, value);
    }

    public void BindingScope(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.BindingScope, value);
    }
}
