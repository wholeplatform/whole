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
public class PointwiseInsertAdapter extends AbstractEntityAdapter implements PointwiseInsert {
    private static final long serialVersionUID = 1;

    public PointwiseInsertAdapter(IEntity implementor) {
        super(implementor);
    }

    public PointwiseInsertAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PointwiseInsert> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseInsert;
    }

    public Placement getPlacement() {
        return wGet(QueriesFeatureDescriptorEnum.placement).wGetAdapter(QueriesEntityDescriptorEnum.Placement);
    }

    public void setPlacement(Placement placement) {
        wSet(QueriesFeatureDescriptorEnum.placement, placement);
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
