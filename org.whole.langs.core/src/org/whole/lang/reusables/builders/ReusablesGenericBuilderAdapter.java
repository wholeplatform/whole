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
package org.whole.lang.reusables.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesGenericBuilderAdapter extends GenericIdentityBuilder {
    private IReusablesBuilder specificBuilder;

    public ReusablesGenericBuilderAdapter(IReusablesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public ReusablesGenericBuilderAdapter(IReusablesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case ReusablesFeatureDescriptorEnum.original_ord :
            specificBuilder.original();
            break;
            case ReusablesFeatureDescriptorEnum.adapter_ord :
            specificBuilder.adapter();
            break;
            case ReusablesFeatureDescriptorEnum.adapted_ord :
            specificBuilder.adapted();
            break;
            case ReusablesFeatureDescriptorEnum.adaptedRevision_ord :
            specificBuilder.adaptedRevision();
            break;
            case ReusablesFeatureDescriptorEnum.source_ord :
            specificBuilder.source();
            break;
            case ReusablesFeatureDescriptorEnum.variant_ord :
            specificBuilder.variant();
            break;
            case ReusablesFeatureDescriptorEnum.variantRevision_ord :
            specificBuilder.variantRevision();
            break;
            case ReusablesFeatureDescriptorEnum.locator_ord :
            specificBuilder.locator();
            break;
            case ReusablesFeatureDescriptorEnum.persistence_ord :
            specificBuilder.persistence();
            break;
            case ReusablesFeatureDescriptorEnum.uri_ord :
            specificBuilder.uri();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder.Adapt();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse();
            break;
            case ReusablesEntityDescriptorEnum.Synch_ord :
            specificBuilder.Synch();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables();
            break;
            case ReusablesEntityDescriptorEnum.ReferenceStep_ord :
            specificBuilder.ReferenceStep();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder.Adapt_();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse_();
            break;
            case ReusablesEntityDescriptorEnum.Synch_ord :
            specificBuilder.Synch_();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include_();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables_();
            break;
            case ReusablesEntityDescriptorEnum.ReferenceStep_ord :
            specificBuilder.ReferenceStep_();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource_();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder._Adapt();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder._Reuse();
            break;
            case ReusablesEntityDescriptorEnum.Synch_ord :
            specificBuilder._Synch();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder._Include();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder._Reusables();
            break;
            case ReusablesEntityDescriptorEnum.ReferenceStep_ord :
            specificBuilder._ReferenceStep();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder._Resource();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder._Registry();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.WorkspacePath_ord :
            specificBuilder.WorkspacePath(value);
            break;
            case ReusablesEntityDescriptorEnum.FileSystemPath_ord :
            specificBuilder.FileSystemPath(value);
            break;
            case ReusablesEntityDescriptorEnum.ClassPathURI_ord :
            specificBuilder.ClassPathURI(value);
            break;
            case ReusablesEntityDescriptorEnum.URI_ord :
            specificBuilder.URI(value);
            break;
            case ReusablesEntityDescriptorEnum.Persistence_ord :
            specificBuilder.Persistence(value);
            break;
        }
    }
}
