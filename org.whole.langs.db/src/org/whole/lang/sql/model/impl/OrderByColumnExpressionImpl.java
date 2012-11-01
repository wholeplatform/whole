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
public class OrderByColumnExpressionImpl extends AbstractSimpleEntity implements
		OrderByColumnExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<OrderByColumnExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.OrderByColumnExpression;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.OrderByColumnExpression_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private SQLExpression expression;

	public SQLExpression getExpression() {
		return notifyRequested(SQLFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(SQLExpression expression) {
		notifyChanged(SQLFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private OrderType orderType;

	public OrderType getOrderType() {
		return notifyRequested(SQLFeatureDescriptorEnum.orderType, orderType);
	}

	public void setOrderType(OrderType orderType) {
		notifyChanged(SQLFeatureDescriptorEnum.orderType, this.orderType,
				this.orderType = orderType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getOrderType().wGetAdaptee(false);
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
			setOrderType(value.wGetAdapter(SQLEntityDescriptorEnum.OrderType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
