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
public class LongLiteralAdapter extends AbstractEntityAdapter implements
		LongLiteral {
	private static final long serialVersionUID = 1;

	public LongLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public LongLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LongLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LongLiteral;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
