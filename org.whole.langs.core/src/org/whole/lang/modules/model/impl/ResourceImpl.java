package org.whole.lang.modules.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.modules.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ResourceImpl extends AbstractSimpleEntity implements Resource {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Resource> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Resource;
    }

    public int wGetEntityOrd() {
        return ModulesEntityDescriptorEnum.Resource_ord;
    }

    public void accept(IModulesVisitor visitor) {
        visitor.visit(this);
    }
    private Locator locator;

    public Locator getLocator() {
        return notifyRequested(ModulesFeatureDescriptorEnum.locator, locator);
    }

    public void setLocator(Locator locator) {
        notifyChanged(ModulesFeatureDescriptorEnum.locator, this.locator, this.locator = locator);
    }
    private Persistence persistence;

    public Persistence getPersistence() {
        return notifyRequested(ModulesFeatureDescriptorEnum.persistence, persistence);
    }

    public void setPersistence(Persistence persistence) {
        notifyChanged(ModulesFeatureDescriptorEnum.persistence, this.persistence, this.persistence = persistence);
    }
    private Registry registry;

    public Registry getRegistry() {
        return notifyRequested(ModulesFeatureDescriptorEnum.registry, registry);
    }

    public void setRegistry(Registry registry) {
        notifyChanged(ModulesFeatureDescriptorEnum.registry, this.registry, this.registry = registry);
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
            setLocator(value.wGetAdapter(ModulesEntityDescriptorEnum.Locator));
            break;
            case 1 :
            setPersistence(value.wGetAdapter(ModulesEntityDescriptorEnum.Persistence));
            break;
            case 2 :
            setRegistry(value.wGetAdapter(ModulesEntityDescriptorEnum.Registry));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
