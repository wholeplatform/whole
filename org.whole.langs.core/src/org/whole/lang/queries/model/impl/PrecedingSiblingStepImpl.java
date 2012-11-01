package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/** 
 * @generator Whole
 */
public class PrecedingSiblingStepImpl extends AbstractSimpleEntity implements
		PrecedingSiblingStep {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrecedingSiblingStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.PrecedingSiblingStep;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}
}
