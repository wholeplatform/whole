package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EqualityPredicateApplicationImpl extends AbstractSimpleEntity
		implements EqualityPredicateApplication {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EqualityPredicateApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Term leftTerm;

	public Term getLeftTerm() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.leftTerm,
				leftTerm);
	}

	public void setLeftTerm(Term leftTerm) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.leftTerm,
				this.leftTerm, this.leftTerm = leftTerm);
	}

	private Term rightTerm;

	public Term getRightTerm() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.rightTerm,
				rightTerm);
	}

	public void setRightTerm(Term rightTerm) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.rightTerm,
				this.rightTerm, this.rightTerm = rightTerm);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftTerm().wGetAdaptee(false);
		case 1:
			return getRightTerm().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftTerm(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Term));
			break;
		case 1:
			setRightTerm(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Term));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
