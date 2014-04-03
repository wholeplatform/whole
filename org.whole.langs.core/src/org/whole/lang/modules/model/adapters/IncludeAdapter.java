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
public class IncludeAdapter extends AbstractEntityAdapter implements Include {
    private static final long serialVersionUID = 1;

    public IncludeAdapter(IEntity implementor) {
        super(implementor);
    }

    public IncludeAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Include> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Include;
    }

    public Resource getResource() {
        return wGet(ModulesFeatureDescriptorEnum.resource).wGetAdapter(ModulesEntityDescriptorEnum.Resource);
    }

    public void setResource(Resource resource) {
        wSet(ModulesFeatureDescriptorEnum.resource, resource);
    }
}
