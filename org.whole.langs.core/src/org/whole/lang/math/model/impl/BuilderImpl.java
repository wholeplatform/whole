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
public class BuilderImpl extends AbstractSimpleEntity implements Builder {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Builder> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Builder;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Builder_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Expression element;

	public Expression getElement() {
		return notifyRequested(MathFeatureDescriptorEnum.element, element);
	}

	public void setElement(Expression element) {
		notifyChanged(MathFeatureDescriptorEnum.element, this.element,
				this.element = element);
	}

	private Expression rule;

	public Expression getRule() {
		return notifyRequested(MathFeatureDescriptorEnum.rule, rule);
	}

	public void setRule(Expression rule) {
		notifyChanged(MathFeatureDescriptorEnum.rule, this.rule,
				this.rule = rule);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getElement().wGetAdaptee(false);
		case 1:
			return getRule().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setElement(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		case 1:
			setRule(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
