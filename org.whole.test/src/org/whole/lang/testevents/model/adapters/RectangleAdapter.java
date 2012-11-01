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
public class RectangleAdapter extends AbstractEntityAdapter implements
		Rectangle {
	private static final long serialVersionUID = 1;

	public RectangleAdapter(IEntity implementor) {
		super(implementor);
	}

	public RectangleAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Rectangle> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Rectangle;
	}

	public Val getBase() {
		return wGet(TestEventsFeatureDescriptorEnum.base).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setBase(Val base) {
		wSet(TestEventsFeatureDescriptorEnum.base, base);
	}

	public Val getHeight() {
		return wGet(TestEventsFeatureDescriptorEnum.height).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setHeight(Val height) {
		wSet(TestEventsFeatureDescriptorEnum.height, height);
	}

	public Val getArea() {
		return wGet(TestEventsFeatureDescriptorEnum.area).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setArea(Val area) {
		wSet(TestEventsFeatureDescriptorEnum.area, area);
	}

	public Val getPerimeter() {
		return wGet(TestEventsFeatureDescriptorEnum.perimeter).wGetAdapter(
				TestEventsEntityDescriptorEnum.Val);
	}

	public void setPerimeter(Val perimeter) {
		wSet(TestEventsFeatureDescriptorEnum.perimeter, perimeter);
	}
}
