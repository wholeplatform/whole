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
public class VarargsAdapter extends AbstractEntityAdapter implements Varargs {
	private static final long serialVersionUID = 1;

	public VarargsAdapter(IEntity implementor) {
		super(implementor);
	}

	public VarargsAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Varargs> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Varargs;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
