package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EnhancedForStatementImpl extends AbstractSimpleEntity implements
		EnhancedForStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnhancedForStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.EnhancedForStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.EnhancedForStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SingleVariableDeclaration parameter;

	public SingleVariableDeclaration getParameter() {
		return notifyRequested(JavaFeatureDescriptorEnum.parameter, parameter);
	}

	public void setParameter(SingleVariableDeclaration parameter) {
		notifyChanged(JavaFeatureDescriptorEnum.parameter, this.parameter,
				this.parameter = parameter);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getParameter().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setParameter(value
					.wGetAdapter(JavaEntityDescriptorEnum.SingleVariableDeclaration));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 2:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
