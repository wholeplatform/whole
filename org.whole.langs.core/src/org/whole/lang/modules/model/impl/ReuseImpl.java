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
public class ReuseImpl extends AbstractSimpleEntity implements Reuse {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Reuse> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Reuse;
    }

    public int wGetEntityOrd() {
        return ModulesEntityDescriptorEnum.Reuse_ord;
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
    private Adapter adapter;

    public Adapter getAdapter() {
        return notifyRequested(ModulesFeatureDescriptorEnum.adapter, adapter);
    }

    public void setAdapter(Adapter adapter) {
        notifyChanged(ModulesFeatureDescriptorEnum.adapter, this.adapter, this.adapter = adapter);
    }
    private Content original;

    public Content getOriginal() {
        return notifyRequested(ModulesFeatureDescriptorEnum.original, original);
    }

    public void setOriginal(Content original) {
        notifyChanged(ModulesFeatureDescriptorEnum.original, this.original, this.original = original);
    }
    private Content adapted;

    public Content getAdapted() {
        return notifyRequested(ModulesFeatureDescriptorEnum.adapted, adapted);
    }

    public void setAdapted(Content adapted) {
        notifyChanged(ModulesFeatureDescriptorEnum.adapted, this.adapted, this.adapted = adapted);
    }
    private Content variant;

    public Content getVariant() {
        return notifyRequested(ModulesFeatureDescriptorEnum.variant, variant);
    }

    public void setVariant(Content variant) {
        notifyChanged(ModulesFeatureDescriptorEnum.variant, this.variant, this.variant = variant);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getResource().wGetAdaptee(false);
            case 1 :
            return getAdapter().wGetAdaptee(false);
            case 2 :
            return getOriginal().wGetAdaptee(false);
            case 3 :
            return getAdapted().wGetAdaptee(false);
            case 4 :
            return getVariant().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setResource(value.wGetAdapter(ModulesEntityDescriptorEnum.Resource));
            break;
            case 1 :
            setAdapter(value.wGetAdapter(ModulesEntityDescriptorEnum.Adapter));
            break;
            case 2 :
            setOriginal(value.wGetAdapter(ModulesEntityDescriptorEnum.Content));
            break;
            case 3 :
            setAdapted(value.wGetAdapter(ModulesEntityDescriptorEnum.Content));
            break;
            case 4 :
            setVariant(value.wGetAdapter(ModulesEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
