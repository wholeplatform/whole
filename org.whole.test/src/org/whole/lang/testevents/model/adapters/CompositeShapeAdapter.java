package org.whole.lang.testevents.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CompositeShapeAdapter extends AbstractSetEntityAdapter<Shape>
		implements CompositeShape {
	private static final long serialVersionUID = 1;

	public CompositeShapeAdapter(IEntity implementor) {
		super(implementor);
	}

	public CompositeShapeAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CompositeShape> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.CompositeShape;
	}
}
