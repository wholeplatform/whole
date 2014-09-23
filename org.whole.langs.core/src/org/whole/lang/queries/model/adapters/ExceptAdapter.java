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
public class ExceptAdapter extends AbstractEntityAdapter implements Except {
    private static final long serialVersionUID = 1;

    public ExceptAdapter(IEntity implementor) {
        super(implementor);
    }

    public ExceptAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Except> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Except;
    }

    public Expressions getExpressions() {
        return wGet(QueriesFeatureDescriptorEnum.expressions).wGetAdapter(QueriesEntityDescriptorEnum.Expressions);
    }

    public void setExpressions(Expressions expressions) {
        wSet(QueriesFeatureDescriptorEnum.expressions, expressions);
    }

    public Comparator getComparator() {
        return wGet(QueriesFeatureDescriptorEnum.comparator).wGetAdapter(QueriesEntityDescriptorEnum.Comparator);
    }

    public void setComparator(Comparator comparator) {
        wSet(QueriesFeatureDescriptorEnum.comparator, comparator);
    }
}
