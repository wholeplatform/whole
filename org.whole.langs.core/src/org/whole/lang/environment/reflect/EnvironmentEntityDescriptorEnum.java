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
package org.whole.lang.environment.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class EnvironmentEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Data_ord = 0;
    public static final int BooleanData_ord = 1;
    public static final int ByteData_ord = 2;
    public static final int CharData_ord = 3;
    public static final int DoubleData_ord = 4;
    public static final int FloatData_ord = 5;
    public static final int IntData_ord = 6;
    public static final int LongData_ord = 7;
    public static final int ShortData_ord = 8;
    public static final int StringData_ord = 9;
    public static final int DateData_ord = 10;
    public static final int ObjectData_ord = 11;
    public static final int Tuple_ord = 12;
    public static final int ContainmentTuple_ord = 13;
    public static final int Void_ord = 14;
    public static final int ContextViewModel_ord = 15;
    public static final int SampleViewModel_ord = 16;
    public static final int DebugViewModel_ord = 17;
    public static final int Jobs_ord = 18;
    public static final int Job_ord = 19;
    public static final int ExecutionStack_ord = 20;
    public static final int ExecutionFrame_ord = 21;
    public static final int VariablesViewModel_ord = 22;
    public static final int Environments_ord = 23;
    public static final int Environment_ord = 24;
    public static final int BindingsModel_ord = 25;
    public static final int ScopedBindings_ord = 26;
    public static final int Bindings_ord = 27;
    public static final int Binding_ord = 28;
    public static final int Scope_ord = 29;
    public static final int Id_ord = 30;
    public static final int Names_ord = 31;
    public static final int Name_ord = 32;
    public static final int Index_ord = 33;
    public static final int Value_ord = 34;
    public static final int EnvironmentManager_ord = 35;
    public static final int BindingManager_ord = 36;
    public static final int BindingScope_ord = 37;
    public static final int BindingOrScope_ord = 38;
    public static final EnvironmentEntityDescriptorEnum instance = new EnvironmentEntityDescriptorEnum();
    public static final EntityDescriptor<Data> Data = (EntityDescriptor<Data>) instance.valueOf(Data_ord);
    public static final EntityDescriptor<BooleanData> BooleanData = (EntityDescriptor<BooleanData>) instance.valueOf(BooleanData_ord);
    public static final EntityDescriptor<ByteData> ByteData = (EntityDescriptor<ByteData>) instance.valueOf(ByteData_ord);
    public static final EntityDescriptor<CharData> CharData = (EntityDescriptor<CharData>) instance.valueOf(CharData_ord);
    public static final EntityDescriptor<DoubleData> DoubleData = (EntityDescriptor<DoubleData>) instance.valueOf(DoubleData_ord);
    public static final EntityDescriptor<FloatData> FloatData = (EntityDescriptor<FloatData>) instance.valueOf(FloatData_ord);
    public static final EntityDescriptor<IntData> IntData = (EntityDescriptor<IntData>) instance.valueOf(IntData_ord);
    public static final EntityDescriptor<LongData> LongData = (EntityDescriptor<LongData>) instance.valueOf(LongData_ord);
    public static final EntityDescriptor<ShortData> ShortData = (EntityDescriptor<ShortData>) instance.valueOf(ShortData_ord);
    public static final EntityDescriptor<StringData> StringData = (EntityDescriptor<StringData>) instance.valueOf(StringData_ord);
    public static final EntityDescriptor<DateData> DateData = (EntityDescriptor<DateData>) instance.valueOf(DateData_ord);
    public static final EntityDescriptor<ObjectData> ObjectData = (EntityDescriptor<ObjectData>) instance.valueOf(ObjectData_ord);
    public static final EntityDescriptor<Tuple> Tuple = (EntityDescriptor<Tuple>) instance.valueOf(Tuple_ord);
    public static final EntityDescriptor<ContainmentTuple> ContainmentTuple = (EntityDescriptor<ContainmentTuple>) instance.valueOf(ContainmentTuple_ord);
    public static final EntityDescriptor<Void> Void = (EntityDescriptor<Void>) instance.valueOf(Void_ord);
    public static final EntityDescriptor<ContextViewModel> ContextViewModel = (EntityDescriptor<ContextViewModel>) instance.valueOf(ContextViewModel_ord);
    public static final EntityDescriptor<SampleViewModel> SampleViewModel = (EntityDescriptor<SampleViewModel>) instance.valueOf(SampleViewModel_ord);
    public static final EntityDescriptor<DebugViewModel> DebugViewModel = (EntityDescriptor<DebugViewModel>) instance.valueOf(DebugViewModel_ord);
    public static final EntityDescriptor<Jobs> Jobs = (EntityDescriptor<Jobs>) instance.valueOf(Jobs_ord);
    public static final EntityDescriptor<Job> Job = (EntityDescriptor<Job>) instance.valueOf(Job_ord);
    public static final EntityDescriptor<ExecutionStack> ExecutionStack = (EntityDescriptor<ExecutionStack>) instance.valueOf(ExecutionStack_ord);
    public static final EntityDescriptor<ExecutionFrame> ExecutionFrame = (EntityDescriptor<ExecutionFrame>) instance.valueOf(ExecutionFrame_ord);
    public static final EntityDescriptor<VariablesViewModel> VariablesViewModel = (EntityDescriptor<VariablesViewModel>) instance.valueOf(VariablesViewModel_ord);
    public static final EntityDescriptor<Environments> Environments = (EntityDescriptor<Environments>) instance.valueOf(Environments_ord);
    public static final EntityDescriptor<Environment> Environment = (EntityDescriptor<Environment>) instance.valueOf(Environment_ord);
    public static final EntityDescriptor<BindingsModel> BindingsModel = (EntityDescriptor<BindingsModel>) instance.valueOf(BindingsModel_ord);
    public static final EntityDescriptor<ScopedBindings> ScopedBindings = (EntityDescriptor<ScopedBindings>) instance.valueOf(ScopedBindings_ord);
    public static final EntityDescriptor<Bindings> Bindings = (EntityDescriptor<Bindings>) instance.valueOf(Bindings_ord);
    public static final EntityDescriptor<Binding> Binding = (EntityDescriptor<Binding>) instance.valueOf(Binding_ord);
    public static final EntityDescriptor<Scope> Scope = (EntityDescriptor<Scope>) instance.valueOf(Scope_ord);
    public static final EntityDescriptor<Id> Id = (EntityDescriptor<Id>) instance.valueOf(Id_ord);
    public static final EntityDescriptor<Names> Names = (EntityDescriptor<Names>) instance.valueOf(Names_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<Index> Index = (EntityDescriptor<Index>) instance.valueOf(Index_ord);
    public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance.valueOf(Value_ord);
    public static final EntityDescriptor<EnvironmentManager> EnvironmentManager = (EntityDescriptor<EnvironmentManager>) instance.valueOf(EnvironmentManager_ord);
    public static final EntityDescriptor<BindingManager> BindingManager = (EntityDescriptor<BindingManager>) instance.valueOf(BindingManager_ord);
    public static final EntityDescriptor<BindingScope> BindingScope = (EntityDescriptor<BindingScope>) instance.valueOf(BindingScope_ord);
    public static final EntityDescriptor<BindingOrScope> BindingOrScope = (EntityDescriptor<BindingOrScope>) instance.valueOf(BindingOrScope_ord);

    private EnvironmentEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Data_ord, "Data", Data.class, true, ContainmentTuple_ord, CharData_ord, IntData_ord, ObjectData_ord, LongData_ord, DoubleData_ord, ShortData_ord, BooleanData_ord, ByteData_ord, FloatData_ord, DateData_ord, StringData_ord, Void_ord, Tuple_ord);
        putDataEntity(BooleanData_ord, "BooleanData", BooleanData.class, false, boolean.class);
        putDataEntity(ByteData_ord, "ByteData", ByteData.class, false, byte.class);
        putDataEntity(CharData_ord, "CharData", CharData.class, false, char.class);
        putDataEntity(DoubleData_ord, "DoubleData", DoubleData.class, false, double.class);
        putDataEntity(FloatData_ord, "FloatData", FloatData.class, false, float.class);
        putDataEntity(IntData_ord, "IntData", IntData.class, false, int.class);
        putDataEntity(LongData_ord, "LongData", LongData.class, false, long.class);
        putDataEntity(ShortData_ord, "ShortData", ShortData.class, false, short.class);
        putDataEntity(StringData_ord, "StringData", StringData.class, false, String.class);
        putDataEntity(DateData_ord, "DateData", DateData.class, false, java.util.Date.class);
        putDataEntity(ObjectData_ord, "ObjectData", ObjectData.class, false, Object.class);
        putCompositeEntity(Tuple_ord, "Tuple", Tuple.class, false, Data_ord, true, false, true, false, false);
        putCompositeEntity(
		ContainmentTuple_ord, "ContainmentTuple", ContainmentTuple.class, false, Data_ord, true, false);
        putSimpleEntity(Void_ord, "Void", Void.class, false);
        putSimpleEntity(ContextViewModel_ord, "ContextViewModel", ContextViewModel.class, false).withFeature(EnvironmentFeatureDescriptorEnum.environments, Environments_ord).withFeature(EnvironmentFeatureDescriptorEnum.bindings, Bindings_ord);
        putSimpleEntity(SampleViewModel_ord, "SampleViewModel", SampleViewModel.class, false).withFeature(EnvironmentFeatureDescriptorEnum.behavior, Data_ord).withFeature(EnvironmentFeatureDescriptorEnum.result, Data_ord);
        putSimpleEntity(DebugViewModel_ord, "DebugViewModel", DebugViewModel.class, false).withFeature(EnvironmentFeatureDescriptorEnum.focusJob, Index_ord).withFeature(EnvironmentFeatureDescriptorEnum.jobs, Jobs_ord);
        putCompositeEntity(
		Jobs_ord, "Jobs", Jobs.class, false, Job_ord, true, false);
        putSimpleEntity(Job_ord, "Job", Job.class, false).withFeature(EnvironmentFeatureDescriptorEnum.focusFrame, Index_ord).withFeature(EnvironmentFeatureDescriptorEnum.executionStack, ExecutionStack_ord);
        putCompositeEntity(
		ExecutionStack_ord, "ExecutionStack", ExecutionStack.class, false, ExecutionFrame_ord, true, false);
        putSimpleEntity(ExecutionFrame_ord, "ExecutionFrame", ExecutionFrame.class, false).withFeature(EnvironmentFeatureDescriptorEnum.sourceFragment, Data_ord).withFeature(EnvironmentFeatureDescriptorEnum.sourceEntity, Value_ord);
        putSimpleEntity(VariablesViewModel_ord, "VariablesViewModel", VariablesViewModel.class, false).withFeature(EnvironmentFeatureDescriptorEnum.environmentManager, EnvironmentManager_ord).withFeature(EnvironmentFeatureDescriptorEnum.environments, Environments_ord);
        putCompositeEntity(
		Environments_ord, "Environments", Environments.class, false, Environment_ord, true, false);
        putSimpleEntity(Environment_ord, "Environment", Environment.class, false).withFeature(EnvironmentFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(EnvironmentFeatureDescriptorEnum.filter, Names_ord, true, false, false, false, false).withFeature(EnvironmentFeatureDescriptorEnum.bindingManager, BindingManager_ord).withFeature(EnvironmentFeatureDescriptorEnum.bindings, BindingsModel_ord);
        putSimpleEntity(BindingsModel_ord, "BindingsModel", BindingsModel.class, true, Bindings_ord, ScopedBindings_ord);
        putCompositeEntity(
		ScopedBindings_ord, "ScopedBindings", ScopedBindings.class, false, BindingOrScope_ord, true, false);
        putCompositeEntity(
		Bindings_ord, "Bindings", Bindings.class, false, Binding_ord, true, false);
        putSimpleEntity(Binding_ord, "Binding", Binding.class, false).withFeature(EnvironmentFeatureDescriptorEnum.name, Name_ord, false, true, false, false, false).withFeature(EnvironmentFeatureDescriptorEnum.value, Value_ord);
        putSimpleEntity(Scope_ord, "Scope", Scope.class, false).withFeature(EnvironmentFeatureDescriptorEnum.scope, BindingScope_ord).withFeature(EnvironmentFeatureDescriptorEnum.sourceEntity, Value_ord);
        putDataEntity(Id_ord, "Id", Id.class, false, String.class);
        putCompositeEntity(
		Names_ord, "Names", Names.class, false, Name_ord, true, false);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putDataEntity(Index_ord, "Index", Index.class, false, int.class);
        putDataEntity(Value_ord, "Value", Value.class, false, org.whole.lang.model.IEntity.class);
        putDataEntity(EnvironmentManager_ord, "EnvironmentManager", EnvironmentManager.class, false, org.whole.lang.bindings.IEnvironmentManager.class);
        putDataEntity(BindingManager_ord, "BindingManager", BindingManager.class, false, org.whole.lang.bindings.IBindingManager.class);
        putDataEntity(BindingScope_ord, "BindingScope", BindingScope.class, false, org.whole.lang.bindings.IBindingScope.class);
        putSimpleEntity(BindingOrScope_ord, "BindingOrScope", BindingOrScope.class, true, Binding_ord, Scope_ord);
    }

    protected void initForeignTypeRelations() {
        setAssignableFromAll(true, Data_ord);
        setAssignableToAll(true, Void_ord);
    }
}
