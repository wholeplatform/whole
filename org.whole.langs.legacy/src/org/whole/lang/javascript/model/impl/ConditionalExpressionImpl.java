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
public class ConditionalExpressionImpl extends AbstractSimpleEntity implements
		ConditionalExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ConditionalExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ConditionalExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ConditionalExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression test;

	public Expression getTest() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public void setTest(Expression test) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.test, this.test,
				this.test = test);
	}

	private Expression consequent;

	public Expression getConsequent() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.consequent,
				consequent);
	}

	public void setConsequent(Expression consequent) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.consequent,
				this.consequent, this.consequent = consequent);
	}

	private Expression alternate;

	public Expression getAlternate() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.alternate,
				alternate);
	}

	public void setAlternate(Expression alternate) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.alternate,
				this.alternate, this.alternate = alternate);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTest().wGetAdaptee(false);
		case 1:
			return getConsequent().wGetAdaptee(false);
		case 2:
			return getAlternate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTest(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setConsequent(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 2:
			setAlternate(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
