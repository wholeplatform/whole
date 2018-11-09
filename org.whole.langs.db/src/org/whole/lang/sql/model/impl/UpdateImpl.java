package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.Update;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.TableName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.SetClauses;
import org.whole.lang.sql.model.FromClauses;
import org.whole.lang.sql.model.SQLExpression;
import org.whole.lang.sql.model.IntValue;

/** 
 * @generator Whole
 */
public class UpdateImpl extends AbstractSimpleEntity implements Update {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Update> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Update;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Update_ord;
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

	private SetClauses setClauses;

	public SetClauses getSetClauses() {
		return notifyRequested(SQLFeatureDescriptorEnum.setClauses, setClauses);
	}

	public void setSetClauses(SetClauses setClauses) {
		notifyChanged(SQLFeatureDescriptorEnum.setClauses, this.setClauses, this.setClauses = setClauses);
	}

	private FromClauses fromClauses;

	public FromClauses getFromClauses() {
		return notifyRequested(SQLFeatureDescriptorEnum.fromClauses, fromClauses);
	}

	public void setFromClauses(FromClauses fromClauses) {
		notifyChanged(SQLFeatureDescriptorEnum.fromClauses, this.fromClauses, this.fromClauses = fromClauses);
	}

	private SQLExpression whereExpr;

	public SQLExpression getWhereExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.whereExpr, this.whereExpr, this.whereExpr = whereExpr);
	}

	private IntValue limit;

	public IntValue getLimit() {
		return notifyRequested(SQLFeatureDescriptorEnum.limit, limit);
	}

	public void setLimit(IntValue limit) {
		notifyChanged(SQLFeatureDescriptorEnum.limit, this.limit, this.limit = limit);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		case 1:
			return getSetClauses().wGetAdaptee(false);
		case 2:
			return getFromClauses().wGetAdaptee(false);
		case 3:
			return getWhereExpr().wGetAdaptee(false);
		case 4:
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
			setSetClauses(value.wGetAdapter(SQLEntityDescriptorEnum.SetClauses));
			break;
		case 2:
			setFromClauses(value.wGetAdapter(SQLEntityDescriptorEnum.FromClauses));
			break;
		case 3:
			setWhereExpr(value.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 4:
			setLimit(value.wGetAdapter(SQLEntityDescriptorEnum.IntValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
