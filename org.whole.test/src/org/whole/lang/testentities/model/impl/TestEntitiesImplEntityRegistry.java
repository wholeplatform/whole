package org.whole.lang.testentities.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEntitiesImplEntityRegistry extends AbstractEntityRegistry {
	public TestEntitiesImplEntityRegistry() {
		super(TestEntitiesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SimpleTestEntityImpl());
		put(new ListTestEntityImpl());
		put(new UListTestEntityImpl());
		put(new SetTestEntityImpl());
		put(new BagTestEntityImpl());
		put(new MapTestEntityImpl());
		put(new BooleanTestEntityImpl());
		put(new ByteTestEntityImpl());
		put(new CharTestEntityImpl());
		put(new DoubleTestEntityImpl());
		put(new FloatTestEntityImpl());
		put(new IntTestEntityImpl());
		put(new LongTestEntityImpl());
		put(new ShortTestEntityImpl());
		put(new StringTestEntityImpl());
		put(new DateTestEntityImpl());
		put(new EnumTestEntityImpl());
		put(new ObjectTestEntityImpl());
	}
}
