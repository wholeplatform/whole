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
public class CharLiteralAdapter extends AbstractEntityAdapter implements
		CharLiteral {
	private static final long serialVersionUID = 1;

	public CharLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharLiteralAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.CharLiteral;
	}

	public char getValue() {
		return wCharValue();
	}

	public void setValue(char value) {
		wSetValue(value);
	}
}
