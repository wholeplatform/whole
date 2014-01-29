package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ArrayAdapter extends AbstractListEntityAdapter<Value> implements Array {
    private static final long serialVersionUID = 1;

    public ArrayAdapter(IEntity implementor) {
        super(implementor);
    }

    public ArrayAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Array> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Array;
    }
}
