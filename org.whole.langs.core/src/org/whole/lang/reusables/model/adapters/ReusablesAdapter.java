package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReusablesAdapter extends AbstractListEntityAdapter<Reusable> implements Reusables {
    private static final long serialVersionUID = 1;

    public ReusablesAdapter(IEntity implementor) {
        super(implementor);
    }

    public ReusablesAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Reusables> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Reusables;
    }
}
