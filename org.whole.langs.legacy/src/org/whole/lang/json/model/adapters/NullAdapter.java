package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class NullAdapter extends AbstractEntityAdapter implements Null {
    private static final long serialVersionUID = 1;

    public NullAdapter(IEntity implementor) {
        super(implementor);
    }

    public NullAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Null> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Null;
    }
}
