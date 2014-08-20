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
public class URIAdapter extends AbstractEntityAdapter implements URI {
    private static final long serialVersionUID = 1;

    public URIAdapter(IEntity implementor) {
        super(implementor);
    }

    public URIAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<URI> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.URI;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
