package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArrayInitializerAdapter extends
		AbstractListEntityAdapter<Expression> implements ArrayInitializer {
	private static final long serialVersionUID = 1;

	public ArrayInitializerAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayInitializerAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayInitializer> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ArrayInitializer;
	}
}
