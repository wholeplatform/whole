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
public class SubtractionStepAdapter extends AbstractEntityAdapter implements SubtractionStep {
    private static final long serialVersionUID = 1;

    public SubtractionStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public SubtractionStepAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SubtractionStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.SubtractionStep;
    }

    public Expression getExpression() {
        return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(QueriesEntityDescriptorEnum.Expression);
    }

    public void setExpression(Expression expression) {
        wSet(QueriesFeatureDescriptorEnum.expression, expression);
    }
}
