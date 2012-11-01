package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.XmlMemberOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class XmlMemberOperatorAdapter extends AbstractEntityAdapter implements
		XmlMemberOperator {
	private static final long serialVersionUID = 1;

	public XmlMemberOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlMemberOperatorAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlMemberOperator> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlMemberOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
