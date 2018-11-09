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
public class OrderByColumnExpressionAdapter extends AbstractEntityAdapter implements OrderByColumnExpression {
	private static final long serialVersionUID = 1;

	public OrderByColumnExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrderByColumnExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OrderByColumnExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.OrderByColumnExpression;
	}

	public SQLExpression getExpression() {
		return wGet(SQLFeatureDescriptorEnum.expression).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setExpression(SQLExpression expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}

	public OrderType getOrderType() {
		return wGet(SQLFeatureDescriptorEnum.orderType).wGetAdapter(SQLEntityDescriptorEnum.OrderType);
	}

	public void setOrderType(OrderType orderType) {
		wSet(SQLFeatureDescriptorEnum.orderType, orderType);
	}
}
