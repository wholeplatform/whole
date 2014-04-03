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
public class LocatorAdapter extends AbstractEntityAdapter implements Locator {
    private static final long serialVersionUID = 1;

    public LocatorAdapter(IEntity implementor) {
        super(implementor);
    }

    public LocatorAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Locator> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Locator;
    }
}
