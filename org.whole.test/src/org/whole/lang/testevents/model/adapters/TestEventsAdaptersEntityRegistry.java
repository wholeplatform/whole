package org.whole.lang.testevents.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TestEventsAdaptersEntityRegistry() {
		super(TestEventsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TestEventsAdapter());
		put(new CompositeShapeAdapter());
		put(new RectangleAdapter());
		put(new LabelsAdapter());
		put(new ValAdapter());
		put(new LabelAdapter());
		put(new ShapeAdapter());
	}
}
