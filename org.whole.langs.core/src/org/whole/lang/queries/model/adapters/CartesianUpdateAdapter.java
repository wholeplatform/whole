package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class CartesianUpdateAdapter extends AbstractEntityAdapter implements CartesianUpdate {
    private static final long serialVersionUID = 1;

    public CartesianUpdateAdapter(IEntity implementor) {
        super(implementor);
    }

    public CartesianUpdateAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<CartesianUpdate> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.CartesianUpdate;
    }

    public PathExpression getFromClause() {
        return wGet(QueriesFeatureDescriptorEnum.fromClause).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setFromClause(PathExpression fromClause) {
        wSet(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public PathExpression getValuesClause() {
        return wGet(QueriesFeatureDescriptorEnum.valuesClause).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setValuesClause(PathExpression valuesClause) {
        wSet(QueriesFeatureDescriptorEnum.valuesClause, valuesClause);
    }
}
