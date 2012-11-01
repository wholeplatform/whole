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
public class BooleanLiteralAdapter extends AbstractEntityAdapter implements
		BooleanLiteral {
	private static final long serialVersionUID = 1;

	public BooleanLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BooleanLiteral;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
