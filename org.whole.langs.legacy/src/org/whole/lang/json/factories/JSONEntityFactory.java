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
package org.whole.lang.json.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.json.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.json.model.String;

/**
 *  @generator Whole
 */
public class JSONEntityFactory extends GenericEntityFactory {
    public static final JSONEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static JSONEntityFactory instance(IEntityRegistryProvider provider) {
        return new JSONEntityFactory(provider);
    }

    protected JSONEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Object createObject() {
        return create(JSONEntityDescriptorEnum.Object);
    }

    public Object createObject(Pair... entities) {
        return create(JSONEntityDescriptorEnum.Object, (IEntity[]) entities);
    }

    public Object createObject(int initialSize) {
        return clone(JSONEntityDescriptorEnum.Object, initialSize);
    }

    public Pair createPair() {
        return create(JSONEntityDescriptorEnum.Pair);
    }

    public Pair createPair(Name name, Value value) {
        return create(JSONEntityDescriptorEnum.Pair, name, value);
    }

    public IEntityBuilder<Pair> buildPair() {
        return new EntityBuilder<Pair>(create(JSONEntityDescriptorEnum.Pair));
    }

    public Name createName() {
        return create(JSONEntityDescriptorEnum.Name);
    }

    public Name createName(java.lang.String value) {
        return create(JSONEntityDescriptorEnum.Name, value);
    }

    public Array createArray() {
        return create(JSONEntityDescriptorEnum.Array);
    }

    public Array createArray(Value... entities) {
        return create(JSONEntityDescriptorEnum.Array, (IEntity[]) entities);
    }

    public Array createArray(int initialSize) {
        return clone(JSONEntityDescriptorEnum.Array, initialSize);
    }

    public String createString() {
        return create(JSONEntityDescriptorEnum.String);
    }

    public String createString(java.lang.String value) {
        return create(JSONEntityDescriptorEnum.String, value);
    }

    public Decimal createDecimal() {
        return create(JSONEntityDescriptorEnum.Decimal);
    }

    public Decimal createDecimal(double value) {
        return create(JSONEntityDescriptorEnum.Decimal, value);
    }

    public Int createInt() {
        return create(JSONEntityDescriptorEnum.Int);
    }

    public Int createInt(long value) {
        return create(JSONEntityDescriptorEnum.Int, value);
    }

    public Bool createBool() {
        return create(JSONEntityDescriptorEnum.Bool);
    }

    public Bool createBool(boolean value) {
        return create(JSONEntityDescriptorEnum.Bool, value);
    }

    public Null createNull() {
        return create(JSONEntityDescriptorEnum.Null);
    }
}
