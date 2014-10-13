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
public class StringLiteralAdapter extends AbstractEntityAdapter implements
		StringLiteral {
	private static final long serialVersionUID = 1;

	public StringLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.StringLiteral;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
