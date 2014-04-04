package org.whole.lang.reusables.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
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
            case ReusablesFeatureDescriptorEnum.source_ord :
            specificBuilder.source();
            break;
            case ReusablesFeatureDescriptorEnum.variant_ord :
            specificBuilder.variant();
            break;
            case ReusablesFeatureDescriptorEnum.locator_ord :
            specificBuilder.locator();
            break;
            case ReusablesFeatureDescriptorEnum.persistence_ord :
            specificBuilder.persistence();
            break;
            case ReusablesFeatureDescriptorEnum.registry_ord :
            specificBuilder.registry();
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
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource();
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
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include_();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource_();
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
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder._Include();
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            specificBuilder._Resource();
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
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry(value);
            break;
        }
    }
}
