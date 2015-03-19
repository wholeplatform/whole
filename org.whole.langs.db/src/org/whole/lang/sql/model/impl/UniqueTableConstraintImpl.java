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
public class UniqueTableConstraintImpl extends AbstractSimpleEntity implements
		UniqueTableConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UniqueTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UniqueTableConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.UniqueTableConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnNames,
				columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.columnNames, this.columnNames,
				this.columnNames = columnNames);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getColumnNames().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setColumnNames(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
