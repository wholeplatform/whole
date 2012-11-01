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
public class SwitchStatementImpl extends AbstractSimpleEntity implements
		SwitchStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SwitchStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.SwitchStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.SwitchStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
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

	private SwitchCases cases;

	public SwitchCases getCases() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.cases, cases);
	}

	public void setCases(SwitchCases cases) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.cases, this.cases,
				this.cases = cases);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getCases().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setCases(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.SwitchCases));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
