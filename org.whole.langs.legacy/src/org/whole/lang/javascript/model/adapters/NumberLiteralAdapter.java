package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NumberLiteralAdapter extends AbstractEntityAdapter implements
		NumberLiteral {
	private static final long serialVersionUID = 1;

	public NumberLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public NumberLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NumberLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.NumberLiteral;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
