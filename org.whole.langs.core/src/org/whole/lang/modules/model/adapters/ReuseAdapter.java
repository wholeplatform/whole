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
public class ReuseAdapter extends AbstractEntityAdapter implements Reuse {
    private static final long serialVersionUID = 1;

    public ReuseAdapter(IEntity implementor) {
        super(implementor);
    }

    public ReuseAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Reuse> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Reuse;
    }

    public Resource getResource() {
        return wGet(ModulesFeatureDescriptorEnum.resource).wGetAdapter(ModulesEntityDescriptorEnum.Resource);
    }

    public void setResource(Resource resource) {
        wSet(ModulesFeatureDescriptorEnum.resource, resource);
    }

    public Adapter getAdapter() {
        return wGet(ModulesFeatureDescriptorEnum.adapter).wGetAdapter(ModulesEntityDescriptorEnum.Adapter);
    }

    public void setAdapter(Adapter adapter) {
        wSet(ModulesFeatureDescriptorEnum.adapter, adapter);
    }

    public Content getOriginal() {
        return wGet(ModulesFeatureDescriptorEnum.original).wGetAdapter(ModulesEntityDescriptorEnum.Content);
    }

    public void setOriginal(Content original) {
        wSet(ModulesFeatureDescriptorEnum.original, original);
    }

    public Content getAdapted() {
        return wGet(ModulesFeatureDescriptorEnum.adapted).wGetAdapter(ModulesEntityDescriptorEnum.Content);
    }

    public void setAdapted(Content adapted) {
        wSet(ModulesFeatureDescriptorEnum.adapted, adapted);
    }

    public Content getVariant() {
        return wGet(ModulesFeatureDescriptorEnum.variant).wGetAdapter(ModulesEntityDescriptorEnum.Content);
    }

    public void setVariant(Content variant) {
        wSet(ModulesFeatureDescriptorEnum.variant, variant);
    }
}
