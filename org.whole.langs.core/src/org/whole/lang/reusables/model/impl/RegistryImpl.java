package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.reusables.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class RegistryImpl extends AbstractSimpleEntity implements Registry {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Registry> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Registry;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Registry_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        visitor.visit(this);
    }
    private URI locator;

    public URI getLocator() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public void setLocator(URI locator) {
        notifyChanged(ReusablesFeatureDescriptorEnum.locator, this.locator, this.locator = locator);
    }
    private URI uri;

    public URI getUri() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.uri, uri);
    }

    public void setUri(URI uri) {
        notifyChanged(ReusablesFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLocator().wGetAdaptee(false);
            case 1 :
            return getUri().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLocator(value.wGetAdapter(ReusablesEntityDescriptorEnum.URI));
            break;
            case 1 :
            setUri(value.wGetAdapter(ReusablesEntityDescriptorEnum.URI));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
