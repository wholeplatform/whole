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
public class ScopeImpl extends AbstractSimpleEntity implements Scope {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Scope> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Scope;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Scope_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private Names localNames;

    public Names getLocalNames() {
        return notifyRequested(QueriesFeatureDescriptorEnum.localNames, localNames);
    }

    public void setLocalNames(Names localNames) {
        notifyChanged(QueriesFeatureDescriptorEnum.localNames, this.localNames, this.localNames = localNames);
    }
    private PathExpression expression;

    public PathExpression getExpression() {
        return notifyRequested(QueriesFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(PathExpression expression) {
        notifyChanged(QueriesFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLocalNames().wGetAdaptee(false);
            case 1 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLocalNames(value.wGetAdapter(QueriesEntityDescriptorEnum.Names));
            break;
            case 1 :
            setExpression(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
