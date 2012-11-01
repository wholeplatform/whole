package org.whole.lang.environment.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.environment.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentEntityFactory extends GenericEntityFactory {
	public static final EnvironmentEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static EnvironmentEntityFactory instance(
			IEntityRegistryProvider provider) {
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
		return create(EnvironmentEntityDescriptorEnum.Tuple,
				(IEntity[]) entities);
	}

	public Tuple createTuple(int initialSize) {
		return clone(EnvironmentEntityDescriptorEnum.Tuple, initialSize);
	}

	public ContainmentTuple createContainmentTuple() {
		return create(EnvironmentEntityDescriptorEnum.ContainmentTuple);
	}

	public ContainmentTuple createContainmentTuple(Data... entities) {
		return create(EnvironmentEntityDescriptorEnum.ContainmentTuple,
				(IEntity[]) entities);
	}

	public ContainmentTuple createContainmentTuple(int initialSize) {
		return clone(EnvironmentEntityDescriptorEnum.ContainmentTuple,
				initialSize);
	}

	public Void createVoid() {
		return create(EnvironmentEntityDescriptorEnum.Void);
	}
}
