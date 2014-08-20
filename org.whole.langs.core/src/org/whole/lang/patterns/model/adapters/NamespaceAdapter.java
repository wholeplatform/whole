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
public class NamespaceAdapter extends AbstractEntityAdapter implements Namespace {
    private static final long serialVersionUID = 1;

    public NamespaceAdapter(IEntity implementor) {
        super(implementor);
    }

    public NamespaceAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Namespace> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Namespace;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
