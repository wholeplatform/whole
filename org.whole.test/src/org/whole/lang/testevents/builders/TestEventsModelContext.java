package org.whole.lang.testevents.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsModelContext extends EntityContext {
	public TestEventsModelContext(IEntity root) {
		super(root);
	}

	public TestEventsModelContext getMaxBase() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.maxBase);
	}

	public void setMaxBase(TestEventsModelContext maxBase) {
		wSet(TestEventsFeatureDescriptorEnum.maxBase, maxBase);
	}

	public TestEventsModelContext getMaxHeight() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.maxHeight);
	}

	public void setMaxHeight(TestEventsModelContext maxHeight) {
		wSet(TestEventsFeatureDescriptorEnum.maxHeight, maxHeight);
	}

	public TestEventsModelContext getNumShapes() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.numShapes);
	}

	public void setNumShapes(TestEventsModelContext numShapes) {
		wSet(TestEventsFeatureDescriptorEnum.numShapes, numShapes);
	}

	public TestEventsModelContext getShape() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.shape);
	}

	public void setShape(TestEventsModelContext shape) {
		wSet(TestEventsFeatureDescriptorEnum.shape, shape);
	}

	public TestEventsModelContext getBase() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.base);
	}

	public void setBase(TestEventsModelContext base) {
		wSet(TestEventsFeatureDescriptorEnum.base, base);
	}

	public TestEventsModelContext getHeight() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.height);
	}

	public void setHeight(TestEventsModelContext height) {
		wSet(TestEventsFeatureDescriptorEnum.height, height);
	}

	public TestEventsModelContext getArea() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.area);
	}

	public void setArea(TestEventsModelContext area) {
		wSet(TestEventsFeatureDescriptorEnum.area, area);
	}

	public TestEventsModelContext getPerimeter() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.perimeter);
	}

	public void setPerimeter(TestEventsModelContext perimeter) {
		wSet(TestEventsFeatureDescriptorEnum.perimeter, perimeter);
	}

	public TestEventsModelContext getSimple() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.simple);
	}

	public void setSimple(TestEventsModelContext simple) {
		wSet(TestEventsFeatureDescriptorEnum.simple, simple);
	}

	public TestEventsModelContext getSimpleDerived() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.simpleDerived);
	}

	public void setSimpleDerived(TestEventsModelContext simpleDerived) {
		wSet(TestEventsFeatureDescriptorEnum.simpleDerived, simpleDerived);
	}

	public TestEventsModelContext getSimpleDerivedDerived() {
		return (TestEventsModelContext) wGet(TestEventsFeatureDescriptorEnum.simpleDerivedDerived);
	}

	public void setSimpleDerivedDerived(
			TestEventsModelContext simpleDerivedDerived) {
		wSet(TestEventsFeatureDescriptorEnum.simpleDerivedDerived,
				simpleDerivedDerived);
	}
}
