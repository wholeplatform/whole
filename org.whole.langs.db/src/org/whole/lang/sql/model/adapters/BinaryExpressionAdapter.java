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
public class BinaryExpressionAdapter extends AbstractEntityAdapter implements
		BinaryExpression {
	private static final long serialVersionUID = 1;

	public BinaryExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public BinaryExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BinaryExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BinaryExpression;
	}

	public SQLExpression getLeftExpr() {
		return wGet(SQLFeatureDescriptorEnum.leftExpr).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setLeftExpr(SQLExpression leftExpr) {
		wSet(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public BinaryOperator getOperator() {
		return wGet(SQLFeatureDescriptorEnum.operator).wGetAdapter(
				SQLEntityDescriptorEnum.BinaryOperator);
	}

	public void setOperator(BinaryOperator operator) {
		wSet(SQLFeatureDescriptorEnum.operator, operator);
	}

	public SQLExpression getRightExpr() {
		return wGet(SQLFeatureDescriptorEnum.rightExpr).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setRightExpr(SQLExpression rightExpr) {
		wSet(SQLFeatureDescriptorEnum.rightExpr, rightExpr);
	}
}
