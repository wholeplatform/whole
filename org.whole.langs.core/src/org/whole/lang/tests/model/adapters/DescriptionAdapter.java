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
public class DescriptionAdapter extends AbstractEntityAdapter implements
		Description {
	private static final long serialVersionUID = 1;

	public DescriptionAdapter(IEntity implementor) {
		super(implementor);
	}

	public DescriptionAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Description> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Description;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
