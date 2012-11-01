package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ExpressionsImpl extends
		AbstractListCompositeEntity<PathExpression> implements Expressions {
	private static final long serialVersionUID = 1;

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.Expressions_ord;
	}

	public EntityDescriptor<Expressions> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Expressions;
	}
}
