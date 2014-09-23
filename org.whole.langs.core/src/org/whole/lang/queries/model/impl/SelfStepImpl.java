package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/**
 *  @generator  Whole
 */
public class SelfStepImpl extends AbstractSimpleEntity implements SelfStep {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SelfStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.SelfStep;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.SelfStep_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
}
