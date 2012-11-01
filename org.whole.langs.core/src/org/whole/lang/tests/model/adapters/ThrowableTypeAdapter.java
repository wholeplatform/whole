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
public class ThrowableTypeAdapter extends AbstractEntityAdapter implements
		ThrowableType {
	private static final long serialVersionUID = 1;

	public ThrowableTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ThrowableTypeAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ThrowableType> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.ThrowableType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
