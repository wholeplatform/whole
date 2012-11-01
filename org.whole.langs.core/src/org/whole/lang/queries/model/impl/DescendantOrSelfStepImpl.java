package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/** 
 * @generator Whole
 */
public class DescendantOrSelfStepImpl extends AbstractSimpleEntity implements
		DescendantOrSelfStep {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DescendantOrSelfStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DescendantOrSelfStep;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}
}
