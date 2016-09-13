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
    public static final int Synch_ord = 3;
    public static final int Include_ord = 4;
    public static final int Reusables_ord = 5;
    public static final int Source_ord = 6;
    public static final int PathExpression_ord = 7;
    public static final int StepExpression_ord = 8;
    public static final int ReferenceStep_ord = 9;
    public static final int Resource_ord = 10;
    public static final int Registry_ord = 11;
    public static final int Locator_ord = 12;
    public static final int WorkspacePath_ord = 13;
    public static final int FileSystemPath_ord = 14;
    public static final int ClassPathURI_ord = 15;
    public static final int URI_ord = 16;
    public static final int Persistence_ord = 17;
    public static final int Revision_ord = 18;
    public static final ReusablesEntityDescriptorEnum instance = new ReusablesEntityDescriptorEnum();
    public static final EntityDescriptor<Reusable> Reusable = (EntityDescriptor<Reusable>) instance.valueOf(Reusable_ord);
    public static final EntityDescriptor<Adapt> Adapt = (EntityDescriptor<Adapt>) instance.valueOf(Adapt_ord);
    public static final EntityDescriptor<Reuse> Reuse = (EntityDescriptor<Reuse>) instance.valueOf(Reuse_ord);
    public static final EntityDescriptor<Synch> Synch = (EntityDescriptor<Synch>) instance.valueOf(Synch_ord);
    public static final EntityDescriptor<Include> Include = (EntityDescriptor<Include>) instance.valueOf(Include_ord);
    public static final EntityDescriptor<Reusables> Reusables = (EntityDescriptor<Reusables>) instance.valueOf(Reusables_ord);
    public static final EntityDescriptor<Source> Source = (EntityDescriptor<Source>) instance.valueOf(Source_ord);
    public static final EntityDescriptor<PathExpression> PathExpression = (EntityDescriptor<PathExpression>) instance.valueOf(PathExpression_ord);
    public static final EntityDescriptor<StepExpression> StepExpression = (EntityDescriptor<StepExpression>) instance.valueOf(StepExpression_ord);
    public static final EntityDescriptor<ReferenceStep> ReferenceStep = (EntityDescriptor<ReferenceStep>) instance.valueOf(ReferenceStep_ord);
    public static final EntityDescriptor<Resource> Resource = (EntityDescriptor<Resource>) instance.valueOf(Resource_ord);
    public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance.valueOf(Registry_ord);
    public static final EntityDescriptor<Locator> Locator = (EntityDescriptor<Locator>) instance.valueOf(Locator_ord);
    public static final EntityDescriptor<WorkspacePath> WorkspacePath = (EntityDescriptor<WorkspacePath>) instance.valueOf(WorkspacePath_ord);
    public static final EntityDescriptor<FileSystemPath> FileSystemPath = (EntityDescriptor<FileSystemPath>) instance.valueOf(FileSystemPath_ord);
    public static final EntityDescriptor<ClassPathURI> ClassPathURI = (EntityDescriptor<ClassPathURI>) instance.valueOf(ClassPathURI_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Persistence> Persistence = (EntityDescriptor<Persistence>) instance.valueOf(Persistence_ord);
    public static final EntityDescriptor<Revision> Revision = (EntityDescriptor<Revision>) instance.valueOf(Revision_ord);

    private ReusablesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Reusable_ord, "Reusable", Reusable.class, true, Adapt_ord, Reusables_ord, Reuse_ord, Synch_ord);
        putSimpleEntity(Adapt_ord, "Adapt", Adapt.class, false).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord).withFeature(ReusablesFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Reuse_ord, "Reuse", Reuse.class, false, Synch_ord).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Synch_ord, "Synch", Synch.class, false).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord).withFeature(ReusablesFeatureDescriptorEnum.original, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.adapted, Reusable_ord, true, false, false, true, false).withFeature(ReusablesFeatureDescriptorEnum.adaptedRevision, Revision_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.variant, Reusable_ord, true, false, false, false, false).withFeature(ReusablesFeatureDescriptorEnum.variantRevision, Revision_ord, true, false, false, false, false);
        putSimpleEntity(Include_ord, "Include", Include.class, false).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord);
        putCompositeEntity(
		Reusables_ord, "Reusables", Reusables.class, false, Reusable_ord, true, false);
        putSimpleEntity(Source_ord, "Source", Source.class, true, Resource_ord, Registry_ord, PathExpression_ord, ReferenceStep_ord, StepExpression_ord);
        putSimpleEntity(PathExpression_ord, "PathExpression", PathExpression.class, true, ReferenceStep_ord, StepExpression_ord);
        putSimpleEntity(StepExpression_ord, "StepExpression", StepExpression.class, true, ReferenceStep_ord);
        putSimpleEntity(ReferenceStep_ord, "ReferenceStep", ReferenceStep.class, false).withFeature(ReusablesFeatureDescriptorEnum.source, Source_ord);
        putSimpleEntity(Resource_ord, "Resource", Resource.class, false).withFeature(ReusablesFeatureDescriptorEnum.locator, Locator_ord).withFeature(ReusablesFeatureDescriptorEnum.persistence, Persistence_ord, true, false, false, false, false);
        putSimpleEntity(Registry_ord, "Registry", Registry.class, false).withFeature(ReusablesFeatureDescriptorEnum.locator, URI_ord).withFeature(ReusablesFeatureDescriptorEnum.uri, URI_ord);
        putSimpleEntity(Locator_ord, "Locator", Locator.class, true, WorkspacePath_ord, FileSystemPath_ord, ClassPathURI_ord, PathExpression_ord, ReferenceStep_ord, URI_ord, StepExpression_ord);
        putDataEntity(WorkspacePath_ord, "WorkspacePath", WorkspacePath.class, false, String.class);
        putDataEntity(FileSystemPath_ord, "FileSystemPath", FileSystemPath.class, false, String.class);
        putDataEntity(ClassPathURI_ord, "ClassPathURI", ClassPathURI.class, false, String.class);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putDataEntity(Persistence_ord, "Persistence", Persistence.class, false, String.class);
        putSimpleEntity(Revision_ord, "Revision", Revision.class, true);
    }

    protected void initForeignTypeRelations() {
        setAssignableToAll(true, Adapt_ord, Reuse_ord, Include_ord);
        setAssignableFromAll(true, Reusable_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#PathExpression", PathExpression_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#StepExpression", StepExpression_ord);
        setAliasOf(true, "whole:org.whole.lang.changes:ChangesModel#Revision", Revision_ord);
    }
}
