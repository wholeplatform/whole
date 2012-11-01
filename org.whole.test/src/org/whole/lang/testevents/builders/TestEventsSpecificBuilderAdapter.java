package org.whole.lang.testevents.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsSpecificBuilderAdapter extends GenericBuilderContext
		implements ITestEventsBuilder {
	public TestEventsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public TestEventsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void simpleDerivedDerived() {
		wFeature(TestEventsFeatureDescriptorEnum.simpleDerivedDerived);
	}

	public void simpleDerived() {
		wFeature(TestEventsFeatureDescriptorEnum.simpleDerived);
	}

	public void simple() {
		wFeature(TestEventsFeatureDescriptorEnum.simple);
	}

	public void perimeter() {
		wFeature(TestEventsFeatureDescriptorEnum.perimeter);
	}

	public void area() {
		wFeature(TestEventsFeatureDescriptorEnum.area);
	}

	public void height() {
		wFeature(TestEventsFeatureDescriptorEnum.height);
	}

	public void base() {
		wFeature(TestEventsFeatureDescriptorEnum.base);
	}

	public void shape() {
		wFeature(TestEventsFeatureDescriptorEnum.shape);
	}

	public void numShapes() {
		wFeature(TestEventsFeatureDescriptorEnum.numShapes);
	}

	public void maxHeight() {
		wFeature(TestEventsFeatureDescriptorEnum.maxHeight);
	}

	public void maxBase() {
		wFeature(TestEventsFeatureDescriptorEnum.maxBase);
	}

	public void visit() {
	}

	public void TestEvents() {
		wEntity(TestEventsEntityDescriptorEnum.TestEvents);
	}

	public void TestEvents_() {
		wEntity_(TestEventsEntityDescriptorEnum.TestEvents);
	}

	public void _TestEvents() {
		_wEntity(TestEventsEntityDescriptorEnum.TestEvents);
	}

	public void CompositeShape() {
		wEntity(TestEventsEntityDescriptorEnum.CompositeShape);
	}

	public void CompositeShape_() {
		wEntity_(TestEventsEntityDescriptorEnum.CompositeShape);
	}

	public void CompositeShape_(int initialCapacity) {
		wEntity_(TestEventsEntityDescriptorEnum.CompositeShape, initialCapacity);
	}

	public void _CompositeShape() {
		_wEntity(TestEventsEntityDescriptorEnum.CompositeShape);
	}

	public void Rectangle() {
		wEntity(TestEventsEntityDescriptorEnum.Rectangle);
	}

	public void Rectangle_() {
		wEntity_(TestEventsEntityDescriptorEnum.Rectangle);
	}

	public void _Rectangle() {
		_wEntity(TestEventsEntityDescriptorEnum.Rectangle);
	}

	public void Labels() {
		wEntity(TestEventsEntityDescriptorEnum.Labels);
	}

	public void Labels_() {
		wEntity_(TestEventsEntityDescriptorEnum.Labels);
	}

	public void _Labels() {
		_wEntity(TestEventsEntityDescriptorEnum.Labels);
	}

	public void Val() {
		wEntity(TestEventsEntityDescriptorEnum.Val);
	}

	public void Val(int value) {
		wEntity(TestEventsEntityDescriptorEnum.Val, value);
	}

	public void Label() {
		wEntity(TestEventsEntityDescriptorEnum.Label);
	}

	public void Label(String value) {
		wEntity(TestEventsEntityDescriptorEnum.Label, value);
	}
}
