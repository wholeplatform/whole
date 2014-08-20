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
public class SlotsDefinedAdapter extends AbstractEntityAdapter implements SlotsDefined {
    private static final long serialVersionUID = 1;

    public SlotsDefinedAdapter(IEntity implementor) {
        super(implementor);
    }

    public SlotsDefinedAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SlotsDefined> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.SlotsDefined;
    }
}
