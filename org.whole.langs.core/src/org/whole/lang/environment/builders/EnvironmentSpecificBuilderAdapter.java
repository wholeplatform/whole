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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

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

    public void value() {
        wFeature(EnvironmentFeatureDescriptorEnum.value);
    }

    public void name() {
        wFeature(EnvironmentFeatureDescriptorEnum.name);
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

    public void Name() {
        wEntity(EnvironmentEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(EnvironmentEntityDescriptorEnum.Name, value);
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
}
