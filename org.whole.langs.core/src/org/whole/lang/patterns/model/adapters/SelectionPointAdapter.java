package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class SelectionPointAdapter extends AbstractListEntityAdapter<ConditionPoint> implements SelectionPoint {
    private static final long serialVersionUID = 1;

    public SelectionPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public SelectionPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SelectionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.SelectionPoint;
    }
}
