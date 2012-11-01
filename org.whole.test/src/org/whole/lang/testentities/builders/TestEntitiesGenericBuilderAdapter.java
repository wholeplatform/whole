package org.whole.lang.testentities.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.model.MapTestEntity;
import java.util.Date;
import org.whole.lang.model.EnumValue;
import org.whole.lang.testentities.model.EnumTestEntityEnum.Value;

/** 
 * @generator Whole
 */
public class TestEntitiesGenericBuilderAdapter extends GenericIdentityBuilder {
	private ITestEntitiesBuilder specificBuilder;

	public TestEntitiesGenericBuilderAdapter(
			ITestEntitiesBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public TestEntitiesGenericBuilderAdapter(
			ITestEntitiesBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case TestEntitiesFeatureDescriptorEnum.anyEntityValue_ord:
			specificBuilder.anyEntityValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.structuralEntityValue_ord:
			specificBuilder.structuralEntityValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.compositeEntityValue_ord:
			specificBuilder.compositeEntityValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.dataEntityValue_ord:
			specificBuilder.dataEntityValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.booleanValue_ord:
			specificBuilder.booleanValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.byteValue_ord:
			specificBuilder.byteValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.charValue_ord:
			specificBuilder.charValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.doubleValue_ord:
			specificBuilder.doubleValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.floatValue_ord:
			specificBuilder.floatValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.intValue_ord:
			specificBuilder.intValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.longValue_ord:
			specificBuilder.longValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.shortValue_ord:
			specificBuilder.shortValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.stringValue_ord:
			specificBuilder.stringValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.dateValue_ord:
			specificBuilder.dateValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.enumValue_ord:
			specificBuilder.enumValue();
			break;
		case TestEntitiesFeatureDescriptorEnum.objectValue_ord:
			specificBuilder.objectValue();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.SimpleTestEntity_ord:
			specificBuilder.SimpleTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.ListTestEntity_ord:
			specificBuilder.ListTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.UListTestEntity_ord:
			specificBuilder.UListTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.SetTestEntity_ord:
			specificBuilder.SetTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.BagTestEntity_ord:
			specificBuilder.BagTestEntity();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.SimpleTestEntity_ord:
			specificBuilder.SimpleTestEntity_();
			break;
		case TestEntitiesEntityDescriptorEnum.ListTestEntity_ord:
			specificBuilder.ListTestEntity_();
			break;
		case TestEntitiesEntityDescriptorEnum.UListTestEntity_ord:
			specificBuilder.UListTestEntity_();
			break;
		case TestEntitiesEntityDescriptorEnum.SetTestEntity_ord:
			specificBuilder.SetTestEntity_();
			break;
		case TestEntitiesEntityDescriptorEnum.BagTestEntity_ord:
			specificBuilder.BagTestEntity_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.SimpleTestEntity_ord:
			specificBuilder._SimpleTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.ListTestEntity_ord:
			specificBuilder._ListTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.UListTestEntity_ord:
			specificBuilder._UListTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.SetTestEntity_ord:
			specificBuilder._SetTestEntity();
			break;
		case TestEntitiesEntityDescriptorEnum.BagTestEntity_ord:
			specificBuilder._BagTestEntity();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.ListTestEntity_ord:
			specificBuilder.ListTestEntity_(initialCapacity);
			break;
		case TestEntitiesEntityDescriptorEnum.UListTestEntity_ord:
			specificBuilder.UListTestEntity_(initialCapacity);
			break;
		case TestEntitiesEntityDescriptorEnum.SetTestEntity_ord:
			specificBuilder.SetTestEntity_(initialCapacity);
			break;
		case TestEntitiesEntityDescriptorEnum.BagTestEntity_ord:
			specificBuilder.BagTestEntity_(initialCapacity);
			break;
		}
	}

	public void visit(MapTestEntity entity) {
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.BooleanTestEntity_ord:
			specificBuilder.BooleanTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.ByteTestEntity_ord:
			specificBuilder.ByteTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.CharTestEntity_ord:
			specificBuilder.CharTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.DoubleTestEntity_ord:
			specificBuilder.DoubleTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.FloatTestEntity_ord:
			specificBuilder.FloatTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.IntTestEntity_ord:
			specificBuilder.IntTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.LongTestEntity_ord:
			specificBuilder.LongTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.ShortTestEntity_ord:
			specificBuilder.ShortTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.StringTestEntity_ord:
			specificBuilder.StringTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.DateTestEntity_ord:
			specificBuilder.DateTestEntity(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.EnumTestEntity_ord:
			specificBuilder.EnumTestEntity((Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		switch (entityDesc.getOrdinal()) {
		case TestEntitiesEntityDescriptorEnum.ObjectTestEntity_ord:
			specificBuilder.ObjectTestEntity(value);
			break;
		}
	}
}
