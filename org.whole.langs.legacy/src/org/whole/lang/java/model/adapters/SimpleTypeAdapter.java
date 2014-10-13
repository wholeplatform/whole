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
public class SimpleTypeAdapter extends AbstractEntityAdapter implements
		SimpleType {
	private static final long serialVersionUID = 1;

	public SimpleTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleTypeAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SimpleType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
