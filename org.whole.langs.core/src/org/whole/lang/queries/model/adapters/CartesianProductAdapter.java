package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class CartesianProductAdapter extends AbstractListEntityAdapter<PathExpression> implements CartesianProduct {
    private static final long serialVersionUID = 1;

    public CartesianProductAdapter(IEntity implementor) {
        super(implementor);
    }

    public CartesianProductAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<CartesianProduct> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.CartesianProduct;
    }
}
