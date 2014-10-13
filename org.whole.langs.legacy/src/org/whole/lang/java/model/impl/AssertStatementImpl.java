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
public class AssertStatementImpl extends AbstractSimpleEntity implements
		AssertStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AssertStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AssertStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.AssertStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Expression message;

	public Expression getMessage() {
		return notifyRequested(JavaFeatureDescriptorEnum.message, message);
	}

	public void setMessage(Expression message) {
		notifyChanged(JavaFeatureDescriptorEnum.message, this.message,
				this.message = message);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getMessage().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setMessage(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
