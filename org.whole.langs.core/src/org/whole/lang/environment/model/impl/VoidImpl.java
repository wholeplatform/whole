package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;

/** 
 * @generator Whole
 */
public class VoidImpl extends AbstractSimpleEntity implements Void {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Void> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.Void;
	}

	public int wGetEntityOrd() {
		return EnvironmentEntityDescriptorEnum.Void_ord;
	}

	public void accept(IEnvironmentVisitor visitor) {
		visitor.visit(this);
	}
}
