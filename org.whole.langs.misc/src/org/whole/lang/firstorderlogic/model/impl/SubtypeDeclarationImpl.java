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
public class SubtypeDeclarationImpl extends AbstractSimpleEntity implements
		SubtypeDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SubtypeDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name subSort;

	public Name getSubSort() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.subSort,
				subSort);
	}

	public void setSubSort(Name subSort) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.subSort,
				this.subSort, this.subSort = subSort);
	}

	private Name superSort;

	public Name getSuperSort() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.superSort,
				superSort);
	}

	public void setSuperSort(Name superSort) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.superSort,
				this.superSort, this.superSort = superSort);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSubSort().wGetAdaptee(false);
		case 1:
			return getSuperSort().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSubSort(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setSuperSort(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
