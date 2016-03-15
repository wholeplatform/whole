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
package org.whole.lang.environment.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.environment.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/**
 *  @generator Whole
 */
public class EnvironmentEntityFactory extends GenericEntityFactory {
    public static final EnvironmentEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static EnvironmentEntityFactory instance(IEntityRegistryProvider provider) {
        return new EnvironmentEntityFactory(provider);
    }

    protected EnvironmentEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public BooleanData createBooleanData() {
        return create(EnvironmentEntityDescriptorEnum.BooleanData);
    }

    public BooleanData createBooleanData(boolean value) {
        return create(EnvironmentEntityDescriptorEnum.BooleanData, value);
    }

    public ByteData createByteData() {
        return create(EnvironmentEntityDescriptorEnum.ByteData);
    }

    public ByteData createByteData(byte value) {
        return create(EnvironmentEntityDescriptorEnum.ByteData, value);
    }

    public CharData createCharData() {
        return create(EnvironmentEntityDescriptorEnum.CharData);
    }

    public CharData createCharData(char value) {
        return create(EnvironmentEntityDescriptorEnum.CharData, value);
    }

    public DoubleData createDoubleData() {
        return create(EnvironmentEntityDescriptorEnum.DoubleData);
    }

    public DoubleData createDoubleData(double value) {
        return create(EnvironmentEntityDescriptorEnum.DoubleData, value);
    }

    public FloatData createFloatData() {
        return create(EnvironmentEntityDescriptorEnum.FloatData);
    }

    public FloatData createFloatData(float value) {
        return create(EnvironmentEntityDescriptorEnum.FloatData, value);
    }

    public IntData createIntData() {
        return create(EnvironmentEntityDescriptorEnum.IntData);
    }

    public IntData createIntData(int value) {
        return create(EnvironmentEntityDescriptorEnum.IntData, value);
    }

    public LongData createLongData() {
        return create(EnvironmentEntityDescriptorEnum.LongData);
    }

    public LongData createLongData(long value) {
        return create(EnvironmentEntityDescriptorEnum.LongData, value);
    }

    public ShortData createShortData() {
        return create(EnvironmentEntityDescriptorEnum.ShortData);
    }

    public ShortData createShortData(short value) {
        return create(EnvironmentEntityDescriptorEnum.ShortData, value);
    }

    public StringData createStringData() {
        return create(EnvironmentEntityDescriptorEnum.StringData);
    }

    public StringData createStringData(String value) {
        return create(EnvironmentEntityDescriptorEnum.StringData, value);
    }

    public DateData createDateData() {
        return create(EnvironmentEntityDescriptorEnum.DateData);
    }

    public DateData createDateData(java.util.Date value) {
        return create(EnvironmentEntityDescriptorEnum.DateData, value);
    }

    public ObjectData createObjectData() {
        return create(EnvironmentEntityDescriptorEnum.ObjectData);
    }

    public ObjectData createObjectData(Object value) {
        return create(EnvironmentEntityDescriptorEnum.ObjectData, value);
    }

    public Tuple createTuple() {
        return create(EnvironmentEntityDescriptorEnum.Tuple);
    }

    public Tuple createTuple(Data... entities) {
        return create(EnvironmentEntityDescriptorEnum.Tuple, (IEntity[]) entities);
    }

