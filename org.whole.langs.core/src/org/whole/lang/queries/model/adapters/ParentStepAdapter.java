package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ParentStepAdapter extends AbstractEntityAdapter implements ParentStep {
    private static final long serialVersionUID = 1;

    public ParentStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public ParentStepAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ParentStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ParentStep;
    }
}
