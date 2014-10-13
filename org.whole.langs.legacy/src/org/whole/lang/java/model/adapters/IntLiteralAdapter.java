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
public class IntLiteralAdapter extends AbstractEntityAdapter implements
		IntLiteral {
	private static final long serialVersionUID = 1;

	public IntLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.IntLiteral;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
