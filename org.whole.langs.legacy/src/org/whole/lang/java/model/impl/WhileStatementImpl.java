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
public class WhileStatementImpl extends AbstractSimpleEntity implements
		WhileStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WhileStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.WhileStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.WhileStatement_ord;
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
			return getExpression().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
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
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
