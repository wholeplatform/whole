package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.PrefixOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class PrefixOperatorAdapter extends AbstractEntityAdapter implements
		PrefixOperator {
	private static final long serialVersionUID = 1;

	public PrefixOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrefixOperatorAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PrefixOperator> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.PrefixOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
