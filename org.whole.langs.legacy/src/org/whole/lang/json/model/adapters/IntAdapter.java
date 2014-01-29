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
public class IntAdapter extends AbstractEntityAdapter implements Int {
    private static final long serialVersionUID = 1;

    public IntAdapter(IEntity implementor) {
        super(implementor);
    }

    public IntAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Int> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Int;
    }

    public long getValue() {
        return wLongValue();
    }

    public void setValue(long value) {
        wSetValue(value);
    }
}
