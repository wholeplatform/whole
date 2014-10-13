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
public class LambdaExpressionImpl extends AbstractSimpleEntity implements
		LambdaExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LambdaExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LambdaExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.LambdaExpression_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private LambdaParameters parameters;

	public LambdaParameters getParameters() {
		return notifyRequested(JavaFeatureDescriptorEnum.parameters, parameters);
	}

	public void setParameters(LambdaParameters parameters) {
		notifyChanged(JavaFeatureDescriptorEnum.parameters, this.parameters,
				this.parameters = parameters);
	}

	private ExpressionOrStatement body;

	public ExpressionOrStatement getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(ExpressionOrStatement body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getParameters().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setParameters(value
					.wGetAdapter(JavaEntityDescriptorEnum.LambdaParameters));
			break;
		case 1:
			setBody(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExpressionOrStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
