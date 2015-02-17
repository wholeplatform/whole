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

    public Id createId() {
        return create(EnvironmentEntityDescriptorEnum.Id);
    }

    public Id createId(String value) {
        return create(EnvironmentEntityDescriptorEnum.Id, value);
    }

    public Name createName() {
        return create(EnvironmentEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(EnvironmentEntityDescriptorEnum.Name, value);
    }

    public Value createValue() {
        return create(EnvironmentEntityDescriptorEnum.Value);
    }

    public Value createValue(org.whole.lang.model.IEntity value) {
        return create(EnvironmentEntityDescriptorEnum.Value, (java.lang.Object) value);
    }
}
