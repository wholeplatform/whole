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
package org.whole.lang.json.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class JSONEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Value_ord = 0;
    public static final int Object_ord = 1;
    public static final int Pair_ord = 2;
    public static final int Name_ord = 3;
    public static final int Array_ord = 4;
    public static final int String_ord = 5;
    public static final int Decimal_ord = 6;
    public static final int Int_ord = 7;
    public static final int Bool_ord = 8;
    public static final int Null_ord = 9;
    public static final JSONEntityDescriptorEnum instance = new JSONEntityDescriptorEnum();
    public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance.valueOf(Value_ord);
    public static final EntityDescriptor<Object> Object = (EntityDescriptor<Object>) instance.valueOf(Object_ord);
    public static final EntityDescriptor<Pair> Pair = (EntityDescriptor<Pair>) instance.valueOf(Pair_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<Array> Array = (EntityDescriptor<Array>) instance.valueOf(Array_ord);
    public static final EntityDescriptor<String> String = (EntityDescriptor<String>) instance.valueOf(String_ord);
    public static final EntityDescriptor<Decimal> Decimal = (EntityDescriptor<Decimal>) instance.valueOf(Decimal_ord);
    public static final EntityDescriptor<Int> Int = (EntityDescriptor<Int>) instance.valueOf(Int_ord);
    public static final EntityDescriptor<Bool> Bool = (EntityDescriptor<Bool>) instance.valueOf(Bool_ord);
    public static final EntityDescriptor<Null> Null = (EntityDescriptor<Null>) instance.valueOf(Null_ord);

    private JSONEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Value_ord, "Value", Value.class, true, Bool_ord, Decimal_ord, String_ord, Array_ord, Int_ord, Object_ord, Null_ord);
        putCompositeEntity(
		Object_ord, "Object", Object.class, false, Pair_ord, true, false);
        putSimpleEntity(Pair_ord, "Pair", Pair.class, false).withFeature(JSONFeatureDescriptorEnum.name, Name_ord).withFeature(JSONFeatureDescriptorEnum.value, Value_ord);
        putDataEntity(Name_ord, "Name", Name.class, false, java.lang.String.class);
        putCompositeEntity(
		Array_ord, "Array", Array.class, false, Value_ord, true, false);
        putDataEntity(String_ord, "String", String.class, false, java.lang.String.class);
        putDataEntity(Decimal_ord, "Decimal", Decimal.class, false, double.class);
        putDataEntity(Int_ord, "Int", Int.class, false, long.class);
        putDataEntity(Bool_ord, "Bool", Bool.class, false, boolean.class);
        putSimpleEntity(Null_ord, "Null", Null.class, false);
    }

    protected void initForeignTypeRelations() {
        setAssignableFromAll(true, Value_ord);
    }
}
