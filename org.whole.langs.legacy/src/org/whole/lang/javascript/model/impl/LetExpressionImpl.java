package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LetExpressionImpl extends AbstractSimpleEntity implements
		LetExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LetExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.LetExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.LetExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VariableInitializers variables;

	public VariableInitializers getVariables() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.variables,
				variables);
	}

	public void setVariables(VariableInitializers variables) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.variables,
				this.variables, this.variables = variables);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVariables().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVariables(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableInitializers));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
