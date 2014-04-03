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
public class IncludeImpl extends AbstractSimpleEntity implements Include {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Include> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Include;
    }

    public int wGetEntityOrd() {
        return ModulesEntityDescriptorEnum.Include_ord;
    }

    public void accept(IModulesVisitor visitor) {
        visitor.visit(this);
    }
    private Resource resource;

    public Resource getResource() {
        return notifyRequested(ModulesFeatureDescriptorEnum.resource, resource);
    }

    public void setResource(Resource resource) {
        notifyChanged(ModulesFeatureDescriptorEnum.resource, this.resource, this.resource = resource);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getResource().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setResource(value.wGetAdapter(ModulesEntityDescriptorEnum.Resource));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
