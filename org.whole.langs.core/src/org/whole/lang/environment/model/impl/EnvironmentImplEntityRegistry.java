package org.whole.lang.environment.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentImplEntityRegistry extends AbstractEntityRegistry {
	public EnvironmentImplEntityRegistry() {
		super(EnvironmentEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new BooleanDataImpl());
		put(new ByteDataImpl());
		put(new CharDataImpl());
		put(new DoubleDataImpl());
		put(new FloatDataImpl());
		put(new IntDataImpl());
		put(new LongDataImpl());
		put(new ShortDataImpl());
		put(new StringDataImpl());
		put(new DateDataImpl());
		put(new ObjectDataImpl());
		put(new TupleImpl());
		put(new ContainmentTupleImpl());
		put(new VoidImpl());
	}
}
