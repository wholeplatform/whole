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
public class BetweenImpl extends AbstractSimpleEntity implements Between {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Between> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Between;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Between_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SQLExpression expression;

	public SQLExpression getExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(SQLExpression expression) {
		notifyChanged(SQLFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private SQLExpression lowerExpression;

	public SQLExpression getLowerExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.lowerExpression,
				lowerExpression);
	}

	public void setLowerExpression(SQLExpression lowerExpression) {
		notifyChanged(SQLFeatureDescriptorEnum.lowerExpression,
				this.lowerExpression, this.lowerExpression = lowerExpression);
	}

	private SQLExpression upperExpression;

	public SQLExpression getUpperExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.upperExpression,
				upperExpression);
	}

	public void setUpperExpression(SQLExpression upperExpression) {
		notifyChanged(SQLFeatureDescriptorEnum.upperExpression,
				this.upperExpression, this.upperExpression = upperExpression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getLowerExpression().wGetAdaptee(false);
		case 2:
			return getUpperExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 1:
			setLowerExpression(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 2:
			setUpperExpression(value
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
