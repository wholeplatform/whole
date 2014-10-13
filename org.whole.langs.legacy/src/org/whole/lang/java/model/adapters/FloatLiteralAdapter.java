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
public class FloatLiteralAdapter extends AbstractEntityAdapter implements
		FloatLiteral {
	private static final long serialVersionUID = 1;

	public FloatLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public FloatLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FloatLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.FloatLiteral;
	}

	public float getValue() {
		return wFloatValue();
	}

	public void setValue(float value) {
		wSetValue(value);
	}
}
