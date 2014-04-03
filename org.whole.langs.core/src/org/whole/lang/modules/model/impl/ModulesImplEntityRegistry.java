package org.whole.lang.modules.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModulesImplEntityRegistry extends AbstractEntityRegistry {

    public ModulesImplEntityRegistry() {
        super(ModulesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ModuleImpl());
        put(new IncludeImpl());
        put(new ReuseImpl());
        put(new ResourceImpl());
        put(new WorkspacePathImpl());
        put(new FileSystemPathImpl());
        put(new ClassPathURIImpl());
        put(new URIImpl());
        put(new PersistenceImpl());
        put(new RegistryImpl());
    }
}
