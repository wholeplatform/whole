package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ObjectImpl extends AbstractListCompositeEntity<Pair> implements Object {
    private static final long serialVersionUID = 1;

    public void accept(IJSONVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Object_ord;
    }

    public EntityDescriptor<Object> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Object;
    }
}
