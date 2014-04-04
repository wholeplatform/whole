package org.whole.lang.reusables.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReusablesSpecificBuilderAdapter extends GenericBuilderContext implements IReusablesBuilder {

    public ReusablesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public ReusablesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void registry() {
        wFeature(ReusablesFeatureDescriptorEnum.registry);
    }

    public void persistence() {
        wFeature(ReusablesFeatureDescriptorEnum.persistence);
    }

    public void locator() {
        wFeature(ReusablesFeatureDescriptorEnum.locator);
    }

    public void variant() {
        wFeature(ReusablesFeatureDescriptorEnum.variant);
    }

    public void source() {
        wFeature(ReusablesFeatureDescriptorEnum.source);
    }

    public void adapted() {
        wFeature(ReusablesFeatureDescriptorEnum.adapted);
    }

    public void adapter() {
        wFeature(ReusablesFeatureDescriptorEnum.adapter);
    }

    public void original() {
        wFeature(ReusablesFeatureDescriptorEnum.original);
    }

    public void visit() {
    }

    public void Adapt() {
        wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Adapt_() {
        wEntity_(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void _Adapt() {
        _wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Reuse() {
        wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Reuse_() {
        wEntity_(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void _Reuse() {
        _wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Include() {
        wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Include_() {
        wEntity_(ReusablesEntityDescriptorEnum.Include);
    }

    public void _Include() {
        _wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Resource() {
        wEntity(ReusablesEntityDescriptorEnum.Resource);
    }

    public void Resource_() {
        wEntity_(ReusablesEntityDescriptorEnum.Resource);
    }

    public void _Resource() {
        _wEntity(ReusablesEntityDescriptorEnum.Resource);
    }

    public void WorkspacePath() {
        wEntity(ReusablesEntityDescriptorEnum.WorkspacePath);
    }

    public void WorkspacePath(String value) {
        wEntity(ReusablesEntityDescriptorEnum.WorkspacePath, value);
    }

    public void FileSystemPath() {
        wEntity(ReusablesEntityDescriptorEnum.FileSystemPath);
    }

    public void FileSystemPath(String value) {
        wEntity(ReusablesEntityDescriptorEnum.FileSystemPath, value);
    }

    public void ClassPathURI() {
        wEntity(ReusablesEntityDescriptorEnum.ClassPathURI);
    }

    public void ClassPathURI(String value) {
        wEntity(ReusablesEntityDescriptorEnum.ClassPathURI, value);
    }

    public void URI() {
        wEntity(ReusablesEntityDescriptorEnum.URI);
    }

    public void URI(String value) {
        wEntity(ReusablesEntityDescriptorEnum.URI, value);
    }

    public void Persistence() {
        wEntity(ReusablesEntityDescriptorEnum.Persistence);
    }

    public void Persistence(String value) {
        wEntity(ReusablesEntityDescriptorEnum.Persistence, value);
    }

    public void Registry() {
        wEntity(ReusablesEntityDescriptorEnum.Registry);
    }

    public void Registry(String value) {
        wEntity(ReusablesEntityDescriptorEnum.Registry, value);
    }
}
