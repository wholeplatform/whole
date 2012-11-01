package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FilterRulesStrictImpl extends
		AbstractUniqueListCompositeEntity<FilterRule> implements FilterRules {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.FilterRules_ord;
	}

	public EntityDescriptor<FilterRules> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.FilterRules;
	}
}
