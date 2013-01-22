package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/** 
 * @generator Whole
 */
public class ReachableStepImpl extends AbstractSimpleEntity implements
		ReachableStep {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ReachableStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.ReachableStep;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.ReachableStep_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}
}
