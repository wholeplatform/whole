package org.whole.lang.json.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class JSONImplEntityRegistry extends AbstractEntityRegistry {

    public JSONImplEntityRegistry() {
        super(JSONEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ObjectImpl());
        put(new PairImpl());
        put(new NameImpl());
        put(new ArrayImpl());
        put(new StringImpl());
        put(new DecimalImpl());
        put(new IntImpl());
        put(new BoolImpl());
        put(new NullImpl());
    }
}
