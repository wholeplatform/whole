package org.whole.lang.testentities.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestEntitiesAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TestEntitiesAdaptersEntityRegistry() {
		super(TestEntitiesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SimpleTestEntityAdapter());
		put(new ListTestEntityAdapter());
		put(new UListTestEntityAdapter());
		put(new SetTestEntityAdapter());
		put(new BagTestEntityAdapter());
		put(new MapTestEntityAdapter());
		put(new BooleanTestEntityAdapter());
		put(new ByteTestEntityAdapter());
		put(new CharTestEntityAdapter());
		put(new DoubleTestEntityAdapter());
		put(new FloatTestEntityAdapter());
		put(new IntTestEntityAdapter());
		put(new LongTestEntityAdapter());
		put(new ShortTestEntityAdapter());
		put(new StringTestEntityAdapter());
		put(new DateTestEntityAdapter());
		put(new EnumTestEntityAdapter());
		put(new ObjectTestEntityAdapter());
		put(new IDataEntityAdapter());
		put(new ICompositeEntityAdapter());
		put(new ITestEntityAdapter());
		put(new IStructuralEntityAdapter());
	}
}
