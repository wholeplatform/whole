package org.whole.lang.modules.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.modules.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/**
 *  @generator  Whole
 */
public class ModulesEntityFactory extends GenericEntityFactory {
    public static final ModulesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static ModulesEntityFactory instance(IEntityRegistryProvider provider) {
        return new ModulesEntityFactory(provider);
    }

    protected ModulesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Module createModule() {
        return create(ModulesEntityDescriptorEnum.Module);
    }

    public Module createModule(Content content) {
        return create(ModulesEntityDescriptorEnum.Module, content);
    }

    public Include createInclude() {
        return create(ModulesEntityDescriptorEnum.Include);
    }

    public Include createInclude(Resource resource) {
        return create(ModulesEntityDescriptorEnum.Include, resource);
    }

    public Reuse createReuse() {
        return create(ModulesEntityDescriptorEnum.Reuse);
    }

    public Reuse createReuse(Resource resource, Adapter adapter, Content original, Content adapted, Content variant) {
        return create(ModulesEntityDescriptorEnum.Reuse, resource, adapter, original, adapted, variant);
    }

    public IEntityBuilder<Reuse> buildReuse() {
        return new EntityBuilder<Reuse>(create(ModulesEntityDescriptorEnum.Reuse));
    }

    public Resource createResource() {
        return create(ModulesEntityDescriptorEnum.Resource);
    }

    public Resource createResource(Locator locator, Persistence persistence, Registry registry) {
        return create(ModulesEntityDescriptorEnum.Resource, locator, persistence, registry);
    }

    public IEntityBuilder<Resource> buildResource() {
        return new EntityBuilder<Resource>(create(ModulesEntityDescriptorEnum.Resource));
    }

    public WorkspacePath createWorkspacePath() {
        return create(ModulesEntityDescriptorEnum.WorkspacePath);
    }

    public WorkspacePath createWorkspacePath(String value) {
        return create(ModulesEntityDescriptorEnum.WorkspacePath, value);
    }

    public FileSystemPath createFileSystemPath() {
        return create(ModulesEntityDescriptorEnum.FileSystemPath);
    }

    public FileSystemPath createFileSystemPath(String value) {
        return create(ModulesEntityDescriptorEnum.FileSystemPath, value);
    }

    public ClassPathURI createClassPathURI() {
        return create(ModulesEntityDescriptorEnum.ClassPathURI);
    }

    public ClassPathURI createClassPathURI(String value) {
        return create(ModulesEntityDescriptorEnum.ClassPathURI, value);
    }

    public URI createURI() {
        return create(ModulesEntityDescriptorEnum.URI);
    }

    public URI createURI(String value) {
        return create(ModulesEntityDescriptorEnum.URI, value);
    }

    public Persistence createPersistence() {
        return create(ModulesEntityDescriptorEnum.Persistence);
    }

    public Persistence createPersistence(String value) {
        return create(ModulesEntityDescriptorEnum.Persistence, value);
    }

    public Registry createRegistry() {
        return create(ModulesEntityDescriptorEnum.Registry);
    }

    public Registry createRegistry(String value) {
        return create(ModulesEntityDescriptorEnum.Registry, value);
    }
}
