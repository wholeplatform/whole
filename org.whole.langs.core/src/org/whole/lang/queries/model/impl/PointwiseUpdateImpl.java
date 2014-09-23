package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PointwiseUpdateImpl extends AbstractSimpleEntity implements PointwiseUpdate {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PointwiseUpdate> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseUpdate;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.PointwiseUpdate_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private PathExpression fromClause;

    public PathExpression getFromClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public void setFromClause(PathExpression fromClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause, this.fromClause = fromClause);
    }
    private PathExpression valuesClause;

    public PathExpression getValuesClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.valuesClause, valuesClause);
    }

    public void setValuesClause(PathExpression valuesClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.valuesClause, this.valuesClause, this.valuesClause = valuesClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFromClause().wGetAdaptee(false);
            case 1 :
            return getValuesClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFromClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 1 :
            setValuesClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
