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
public class ForStatementImpl extends AbstractSimpleEntity implements
		ForStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ForStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.ForStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expressions initializers;

	public Expressions getInitializers() {
		return notifyRequested(JavaFeatureDescriptorEnum.initializers,
				initializers);
	}

	public void setInitializers(Expressions initializers) {
		notifyChanged(JavaFeatureDescriptorEnum.initializers,
				this.initializers, this.initializers = initializers);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Expressions updaters;

	public Expressions getUpdaters() {
		return notifyRequested(JavaFeatureDescriptorEnum.updaters, updaters);
	}

	public void setUpdaters(Expressions updaters) {
		notifyChanged(JavaFeatureDescriptorEnum.updaters, this.updaters,
				this.updaters = updaters);
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
			return getInitializers().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		case 2:
			return getUpdaters().wGetAdaptee(false);
		case 3:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setInitializers(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 2:
			setUpdaters(value.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
			break;
		case 3:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
