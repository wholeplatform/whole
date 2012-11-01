package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/** 
 * @generator Whole
 */
public class AdjacentStepImpl extends AbstractSimpleEntity implements
		AdjacentStep {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AdjacentStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.AdjacentStep;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.AdjacentStep_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}
}
