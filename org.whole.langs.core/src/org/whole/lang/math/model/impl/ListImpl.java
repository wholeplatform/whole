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
public class ListImpl extends AbstractSimpleEntity implements List {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<List> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.List;
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.List_ord;
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	private Constructor elements;

	public Constructor getElements() {
		return notifyRequested(MathFeatureDescriptorEnum.elements, elements);
	}

	public void setElements(Constructor elements) {
		notifyChanged(MathFeatureDescriptorEnum.elements, this.elements,
				this.elements = elements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getElements().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setElements(value.wGetAdapter(MathEntityDescriptorEnum.Constructor));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
