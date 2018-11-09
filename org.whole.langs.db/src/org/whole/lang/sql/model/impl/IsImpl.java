package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.Is;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.SQLExpression;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.IsType;

/** 
 * @generator Whole
 */
public class IsImpl extends AbstractSimpleEntity implements Is {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Is> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Is;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Is_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SQLExpression expression;

	public SQLExpression getExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(SQLExpression expression) {
		notifyChanged(SQLFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
	}

	private IsType type;

	public IsType getType() {
		return notifyRequested(SQLFeatureDescriptorEnum.type, type);
	}

	public void setType(IsType type) {
		notifyChanged(SQLFeatureDescriptorEnum.type, this.type, this.type = type);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 1:
			setType(value.wGetAdapter(SQLEntityDescriptorEnum.IsType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
