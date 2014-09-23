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
public class PointwiseEqualsImpl extends AbstractSimpleEntity implements PointwiseEquals {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PointwiseEquals> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseEquals;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.PointwiseEquals_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private PathExpression pexp1;

    public PathExpression getPexp1() {
        return notifyRequested(QueriesFeatureDescriptorEnum.pexp1, pexp1);
    }

    public void setPexp1(PathExpression pexp1) {
        notifyChanged(QueriesFeatureDescriptorEnum.pexp1, this.pexp1, this.pexp1 = pexp1);
    }
    private PathExpression pexp2;

    public PathExpression getPexp2() {
        return notifyRequested(QueriesFeatureDescriptorEnum.pexp2, pexp2);
    }

    public void setPexp2(PathExpression pexp2) {
        notifyChanged(QueriesFeatureDescriptorEnum.pexp2, this.pexp2, this.pexp2 = pexp2);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPexp1().wGetAdaptee(false);
            case 1 :
            return getPexp2().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPexp1(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 1 :
            setPexp2(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
