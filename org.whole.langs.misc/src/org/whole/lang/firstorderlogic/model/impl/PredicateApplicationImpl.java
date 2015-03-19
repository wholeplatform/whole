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
public class PredicateApplicationImpl extends AbstractSimpleEntity implements
		PredicateApplication {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PredicateApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateApplication;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateApplication_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Predicate predicate;

	public Predicate getPredicate() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.predicate,
				predicate);
	}

	public void setPredicate(Predicate predicate) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.predicate,
				this.predicate, this.predicate = predicate);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.arguments,
				this.arguments, this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPredicate().wGetAdaptee(false);
		case 1:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPredicate(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Predicate));
			break;
		case 1:
			setArguments(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
