package org.whole.lang.environment.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;

/** 
 * @generator Whole
 */
public class EnvironmentGenericBuilderAdapter extends GenericIdentityBuilder {
	private IEnvironmentBuilder specificBuilder;

	public EnvironmentGenericBuilderAdapter(IEnvironmentBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public EnvironmentGenericBuilderAdapter(
			IEnvironmentBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.BooleanData_ord:
			specificBuilder.BooleanData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.ByteData_ord:
			specificBuilder.ByteData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.CharData_ord:
			specificBuilder.CharData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.DoubleData_ord:
			specificBuilder.DoubleData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.FloatData_ord:
			specificBuilder.FloatData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.IntData_ord:
			specificBuilder.IntData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.LongData_ord:
			specificBuilder.LongData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.ShortData_ord:
			specificBuilder.ShortData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.StringData_ord:
			specificBuilder.StringData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.DateData_ord:
			specificBuilder.DateData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.ObjectData_ord:
			specificBuilder.ObjectData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.Tuple_ord:
			specificBuilder.Tuple();
			break;
		case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord:
			specificBuilder.ContainmentTuple();
			break;
		case EnvironmentEntityDescriptorEnum.Void_ord:
			specificBuilder.Void();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.Tuple_ord:
			specificBuilder.Tuple_();
			break;
		case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord:
			specificBuilder.ContainmentTuple_();
			break;
		case EnvironmentEntityDescriptorEnum.Void_ord:
			specificBuilder.Void_();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.Tuple_ord:
			specificBuilder.Tuple_(initialCapacity);
			break;
		case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord:
			specificBuilder.ContainmentTuple_(initialCapacity);
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case EnvironmentEntityDescriptorEnum.Tuple_ord:
			specificBuilder._Tuple();
			break;
		case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord:
			specificBuilder._ContainmentTuple();
			break;
		case EnvironmentEntityDescriptorEnum.Void_ord:
			specificBuilder._Void();
			break;
		}
	}
}
