package org.whole.lang.testevents.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.testevents.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RectangleImpl extends AbstractSimpleEntity implements Rectangle {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Rectangle> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Rectangle;
	}

	public int wGetEntityOrd() {
		return TestEventsEntityDescriptorEnum.Rectangle_ord;
	}

	public void accept(ITestEventsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Val base;

	public Val getBase() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.base, base);
	}

	public void setBase(Val base) {
		notifyChanged(TestEventsFeatureDescriptorEnum.base, this.base,
				this.base = base);
	}

	private Val height;

	public Val getHeight() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.height, height);
	}

	public void setHeight(Val height) {
		notifyChanged(TestEventsFeatureDescriptorEnum.height, this.height,
				this.height = height);
	}

	private Val area;

	public Val getArea() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.area, area);
	}

	public void setArea(Val area) {
		notifyChanged(TestEventsFeatureDescriptorEnum.area, this.area,
				this.area = area);
	}

	private Val perimeter;

	public Val getPerimeter() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.perimeter,
				perimeter);
	}

	public void setPerimeter(Val perimeter) {
		notifyChanged(TestEventsFeatureDescriptorEnum.perimeter,
				this.perimeter, this.perimeter = perimeter);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBase().wGetAdaptee(false);
		case 1:
			return getHeight().wGetAdaptee(false);
		case 2:
			return getArea().wGetAdaptee(false);
		case 3:
			return getPerimeter().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBase(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 1:
			setHeight(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 2:
			setArea(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 3:
			setPerimeter(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
