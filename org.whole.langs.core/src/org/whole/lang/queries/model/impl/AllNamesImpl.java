package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/**
 *  @generator  Whole
 */
public class AllNamesImpl extends AbstractSimpleEntity implements AllNames {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AllNames> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.AllNames;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.AllNames_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
}
