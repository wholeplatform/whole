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
public class ValueAdapter extends AbstractEntityAdapter implements Value {
    private static final long serialVersionUID = 1;

    public ValueAdapter(IEntity implementor) {
        super(implementor);
    }

    public ValueAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Value> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Value;
    }
}
