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
public class ResourceAdapter extends AbstractEntityAdapter implements Resource {
    private static final long serialVersionUID = 1;

    public ResourceAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResourceAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Resource> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Resource;
    }

    public Locator getLocator() {
        return wGet(ReusablesFeatureDescriptorEnum.locator).wGetAdapter(ReusablesEntityDescriptorEnum.Locator);
    }

    public void setLocator(Locator locator) {
        wSet(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public Persistence getPersistence() {
        return wGet(ReusablesFeatureDescriptorEnum.persistence).wGetAdapter(ReusablesEntityDescriptorEnum.Persistence);
    }

    public void setPersistence(Persistence persistence) {
        wSet(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }

    public Registry getRegistry() {
        return wGet(ReusablesFeatureDescriptorEnum.registry).wGetAdapter(ReusablesEntityDescriptorEnum.Registry);
    }

    public void setRegistry(Registry registry) {
        wSet(ReusablesFeatureDescriptorEnum.registry, registry);
    }
}
