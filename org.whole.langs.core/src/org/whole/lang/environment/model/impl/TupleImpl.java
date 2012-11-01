package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TupleImpl extends AbstractListCompositeEntity<Data> implements
		Tuple {
	private static final long serialVersionUID = 1;

	public void accept(IEnvironmentVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EnvironmentEntityDescriptorEnum.Tuple_ord;
	}

	public EntityDescriptor<Tuple> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.Tuple;
	}

	public boolean isContainment() {
		return false;
	}
}
