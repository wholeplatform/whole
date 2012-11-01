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
public class QualifiedPredicateImpl extends AbstractSimpleEntity implements
		QualifiedPredicate {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<QualifiedPredicate> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Name theoryAlias;

	public Name getTheoryAlias() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.theoryAlias, theoryAlias);
	}

	public void setTheoryAlias(Name theoryAlias) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.theoryAlias,
				this.theoryAlias, this.theoryAlias = theoryAlias);
	}

	private SimplePredicate name;

	public SimplePredicate getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(SimplePredicate name) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTheoryAlias().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTheoryAlias(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setName(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimplePredicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
