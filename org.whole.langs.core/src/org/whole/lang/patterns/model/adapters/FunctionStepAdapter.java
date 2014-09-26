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
public class FunctionStepAdapter extends AbstractEntityAdapter implements FunctionStep {
    private static final long serialVersionUID = 1;

    public FunctionStepAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionStepAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionStep> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionStep;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
