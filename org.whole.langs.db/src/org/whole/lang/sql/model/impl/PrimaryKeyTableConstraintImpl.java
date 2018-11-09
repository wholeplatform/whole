package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.PrimaryKeyTableConstraint;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.ConstraintName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.ColumnNames;

/** 
 * @generator Whole
 */
public class PrimaryKeyTableConstraintImpl extends AbstractSimpleEntity implements PrimaryKeyTableConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrimaryKeyTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.PrimaryKeyTableConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getConstraintName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getConstraintName().wEquals(entity.wGet(SQLFeatureDescriptorEnum.constraintName));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("constraintName=");
		buffer.append(constraintName);
	}

	private ConstraintName constraintName;

	public ConstraintName getConstraintName() {
		return notifyRequested(SQLFeatureDescriptorEnum.constraintName, constraintName);
	}

	public void setConstraintName(ConstraintName constraintName) {
		notifyChanged(SQLFeatureDescriptorEnum.constraintName, this.constraintName,
				this.constraintName = constraintName);
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.columnNames, this.columnNames, this.columnNames = columnNames);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getConstraintName().wGetAdaptee(false);
		case 1:
			return getColumnNames().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setConstraintName(value.wGetAdapter(SQLEntityDescriptorEnum.ConstraintName));
			break;
		case 1:
			setColumnNames(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
