package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.SetClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.ColumnName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.SQLExpression;

/** 
 * @generator Whole
 */
public class SetClauseImpl extends AbstractSimpleEntity implements SetClause {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SetClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SetClause;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.SetClause_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getColumnName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getColumnName().wEquals(entity.wGet(SQLFeatureDescriptorEnum.columnName));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("columnName=");
		buffer.append(columnName);
	}

	private ColumnName columnName;

	public ColumnName getColumnName() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public void setColumnName(ColumnName columnName) {
		notifyChanged(SQLFeatureDescriptorEnum.columnName, this.columnName, this.columnName = columnName);
	}

	private SQLExpression expression;

	public SQLExpression getExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(SQLExpression expression) {
		notifyChanged(SQLFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getColumnName().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setColumnName(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnName));
			break;
		case 1:
			setExpression(value.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
