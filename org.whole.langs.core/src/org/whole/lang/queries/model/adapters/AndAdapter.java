package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class AndAdapter extends AbstractListEntityAdapter<Predicate> implements And {
    private static final long serialVersionUID = 1;

    public AndAdapter(IEntity implementor) {
        super(implementor);
    }

    public AndAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<And> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.And;
    }
}
