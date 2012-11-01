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
public class XorImpl extends AbstractSimpleEntity implements Xor {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Xor> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Xor;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.Xor_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Formula leftFormula;

	public Formula getLeftFormula() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.leftFormula, leftFormula);
	}

	public void setLeftFormula(Formula leftFormula) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.leftFormula,
				this.leftFormula, this.leftFormula = leftFormula);
	}

	private Formula rightFormula;

	public Formula getRightFormula() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.rightFormula, rightFormula);
	}

	public void setRightFormula(Formula rightFormula) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.rightFormula,
				this.rightFormula, this.rightFormula = rightFormula);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftFormula().wGetAdaptee(false);
		case 1:
			return getRightFormula().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftFormula(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula));
			break;
		case 1:
			setRightFormula(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