    public Tuple createTuple(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.Tuple, initialSize);
    }

    public ContainmentTuple createContainmentTuple() {
        return create(EnvironmentEntityDescriptorEnum.ContainmentTuple);
    }

    public ContainmentTuple createContainmentTuple(Data... entities) {
        return create(EnvironmentEntityDescriptorEnum.ContainmentTuple, (IEntity[]) entities);
    }

    public ContainmentTuple createContainmentTuple(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.ContainmentTuple, initialSize);
    }

    public Void createVoid() {
        return create(EnvironmentEntityDescriptorEnum.Void);
    }

    public ContextViewModel createContextViewModel() {
        return create(EnvironmentEntityDescriptorEnum.ContextViewModel);
    }

    public ContextViewModel createContextViewModel(Environments environments, Bindings bindings) {
        return create(EnvironmentEntityDescriptorEnum.ContextViewModel, environments, bindings);
    }

    public IEntityBuilder<ContextViewModel> buildContextViewModel() {
        return new EntityBuilder<ContextViewModel>(create(EnvironmentEntityDescriptorEnum.ContextViewModel));
    }

    public SampleViewModel createSampleViewModel() {
        return create(EnvironmentEntityDescriptorEnum.SampleViewModel);
    }

    public SampleViewModel createSampleViewModel(Data behavior, Data result) {
        return create(EnvironmentEntityDescriptorEnum.SampleViewModel, behavior, result);
    }

    public IEntityBuilder<SampleViewModel> buildSampleViewModel() {
        return new EntityBuilder<SampleViewModel>(create(EnvironmentEntityDescriptorEnum.SampleViewModel));
    }

    public DebugViewModel createDebugViewModel() {
        return create(EnvironmentEntityDescriptorEnum.DebugViewModel);
    }

    public DebugViewModel createDebugViewModel(Index focusJob, Jobs jobs) {
        return create(EnvironmentEntityDescriptorEnum.DebugViewModel, focusJob, jobs);
    }

    public IEntityBuilder<DebugViewModel> buildDebugViewModel() {
        return new EntityBuilder<DebugViewModel>(create(EnvironmentEntityDescriptorEnum.DebugViewModel));
    }

    public Jobs createJobs() {
        return create(EnvironmentEntityDescriptorEnum.Jobs);
    }

    public Jobs createJobs(Job... entities) {
        return create(EnvironmentEntityDescriptorEnum.Jobs, (IEntity[]) entities);
    }

    public Jobs createJobs(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.Jobs, initialSize);
    }

    public Job createJob() {
        return create(EnvironmentEntityDescriptorEnum.Job);
    }

    public Job createJob(Index focusFrame, ExecutionStack executionStack) {
        return create(EnvironmentEntityDescriptorEnum.Job, focusFrame, executionStack);
    }

    public IEntityBuilder<Job> buildJob() {
        return new EntityBuilder<Job>(create(EnvironmentEntityDescriptorEnum.Job));
    }

    public ExecutionStack createExecutionStack() {
        return create(EnvironmentEntityDescriptorEnum.ExecutionStack);
    }

    public ExecutionStack createExecutionStack(ExecutionFrame... entities) {
        return create(EnvironmentEntityDescriptorEnum.ExecutionStack, (IEntity[]) entities);
    }

    public ExecutionStack createExecutionStack(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.ExecutionStack, initialSize);
    }

    public ExecutionFrame createExecutionFrame() {
        return create(EnvironmentEntityDescriptorEnum.ExecutionFrame);
    }

    public ExecutionFrame createExecutionFrame(Data sourceFragment, Value sourceEntity) {
        return create(EnvironmentEntityDescriptorEnum.ExecutionFrame, sourceFragment, sourceEntity);
    }

    public IEntityBuilder<ExecutionFrame> buildExecutionFrame() {
        return new EntityBuilder<ExecutionFrame>(create(EnvironmentEntityDescriptorEnum.ExecutionFrame));
    }

    public VariablesViewModel createVariablesViewModel() {
        return create(EnvironmentEntityDescriptorEnum.VariablesViewModel);
    }

    public VariablesViewModel createVariablesViewModel(EnvironmentManager environmentManager, Environments environments) {
        return create(EnvironmentEntityDescriptorEnum.VariablesViewModel, environmentManager, environments);
    }

    public IEntityBuilder<VariablesViewModel> buildVariablesViewModel() {
        return new EntityBuilder<VariablesViewModel>(create(EnvironmentEntityDescriptorEnum.VariablesViewModel));
    }

    public Environments createEnvironments() {
        return create(EnvironmentEntityDescriptorEnum.Environments);
    }

    public Environments createEnvironments(Environment... entities) {
        return create(EnvironmentEntityDescriptorEnum.Environments, (IEntity[]) entities);
    }

    public Environments createEnvironments(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.Environments, initialSize);
    }

    public Environment createEnvironment() {
        return create(EnvironmentEntityDescriptorEnum.Environment);
    }

    public Environment createEnvironment(Name name, Names filter, BindingManager bindingManager, BindingsModel bindings) {
        return create(EnvironmentEntityDescriptorEnum.Environment, name, filter, bindingManager, bindings);
    }

    public IEntityBuilder<Environment> buildEnvironment() {
        return new EntityBuilder<Environment>(create(EnvironmentEntityDescriptorEnum.Environment));
    }

    public ScopedBindings createScopedBindings() {
        return create(EnvironmentEntityDescriptorEnum.ScopedBindings);
    }

    public ScopedBindings createScopedBindings(BindingOrScope... entities) {
        return create(EnvironmentEntityDescriptorEnum.ScopedBindings, (IEntity[]) entities);
    }

    public ScopedBindings createScopedBindings(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.ScopedBindings, initialSize);
    }

    public Bindings createBindings() {
        return create(EnvironmentEntityDescriptorEnum.Bindings);
    }

    public Bindings createBindings(Binding... entities) {
        return create(EnvironmentEntityDescriptorEnum.Bindings, (IEntity[]) entities);
    }

    public Bindings createBindings(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.Bindings, initialSize);
    }

    public Binding createBinding() {
        return create(EnvironmentEntityDescriptorEnum.Binding);
    }

    public Binding createBinding(Name name, Value value) {
        return create(EnvironmentEntityDescriptorEnum.Binding, name, value);
    }

    public IEntityBuilder<Binding> buildBinding() {
        return new EntityBuilder<Binding>(create(EnvironmentEntityDescriptorEnum.Binding));
    }

    public Scope createScope() {
        return create(EnvironmentEntityDescriptorEnum.Scope);
    }

    public Scope createScope(BindingScope scope, Value sourceEntity) {
        return create(EnvironmentEntityDescriptorEnum.Scope, scope, sourceEntity);
    }

    public IEntityBuilder<Scope> buildScope() {
        return new EntityBuilder<Scope>(create(EnvironmentEntityDescriptorEnum.Scope));
    }

    public Id createId() {
        return create(EnvironmentEntityDescriptorEnum.Id);
    }

    public Id createId(String value) {
        return create(EnvironmentEntityDescriptorEnum.Id, value);
    }

    public Names createNames() {
        return create(EnvironmentEntityDescriptorEnum.Names);
    }

    public Names createNames(Name... entities) {
        return create(EnvironmentEntityDescriptorEnum.Names, (IEntity[]) entities);
    }

    public Names createNames(int initialSize) {
        return clone(EnvironmentEntityDescriptorEnum.Names, initialSize);
    }

    public Name createName() {
        return create(EnvironmentEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(EnvironmentEntityDescriptorEnum.Name, value);
    }

    public Index createIndex() {
        return create(EnvironmentEntityDescriptorEnum.Index);
    }

    public Index createIndex(int value) {
        return create(EnvironmentEntityDescriptorEnum.Index, value);
    }

    public Value createValue() {
        return create(EnvironmentEntityDescriptorEnum.Value);
    }

    public Value createValue(org.whole.lang.model.IEntity value) {
        return create(EnvironmentEntityDescriptorEnum.Value, (java.lang.Object) value);
    }

    public EnvironmentManager createEnvironmentManager() {
        return create(EnvironmentEntityDescriptorEnum.EnvironmentManager);
    }

    public EnvironmentManager createEnvironmentManager(org.whole.lang.bindings.IEnvironmentManager value) {
        return create(EnvironmentEntityDescriptorEnum.EnvironmentManager, (java.lang.Object) value);
    }

    public BindingManager createBindingManager() {
        return create(EnvironmentEntityDescriptorEnum.BindingManager);
    }

    public BindingManager createBindingManager(org.whole.lang.bindings.IBindingManager value) {
        return create(EnvironmentEntityDescriptorEnum.BindingManager, (java.lang.Object) value);
    }

    public BindingScope createBindingScope() {
        return create(EnvironmentEntityDescriptorEnum.BindingScope);
    }

    public BindingScope createBindingScope(org.whole.lang.bindings.IBindingScope value) {
        return create(EnvironmentEntityDescriptorEnum.BindingScope, (java.lang.Object) value);
    }
}
