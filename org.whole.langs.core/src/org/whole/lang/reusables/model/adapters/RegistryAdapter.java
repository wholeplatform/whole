package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class RegistryAdapter extends AbstractEntityAdapter implements Registry {
    private static final long serialVersionUID = 1;

    public RegistryAdapter(IEntity implementor) {
        super(implementor);
    }

    public RegistryAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Registry> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Registry;
    }

    public URI getLocator() {
        return wGet(ReusablesFeatureDescriptorEnum.locator).wGetAdapter(ReusablesEntityDescriptorEnum.URI);
    }

    public void setLocator(URI locator) {
        wSet(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public URI getUri() {
        return wGet(ReusablesFeatureDescriptorEnum.uri).wGetAdapter(ReusablesEntityDescriptorEnum.URI);
    }

    public void setUri(URI uri) {
        wSet(ReusablesFeatureDescriptorEnum.uri, uri);
    }
}
