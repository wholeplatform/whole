package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SchemeEnvironmentImpl extends AbstractDataEntity implements
		SchemeEnvironment {
	private static final long serialVersionUID = 1;
	private org.whole.lang.bindings.IBindingManager value;

	public org.whole.lang.bindings.IBindingManager getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.bindings.IBindingManager value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.SchemeEnvironment_ord;
	}

	public EntityDescriptor<SchemeEnvironment> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.SchemeEnvironment;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.bindings.IBindingManager) value);
	}
}
