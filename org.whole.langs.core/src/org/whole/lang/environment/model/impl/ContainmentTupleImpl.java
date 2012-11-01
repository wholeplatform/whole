package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ContainmentTupleImpl extends AbstractListCompositeEntity<Data>
		implements ContainmentTuple {
	private static final long serialVersionUID = 1;

	public void accept(IEnvironmentVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EnvironmentEntityDescriptorEnum.ContainmentTuple_ord;
	}

	public EntityDescriptor<ContainmentTuple> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.ContainmentTuple;
	}
}
