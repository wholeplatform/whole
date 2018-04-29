package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class StringLiteralAdapter extends AbstractEntityAdapter implements StringLiteral {
	private static final long serialVersionUID = 1;

	public StringLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringLiteralAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.StringLiteral;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
