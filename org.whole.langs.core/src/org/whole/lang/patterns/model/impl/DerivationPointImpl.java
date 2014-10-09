package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class DerivationPointImpl extends AbstractSimpleEntity implements DerivationPoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DerivationPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.DerivationPoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.DerivationPoint_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private PathExpression expression;

    public PathExpression getExpression() {
        return notifyRequested(PatternsFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(PathExpression expression) {
        notifyChanged(PatternsFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private ResultType resultType;

    public ResultType getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(ResultType resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getResultType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(PatternsEntityDescriptorEnum.PathExpression));
            break;
            case 1 :
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultType));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
