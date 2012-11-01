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
public class PredicateTypeImpl extends AbstractSimpleEntity implements
		PredicateType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PredicateType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateType;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateType_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.parameters,
				parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.parameters,
				this.parameters, this.parameters = parameters);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getParameters().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setParameters(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
