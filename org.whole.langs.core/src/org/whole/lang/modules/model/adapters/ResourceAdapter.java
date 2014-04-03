package org.whole.lang.modules.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ResourceAdapter extends AbstractEntityAdapter implements Resource {
    private static final long serialVersionUID = 1;

    public ResourceAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResourceAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Resource> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Resource;
    }

    public Locator getLocator() {
        return wGet(ModulesFeatureDescriptorEnum.locator).wGetAdapter(ModulesEntityDescriptorEnum.Locator);
    }

    public void setLocator(Locator locator) {
        wSet(ModulesFeatureDescriptorEnum.locator, locator);
    }

    public Persistence getPersistence() {
        return wGet(ModulesFeatureDescriptorEnum.persistence).wGetAdapter(ModulesEntityDescriptorEnum.Persistence);
    }

    public void setPersistence(Persistence persistence) {
        wSet(ModulesFeatureDescriptorEnum.persistence, persistence);
    }

    public Registry getRegistry() {
        return wGet(ModulesFeatureDescriptorEnum.registry).wGetAdapter(ModulesEntityDescriptorEnum.Registry);
    }

    public void setRegistry(Registry registry) {
        wSet(ModulesFeatureDescriptorEnum.registry, registry);
    }
}
