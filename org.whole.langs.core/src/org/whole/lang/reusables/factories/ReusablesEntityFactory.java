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

    public Adapt createAdapt(Reusable original, PathExpression adapter, Reusable adapted, Revision adaptedRevision) {
        return create(ReusablesEntityDescriptorEnum.Adapt, original, adapter, adapted, adaptedRevision);
    }

    public IEntityBuilder<Adapt> buildAdapt() {
        return new EntityBuilder<Adapt>(create(ReusablesEntityDescriptorEnum.Adapt));
    }

    public Reuse createReuse() {
        return create(ReusablesEntityDescriptorEnum.Reuse);
    }

    public Reuse createReuse(Source source, Reusable original, PathExpression adapter, Reusable adapted, Revision adaptedRevision) {
        return create(ReusablesEntityDescriptorEnum.Reuse, source, original, adapter, adapted, adaptedRevision);
    }

    public IEntityBuilder<Reuse> buildReuse() {
        return new EntityBuilder<Reuse>(create(ReusablesEntityDescriptorEnum.Reuse));
    }

    public Synch createSynch() {
        return create(ReusablesEntityDescriptorEnum.Synch);
    }

    public Synch createSynch(Source source, Reusable original, PathExpression adapter, Reusable adapted, Revision adaptedRevision, Reusable variant, Revision variantRevision) {
        return create(ReusablesEntityDescriptorEnum.Synch, source, original, adapter, adapted, adaptedRevision, variant, variantRevision);
    }

    public IEntityBuilder<Synch> buildSynch() {
        return new EntityBuilder<Synch>(create(ReusablesEntityDescriptorEnum.Synch));
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

    public ReferenceStep createReferenceStep() {
        return create(ReusablesEntityDescriptorEnum.ReferenceStep);
    }

    public ReferenceStep createReferenceStep(Source source) {
        return create(ReusablesEntityDescriptorEnum.ReferenceStep, source);
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
