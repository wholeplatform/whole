package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SequenceStrictImpl extends AbstractBagCompositeEntity<Expression>
		implements Sequence {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Sequence_ord;
	}

	public EntityDescriptor<Sequence> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Sequence;
	}
}
