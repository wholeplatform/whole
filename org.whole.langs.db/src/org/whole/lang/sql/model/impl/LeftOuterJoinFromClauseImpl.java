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
public class LeftOuterJoinFromClauseImpl extends AbstractSimpleEntity implements
		LeftOuterJoinFromClause {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LeftOuterJoinFromClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.LeftOuterJoinFromClause;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.LeftOuterJoinFromClause_ord;
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

	private TableName outerTable;

	public TableName getOuterTable() {
		return notifyRequested(SQLFeatureDescriptorEnum.outerTable, outerTable);
	}

	public void setOuterTable(TableName outerTable) {
		notifyChanged(SQLFeatureDescriptorEnum.outerTable, this.outerTable,
				this.outerTable = outerTable);
	}

	private SQLExpression onExpression;

	public SQLExpression getOnExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.onExpression,
				onExpression);
	}

	public void setOnExpression(SQLExpression onExpression) {
		notifyChanged(SQLFeatureDescriptorEnum.onExpression, this.onExpression,
				this.onExpression = onExpression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		case 1:
			return getOuterTable().wGetAdaptee(false);
		case 2:
			return getOnExpression().wGetAdaptee(false);
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
			setOuterTable(value.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 2:
			setOnExpression(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
