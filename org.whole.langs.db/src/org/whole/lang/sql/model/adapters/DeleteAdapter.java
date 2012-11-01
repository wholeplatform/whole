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
public class DeleteAdapter extends AbstractEntityAdapter implements Delete {
	private static final long serialVersionUID = 1;

	public DeleteAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeleteAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Delete> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Delete;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public SQLExpression getWhereExpr() {
		return wGet(SQLFeatureDescriptorEnum.whereExpr).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		wSet(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public IntValue getLimit() {
		return wGet(SQLFeatureDescriptorEnum.limit).wGetAdapter(
				SQLEntityDescriptorEnum.IntValue);
	}

	public void setLimit(IntValue limit) {
		wSet(SQLFeatureDescriptorEnum.limit, limit);
	}
}
