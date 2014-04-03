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
public class ContentAdapter extends AbstractEntityAdapter implements Content {
    private static final long serialVersionUID = 1;

    public ContentAdapter(IEntity implementor) {
        super(implementor);
    }

    public ContentAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Content> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Content;
    }
}
