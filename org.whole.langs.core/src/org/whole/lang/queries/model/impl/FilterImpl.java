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
public class FilterImpl extends AbstractSimpleEntity implements Filter {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Filter> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Filter;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Filter_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private StepExpression expression;

    public StepExpression getExpression() {
        return notifyRequested(QueriesFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(StepExpression expression) {
        notifyChanged(QueriesFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private PruneOrPredicate predicate;

    public PruneOrPredicate getPredicate() {
        return notifyRequested(QueriesFeatureDescriptorEnum.predicate, predicate);
    }

    public void setPredicate(PruneOrPredicate predicate) {
        notifyChanged(QueriesFeatureDescriptorEnum.predicate, this.predicate, this.predicate = predicate);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getPredicate().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(QueriesEntityDescriptorEnum.StepExpression));
            break;
            case 1 :
            setPredicate(value.wGetAdapter(QueriesEntityDescriptorEnum.PruneOrPredicate));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
