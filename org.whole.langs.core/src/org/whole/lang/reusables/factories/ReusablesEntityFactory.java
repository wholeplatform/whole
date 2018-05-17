/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
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
 *  @generator Whole
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

    public Adapt createAdapt(Reusable original, Expression adapter, Reusable adapted, Revision adaptedRevision) {
        return create(ReusablesEntityDescriptorEnum.Adapt, original, adapter, adapted, adaptedRevision);
    }

    public IEntityBuilder<Adapt> buildAdapt() {
        return new EntityBuilder<Adapt>(create(ReusablesEntityDescriptorEnum.Adapt));
    }

    public Reuse createReuse() {
        return create(ReusablesEntityDescriptorEnum.Reuse);
    }

    public Reuse createReuse(Resource resource, Reusable original, Expression adapter, Reusable adapted, Revision adaptedRevision) {
        return create(ReusablesEntityDescriptorEnum.Reuse, resource, original, adapter, adapted, adaptedRevision);
    }

    public IEntityBuilder<Reuse> buildReuse() {
        return new EntityBuilder<Reuse>(create(ReusablesEntityDescriptorEnum.Reuse));
    }

    public Sync createSync() {
        return create(ReusablesEntityDescriptorEnum.Sync);
    }

    public Sync createSync(Resource resource, Reusable original, Expression adapter, Reusable adapted, Revision adaptedRevision, Reusable variant, Revision variantRevision) {
        return create(ReusablesEntityDescriptorEnum.Sync, resource, original, adapter, adapted, adaptedRevision, variant, variantRevision);
    }

    public IEntityBuilder<Sync> buildSync() {
        return new EntityBuilder<Sync>(create(ReusablesEntityDescriptorEnum.Sync));
    }

    public Include createInclude() {
        return create(ReusablesEntityDescriptorEnum.Include);
    }

    public Include createInclude(Resource resource) {
        return create(ReusablesEntityDescriptorEnum.Include, resource);
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

    public Workspace createWorkspace() {
        return create(ReusablesEntityDescriptorEnum.Workspace);
    }

    public Workspace createWorkspace(Content content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.Workspace, content, persistence);
    }

    public IEntityBuilder<Workspace> buildWorkspace() {
        return new EntityBuilder<Workspace>(create(ReusablesEntityDescriptorEnum.Workspace));
    }

    public FileSystem createFileSystem() {
        return create(ReusablesEntityDescriptorEnum.FileSystem);
    }

    public FileSystem createFileSystem(Content content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.FileSystem, content, persistence);
    }

    public IEntityBuilder<FileSystem> buildFileSystem() {
        return new EntityBuilder<FileSystem>(create(ReusablesEntityDescriptorEnum.FileSystem));
    }

    public Classpath createClasspath() {
        return create(ReusablesEntityDescriptorEnum.Classpath);
    }

    public Classpath createClasspath(Content content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.Classpath, content, persistence);
    }

    public IEntityBuilder<Classpath> buildClasspath() {
        return new EntityBuilder<Classpath>(create(ReusablesEntityDescriptorEnum.Classpath));
    }

    public URL createURL() {
        return create(ReusablesEntityDescriptorEnum.URL);
    }

    public URL createURL(Content content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.URL, content, persistence);
    }

    public IEntityBuilder<URL> buildURL() {
        return new EntityBuilder<URL>(create(ReusablesEntityDescriptorEnum.URL));
    }

    public Model createModel() {
        return create(ReusablesEntityDescriptorEnum.Model);
    }

    public Model createModel(Expression content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.Model, content, persistence);
    }

    public IEntityBuilder<Model> buildModel() {
        return new EntityBuilder<Model>(create(ReusablesEntityDescriptorEnum.Model));
    }

    public Registry createRegistry() {
        return create(ReusablesEntityDescriptorEnum.Registry);
    }

    public Registry createRegistry(URI registryUri, URI uri) {
        return create(ReusablesEntityDescriptorEnum.Registry, registryUri, uri);
    }

    public IEntityBuilder<Registry> buildRegistry() {
        return new EntityBuilder<Registry>(create(ReusablesEntityDescriptorEnum.Registry));
    }

    public Contents createContents() {
        return create(ReusablesEntityDescriptorEnum.Contents);
    }

    public Contents createContents(Content... entities) {
        return create(ReusablesEntityDescriptorEnum.Contents, (IEntity[]) entities);
    }

    public Contents createContents(int initialSize) {
        return clone(ReusablesEntityDescriptorEnum.Contents, initialSize);
    }

    public Folder createFolder() {
        return create(ReusablesEntityDescriptorEnum.Folder);
    }

    public Folder createFolder(Expression path, Content content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.Folder, path, content, persistence);
    }

    public IEntityBuilder<Folder> buildFolder() {
        return new EntityBuilder<Folder>(create(ReusablesEntityDescriptorEnum.Folder));
    }

    public File createFile() {
        return create(ReusablesEntityDescriptorEnum.File);
    }

    public File createFile(Expression path, Any content, Persistence persistence) {
        return create(ReusablesEntityDescriptorEnum.File, path, content, persistence);
    }

    public IEntityBuilder<File> buildFile() {
        return new EntityBuilder<File>(create(ReusablesEntityDescriptorEnum.File));
    }

    public Exists createExists() {
        return create(ReusablesEntityDescriptorEnum.Exists);
    }

    public Exists createExists(Resource resource) {
        return create(ReusablesEntityDescriptorEnum.Exists, resource);
    }

    public Delete createDelete() {
        return create(ReusablesEntityDescriptorEnum.Delete);
    }

    public Delete createDelete(Resource resource) {
        return create(ReusablesEntityDescriptorEnum.Delete, resource);
    }

    public Load createLoad() {
        return create(ReusablesEntityDescriptorEnum.Load);
    }

    public Load createLoad(Resource resource) {
        return create(ReusablesEntityDescriptorEnum.Load, resource);
    }

    public Save createSave() {
        return create(ReusablesEntityDescriptorEnum.Save);
    }

    public Save createSave(Resource resource) {
        return create(ReusablesEntityDescriptorEnum.Save, resource);
    }

    public PathName createPathName() {
        return create(ReusablesEntityDescriptorEnum.PathName);
    }

    public PathName createPathName(String value) {
        return create(ReusablesEntityDescriptorEnum.PathName, value);
    }

    public PathWithExtension createPathWithExtension() {
        return create(ReusablesEntityDescriptorEnum.PathWithExtension);
    }

    public PathWithExtension createPathWithExtension(Expression path, Expression extension) {
        return create(ReusablesEntityDescriptorEnum.PathWithExtension, path, extension);
    }

    public IEntityBuilder<PathWithExtension> buildPathWithExtension() {
        return new EntityBuilder<PathWithExtension>(create(ReusablesEntityDescriptorEnum.PathWithExtension));
    }

    public PathSegments createPathSegments() {
        return create(ReusablesEntityDescriptorEnum.PathSegments);
    }

    public PathSegments createPathSegments(Expression... entities) {
        return create(ReusablesEntityDescriptorEnum.PathSegments, (IEntity[]) entities);
    }

    public PathSegments createPathSegments(int initialSize) {
        return clone(ReusablesEntityDescriptorEnum.PathSegments, initialSize);
    }

    public URI createURI() {
        return create(ReusablesEntityDescriptorEnum.URI);
    }

    public URI createURI(String value) {
        return create(ReusablesEntityDescriptorEnum.URI, value);
    }

    public PersistenceId createPersistenceId() {
        return create(ReusablesEntityDescriptorEnum.PersistenceId);
    }

    public PersistenceId createPersistenceId(String value) {
        return create(ReusablesEntityDescriptorEnum.PersistenceId, value);
    }
}
