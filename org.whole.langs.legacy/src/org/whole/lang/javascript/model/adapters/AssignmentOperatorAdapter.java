package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.AssignmentOperatorEnum.Value;

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

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AssignmentOperator> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.AssignmentOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
