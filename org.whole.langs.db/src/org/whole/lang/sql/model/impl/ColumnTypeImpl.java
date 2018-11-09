package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.ColumnType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.Type;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.IntValue;

/** 
 * @generator Whole
 */
public class ColumnTypeImpl extends AbstractSimpleEntity implements ColumnType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ColumnType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnType;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ColumnType_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type type;

	public Type getType() {
		return notifyRequested(SQLFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(SQLFeatureDescriptorEnum.type, this.type, this.type = type);
	}

	private IntValue size;

	public IntValue getSize() {
		return notifyRequested(SQLFeatureDescriptorEnum.size, size);
	}

	public void setSize(IntValue size) {
		notifyChanged(SQLFeatureDescriptorEnum.size, this.size, this.size = size);
	}

	private IntValue precision;

	public IntValue getPrecision() {
		return notifyRequested(SQLFeatureDescriptorEnum.precision, precision);
	}

	public void setPrecision(IntValue precision) {
		notifyChanged(SQLFeatureDescriptorEnum.precision, this.precision, this.precision = precision);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getSize().wGetAdaptee(false);
		case 2:
			return getPrecision().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(SQLEntityDescriptorEnum.Type));
			break;
		case 1:
			setSize(value.wGetAdapter(SQLEntityDescriptorEnum.IntValue));
			break;
		case 2:
			setPrecision(value.wGetAdapter(SQLEntityDescriptorEnum.IntValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
