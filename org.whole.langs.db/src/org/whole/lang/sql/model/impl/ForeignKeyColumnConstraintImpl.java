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
public class ForeignKeyColumnConstraintImpl extends AbstractSimpleEntity
		implements ForeignKeyColumnConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForeignKeyColumnConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ForeignKeyColumnConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ForeignKeyColumnConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private TableName foreignTableName;

	public TableName getForeignTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignTableName,
				foreignTableName);
	}

	public void setForeignTableName(TableName foreignTableName) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignTableName,
				this.foreignTableName, this.foreignTableName = foreignTableName);
	}

	private ColumnName foreignColumnName;

	public ColumnName getForeignColumnName() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignColumnName,
				foreignColumnName);
	}

	public void setForeignColumnName(ColumnName foreignColumnName) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignColumnName,
				this.foreignColumnName,
				this.foreignColumnName = foreignColumnName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getForeignTableName().wGetAdaptee(false);
		case 1:
			return getForeignColumnName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setForeignTableName(value
					.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 1:
			setForeignColumnName(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
