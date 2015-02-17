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
    public static final int Bindings_ord = 15;
    public static final int Binding_ord = 16;
    public static final int Id_ord = 17;
    public static final int Name_ord = 18;
    public static final int Value_ord = 19;
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
    public static final EntityDescriptor<Bindings> Bindings = (EntityDescriptor<Bindings>) instance.valueOf(Bindings_ord);
    public static final EntityDescriptor<Binding> Binding = (EntityDescriptor<Binding>) instance.valueOf(Binding_ord);
    public static final EntityDescriptor<Id> Id = (EntityDescriptor<Id>) instance.valueOf(Id_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance.valueOf(Value_ord);

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
        putCompositeEntity(ContainmentTuple_ord, "ContainmentTuple", ContainmentTuple.class, false, Data_ord, true, false);
        putSimpleEntity(Void_ord, "Void", Void.class, false);
        putCompositeEntity(Bindings_ord, "Bindings", Bindings.class, false, Binding_ord, true, false);
        putSimpleEntity(Binding_ord, "Binding", Binding.class, false).withFeature(EnvironmentFeatureDescriptorEnum.name, Name_ord, false, true, false, false, false).withFeature(EnvironmentFeatureDescriptorEnum.value, Value_ord);
        putDataEntity(Id_ord, "Id", Id.class, false, String.class);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putDataEntity(Value_ord, "Value", Value.class, false, org.whole.lang.model.IEntity.class);
    }

    protected void initForeignTypeRelations() {
        setAssignableFromAll(true, Data_ord);
        setAssignableToAll(true, Void_ord);
    }
}
