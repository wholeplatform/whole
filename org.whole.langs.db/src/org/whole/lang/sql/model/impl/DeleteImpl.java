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
public class DeleteImpl extends AbstractSimpleEntity implements Delete {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Delete> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Delete;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Delete_ord;
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

	private SQLExpression whereExpr;

	public SQLExpression getWhereExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.whereExpr, this.whereExpr,
				this.whereExpr = whereExpr);
	}

	private IntValue limit;

	public IntValue getLimit() {
		return notifyRequested(SQLFeatureDescriptorEnum.limit, limit);
	}

	public void setLimit(IntValue limit) {
		notifyChanged(SQLFeatureDescriptorEnum.limit, this.limit,
				this.limit = limit);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		case 1:
			return getWhereExpr().wGetAdaptee(false);
		case 2:
			return getLimit().wGetAdaptee(false);
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
			setWhereExpr(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 2:
			setLimit(value.wGetAdapter(SQLEntityDescriptorEnum.IntValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
