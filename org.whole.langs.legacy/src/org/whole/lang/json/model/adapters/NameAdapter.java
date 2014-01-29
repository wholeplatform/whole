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
public class NameAdapter extends AbstractEntityAdapter implements Name {
    private static final long serialVersionUID = 1;

    public NameAdapter(IEntity implementor) {
        super(implementor);
    }

    public NameAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Name> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Name;
    }

    public java.lang.String getValue() {
        return wStringValue();
    }

    public void setValue(java.lang.String value) {
        wSetValue(value);
    }
}
