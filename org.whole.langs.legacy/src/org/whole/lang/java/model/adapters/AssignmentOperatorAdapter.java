package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.model.AssignmentOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class AssignmentOperatorAdapter extends AbstractEntityAdapter implements
		AssignmentOperator {
	private static final long serialVersionUID = 1;

	public AssignmentOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssignmentOperatorAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AssignmentOperator> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AssignmentOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
