package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.CommentKindEnum.Value;

/** 
 * @generator Whole
 */
public class CommentKindAdapter extends AbstractEntityAdapter implements
		CommentKind {
	private static final long serialVersionUID = 1;

	public CommentKindAdapter(IEntity implementor) {
		super(implementor);
	}

	public CommentKindAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CommentKind> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.CommentKind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
