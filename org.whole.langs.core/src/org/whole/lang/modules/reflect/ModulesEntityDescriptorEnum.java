package org.whole.lang.modules.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.model.*;

/**
 *  @generator  Whole
 */
@SuppressWarnings("unchecked")
public class ModulesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Module_ord = 0;
    public static final int Include_ord = 1;
    public static final int Reuse_ord = 2;
    public static final int Resource_ord = 3;
    public static final int Locator_ord = 4;
    public static final int WorkspacePath_ord = 5;
    public static final int FileSystemPath_ord = 6;
    public static final int ClassPathURI_ord = 7;
    public static final int URI_ord = 8;
    public static final int Persistence_ord = 9;
    public static final int Registry_ord = 10;
    public static final int Content_ord = 11;
    public static final int Adapter_ord = 12;
    public static final ModulesEntityDescriptorEnum instance = new ModulesEntityDescriptorEnum();
    public static final EntityDescriptor<Module> Module = (EntityDescriptor<Module>) instance.valueOf(Module_ord);
    public static final EntityDescriptor<Include> Include = (EntityDescriptor<Include>) instance.valueOf(Include_ord);
    public static final EntityDescriptor<Reuse> Reuse = (EntityDescriptor<Reuse>) instance.valueOf(Reuse_ord);
    public static final EntityDescriptor<Resource> Resource = (EntityDescriptor<Resource>) instance.valueOf(Resource_ord);
    public static final EntityDescriptor<Locator> Locator = (EntityDescriptor<Locator>) instance.valueOf(Locator_ord);
    public static final EntityDescriptor<WorkspacePath> WorkspacePath = (EntityDescriptor<WorkspacePath>) instance.valueOf(WorkspacePath_ord);
    public static final EntityDescriptor<FileSystemPath> FileSystemPath = (EntityDescriptor<FileSystemPath>) instance.valueOf(FileSystemPath_ord);
    public static final EntityDescriptor<ClassPathURI> ClassPathURI = (EntityDescriptor<ClassPathURI>) instance.valueOf(ClassPathURI_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Persistence> Persistence = (EntityDescriptor<Persistence>) instance.valueOf(Persistence_ord);
    public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance.valueOf(Registry_ord);
    public static final EntityDescriptor<Content> Content = (EntityDescriptor<Content>) instance.valueOf(Content_ord);
    public static final EntityDescriptor<Adapter> Adapter = (EntityDescriptor<Adapter>) instance.valueOf(Adapter_ord);

    private ModulesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Module_ord, "Module", Module.class, false).withFeature(ModulesFeatureDescriptorEnum.content, Content_ord);
        putSimpleEntity(Include_ord, "Include", Include.class, false).withFeature(ModulesFeatureDescriptorEnum.resource, Resource_ord);
        putSimpleEntity(Reuse_ord, "Reuse", Reuse.class, false).withFeature(ModulesFeatureDescriptorEnum.resource, Resource_ord).withFeature(ModulesFeatureDescriptorEnum.adapter, Adapter_ord, true, false, false, false, false).withFeature(ModulesFeatureDescriptorEnum.original, Content_ord, true, false, false, true, false).withFeature(ModulesFeatureDescriptorEnum.adapted, Content_ord, true, false, false, true, false).withFeature(ModulesFeatureDescriptorEnum.variant, Content_ord, true, false, false, false, false);
        putSimpleEntity(Resource_ord, "Resource", Resource.class, false).withFeature(ModulesFeatureDescriptorEnum.locator, Locator_ord).withFeature(ModulesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false).withFeature(ModulesFeatureDescriptorEnum.registry, Registry_ord, true, false, false, false, false);
        putSimpleEntity(Locator_ord, "Locator", Locator.class, true, WorkspacePath_ord, FileSystemPath_ord, ClassPathURI_ord, URI_ord);
        putDataEntity(WorkspacePath_ord, "WorkspacePath", WorkspacePath.class, false, String.class);
        putDataEntity(FileSystemPath_ord, "FileSystemPath", FileSystemPath.class, false, String.class);
        putDataEntity(ClassPathURI_ord, "ClassPathURI", ClassPathURI.class, false, String.class);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putDataEntity(Persistence_ord, "Persistence", Persistence.class, false, String.class);
        putDataEntity(Registry_ord, "Registry", Registry.class, false, String.class);
        putSimpleEntity(Content_ord, "Content", Content.class, true);
        putSimpleEntity(Adapter_ord, "Adapter", Adapter.class, true);
    }

    protected void initForeignTypeRelations() {
        setAssignableToAll(true, Module_ord, Include_ord, Reuse_ord);
        setAssignableFromAll(true, Content_ord, Adapter_ord);
    }
}
