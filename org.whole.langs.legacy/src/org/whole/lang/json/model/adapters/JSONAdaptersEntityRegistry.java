package org.whole.lang.json.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class JSONAdaptersEntityRegistry extends AbstractEntityRegistry {

    public JSONAdaptersEntityRegistry() {
        super(JSONEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ValueAdapter());
        put(new ObjectAdapter());
        put(new PairAdapter());
        put(new NameAdapter());
        put(new ArrayAdapter());
        put(new StringAdapter());
        put(new DecimalAdapter());
        put(new IntAdapter());
        put(new BoolAdapter());
        put(new NullAdapter());
    }
}
