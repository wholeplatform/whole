package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ObjectAdapter extends AbstractListEntityAdapter<Pair> implements Object {
    private static final long serialVersionUID = 1;

    public ObjectAdapter(IEntity implementor) {
        super(implementor);
    }

    public ObjectAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Object> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Object;
    }
}
