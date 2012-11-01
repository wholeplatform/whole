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
public class BooleanBinaryExpressionAdapter extends AbstractEntityAdapter
		implements BooleanBinaryExpression {
	private static final long serialVersionUID = 1;

	public BooleanBinaryExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanBinaryExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanBinaryExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BooleanBinaryExpression;
	}

	public SQLExpression getLeftExpr() {
		return wGet(SQLFeatureDescriptorEnum.leftExpr).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setLeftExpr(SQLExpression leftExpr) {
		wSet(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public BooleanOperator getOperator() {
		return wGet(SQLFeatureDescriptorEnum.operator).wGetAdapter(
				SQLEntityDescriptorEnum.BooleanOperator);
	}

	public void setOperator(BooleanOperator operator) {
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
