package org.whole.lang.testevents.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.testevents.model.*;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CompositeShapeImpl extends
		AbstractCollectionCompositeEntity<Shape> implements CompositeShape {
	private static final long serialVersionUID = 1;

	public void accept(ITestEventsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestEventsEntityDescriptorEnum.CompositeShape_ord;
	}

	public EntityDescriptor<CompositeShape> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.CompositeShape;
	}
}
