package org.whole.lang.modules.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModulesGenericBuilderAdapter extends GenericIdentityBuilder {
    private IModulesBuilder specificBuilder;

    public ModulesGenericBuilderAdapter(IModulesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public ModulesGenericBuilderAdapter(IModulesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case ModulesFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case ModulesFeatureDescriptorEnum.resource_ord :
            specificBuilder.resource();
            break;
            case ModulesFeatureDescriptorEnum.adapter_ord :
            specificBuilder.adapter();
            break;
            case ModulesFeatureDescriptorEnum.original_ord :
            specificBuilder.original();
            break;
            case ModulesFeatureDescriptorEnum.adapted_ord :
            specificBuilder.adapted();
            break;
            case ModulesFeatureDescriptorEnum.variant_ord :
            specificBuilder.variant();
            break;
            case ModulesFeatureDescriptorEnum.locator_ord :
            specificBuilder.locator();
            break;
            case ModulesFeatureDescriptorEnum.persistence_ord :
            specificBuilder.persistence();
            break;
            case ModulesFeatureDescriptorEnum.registry_ord :
            specificBuilder.registry();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ModulesEntityDescriptorEnum.Module_ord :
            specificBuilder.Module();
            break;
            case ModulesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include();
            break;
            case ModulesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse();
            break;
            case ModulesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ModulesEntityDescriptorEnum.Module_ord :
            specificBuilder.Module_();
            break;
            case ModulesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include_();
            break;
            case ModulesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse_();
            break;
            case ModulesEntityDescriptorEnum.Resource_ord :
            specificBuilder.Resource_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ModulesEntityDescriptorEnum.Module_ord :
            specificBuilder._Module();
            break;
            case ModulesEntityDescriptorEnum.Include_ord :
            specificBuilder._Include();
            break;
            case ModulesEntityDescriptorEnum.Reuse_ord :
            specificBuilder._Reuse();
            break;
            case ModulesEntityDescriptorEnum.Resource_ord :
            specificBuilder._Resource();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case ModulesEntityDescriptorEnum.WorkspacePath_ord :
            specificBuilder.WorkspacePath(value);
            break;
            case ModulesEntityDescriptorEnum.FileSystemPath_ord :
            specificBuilder.FileSystemPath(value);
            break;
            case ModulesEntityDescriptorEnum.ClassPathURI_ord :
            specificBuilder.ClassPathURI(value);
            break;
            case ModulesEntityDescriptorEnum.URI_ord :
            specificBuilder.URI(value);
            break;
            case ModulesEntityDescriptorEnum.Persistence_ord :
            specificBuilder.Persistence(value);
            break;
            case ModulesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry(value);
            break;
        }
    }
}
