package org.whole.lang.testevents.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ShapeAdapter extends AbstractEntityAdapter implements Shape {
	private static final long serialVersionUID = 1;

	public ShapeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ShapeAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Shape> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Shape;
	}
}
