package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ColumnDeclarationImpl extends AbstractSimpleEntity implements
		ColumnDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ColumnDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnDeclaration;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ColumnDeclaration_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ColumnName columnName;

	public ColumnName getColumnName() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public void setColumnName(ColumnName columnName) {
		notifyChanged(SQLFeatureDescriptorEnum.columnName, this.columnName,
				this.columnName = columnName);
	}

	private ColumnType columnType;

	public ColumnType getColumnType() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnType, columnType);
	}

	public void setColumnType(ColumnType columnType) {
		notifyChanged(SQLFeatureDescriptorEnum.columnType, this.columnType,
				this.columnType = columnType);
	}

	private ColumnConstraints columnConstraints;

	public ColumnConstraints getColumnConstraints() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnConstraints,
				columnConstraints);
	}

	public void setColumnConstraints(ColumnConstraints columnConstraints) {
		notifyChanged(SQLFeatureDescriptorEnum.columnConstraints,
				this.columnConstraints,
				this.columnConstraints = columnConstraints);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getColumnName().wGetAdaptee(false);
		case 1:
			return getColumnType().wGetAdaptee(false);
		case 2:
			return getColumnConstraints().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setColumnName(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnName));
			break;
		case 1:
			setColumnType(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnType));
			break;
		case 2:
			setColumnConstraints(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnConstraints));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
