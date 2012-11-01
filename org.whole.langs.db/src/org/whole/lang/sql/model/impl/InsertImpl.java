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
public class InsertImpl extends AbstractSimpleEntity implements Insert {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Insert> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Insert;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Insert_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private TableName tableName;

	public TableName getTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public void setTableName(TableName tableName) {
		notifyChanged(SQLFeatureDescriptorEnum.tableName, this.tableName,
				this.tableName = tableName);
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

	private Values values;

	public Values getValues() {
		return notifyRequested(SQLFeatureDescriptorEnum.values, values);
	}

	public void setValues(Values values) {
		notifyChanged(SQLFeatureDescriptorEnum.values, this.values,
				this.values = values);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		case 1:
			return getColumnNames().wGetAdaptee(false);
		case 2:
			return getValues().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTableName(value.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 1:
			setColumnNames(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 2:
			setValues(value.wGetAdapter(SQLEntityDescriptorEnum.Values));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
