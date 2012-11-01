package org.whole.lang.frames.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class FramesIdentitySwitchVisitor extends AbstractVisitor
		implements IFramesVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case FramesEntityDescriptorEnum.Frame_ord:
			visit((Frame) entity);
			break;
		case FramesEntityDescriptorEnum.Variants_ord:
			visit((Variants) entity);
			break;
		case FramesEntityDescriptorEnum.Empty_ord:
			visit((Empty) entity);
			break;
		case FramesEntityDescriptorEnum.Proceed_ord:
			visit((Proceed) entity);
			break;
		case FramesEntityDescriptorEnum.InlineContent_ord:
			visit((InlineContent) entity);
			break;
		case FramesEntityDescriptorEnum.JoinPoint_ord:
			visit((JoinPoint) entity);
			break;
		case FramesEntityDescriptorEnum.ConditionPoint_ord:
			visit((ConditionPoint) entity);
			break;
		case FramesEntityDescriptorEnum.IterationPoint_ord:
			visit((IterationPoint) entity);
			break;
		case FramesEntityDescriptorEnum.SelectionPoint_ord:
			visit((SelectionPoint) entity);
			break;
		case FramesEntityDescriptorEnum.ReusePoint_ord:
			visit((ReusePoint) entity);
			break;
		case FramesEntityDescriptorEnum.IncludePoint_ord:
			visit((IncludePoint) entity);
			break;
		case FramesEntityDescriptorEnum.Relations_ord:
			visit((Relations) entity);
			break;
		case FramesEntityDescriptorEnum.Pointcut_ord:
			visit((Pointcut) entity);
			break;
		case FramesEntityDescriptorEnum.Require_ord:
			visit((Require) entity);
			break;
		case FramesEntityDescriptorEnum.Exclude_ord:
			visit((Exclude) entity);
			break;
		case FramesEntityDescriptorEnum.MutuallyRequire_ord:
			visit((MutuallyRequire) entity);
			break;
		case FramesEntityDescriptorEnum.MutuallyExclude_ord:
			visit((MutuallyExclude) entity);
			break;
		case FramesEntityDescriptorEnum.FeatureNames_ord:
			visit((FeatureNames) entity);
			break;
		case FramesEntityDescriptorEnum.Advices_ord:
			visit((Advices) entity);
			break;
		case FramesEntityDescriptorEnum.Before_ord:
			visit((Before) entity);
			break;
		case FramesEntityDescriptorEnum.After_ord:
			visit((After) entity);
			break;
		case FramesEntityDescriptorEnum.Into_ord:
			visit((Into) entity);
			break;
		case FramesEntityDescriptorEnum.Around_ord:
			visit((Around) entity);
			break;
		case FramesEntityDescriptorEnum.Features_ord:
			visit((Features) entity);
			break;
		case FramesEntityDescriptorEnum.Subfeatures_ord:
			visit((Subfeatures) entity);
			break;
		case FramesEntityDescriptorEnum.VariableFeatures_ord:
			visit((VariableFeatures) entity);
			break;
		case FramesEntityDescriptorEnum.SolitaryFeatures_ord:
			visit((SolitaryFeatures) entity);
			break;
		case FramesEntityDescriptorEnum.SubsetGroup_ord:
			visit((SubsetGroup) entity);
			break;
		case FramesEntityDescriptorEnum.CloneGroup_ord:
			visit((CloneGroup) entity);
			break;
		case FramesEntityDescriptorEnum.VariableFeature_ord:
			visit((VariableFeature) entity);
			break;
		case FramesEntityDescriptorEnum.Feature_ord:
			visit((Feature) entity);
			break;
		case FramesEntityDescriptorEnum.Attribute_ord:
			visit((Attribute) entity);
			break;
		case FramesEntityDescriptorEnum.FeatureReference_ord:
			visit((FeatureReference) entity);
			break;
		case FramesEntityDescriptorEnum.FeatureRename_ord:
			visit((FeatureRename) entity);
			break;
		case FramesEntityDescriptorEnum.EntityType_ord:
			visit((EntityType) entity);
			break;
		case FramesEntityDescriptorEnum.Domain_ord:
			visit((Domain) entity);
			break;
		case FramesEntityDescriptorEnum.VariableValue_ord:
			visit((VariableValue) entity);
			break;
		case FramesEntityDescriptorEnum.Resources_ord:
			visit((Resources) entity);
			break;
		case FramesEntityDescriptorEnum.Resource_ord:
			visit((Resource) entity);
			break;
		case FramesEntityDescriptorEnum.WorkspacePath_ord:
			visit((WorkspacePath) entity);
			break;
		case FramesEntityDescriptorEnum.FileSystemPath_ord:
			visit((FileSystemPath) entity);
			break;
		case FramesEntityDescriptorEnum.URL_ord:
			visit((URL) entity);
			break;
		case FramesEntityDescriptorEnum.PersistenceId_ord:
			visit((PersistenceId) entity);
			break;
		case FramesEntityDescriptorEnum.BooleanValue_ord:
			visit((BooleanValue) entity);
			break;
		case FramesEntityDescriptorEnum.ByteValue_ord:
			visit((ByteValue) entity);
			break;
		case FramesEntityDescriptorEnum.ShortValue_ord:
			visit((ShortValue) entity);
			break;
		case FramesEntityDescriptorEnum.IntValue_ord:
			visit((IntValue) entity);
			break;
		case FramesEntityDescriptorEnum.LongValue_ord:
			visit((LongValue) entity);
			break;
		case FramesEntityDescriptorEnum.FloatValue_ord:
			visit((FloatValue) entity);
			break;
		case FramesEntityDescriptorEnum.DoubleValue_ord:
			visit((DoubleValue) entity);
			break;
		case FramesEntityDescriptorEnum.CharValue_ord:
			visit((CharValue) entity);
			break;
		case FramesEntityDescriptorEnum.StringValue_ord:
			visit((StringValue) entity);
			break;
		case FramesEntityDescriptorEnum.FeatureName_ord:
			visit((FeatureName) entity);
			break;
		case FramesEntityDescriptorEnum.FeatureValue_ord:
			visit((FeatureValue) entity);
			break;
		case FramesEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		case FramesEntityDescriptorEnum.Namespace_ord:
			visit((Namespace) entity);
			break;
		case FramesEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case FramesEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case FramesEntityDescriptorEnum.Cardinality_ord:
			visit((Cardinality) entity);
			break;
		case FramesEntityDescriptorEnum.Annotations_ord:
			visit((Annotations) entity);
			break;
		case FramesEntityDescriptorEnum.Description_ord:
			visit((Description) entity);
			break;
		case FramesEntityDescriptorEnum.Categories_ord:
			visit((Categories) entity);
			break;
		case FramesEntityDescriptorEnum.Stakeholders_ord:
			visit((Stakeholders) entity);
			break;
		case FramesEntityDescriptorEnum.Priority_ord:
			visit((Priority) entity);
			break;
		case FramesEntityDescriptorEnum.BindingTime_ord:
			visit((BindingTime) entity);
			break;
		case FramesEntityDescriptorEnum.CustomAnnotation_ord:
			visit((CustomAnnotation) entity);
			break;
		}
	}
}
