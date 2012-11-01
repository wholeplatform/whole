package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CartesianProductImpl extends
		AbstractListCompositeEntity<PathExpression> implements CartesianProduct {
	private static final long serialVersionUID = 1;

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.CartesianProduct_ord;
	}

	public EntityDescriptor<CartesianProduct> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.CartesianProduct;
	}
}
