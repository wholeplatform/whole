package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class SourceAdapter extends AbstractEntityAdapter implements Source {
    private static final long serialVersionUID = 1;

    public SourceAdapter(IEntity implementor) {
        super(implementor);
    }

    public SourceAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Source> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Source;
    }
}
