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
public class PatternTypeTestAdapter extends AbstractEntityAdapter implements PatternTypeTest {
    private static final long serialVersionUID = 1;

    public PatternTypeTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public PatternTypeTestAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PatternTypeTest> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternTypeTest;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
