package org.whole.lang.modules.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModulesSpecificBuilderAdapter extends GenericBuilderContext implements IModulesBuilder {

    public ModulesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public ModulesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void registry() {
        wFeature(ModulesFeatureDescriptorEnum.registry);
    }

    public void persistence() {
        wFeature(ModulesFeatureDescriptorEnum.persistence);
    }

    public void locator() {
        wFeature(ModulesFeatureDescriptorEnum.locator);
    }

    public void variant() {
        wFeature(ModulesFeatureDescriptorEnum.variant);
    }

    public void adapted() {
        wFeature(ModulesFeatureDescriptorEnum.adapted);
    }

    public void original() {
        wFeature(ModulesFeatureDescriptorEnum.original);
    }

    public void adapter() {
        wFeature(ModulesFeatureDescriptorEnum.adapter);
    }

    public void resource() {
        wFeature(ModulesFeatureDescriptorEnum.resource);
    }

    public void content() {
        wFeature(ModulesFeatureDescriptorEnum.content);
    }

    public void visit() {
    }

    public void Module() {
        wEntity(ModulesEntityDescriptorEnum.Module);
    }

    public void Module_() {
        wEntity_(ModulesEntityDescriptorEnum.Module);
    }

    public void _Module() {
        _wEntity(ModulesEntityDescriptorEnum.Module);
    }

    public void Include() {
        wEntity(ModulesEntityDescriptorEnum.Include);
    }

    public void Include_() {
        wEntity_(ModulesEntityDescriptorEnum.Include);
    }

    public void _Include() {
        _wEntity(ModulesEntityDescriptorEnum.Include);
    }

    public void Reuse() {
        wEntity(ModulesEntityDescriptorEnum.Reuse);
    }

    public void Reuse_() {
        wEntity_(ModulesEntityDescriptorEnum.Reuse);
    }

    public void _Reuse() {
        _wEntity(ModulesEntityDescriptorEnum.Reuse);
    }

    public void Resource() {
        wEntity(ModulesEntityDescriptorEnum.Resource);
    }

    public void Resource_() {
        wEntity_(ModulesEntityDescriptorEnum.Resource);
    }

    public void _Resource() {
        _wEntity(ModulesEntityDescriptorEnum.Resource);
    }

    public void WorkspacePath() {
        wEntity(ModulesEntityDescriptorEnum.WorkspacePath);
    }

    public void WorkspacePath(String value) {
        wEntity(ModulesEntityDescriptorEnum.WorkspacePath, value);
    }

    public void FileSystemPath() {
        wEntity(ModulesEntityDescriptorEnum.FileSystemPath);
    }

    public void FileSystemPath(String value) {
        wEntity(ModulesEntityDescriptorEnum.FileSystemPath, value);
    }

    public void ClassPathURI() {
        wEntity(ModulesEntityDescriptorEnum.ClassPathURI);
    }

    public void ClassPathURI(String value) {
        wEntity(ModulesEntityDescriptorEnum.ClassPathURI, value);
    }

    public void URI() {
        wEntity(ModulesEntityDescriptorEnum.URI);
    }

    public void URI(String value) {
        wEntity(ModulesEntityDescriptorEnum.URI, value);
    }

    public void Persistence() {
        wEntity(ModulesEntityDescriptorEnum.Persistence);
    }

    public void Persistence(String value) {
        wEntity(ModulesEntityDescriptorEnum.Persistence, value);
    }

    public void Registry() {
        wEntity(ModulesEntityDescriptorEnum.Registry);
    }

    public void Registry(String value) {
        wEntity(ModulesEntityDescriptorEnum.Registry, value);
    }
}
