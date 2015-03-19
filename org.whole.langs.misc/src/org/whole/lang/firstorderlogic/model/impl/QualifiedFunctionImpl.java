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
public class QualifiedFunctionImpl extends AbstractSimpleEntity implements
		QualifiedFunction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<QualifiedFunction> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFunction;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFunction_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private SimpleFunction name;

	public SimpleFunction getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleFunction name) {
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
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimpleFunction));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
