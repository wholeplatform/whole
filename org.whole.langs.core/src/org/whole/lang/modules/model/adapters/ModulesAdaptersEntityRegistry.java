package org.whole.lang.modules.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModulesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public ModulesAdaptersEntityRegistry() {
        super(ModulesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ModuleAdapter());
        put(new IncludeAdapter());
        put(new ReuseAdapter());
        put(new ResourceAdapter());
        put(new LocatorAdapter());
        put(new WorkspacePathAdapter());
        put(new FileSystemPathAdapter());
        put(new ClassPathURIAdapter());
        put(new URIAdapter());
        put(new PersistenceAdapter());
        put(new RegistryAdapter());
        put(new ContentAdapter());
        put(new AdapterAdapter());
    }
}
