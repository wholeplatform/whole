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
public class PrimaryKeyTableConstraintImpl extends AbstractSimpleEntity
		implements PrimaryKeyTableConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrimaryKeyTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.PrimaryKeyTableConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.PrimaryKeyTableConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
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
