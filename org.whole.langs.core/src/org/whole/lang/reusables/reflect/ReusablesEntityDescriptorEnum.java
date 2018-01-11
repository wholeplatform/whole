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
package org.whole.lang.reusables.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class ReusablesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Reusable_ord = 0;
    public static final int Adapt_ord = 1;
    public static final int Reuse_ord = 2;
    public static final int Sync_ord = 3;
    public static final int Include_ord = 4;
    public static final int Reusables_ord = 5;
    public static final int Resource_ord = 6;
    public static final int Workspace_ord = 7;
    public static final int FileSystem_ord = 8;
    public static final int Classpath_ord = 9;
    public static final int URL_ord = 10;
    public static final int Model_ord = 11;
    public static final int Registry_ord = 12;
    public static final int Expression_ord = 13;
    public static final int StepExpression_ord = 14;
    public static final int Load_ord = 15;
    public static final int Save_ord = 16;
    public static final int Content_ord = 17;
    public static final int Contents_ord = 18;
    public static final int Folder_ord = 19;
    public static final int File_ord = 20;
    public static final int Path_ord = 21;
    public static final int PathName_ord = 22;
    public static final int PathWithExtension_ord = 23;
    public static final int PathSegments_ord = 24;
    public static final int URI_ord = 25;
    public static final int Persistence_ord = 26;
    public static final int PersistenceId_ord = 27;
    public static final int Revision_ord = 28;
    public static final int Any_ord = 29;
    public static final ReusablesEntityDescriptorEnum instance = new ReusablesEntityDescriptorEnum();
    public static final EntityDescriptor<Reusable> Reusable = (EntityDescriptor<Reusable>) instance.valueOf(Reusable_ord);
    public static final EntityDescriptor<Adapt> Adapt = (EntityDescriptor<Adapt>) instance.valueOf(Adapt_ord);
    public static final EntityDescriptor<Reuse> Reuse = (EntityDescriptor<Reuse>) instance.valueOf(Reuse_ord);
    public static final EntityDescriptor<Sync> Sync = (EntityDescriptor<Sync>) instance.valueOf(Sync_ord);
    public static final EntityDescriptor<Include> Include = (EntityDescriptor<Include>) instance.valueOf(Include_ord);
    public static final EntityDescriptor<Reusables> Reusables = (EntityDescriptor<Reusables>) instance.valueOf(Reusables_ord);
    public static final EntityDescriptor<Resource> Resource = (EntityDescriptor<Resource>) instance.valueOf(Resource_ord);
    public static final EntityDescriptor<Workspace> Workspace = (EntityDescriptor<Workspace>) instance.valueOf(Workspace_ord);
    public static final EntityDescriptor<FileSystem> FileSystem = (EntityDescriptor<FileSystem>) instance.valueOf(FileSystem_ord);
    public static final EntityDescriptor<Classpath> Classpath = (EntityDescriptor<Classpath>) instance.valueOf(Classpath_ord);
    public static final EntityDescriptor<URL> URL = (EntityDescriptor<URL>) instance.valueOf(URL_ord);
    public static final EntityDescriptor<Model> Model = (EntityDescriptor<Model>) instance.valueOf(Model_ord);
    public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance.valueOf(Registry_ord);
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<StepExpression> StepExpression = (EntityDescriptor<StepExpression>) instance.valueOf(StepExpression_ord);
    public static final EntityDescriptor<Load> Load = (EntityDescriptor<Load>) instance.valueOf(Load_ord);
    public static final EntityDescriptor<Save> Save = (EntityDescriptor<Save>) instance.valueOf(Save_ord);
    public static final EntityDescriptor<Content> Content = (EntityDescriptor<Content>) instance.valueOf(Content_ord);
    public static final EntityDescriptor<Contents> Contents = (EntityDescriptor<Contents>) instance.valueOf(Contents_ord);
    public static final EntityDescriptor<Folder> Folder = (EntityDescriptor<Folder>) instance.valueOf(Folder_ord);
    public static final EntityDescriptor<File> File = (EntityDescriptor<File>) instance.valueOf(File_ord);
    public static final EntityDescriptor<Path> Path = (EntityDescriptor<Path>) instance.valueOf(Path_ord);
    public static final EntityDescriptor<PathName> PathName = (EntityDescriptor<PathName>) instance.valueOf(PathName_ord);
    public static final EntityDescriptor<PathWithExtension> PathWithExtension = (EntityDescriptor<PathWithExtension>) instance.valueOf(PathWithExtension_ord);
    public static final EntityDescriptor<PathSegments> PathSegments = (EntityDescriptor<PathSegments>) instance.valueOf(PathSegments_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Persistence> Persistence = (EntityDescriptor<Persistence>) instance.valueOf(Persistence_ord);
    public static final EntityDescriptor<PersistenceId> PersistenceId = (EntityDescriptor<PersistenceId>) instance.valueOf(PersistenceId_ord);
    public static final EntityDescriptor<Revision> Revision = (EntityDescriptor<Revision>) instance.valueOf(Revision_ord);
    public static final EntityDescriptor<Any> Any = (EntityDescriptor<Any>) instance.valueOf(Any_ord);

    private ReusablesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Reusable_ord, "Reusable", Reusable.class, true, Adapt_ord, Sync_ord, Reusables_ord, Reuse_ord);
        putSimpleEntity(Adapt_ord, "Adapt", Adapt.class, false).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord).withFeature(ReusablesFeatureDescriptorEnum.adapter, Expression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Reuse_ord, "Reuse", Reuse.class, false, Sync_ord).withFeature(ReusablesFeatureDescriptorEnum.resource, Resource_ord).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adapter, Expression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Sync_ord, "Sync", Sync.class, false).withFeature(ReusablesFeatureDescriptorEnum.resource, Resource_ord).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adapter, Expression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.variant, Reusable_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.variantRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Include_ord, "Include", Include.class, false).withFeature(ReusablesFeatureDescriptorEnum.resource, Resource_ord);
        putCompositeEntity(Reusables_ord, "Reusables", Reusables.class, false, Reusable_ord, true, false);
        putSimpleEntity(Resource_ord, "Resource", Resource.class, true, Model_ord, Registry_ord, URL_ord, FileSystem_ord, Classpath_ord, Workspace_ord);
        putSimpleEntity(Workspace_ord, "Workspace", Workspace.class, false).withFeature(ReusablesFeatureDescriptorEnum.content, Content_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(FileSystem_ord, "FileSystem", FileSystem.class, false).withFeature(ReusablesFeatureDescriptorEnum.content, Content_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Classpath_ord, "Classpath", Classpath.class, false).withFeature(ReusablesFeatureDescriptorEnum.content, Content_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(URL_ord, "URL", URL.class, false).withFeature(ReusablesFeatureDescriptorEnum.content, Content_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Model_ord, "Model", Model.class, false).withFeature(ReusablesFeatureDescriptorEnum.content, Expression_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Registry_ord, "Registry", Registry.class, false).withFeature(ReusablesFeatureDescriptorEnum.registryUri, URI_ord).withFeature(ReusablesFeatureDescriptorEnum.uri, URI_ord);
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, Path_ord, Load_ord, Save_ord, PathName_ord, PathSegments_ord, StepExpression_ord, PathWithExtension_ord);
        putSimpleEntity(StepExpression_ord, "StepExpression", StepExpression.class, true, Load_ord, Save_ord);
        putSimpleEntity(Load_ord, "Load", Load.class, false).withFeature(ReusablesFeatureDescriptorEnum.resource, Resource_ord);
        putSimpleEntity(Save_ord, "Save", Save.class, false).withFeature(ReusablesFeatureDescriptorEnum.resource, Resource_ord);
        putSimpleEntity(Content_ord, "Content", Content.class, true, Path_ord, Contents_ord, PathName_ord, Folder_ord, PathSegments_ord, File_ord, PathWithExtension_ord);
        putCompositeEntity(Contents_ord, "Contents", Contents.class, false, Content_ord, true, false);
        putSimpleEntity(Folder_ord, "Folder", Folder.class, false).withFeature(ReusablesFeatureDescriptorEnum.path, Expression_ord).withFeature(ReusablesFeatureDescriptorEnum.content, Content_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(File_ord, "File", File.class, false).withFeature(ReusablesFeatureDescriptorEnum.path, Expression_ord).withFeature(ReusablesFeatureDescriptorEnum.content, Any_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Path_ord, "Path", Path.class, true, PathSegments_ord, PathWithExtension_ord, PathName_ord);
        putDataEntity(PathName_ord, "PathName", PathName.class, false, String.class);
        putSimpleEntity(PathWithExtension_ord, "PathWithExtension", PathWithExtension.class, false).withFeature(ReusablesFeatureDescriptorEnum.path, Expression_ord).withFeature(ReusablesFeatureDescriptorEnum.extension, Expression_ord);
        putCompositeEntity(PathSegments_ord, "PathSegments", PathSegments.class, false, Expression_ord, true, false);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putSimpleEntity(Persistence_ord, "Persistence", Persistence.class, true, PersistenceId_ord);
        putDataEntity(PersistenceId_ord, "PersistenceId", PersistenceId.class, false, String.class);
        putSimpleEntity(Revision_ord, "Revision", Revision.class, true);
        putSimpleEntity(Any_ord, "Any", Any.class, true);
    }

    protected void initForeignTypeRelations() {
        setAssignableToAll(true, Adapt_ord, Reuse_ord, Include_ord);
        setAssignableFromAll(true, Reusable_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#Expression", Expression_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#StepExpression", StepExpression_ord);
        setAliasOf(true, "whole:org.whole.lang.changes:ChangesModel#Revision", Revision_ord);
    }
}
