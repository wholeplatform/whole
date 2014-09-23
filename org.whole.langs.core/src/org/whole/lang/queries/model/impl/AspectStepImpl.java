package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/**
 *  @generator  Whole
 */
public class AspectStepImpl extends AbstractSimpleEntity implements AspectStep {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AspectStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.AspectStep;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.AspectStep_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
}
