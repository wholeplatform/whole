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
public class ImplicationImpl extends AbstractSimpleEntity implements
		Implication {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Implication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Implication;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.Implication_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Formula antecedent;

	public Formula getAntecedent() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.antecedent,
				antecedent);
	}

	public void setAntecedent(Formula antecedent) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.antecedent,
				this.antecedent, this.antecedent = antecedent);
	}

	private Formula consequent;

	public Formula getConsequent() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.consequent,
				consequent);
	}

	public void setConsequent(Formula consequent) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.consequent,
				this.consequent, this.consequent = consequent);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAntecedent().wGetAdaptee(false);
		case 1:
			return getConsequent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAntecedent(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula));
			break;
		case 1:
			setConsequent(value
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
