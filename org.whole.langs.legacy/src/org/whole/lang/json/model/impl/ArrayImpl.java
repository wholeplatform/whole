package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.json.model.*;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ArrayImpl extends AbstractListCompositeEntity<Value> implements Array {
    private static final long serialVersionUID = 1;

    public void accept(IJSONVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Array_ord;
    }

    public EntityDescriptor<Array> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Array;
    }
}
