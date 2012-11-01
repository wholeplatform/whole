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
public class BinaryExpressionImpl extends AbstractSimpleEntity implements
		BinaryExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BinaryExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BinaryExpression;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.BinaryExpression_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private SQLExpression leftExpr;

	public SQLExpression getLeftExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public void setLeftExpr(SQLExpression leftExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.leftExpr, this.leftExpr,
				this.leftExpr = leftExpr);
	}

	private BinaryOperator operator;

	public BinaryOperator getOperator() {
		return notifyRequested(SQLFeatureDescriptorEnum.operator, operator);
	}

	public void setOperator(BinaryOperator operator) {
		notifyChanged(SQLFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private SQLExpression rightExpr;

	public SQLExpression getRightExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.rightExpr, rightExpr);
	}

	public void setRightExpr(SQLExpression rightExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.rightExpr, this.rightExpr,
				this.rightExpr = rightExpr);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftExpr().wGetAdaptee(false);
		case 1:
			return getOperator().wGetAdaptee(false);
		case 2:
			return getRightExpr().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftExpr(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(SQLEntityDescriptorEnum.BinaryOperator));
			break;
		case 2:
			setRightExpr(value
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
