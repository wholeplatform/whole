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
public class DoubleLiteralAdapter extends AbstractEntityAdapter implements
		DoubleLiteral {
	private static final long serialVersionUID = 1;

	public DoubleLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoubleLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoubleLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.DoubleLiteral;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
