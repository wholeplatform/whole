package org.whole.lang.reusables.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReusablesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public ReusablesAdaptersEntityRegistry() {
        super(ReusablesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ReusableAdapter());
        put(new AdaptAdapter());
        put(new ReuseAdapter());
        put(new SynchAdapter());
        put(new IncludeAdapter());
        put(new ReusablesAdapter());
        put(new SourceAdapter());
        put(new PathExpressionAdapter());
        put(new StepExpressionAdapter());
        put(new ReferenceStepAdapter());
        put(new ResourceAdapter());
        put(new RegistryAdapter());
        put(new LocatorAdapter());
        put(new WorkspacePathAdapter());
        put(new FileSystemPathAdapter());
        put(new ClassPathURIAdapter());
        put(new URIAdapter());
        put(new PersistenceAdapter());
        put(new RevisionAdapter());
    }
}