package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.model.PostfixOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class PostfixOperatorAdapter extends AbstractEntityAdapter implements
		PostfixOperator {
	private static final long serialVersionUID = 1;

	public PostfixOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public PostfixOperatorAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PostfixOperator> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PostfixOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
