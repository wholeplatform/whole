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
public class LeftOuterJoinFromClauseAdapter extends AbstractEntityAdapter
		implements LeftOuterJoinFromClause {
	private static final long serialVersionUID = 1;

	public LeftOuterJoinFromClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public LeftOuterJoinFromClauseAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LeftOuterJoinFromClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.LeftOuterJoinFromClause;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public TableName getOuterTable() {
		return wGet(SQLFeatureDescriptorEnum.outerTable).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setOuterTable(TableName outerTable) {
		wSet(SQLFeatureDescriptorEnum.outerTable, outerTable);
	}

	public SQLExpression getOnExpression() {
		return wGet(SQLFeatureDescriptorEnum.onExpression).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setOnExpression(SQLExpression onExpression) {
		wSet(SQLFeatureDescriptorEnum.onExpression, onExpression);
	}
}
