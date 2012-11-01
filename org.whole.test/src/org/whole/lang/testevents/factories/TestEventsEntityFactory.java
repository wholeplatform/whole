package org.whole.lang.testevents.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.testevents.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsEntityFactory extends GenericEntityFactory {
	public static final TestEventsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static TestEventsEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new TestEventsEntityFactory(provider);
	}

	protected TestEventsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public TestEvents createTestEvents() {
		return create(TestEventsEntityDescriptorEnum.TestEvents);
	}

	public TestEvents createTestEvents(Val maxBase, Val maxHeight,
			Val numShapes, Shape shape) {
		return create(TestEventsEntityDescriptorEnum.TestEvents, maxBase,
				maxHeight, numShapes, shape);
	}

	public IEntityBuilder<TestEvents> buildTestEvents() {
		return new EntityBuilder<TestEvents>(
				create(TestEventsEntityDescriptorEnum.TestEvents));
	}

	public CompositeShape createCompositeShape() {
		return create(TestEventsEntityDescriptorEnum.CompositeShape);
	}

	public CompositeShape createCompositeShape(Shape... entities) {
		return create(TestEventsEntityDescriptorEnum.CompositeShape,
				(IEntity[]) entities);
	}

	public CompositeShape createCompositeShape(int initialSize) {
		return clone(TestEventsEntityDescriptorEnum.CompositeShape, initialSize);
	}

	public Rectangle createRectangle() {
		return create(TestEventsEntityDescriptorEnum.Rectangle);
	}

	public Rectangle createRectangle(Val base, Val height, Val area,
			Val perimeter) {
		return create(TestEventsEntityDescriptorEnum.Rectangle, base, height,
				area, perimeter);
	}

	public IEntityBuilder<Rectangle> buildRectangle() {
		return new EntityBuilder<Rectangle>(
				create(TestEventsEntityDescriptorEnum.Rectangle));
	}

	public Labels createLabels() {
		return create(TestEventsEntityDescriptorEnum.Labels);
	}

	public Labels createLabels(Label simple, Label simpleDerived,
			Label simpleDerivedDerived) {
		return create(TestEventsEntityDescriptorEnum.Labels, simple,
				simpleDerived, simpleDerivedDerived);
	}

	public IEntityBuilder<Labels> buildLabels() {
		return new EntityBuilder<Labels>(
				create(TestEventsEntityDescriptorEnum.Labels));
	}

	public Val createVal() {
		return create(TestEventsEntityDescriptorEnum.Val);
	}

	public Val createVal(int value) {
		return create(TestEventsEntityDescriptorEnum.Val, value);
	}

	public Label createLabel() {
		return create(TestEventsEntityDescriptorEnum.Label);
	}

	public Label createLabel(String value) {
		return create(TestEventsEntityDescriptorEnum.Label, value);
	}
}
