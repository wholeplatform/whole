package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.visitors.IJSONVisitor;

/**
 *  @generator  Whole
 */
public class NullImpl extends AbstractSimpleEntity implements Null {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Null> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Null;
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Null_ord;
    }

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }
}
