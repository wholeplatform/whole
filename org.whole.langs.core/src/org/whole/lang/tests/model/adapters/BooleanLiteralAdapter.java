package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BooleanLiteralAdapter extends AbstractEntityAdapter implements
		BooleanLiteral {
	private static final long serialVersionUID = 1;

	public BooleanLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanLiteralAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.BooleanLiteral;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
