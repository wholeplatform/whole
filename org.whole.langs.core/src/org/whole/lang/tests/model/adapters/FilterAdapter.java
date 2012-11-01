package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FilterAdapter extends AbstractEntityAdapter implements Filter {
	private static final long serialVersionUID = 1;

	public FilterAdapter(IEntity implementor) {
		super(implementor);
	}

	public FilterAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Filter> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Filter;
	}

	public Name getName() {
		return wGet(TestsFeatureDescriptorEnum.name).wGetAdapter(
				TestsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(TestsFeatureDescriptorEnum.name, name);
	}
}
