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
public class ExpressionTestImpl extends AbstractSimpleEntity implements ExpressionTest {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExpressionTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ExpressionTest;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.ExpressionTest_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
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
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
