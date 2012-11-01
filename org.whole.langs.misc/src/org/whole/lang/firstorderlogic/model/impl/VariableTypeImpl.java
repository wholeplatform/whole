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
public class VariableTypeImpl extends AbstractSimpleEntity implements
		VariableType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableType> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.VariableType;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.VariableType_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Name sort;

	public Name getSort() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.sort, sort);
	}

	public void setSort(Name sort) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.sort, this.sort,
				this.sort = sort);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSort().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSort(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
