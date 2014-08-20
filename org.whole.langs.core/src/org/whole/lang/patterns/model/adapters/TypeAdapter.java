package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class TypeAdapter extends AbstractEntityAdapter implements Type {
    private static final long serialVersionUID = 1;

    public TypeAdapter(IEntity implementor) {
        super(implementor);
    }

    public TypeAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Type> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Type;
    }
}
