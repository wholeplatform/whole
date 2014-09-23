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
public class RemoveNamesImpl extends AbstractSimpleEntity implements RemoveNames {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<RemoveNames> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.RemoveNames;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.RemoveNames_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private NamesExpression expression;

    public NamesExpression getExpression() {
        return notifyRequested(QueriesFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(NamesExpression expression) {
        notifyChanged(QueriesFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Names names;

    public Names getNames() {
        return notifyRequested(QueriesFeatureDescriptorEnum.names, names);
    }

    public void setNames(Names names) {
        notifyChanged(QueriesFeatureDescriptorEnum.names, this.names, this.names = names);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getNames().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(QueriesEntityDescriptorEnum.NamesExpression));
            break;
            case 1 :
            setNames(value.wGetAdapter(QueriesEntityDescriptorEnum.Names));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
