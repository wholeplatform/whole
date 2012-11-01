package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.model.CommentKindEnum.Value;

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

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CommentKind> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.CommentKind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
