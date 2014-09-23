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
public class ChildStepAdapter extends AbstractEntityAdapter implements ChildStep {
    private static final long serialVersionUID = 1;

    public ChildStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public ChildStepAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ChildStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ChildStep;
    }
}
