package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SupertypeTypeImpl extends AbstractSimpleEntity implements
		SupertypeType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SupertypeType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SupertypeType;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.SupertypeType_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Category category;

	public Category getCategory() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.category,
				category);
	}

	public void setCategory(Category category) {
		notifyChanged(SemanticsFeatureDescriptorEnum.category, this.category,
				this.category = category);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCategory().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCategory(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Category));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
