package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RootImpl extends AbstractSimpleEntity implements Root {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Root> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Root;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Root_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(MathFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(MathFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Expression degree;

	public Expression getDegree() {
		return notifyRequested(MathFeatureDescriptorEnum.degree, degree);
	}

	public void setDegree(Expression degree) {
		notifyChanged(MathFeatureDescriptorEnum.degree, this.degree,
				this.degree = degree);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getDegree().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setDegree(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
