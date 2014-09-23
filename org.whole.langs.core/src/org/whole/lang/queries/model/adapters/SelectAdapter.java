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
public class SelectAdapter extends AbstractEntityAdapter implements Select {
    private static final long serialVersionUID = 1;

    public SelectAdapter(IEntity implementor) {
        super(implementor);
    }

    public SelectAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Select> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Select;
    }

    public PathExpression getSelectClause() {
        return wGet(QueriesFeatureDescriptorEnum.selectClause).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setSelectClause(PathExpression selectClause) {
        wSet(QueriesFeatureDescriptorEnum.selectClause, selectClause);
    }

    public PathExpressionOrPredicate getFromClause() {
        return wGet(QueriesFeatureDescriptorEnum.fromClause).wGetAdapter(QueriesEntityDescriptorEnum.PathExpressionOrPredicate);
    }

    public void setFromClause(PathExpressionOrPredicate fromClause) {
        wSet(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public PathExpression getWhereClause() {
        return wGet(QueriesFeatureDescriptorEnum.whereClause).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setWhereClause(PathExpression whereClause) {
        wSet(QueriesFeatureDescriptorEnum.whereClause, whereClause);
    }

    public NamesExpression getClearClause() {
        return wGet(QueriesFeatureDescriptorEnum.clearClause).wGetAdapter(QueriesEntityDescriptorEnum.NamesExpression);
    }

    public void setClearClause(NamesExpression clearClause) {
        wSet(QueriesFeatureDescriptorEnum.clearClause, clearClause);
    }
}
