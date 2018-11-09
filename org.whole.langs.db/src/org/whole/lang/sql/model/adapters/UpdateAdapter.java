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
public class UpdateAdapter extends AbstractEntityAdapter implements Update {
	private static final long serialVersionUID = 1;

	public UpdateAdapter(IEntity implementor) {
		super(implementor);
	}

	public UpdateAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Update> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Update;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public SetClauses getSetClauses() {
		return wGet(SQLFeatureDescriptorEnum.setClauses).wGetAdapter(SQLEntityDescriptorEnum.SetClauses);
	}

	public void setSetClauses(SetClauses setClauses) {
		wSet(SQLFeatureDescriptorEnum.setClauses, setClauses);
	}

	public FromClauses getFromClauses() {
		return wGet(SQLFeatureDescriptorEnum.fromClauses).wGetAdapter(SQLEntityDescriptorEnum.FromClauses);
	}

	public void setFromClauses(FromClauses fromClauses) {
		wSet(SQLFeatureDescriptorEnum.fromClauses, fromClauses);
	}

	public SQLExpression getWhereExpr() {
		return wGet(SQLFeatureDescriptorEnum.whereExpr).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		wSet(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public IntValue getLimit() {
		return wGet(SQLFeatureDescriptorEnum.limit).wGetAdapter(SQLEntityDescriptorEnum.IntValue);
	}

	public void setLimit(IntValue limit) {
		wSet(SQLFeatureDescriptorEnum.limit, limit);
	}
}
