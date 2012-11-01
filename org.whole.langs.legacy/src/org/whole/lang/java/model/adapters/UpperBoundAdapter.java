package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class UpperBoundAdapter extends AbstractEntityAdapter implements
		UpperBound {
	private static final long serialVersionUID = 1;

	public UpperBoundAdapter(IEntity implementor) {
		super(implementor);
	}

	public UpperBoundAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UpperBound> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.UpperBound;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
