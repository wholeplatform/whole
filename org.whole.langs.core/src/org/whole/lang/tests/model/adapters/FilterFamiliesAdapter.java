package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FilterFamiliesAdapter extends
		AbstractListEntityAdapter<FilterFamily> implements FilterFamilies {
	private static final long serialVersionUID = 1;

	public FilterFamiliesAdapter(IEntity implementor) {
		super(implementor);
	}

	public FilterFamiliesAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FilterFamilies> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.FilterFamilies;
	}
}
