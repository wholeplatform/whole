package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.String;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class StringAdapter extends AbstractEntityAdapter implements String {
    private static final long serialVersionUID = 1;

    public StringAdapter(IEntity implementor) {
        super(implementor);
    }

    public StringAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<String> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.String;
    }

    public java.lang.String getValue() {
        return wStringValue();
    }

    public void setValue(java.lang.String value) {
        wSetValue(value);
    }
}
