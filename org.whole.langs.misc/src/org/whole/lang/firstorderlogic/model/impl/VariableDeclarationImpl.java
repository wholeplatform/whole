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
public class VariableDeclarationImpl extends AbstractSimpleEntity implements
		VariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.VariableDeclaration;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.VariableDeclaration_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.name, this.name,
				this.name = name);
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
			return getName().wGetAdaptee(false);
		case 1:
			return getSort().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setSort(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
