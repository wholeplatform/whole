package org.whole.lang.reusables.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.model.*;

/**
 *  @generator  Whole
 */
@SuppressWarnings("unchecked")
public class ReusablesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Reusable_ord = 0;
    public static final int Adapt_ord = 1;
    public static final int Reuse_ord = 2;
    public static final int Include_ord = 3;
    public static final int Reusables_ord = 4;
    public static final int Source_ord = 5;
    public static final int PathExpression_ord = 6;
    public static final int Resource_ord = 7;
    public static final int Registry_ord = 8;
    public static final int Locator_ord = 9;
    public static final int WorkspacePath_ord = 10;
    public static final int FileSystemPath_ord = 11;
    public static final int ClassPathURI_ord = 12;
    public static final int URI_ord = 13;
    public static final int Persistence_ord = 14;
    public static final ReusablesEntityDescriptorEnum instance = new ReusablesEntityDescriptorEnum();
    public static final EntityDescriptor<Reusable> Reusable = (EntityDescriptor<Reusable>) instance.valueOf(Reusable_ord);
    public static final EntityDescriptor<Adapt> Adapt = (EntityDescriptor<Adapt>) instance.valueOf(Adapt_ord);
    public static final EntityDescriptor<Reuse> Reuse = (EntityDescriptor<Reuse>) instance.valueOf(Reuse_ord);
    public static final EntityDescriptor<Include> Include = (EntityDescriptor<Include>) instance.valueOf(Include_ord);
    public static final EntityDescriptor<Reusables> Reusables = (EntityDescriptor<Reusables>) instance.valueOf(Reusables_ord);
    public static final EntityDescriptor<Source> Source = (EntityDescriptor<Source>) instance.valueOf(Source_ord);
    public static final EntityDescriptor<PathExpression> PathExpression = (EntityDescriptor<PathExpression>) instance.valueOf(PathExpression_ord);
    public static final EntityDescriptor<Resource> Resource = (EntityDescriptor<Resource>) instance.valueOf(Resource_ord);
    public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance.valueOf(Registry_ord);
    public static final EntityDescriptor<Locator> Locator = (EntityDescriptor<Locator>) instance.valueOf(Locator_ord);
    public static final EntityDescriptor<WorkspacePath> WorkspacePath = (EntityDescriptor<WorkspacePath>) instance.valueOf(WorkspacePath_ord);
    public static final EntityDescriptor<FileSystemPath> FileSystemPath = (EntityDescriptor<FileSystemPath>) instance.valueOf(FileSystemPath_ord);
    public static final EntityDescriptor<ClassPathURI> ClassPathURI = (EntityDescriptor<ClassPathURI>) instance.valueOf(ClassPathURI_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Persistence> Persistence = (EntityDescriptor<Persistence>) instance.valueOf(Persistence_ord);

    private ReusablesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Reusable_ord, "Reusable", Reusable.class, true, Reusables_ord);
        putSimpleEntity(Adapt_ord, "Adapt", Adapt.class, false).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord).withFeature(ReusablesFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false);
        putSimpleEntity(Reuse_ord, "Reuse", Reuse.class, false).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.variant, Reusable_ord, true, false, false, false, false);
        putSimpleEntity(Include_ord, "Include", Include.class, false).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord);
        putCompositeEntity(Reusables_ord, "Reusables", Reusables.class, false, Reusable_ord, true, false);
        putSimpleEntity(Source_ord, "Source", Source.class, true, PathExpression_ord, Resource_ord, Registry_ord);
        putSimpleEntity(PathExpression_ord, "PathExpression", PathExpression.class, true);
        putSimpleEntity(Resource_ord, "Resource", Resource.class, false).withFeature(ReusablesFeatureDescriptorEnum.locator, Locator_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Registry_ord, "Registry", Registry.class, false).withFeature(ReusablesFeatureDescriptorEnum.locator, URI_ord).withFeature(ReusablesFeatureDescriptorEnum.uri, URI_ord);
        putSimpleEntity(Locator_ord, "Locator", Locator.class, true, WorkspacePath_ord, FileSystemPath_ord, ClassPathURI_ord, PathExpression_ord, URI_ord);
        putDataEntity(WorkspacePath_ord, "WorkspacePath", WorkspacePath.class, false, String.class);
        putDataEntity(FileSystemPath_ord, "FileSystemPath", FileSystemPath.class, false, String.class);
        putDataEntity(ClassPathURI_ord, "ClassPathURI", ClassPathURI.class, false, String.class);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putDataEntity(Persistence_ord, "Persistence", Persistence.class, false, String.class);
    }

    protected void initForeignTypeRelations() {
        setAssignableToAll(true, Adapt_ord, Reuse_ord, Include_ord);
        setAssignableFromAll(true, Reusable_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#PathExpression", PathExpression_ord);
    }
}
