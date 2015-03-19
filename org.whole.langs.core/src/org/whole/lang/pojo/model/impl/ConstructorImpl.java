package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ConstructorImpl extends AbstractSimpleEntity implements
		Constructor {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Constructor> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Constructor;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.Constructor_ord;
	}

	public void accept(IPojoVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(PojoFeatureDescriptorEnum.parameters, parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(PojoFeatureDescriptorEnum.parameters, this.parameters,
				this.parameters = parameters);
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
					.wGetAdapter(PojoEntityDescriptorEnum.Parameters));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
