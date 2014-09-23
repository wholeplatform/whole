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
public class SingletonAdapter extends AbstractEntityAdapter implements Singleton {
    private static final long serialVersionUID = 1;

    public SingletonAdapter(IEntity implementor) {
        super(implementor);
    }

    public SingletonAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Singleton> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Singleton;
    }

    public PathExpression getExpression() {
        return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setExpression(PathExpression expression) {
        wSet(QueriesFeatureDescriptorEnum.expression, expression);
    }
}
