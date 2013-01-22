package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/** 
 * @generator Whole
 */
public class DescendantStepImpl extends AbstractSimpleEntity implements
		DescendantStep {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DescendantStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DescendantStep;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.DescendantStep_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}
}
