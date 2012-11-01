package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.model.InfixOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class InfixOperatorAdapter extends AbstractEntityAdapter implements
		InfixOperator {
	private static final long serialVersionUID = 1;

	public InfixOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public InfixOperatorAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InfixOperator> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.InfixOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
