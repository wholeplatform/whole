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
public class BooleanValueAdapter extends AbstractEntityAdapter implements BooleanValue {
    private static final long serialVersionUID = 1;

    public BooleanValueAdapter(IEntity implementor) {
        super(implementor);
    }

    public BooleanValueAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<BooleanValue> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.BooleanValue;
    }

    public boolean isValue() {
        return wBooleanValue();
    }

    public void setValue(boolean value) {
        wSetValue(value);
    }
}
