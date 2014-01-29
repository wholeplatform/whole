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
public class BoolAdapter extends AbstractEntityAdapter implements Bool {
    private static final long serialVersionUID = 1;

    public BoolAdapter(IEntity implementor) {
        super(implementor);
    }

    public BoolAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Bool> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Bool;
    }

    public boolean isValue() {
        return wBooleanValue();
    }

    public void setValue(boolean value) {
        wSetValue(value);
    }
}
