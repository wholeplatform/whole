package org.whole.lang.reusables.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReusablesImplEntityRegistry extends AbstractEntityRegistry {

    public ReusablesImplEntityRegistry() {
        super(ReusablesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new AdaptImpl());
        put(new ReuseImpl());
        put(new IncludeImpl());
        put(new ReusablesImpl());
        put(new ResourceImpl());
        put(new RegistryImpl());
        put(new WorkspacePathImpl());
        put(new FileSystemPathImpl());
        put(new ClassPathURIImpl());
        put(new URIImpl());
        put(new PersistenceImpl());
    }
}
