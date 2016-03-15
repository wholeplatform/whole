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
package org.whole.lang.json.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class JSONSpecificBuilderAdapter extends GenericBuilderContext implements IJSONBuilder {

    public JSONSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public JSONSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void value() {
        wFeature(JSONFeatureDescriptorEnum.value);
    }

    public void name() {
        wFeature(JSONFeatureDescriptorEnum.name);
    }

    public void visit() {
    }

    public void Object() {
        wEntity(JSONEntityDescriptorEnum.Object);
    }

    public void Object_() {
        wEntity_(JSONEntityDescriptorEnum.Object);
    }

    public void Object_(int initialCapacity) {
        wEntity_(JSONEntityDescriptorEnum.Object, initialCapacity);
    }

    public void _Object() {
        _wEntity(JSONEntityDescriptorEnum.Object);
    }

    public void Pair() {
        wEntity(JSONEntityDescriptorEnum.Pair);
    }

    public void Pair_() {
        wEntity_(JSONEntityDescriptorEnum.Pair);
    }

    public void _Pair() {
        _wEntity(JSONEntityDescriptorEnum.Pair);
    }

    public void Name() {
        wEntity(JSONEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(JSONEntityDescriptorEnum.Name, value);
    }

    public void Array() {
        wEntity(JSONEntityDescriptorEnum.Array);
    }

    public void Array_() {
        wEntity_(JSONEntityDescriptorEnum.Array);
    }

    public void Array_(int initialCapacity) {
        wEntity_(JSONEntityDescriptorEnum.Array, initialCapacity);
    }

    public void _Array() {
        _wEntity(JSONEntityDescriptorEnum.Array);
    }

    public void String() {
        wEntity(JSONEntityDescriptorEnum.String);
    }

    public void String(String value) {
        wEntity(JSONEntityDescriptorEnum.String, value);
    }

    public void Decimal() {
        wEntity(JSONEntityDescriptorEnum.Decimal);
    }

    public void Decimal(double value) {
        wEntity(JSONEntityDescriptorEnum.Decimal, value);
    }

    public void Int() {
        wEntity(JSONEntityDescriptorEnum.Int);
    }

    public void Int(long value) {
        wEntity(JSONEntityDescriptorEnum.Int, value);
    }

    public void Bool() {
        wEntity(JSONEntityDescriptorEnum.Bool);
    }

    public void Bool(boolean value) {
        wEntity(JSONEntityDescriptorEnum.Bool, value);
    }

    public void Null() {
        wEntity(JSONEntityDescriptorEnum.Null);
    }

    public void Null_() {
        wEntity_(JSONEntityDescriptorEnum.Null);
    }

    public void _Null() {
        _wEntity(JSONEntityDescriptorEnum.Null);
    }
}
