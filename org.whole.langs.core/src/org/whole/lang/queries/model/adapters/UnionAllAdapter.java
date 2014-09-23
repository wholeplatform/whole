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
public class UnionAllAdapter extends AbstractEntityAdapter implements UnionAll {
    private static final long serialVersionUID = 1;

    public UnionAllAdapter(IEntity implementor) {
        super(implementor);
    }

    public UnionAllAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<UnionAll> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.UnionAll;
    }

    public Expressions getExpressions() {
        return wGet(QueriesFeatureDescriptorEnum.expressions).wGetAdapter(QueriesEntityDescriptorEnum.Expressions);
    }

    public void setExpressions(Expressions expressions) {
        wSet(QueriesFeatureDescriptorEnum.expressions, expressions);
    }
}
