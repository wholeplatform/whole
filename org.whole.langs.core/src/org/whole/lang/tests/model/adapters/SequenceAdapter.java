package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SequenceAdapter extends
		AbstractCollectionEntityAdapter<Expression> implements Sequence {
	private static final long serialVersionUID = 1;

	public SequenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public SequenceAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Sequence> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Sequence;
	}
}
