package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.VariableDeclarationKindEnum.Value;

/** 
 * @generator Whole
 */
public class VariableDeclarationKindAdapter extends AbstractEntityAdapter
		implements VariableDeclarationKind {
	private static final long serialVersionUID = 1;

	public VariableDeclarationKindAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationKindAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclarationKind> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableDeclarationKind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
