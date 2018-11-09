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
public class AlterTableAdapter extends AbstractEntityAdapter implements AlterTable {
	private static final long serialVersionUID = 1;

	public AlterTableAdapter(IEntity implementor) {
		super(implementor);
	}

	public AlterTableAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AlterTable> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.AlterTable;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public AlterAction getAction() {
		return wGet(SQLFeatureDescriptorEnum.action).wGetAdapter(SQLEntityDescriptorEnum.AlterAction);
	}

	public void setAction(AlterAction action) {
		wSet(SQLFeatureDescriptorEnum.action, action);
	}
}
