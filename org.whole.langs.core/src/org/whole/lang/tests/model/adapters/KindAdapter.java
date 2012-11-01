package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.model.KindEnum.Value;

/** 
 * @generator Whole
 */
public class KindAdapter extends AbstractEntityAdapter implements Kind {
	private static final long serialVersionUID = 1;

	public KindAdapter(IEntity implementor) {
		super(implementor);
	}

	public KindAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Kind> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Kind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
