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
public class InnerJoinFromClauseAdapter extends AbstractEntityAdapter implements
		InnerJoinFromClause {
	private static final long serialVersionUID = 1;

	public InnerJoinFromClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public InnerJoinFromClauseAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InnerJoinFromClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.InnerJoinFromClause;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public TableName getInnerTable() {
		return wGet(SQLFeatureDescriptorEnum.innerTable).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setInnerTable(TableName innerTable) {
		wSet(SQLFeatureDescriptorEnum.innerTable, innerTable);
	}

	public SQLExpression getOnExpression() {
		return wGet(SQLFeatureDescriptorEnum.onExpression).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setOnExpression(SQLExpression onExpression) {
		wSet(SQLFeatureDescriptorEnum.onExpression, onExpression);
	}
}
