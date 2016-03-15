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

import org.whole.lang.builders.IBuilder;
import java.util.Date;
import org.whole.lang.model.IEntity;
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;

/**
 *  @generator Whole
 */
public interface IEnvironmentBuilder extends IBuilder {


    public void visit();

    public void scope();

    public void value();

    public void bindingManager();

    public void filter();

    public void name();

    public void environmentManager();

    public void sourceEntity();

    public void sourceFragment();

    public void executionStack();

    public void focusFrame();

    public void jobs();

    public void focusJob();

    public void result();

    public void behavior();

    public void bindings();

    public void environments();

    public void BooleanData();

    public void BooleanData(boolean value);

    public void ByteData();

    public void ByteData(byte value);

    public void CharData();

    public void CharData(char value);

    public void DoubleData();

    public void DoubleData(double value);

    public void FloatData();

    public void FloatData(float value);

    public void IntData();

    public void IntData(int value);

    public void LongData();

    public void LongData(long value);

    public void ShortData();

    public void ShortData(short value);

    public void StringData();

    public void StringData(String value);

    public void DateData();

    public void DateData(Date value);

    public void DateData(String value);

    public void ObjectData();

    public void ObjectData(Object value);

    public void ObjectData(String value);

    public void Tuple();

    public void Tuple_();

    public void Tuple_(int initialCapacity);

    public void _Tuple();

    public void ContainmentTuple();

    public void ContainmentTuple_();

    public void ContainmentTuple_(int initialCapacity);

    public void _ContainmentTuple();

    public void Void();

    public void Void_();

    public void _Void();

    public void ContextViewModel();

    public void ContextViewModel_();

    public void _ContextViewModel();

    public void SampleViewModel();

    public void SampleViewModel_();

    public void _SampleViewModel();

    public void DebugViewModel();

    public void DebugViewModel_();

    public void _DebugViewModel();

    public void Jobs();

    public void Jobs_();

    public void Jobs_(int initialCapacity);

    public void _Jobs();

    public void Job();

    public void Job_();

    public void _Job();

    public void ExecutionStack();

    public void ExecutionStack_();

    public void ExecutionStack_(int initialCapacity);

    public void _ExecutionStack();

    public void ExecutionFrame();

    public void ExecutionFrame_();

    public void _ExecutionFrame();

    public void VariablesViewModel();

    public void VariablesViewModel_();

    public void _VariablesViewModel();

    public void Environments();

    public void Environments_();

    public void Environments_(int initialCapacity);

    public void _Environments();

    public void Environment();

    public void Environment_();

    public void _Environment();

    public void ScopedBindings();

    public void ScopedBindings_();

    public void ScopedBindings_(int initialCapacity);

    public void _ScopedBindings();

    public void Bindings();

    public void Bindings_();

    public void Bindings_(int initialCapacity);

    public void _Bindings();

    public void Binding();

    public void Binding_();

    public void _Binding();

    public void Scope();

    public void Scope_();

    public void _Scope();

    public void Id();

    public void Id(String value);

    public void Names();

    public void Names_();

    public void Names_(int initialCapacity);

    public void _Names();

    public void Name();

    public void Name(String value);

    public void Index();

    public void Index(int value);

    public void Value();

    public void Value(IEntity value);

    public void Value(String value);

    public void EnvironmentManager();

    public void EnvironmentManager(IEnvironmentManager value);

    public void EnvironmentManager(String value);

    public void BindingManager();

    public void BindingManager(IBindingManager value);

    public void BindingManager(String value);

    public void BindingScope();

    public void BindingScope(IBindingScope value);

    public void BindingScope(String value);
}
