package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.model.PlacementEnum.Value;

/**
 *  @generator  Whole
 */
public class PlacementAdapter extends AbstractEntityAdapter implements Placement {
    private static final long serialVersionUID = 1;

    public PlacementAdapter(IEntity implementor) {
        super(implementor);
    }

    public PlacementAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Placement> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Placement;
    }

    public Value getValue() {
        return (Value) wEnumValue();
    }

    public void setValue(Value value) {
        wSetValue(value);
    }
}
