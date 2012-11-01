package org.whole.lang.testevents.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEventsImplEntityRegistry extends AbstractEntityRegistry {
	public TestEventsImplEntityRegistry() {
		super(TestEventsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TestEventsImpl());
		put(new CompositeShapeImpl());
		put(new RectangleImpl());
		put(new LabelsImpl());
		put(new ValImpl());
		put(new LabelImpl());
	}
}
