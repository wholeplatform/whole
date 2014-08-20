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
public class PointcutStepAdapter extends AbstractEntityAdapter implements PointcutStep {
    private static final long serialVersionUID = 1;

    public PointcutStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public PointcutStepAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PointcutStep> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PointcutStep;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
