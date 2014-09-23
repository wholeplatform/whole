package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class PointwiseProductImpl extends AbstractListCompositeEntity<PathExpression> implements PointwiseProduct {
    private static final long serialVersionUID = 1;

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.PointwiseProduct_ord;
    }

    public EntityDescriptor<PointwiseProduct> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseProduct;
    }
}
