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
public class PrecedingSiblingStepAdapter extends AbstractEntityAdapter implements PrecedingSiblingStep {
    private static final long serialVersionUID = 1;

    public PrecedingSiblingStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public PrecedingSiblingStepAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PrecedingSiblingStep> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PrecedingSiblingStep;
    }
}
