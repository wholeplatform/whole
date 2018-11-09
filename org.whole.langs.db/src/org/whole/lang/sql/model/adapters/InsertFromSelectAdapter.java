package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class InsertFromSelectAdapter extends AbstractEntityAdapter implements InsertFromSelect {
	private static final long serialVersionUID = 1;

	public InsertFromSelectAdapter(IEntity implementor) {
		super(implementor);
	}

	public InsertFromSelectAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InsertFromSelect> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.InsertFromSelect;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public ColumnNames getColumnNames() {
		return wGet(SQLFeatureDescriptorEnum.columnNames).wGetAdapter(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		wSet(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public SelectSQLStatement getSelect() {
		return wGet(SQLFeatureDescriptorEnum.select).wGetAdapter(SQLEntityDescriptorEnum.SelectSQLStatement);
	}

	public void setSelect(SelectSQLStatement select) {
		wSet(SQLFeatureDescriptorEnum.select, select);
	}
}
