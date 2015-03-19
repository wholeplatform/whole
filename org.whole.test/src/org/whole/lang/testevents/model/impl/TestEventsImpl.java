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
public class TestEventsImpl extends AbstractSimpleEntity implements TestEvents {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TestEvents> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.TestEvents;
	}

	public int wGetEntityOrd() {
		return TestEventsEntityDescriptorEnum.TestEvents_ord;
	}

	public void accept(ITestEventsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Val maxBase;

	public Val getMaxBase() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.maxBase, maxBase);
	}

	public void setMaxBase(Val maxBase) {
		notifyChanged(TestEventsFeatureDescriptorEnum.maxBase, this.maxBase,
				this.maxBase = maxBase);
	}

	private Val maxHeight;

	public Val getMaxHeight() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.maxHeight,
				maxHeight);
	}

	public void setMaxHeight(Val maxHeight) {
		notifyChanged(TestEventsFeatureDescriptorEnum.maxHeight,
				this.maxHeight, this.maxHeight = maxHeight);
	}

	private Val numShapes;

	public Val getNumShapes() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.numShapes,
				numShapes);
	}

	public void setNumShapes(Val numShapes) {
		notifyChanged(TestEventsFeatureDescriptorEnum.numShapes,
				this.numShapes, this.numShapes = numShapes);
	}

	private Shape shape;

	public Shape getShape() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.shape, shape);
	}

	public void setShape(Shape shape) {
		notifyChanged(TestEventsFeatureDescriptorEnum.shape, this.shape,
				this.shape = shape);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getMaxBase().wGetAdaptee(false);
		case 1:
			return getMaxHeight().wGetAdaptee(false);
		case 2:
			return getNumShapes().wGetAdaptee(false);
		case 3:
			return getShape().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setMaxBase(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 1:
			setMaxHeight(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 2:
			setNumShapes(value.wGetAdapter(TestEventsEntityDescriptorEnum.Val));
			break;
		case 3:
			setShape(value.wGetAdapter(TestEventsEntityDescriptorEnum.Shape));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
