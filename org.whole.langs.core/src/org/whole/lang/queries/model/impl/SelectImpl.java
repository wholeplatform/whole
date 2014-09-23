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
public class SelectImpl extends AbstractSimpleEntity implements Select {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Select> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Select;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Select_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private PathExpression selectClause;

    public PathExpression getSelectClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.selectClause, selectClause);
    }

    public void setSelectClause(PathExpression selectClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.selectClause, this.selectClause, this.selectClause = selectClause);
    }
    private PathExpressionOrPredicate fromClause;

    public PathExpressionOrPredicate getFromClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public void setFromClause(PathExpressionOrPredicate fromClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause, this.fromClause = fromClause);
    }
    private PathExpression whereClause;

    public PathExpression getWhereClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(PathExpression whereClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }
    private NamesExpression clearClause;

    public NamesExpression getClearClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.clearClause, clearClause);
    }

    public void setClearClause(NamesExpression clearClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.clearClause, this.clearClause, this.clearClause = clearClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSelectClause().wGetAdaptee(false);
            case 1 :
            return getFromClause().wGetAdaptee(false);
            case 2 :
            return getWhereClause().wGetAdaptee(false);
            case 3 :
            return getClearClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSelectClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 1 :
            setFromClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpressionOrPredicate));
            break;
            case 2 :
            setWhereClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 3 :
            setClearClause(value.wGetAdapter(QueriesEntityDescriptorEnum.NamesExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
