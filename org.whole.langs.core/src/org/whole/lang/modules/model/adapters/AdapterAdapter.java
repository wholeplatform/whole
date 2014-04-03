package org.whole.lang.modules.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class AdapterAdapter extends AbstractEntityAdapter implements Adapter {
    private static final long serialVersionUID = 1;

    public AdapterAdapter(IEntity implementor) {
        super(implementor);
    }

    public AdapterAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Adapter> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Adapter;
    }
}
