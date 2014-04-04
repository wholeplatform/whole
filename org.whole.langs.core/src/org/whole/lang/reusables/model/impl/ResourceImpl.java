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
public class ResourceImpl extends AbstractSimpleEntity implements Resource {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Resource> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Resource;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Resource_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        visitor.visit(this);
    }
    private Locator locator;

    public Locator getLocator() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public void setLocator(Locator locator) {
        notifyChanged(ReusablesFeatureDescriptorEnum.locator, this.locator, this.locator = locator);
    }
    private Persistence persistence;

    public Persistence getPersistence() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }

    public void setPersistence(Persistence persistence) {
        notifyChanged(ReusablesFeatureDescriptorEnum.persistence, this.persistence, this.persistence = persistence);
    }
    private Registry registry;

    public Registry getRegistry() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.registry, registry);
    }

    public void setRegistry(Registry registry) {
        notifyChanged(ReusablesFeatureDescriptorEnum.registry, this.registry, this.registry = registry);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLocator().wGetAdaptee(false);
            case 1 :
            return getPersistence().wGetAdaptee(false);
            case 2 :
            return getRegistry().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLocator(value.wGetAdapter(ReusablesEntityDescriptorEnum.Locator));
            break;
            case 1 :
            setPersistence(value.wGetAdapter(ReusablesEntityDescriptorEnum.Persistence));
            break;
            case 2 :
            setRegistry(value.wGetAdapter(ReusablesEntityDescriptorEnum.Registry));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
