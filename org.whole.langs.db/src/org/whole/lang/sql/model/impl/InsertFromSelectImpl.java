package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.InsertFromSelect;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.TableName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.ColumnNames;
import org.whole.lang.sql.model.SelectSQLStatement;

/** 
 * @generator Whole
 */
public class InsertFromSelectImpl extends AbstractSimpleEntity implements InsertFromSelect {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InsertFromSelect> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.InsertFromSelect;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.InsertFromSelect_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private TableName tableName;

	public TableName getTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public void setTableName(TableName tableName) {
		notifyChanged(SQLFeatureDescriptorEnum.tableName, this.tableName, this.tableName = tableName);
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.columnNames, this.columnNames, this.columnNames = columnNames);
	}

	private SelectSQLStatement select;

	public SelectSQLStatement getSelect() {
		return notifyRequested(SQLFeatureDescriptorEnum.select, select);
	}

	public void setSelect(SelectSQLStatement select) {
		notifyChanged(SQLFeatureDescriptorEnum.select, this.select, this.select = select);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		case 1:
			return getColumnNames().wGetAdaptee(false);
		case 2:
			return getSelect().wGetAdaptee(false);
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
			setColumnNames(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 2:
			setSelect(value.wGetAdapter(SQLEntityDescriptorEnum.SelectSQLStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
