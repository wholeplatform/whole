package org.whole.lang.testevents.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsAdapter extends AbstractEntityAdapter implements
		TestEvents {
	private static final long serialVersionUID = 1;

	public TestEventsAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestEventsAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestEvents> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.TestEvents;
	}

	public Val getMaxBase() {
		return wGet(TestEventsFeatureDescriptorEnum.maxBase).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setMaxBase(Val maxBase) {
		wSet(TestEventsFeatureDescriptorEnum.maxBase, maxBase);
	}

	public Val getMaxHeight() {
		return wGet(TestEventsFeatureDescriptorEnum.maxHeight).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setMaxHeight(Val maxHeight) {
		wSet(TestEventsFeatureDescriptorEnum.maxHeight, maxHeight);
	}

	public Val getNumShapes() {
		return wGet(TestEventsFeatureDescriptorEnum.numShapes).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setNumShapes(Val numShapes) {
		wSet(TestEventsFeatureDescriptorEnum.numShapes, numShapes);
	}

	public Shape getShape() {
		return wGet(TestEventsFeatureDescriptorEnum.shape).wGetAdapter(
				TestEventsEntityDescriptorEnum.Shape);
	}

	public void setShape(Shape shape) {
		wSet(TestEventsFeatureDescriptorEnum.shape, shape);
	}
}
