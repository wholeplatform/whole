package org.whole.lang.environment.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentAdaptersEntityRegistry extends AbstractEntityRegistry {
	public EnvironmentAdaptersEntityRegistry() {
		super(EnvironmentEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DataAdapter());
		put(new BooleanDataAdapter());
		put(new ByteDataAdapter());
		put(new CharDataAdapter());
		put(new DoubleDataAdapter());
		put(new FloatDataAdapter());
		put(new IntDataAdapter());
		put(new LongDataAdapter());
		put(new ShortDataAdapter());
		put(new StringDataAdapter());
		put(new DateDataAdapter());
		put(new ObjectDataAdapter());
		put(new TupleAdapter());
		put(new ContainmentTupleAdapter());
		put(new VoidAdapter());
	}
}
