package org.whole.lang.reusables.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.reusables.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ReusablesEntityFactory extends GenericEntityFactory {
    public static final ReusablesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static ReusablesEntityFactory instance(IEntityRegistryProvider provider) {
        return new ReusablesEntityFactory(provider);
    }

    protected ReusablesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Adapt createAdapt() {
        return create(ReusablesEntityDescriptorEnum.Adapt);
    }

    public Adapt createAdapt(Reusable original, PathExpression adapter, Reusable adapted) {
        return create(ReusablesEntityDescriptorEnum.Adapt, original, adapter, adapted);
    }

    public IEntityBuilder<Adapt> buildAdapt() {
        return new EntityBuilder<Adapt>(create(ReusablesEntityDescriptorEnum.Adapt));
    }

    public Reuse createReuse() {
        return create(ReusablesEntityDescriptorEnum.Reuse);
    }

    public Reuse createReuse(Source source, Reusable original, PathExpression adapter, Reusable adapted, Reusable variant) {
        return create(ReusablesEntityDescriptorEnum.Reuse, source, original, adapter, adapted, variant);
    }

    public IEntityBuilder<Reuse> buildReuse() {
        return new EntityBuilder<Reuse>(create(ReusablesEntityDescriptorEnum.Reuse));
    }

    public Include createInclude() {
        return create(ReusablesEntityDescriptorEnum.Include);
    }

    public Include createInclude(Source source) {
        return create(ReusablesEntityDescriptorEnum.Include, source);
    }

    public Reusables createReusables() {
        return create(ReusablesEntityDescriptorEnum.Reusables);
    }

    public Reusables createReusables(Reusable... entities) {
        return create(ReusablesEntityDescriptorEnum.Reusables, (IEntity[]) entities);
    }

    public Reusables createReusables(int initialSize) {
        return clone(ReusablesEntityDescriptorEnum.Reusables, initialSize);
    }

    public Resource createResource() {
        return create(ReusablesEntityDescriptorEnum.Resource);
    }

    public Resource createResource(Locator locator, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.Resource, locator, persistence);
    }

    public IEntityBuilder<Resource> buildResource() {
        return new EntityBuilder<Resource>(create(ReusablesEntityDescriptorEnum.Resource));
    }

    public Registry createRegistry() {
        return create(ReusablesEntityDescriptorEnum.Registry);
    }

    public Registry createRegistry(URI locator, URI uri) {
        return create(ReusablesEntityDescriptorEnum.Registry, locator, uri);
    }

    public IEntityBuilder<Registry> buildRegistry() {
        return new EntityBuilder<Registry>(create(ReusablesEntityDescriptorEnum.Registry));
    }

    public WorkspacePath createWorkspacePath() {
        return create(ReusablesEntityDescriptorEnum.WorkspacePath);
    }

    public WorkspacePath createWorkspacePath(String value) {
        return create(ReusablesEntityDescriptorEnum.WorkspacePath, value);
    }

    public FileSystemPath createFileSystemPath() {
        return create(ReusablesEntityDescriptorEnum.FileSystemPath);
    }

    public FileSystemPath createFileSystemPath(String value) {
        return create(ReusablesEntityDescriptorEnum.FileSystemPath, value);
    }

    public ClassPathURI createClassPathURI() {
        return create(ReusablesEntityDescriptorEnum.ClassPathURI);
    }

    public ClassPathURI createClassPathURI(String value) {
        return create(ReusablesEntityDescriptorEnum.ClassPathURI, value);
    }

    public URI createURI() {
        return create(ReusablesEntityDescriptorEnum.URI);
    }

    public URI createURI(String value) {
        return create(ReusablesEntityDescriptorEnum.URI, value);
    }

    public Persistence createPersistence() {
        return create(ReusablesEntityDescriptorEnum.Persistence);
    }

    public Persistence createPersistence(String value) {
        return create(ReusablesEntityDescriptorEnum.Persistence, value);
    }
}
