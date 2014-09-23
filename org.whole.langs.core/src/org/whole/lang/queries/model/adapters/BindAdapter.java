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
public class BindAdapter extends AbstractEntityAdapter implements Bind {
    private static final long serialVersionUID = 1;

    public BindAdapter(IEntity implementor) {
        super(implementor);
    }

    public BindAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Bind> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Bind;
    }

    public Name getName() {
        return wGet(QueriesFeatureDescriptorEnum.name).wGetAdapter(QueriesEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(QueriesFeatureDescriptorEnum.name, name);
    }

    public PathExpressionOrPredicate getExpression() {
        return wGet(QueriesFeatureDescriptorEnum.expression).wGetAdapter(QueriesEntityDescriptorEnum.PathExpressionOrPredicate);
    }

    public void setExpression(PathExpressionOrPredicate expression) {
        wSet(QueriesFeatureDescriptorEnum.expression, expression);
    }
}
