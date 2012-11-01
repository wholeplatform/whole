package org.whole.lang.frames.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.frames.model.DomainEnum.Value;

/** 
 * @generator Whole
 */
public class FramesGenericBuilderAdapter extends GenericIdentityBuilder {
	private IFramesBuilder specificBuilder;

	public FramesGenericBuilderAdapter(IFramesBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public FramesGenericBuilderAdapter(IFramesBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case FramesFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case FramesFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case FramesFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case FramesFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case FramesFeatureDescriptorEnum.imports_ord:
			specificBuilder.imports();
			break;
		case FramesFeatureDescriptorEnum.variability_ord:
			specificBuilder.variability();
			break;
		case FramesFeatureDescriptorEnum.relations_ord:
			specificBuilder.relations();
			break;
		case FramesFeatureDescriptorEnum.content_ord:
			specificBuilder.content();
			break;
		case FramesFeatureDescriptorEnum.joinpoints_ord:
			specificBuilder.joinpoints();
			break;
		case FramesFeatureDescriptorEnum.enabler_ord:
			specificBuilder.enabler();
			break;
		case FramesFeatureDescriptorEnum.iterator_ord:
			specificBuilder.iterator();
			break;
		case FramesFeatureDescriptorEnum.selector_ord:
			specificBuilder.selector();
			break;
		case FramesFeatureDescriptorEnum.variants_ord:
			specificBuilder.variants();
			break;
		case FramesFeatureDescriptorEnum.frame_ord:
			specificBuilder.frame();
			break;
		case FramesFeatureDescriptorEnum.configuration_ord:
			specificBuilder.configuration();
			break;
		case FramesFeatureDescriptorEnum.advices_ord:
			specificBuilder.advices();
			break;
		case FramesFeatureDescriptorEnum.resource_ord:
			specificBuilder.resource();
			break;
		case FramesFeatureDescriptorEnum.feature_ord:
			specificBuilder.feature();
			break;
		case FramesFeatureDescriptorEnum.requiredFeatures_ord:
			specificBuilder.requiredFeatures();
			break;
		case FramesFeatureDescriptorEnum.excludedFeatures_ord:
			specificBuilder.excludedFeatures();
			break;
		case FramesFeatureDescriptorEnum.cardinality_ord:
			specificBuilder.cardinality();
			break;
		case FramesFeatureDescriptorEnum.features_ord:
			specificBuilder.features();
			break;
		case FramesFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case FramesFeatureDescriptorEnum.annotations_ord:
			specificBuilder.annotations();
			break;
		case FramesFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case FramesFeatureDescriptorEnum.newName_ord:
			specificBuilder.newName();
			break;
		case FramesFeatureDescriptorEnum.location_ord:
			specificBuilder.location();
			break;
		case FramesFeatureDescriptorEnum.persistence_ord:
			specificBuilder.persistence();
			break;
		case FramesFeatureDescriptorEnum.min_ord:
			specificBuilder.min();
			break;
		case FramesFeatureDescriptorEnum.max_ord:
			specificBuilder.max();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.Frame_ord:
			specificBuilder.Frame();
			break;
		case FramesEntityDescriptorEnum.Variants_ord:
			specificBuilder.Variants();
			break;
		case FramesEntityDescriptorEnum.Empty_ord:
			specificBuilder.Empty();
			break;
		case FramesEntityDescriptorEnum.Proceed_ord:
			specificBuilder.Proceed();
			break;
		case FramesEntityDescriptorEnum.InlineContent_ord:
			specificBuilder.InlineContent();
			break;
		case FramesEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder.JoinPoint();
			break;
		case FramesEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder.ConditionPoint();
			break;
		case FramesEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder.IterationPoint();
			break;
		case FramesEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder.SelectionPoint();
			break;
		case FramesEntityDescriptorEnum.ReusePoint_ord:
			specificBuilder.ReusePoint();
			break;
		case FramesEntityDescriptorEnum.IncludePoint_ord:
			specificBuilder.IncludePoint();
			break;
		case FramesEntityDescriptorEnum.Relations_ord:
			specificBuilder.Relations();
			break;
		case FramesEntityDescriptorEnum.Pointcut_ord:
			specificBuilder.Pointcut();
			break;
		case FramesEntityDescriptorEnum.Require_ord:
			specificBuilder.Require();
			break;
		case FramesEntityDescriptorEnum.Exclude_ord:
			specificBuilder.Exclude();
			break;
		case FramesEntityDescriptorEnum.MutuallyRequire_ord:
			specificBuilder.MutuallyRequire();
			break;
		case FramesEntityDescriptorEnum.MutuallyExclude_ord:
			specificBuilder.MutuallyExclude();
			break;
		case FramesEntityDescriptorEnum.FeatureNames_ord:
			specificBuilder.FeatureNames();
			break;
		case FramesEntityDescriptorEnum.Advices_ord:
			specificBuilder.Advices();
			break;
		case FramesEntityDescriptorEnum.Before_ord:
			specificBuilder.Before();
			break;
		case FramesEntityDescriptorEnum.After_ord:
			specificBuilder.After();
			break;
		case FramesEntityDescriptorEnum.Into_ord:
			specificBuilder.Into();
			break;
		case FramesEntityDescriptorEnum.Around_ord:
			specificBuilder.Around();
			break;
		case FramesEntityDescriptorEnum.Features_ord:
			specificBuilder.Features();
			break;
		case FramesEntityDescriptorEnum.Subfeatures_ord:
			specificBuilder.Subfeatures();
			break;
		case FramesEntityDescriptorEnum.VariableFeatures_ord:
			specificBuilder.VariableFeatures();
			break;
		case FramesEntityDescriptorEnum.SolitaryFeatures_ord:
			specificBuilder.SolitaryFeatures();
			break;
		case FramesEntityDescriptorEnum.SubsetGroup_ord:
			specificBuilder.SubsetGroup();
			break;
		case FramesEntityDescriptorEnum.CloneGroup_ord:
			specificBuilder.CloneGroup();
			break;
		case FramesEntityDescriptorEnum.VariableFeature_ord:
			specificBuilder.VariableFeature();
			break;
		case FramesEntityDescriptorEnum.Feature_ord:
			specificBuilder.Feature();
			break;
		case FramesEntityDescriptorEnum.Attribute_ord:
			specificBuilder.Attribute();
			break;
		case FramesEntityDescriptorEnum.FeatureReference_ord:
			specificBuilder.FeatureReference();
			break;
		case FramesEntityDescriptorEnum.FeatureRename_ord:
			specificBuilder.FeatureRename();
			break;
		case FramesEntityDescriptorEnum.Resources_ord:
			specificBuilder.Resources();
			break;
		case FramesEntityDescriptorEnum.Resource_ord:
			specificBuilder.Resource();
			break;
		case FramesEntityDescriptorEnum.Cardinality_ord:
			specificBuilder.Cardinality();
			break;
		case FramesEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations();
			break;
		case FramesEntityDescriptorEnum.Categories_ord:
			specificBuilder.Categories();
			break;
		case FramesEntityDescriptorEnum.Stakeholders_ord:
			specificBuilder.Stakeholders();
			break;
		case FramesEntityDescriptorEnum.CustomAnnotation_ord:
			specificBuilder.CustomAnnotation();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.Frame_ord:
			specificBuilder.Frame_();
			break;
		case FramesEntityDescriptorEnum.Variants_ord:
			specificBuilder.Variants_();
			break;
		case FramesEntityDescriptorEnum.Empty_ord:
			specificBuilder.Empty_();
			break;
		case FramesEntityDescriptorEnum.Proceed_ord:
			specificBuilder.Proceed_();
			break;
		case FramesEntityDescriptorEnum.InlineContent_ord:
			specificBuilder.InlineContent_();
			break;
		case FramesEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder.JoinPoint_();
			break;
		case FramesEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder.ConditionPoint_();
			break;
		case FramesEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder.IterationPoint_();
			break;
		case FramesEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder.SelectionPoint_();
			break;
		case FramesEntityDescriptorEnum.ReusePoint_ord:
			specificBuilder.ReusePoint_();
			break;
		case FramesEntityDescriptorEnum.IncludePoint_ord:
			specificBuilder.IncludePoint_();
			break;
		case FramesEntityDescriptorEnum.Relations_ord:
			specificBuilder.Relations_();
			break;
		case FramesEntityDescriptorEnum.Pointcut_ord:
			specificBuilder.Pointcut_();
			break;
		case FramesEntityDescriptorEnum.Require_ord:
			specificBuilder.Require_();
			break;
		case FramesEntityDescriptorEnum.Exclude_ord:
			specificBuilder.Exclude_();
			break;
		case FramesEntityDescriptorEnum.MutuallyRequire_ord:
			specificBuilder.MutuallyRequire_();
			break;
		case FramesEntityDescriptorEnum.MutuallyExclude_ord:
			specificBuilder.MutuallyExclude_();
			break;
		case FramesEntityDescriptorEnum.FeatureNames_ord:
			specificBuilder.FeatureNames_();
			break;
		case FramesEntityDescriptorEnum.Advices_ord:
			specificBuilder.Advices_();
			break;
		case FramesEntityDescriptorEnum.Before_ord:
			specificBuilder.Before_();
			break;
		case FramesEntityDescriptorEnum.After_ord:
			specificBuilder.After_();
			break;
		case FramesEntityDescriptorEnum.Into_ord:
			specificBuilder.Into_();
			break;
		case FramesEntityDescriptorEnum.Around_ord:
			specificBuilder.Around_();
			break;
		case FramesEntityDescriptorEnum.Features_ord:
			specificBuilder.Features_();
			break;
		case FramesEntityDescriptorEnum.Subfeatures_ord:
			specificBuilder.Subfeatures_();
			break;
		case FramesEntityDescriptorEnum.VariableFeatures_ord:
			specificBuilder.VariableFeatures_();
			break;
		case FramesEntityDescriptorEnum.SolitaryFeatures_ord:
			specificBuilder.SolitaryFeatures_();
			break;
		case FramesEntityDescriptorEnum.SubsetGroup_ord:
			specificBuilder.SubsetGroup_();
			break;
		case FramesEntityDescriptorEnum.CloneGroup_ord:
			specificBuilder.CloneGroup_();
			break;
		case FramesEntityDescriptorEnum.VariableFeature_ord:
			specificBuilder.VariableFeature_();
			break;
		case FramesEntityDescriptorEnum.Feature_ord:
			specificBuilder.Feature_();
			break;
		case FramesEntityDescriptorEnum.Attribute_ord:
			specificBuilder.Attribute_();
			break;
		case FramesEntityDescriptorEnum.FeatureReference_ord:
			specificBuilder.FeatureReference_();
			break;
		case FramesEntityDescriptorEnum.FeatureRename_ord:
			specificBuilder.FeatureRename_();
			break;
		case FramesEntityDescriptorEnum.Resources_ord:
			specificBuilder.Resources_();
			break;
		case FramesEntityDescriptorEnum.Resource_ord:
			specificBuilder.Resource_();
			break;
		case FramesEntityDescriptorEnum.Cardinality_ord:
			specificBuilder.Cardinality_();
			break;
		case FramesEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations_();
			break;
		case FramesEntityDescriptorEnum.Categories_ord:
			specificBuilder.Categories_();
			break;
		case FramesEntityDescriptorEnum.Stakeholders_ord:
			specificBuilder.Stakeholders_();
			break;
		case FramesEntityDescriptorEnum.CustomAnnotation_ord:
			specificBuilder.CustomAnnotation_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.Frame_ord:
			specificBuilder._Frame();
			break;
		case FramesEntityDescriptorEnum.Variants_ord:
			specificBuilder._Variants();
			break;
		case FramesEntityDescriptorEnum.Empty_ord:
			specificBuilder._Empty();
			break;
		case FramesEntityDescriptorEnum.Proceed_ord:
			specificBuilder._Proceed();
			break;
		case FramesEntityDescriptorEnum.InlineContent_ord:
			specificBuilder._InlineContent();
			break;
		case FramesEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder._JoinPoint();
			break;
		case FramesEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder._ConditionPoint();
			break;
		case FramesEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder._IterationPoint();
			break;
		case FramesEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder._SelectionPoint();
			break;
		case FramesEntityDescriptorEnum.ReusePoint_ord:
			specificBuilder._ReusePoint();
			break;
		case FramesEntityDescriptorEnum.IncludePoint_ord:
			specificBuilder._IncludePoint();
			break;
		case FramesEntityDescriptorEnum.Relations_ord:
			specificBuilder._Relations();
			break;
		case FramesEntityDescriptorEnum.Pointcut_ord:
			specificBuilder._Pointcut();
			break;
		case FramesEntityDescriptorEnum.Require_ord:
			specificBuilder._Require();
			break;
		case FramesEntityDescriptorEnum.Exclude_ord:
			specificBuilder._Exclude();
			break;
		case FramesEntityDescriptorEnum.MutuallyRequire_ord:
			specificBuilder._MutuallyRequire();
			break;
		case FramesEntityDescriptorEnum.MutuallyExclude_ord:
			specificBuilder._MutuallyExclude();
			break;
		case FramesEntityDescriptorEnum.FeatureNames_ord:
			specificBuilder._FeatureNames();
			break;
		case FramesEntityDescriptorEnum.Advices_ord:
			specificBuilder._Advices();
			break;
		case FramesEntityDescriptorEnum.Before_ord:
			specificBuilder._Before();
			break;
		case FramesEntityDescriptorEnum.After_ord:
			specificBuilder._After();
			break;
		case FramesEntityDescriptorEnum.Into_ord:
			specificBuilder._Into();
			break;
		case FramesEntityDescriptorEnum.Around_ord:
			specificBuilder._Around();
			break;
		case FramesEntityDescriptorEnum.Features_ord:
			specificBuilder._Features();
			break;
		case FramesEntityDescriptorEnum.Subfeatures_ord:
			specificBuilder._Subfeatures();
			break;
		case FramesEntityDescriptorEnum.VariableFeatures_ord:
			specificBuilder._VariableFeatures();
			break;
		case FramesEntityDescriptorEnum.SolitaryFeatures_ord:
			specificBuilder._SolitaryFeatures();
			break;
		case FramesEntityDescriptorEnum.SubsetGroup_ord:
			specificBuilder._SubsetGroup();
			break;
		case FramesEntityDescriptorEnum.CloneGroup_ord:
			specificBuilder._CloneGroup();
			break;
		case FramesEntityDescriptorEnum.VariableFeature_ord:
			specificBuilder._VariableFeature();
			break;
		case FramesEntityDescriptorEnum.Feature_ord:
			specificBuilder._Feature();
			break;
		case FramesEntityDescriptorEnum.Attribute_ord:
			specificBuilder._Attribute();
			break;
		case FramesEntityDescriptorEnum.FeatureReference_ord:
			specificBuilder._FeatureReference();
			break;
		case FramesEntityDescriptorEnum.FeatureRename_ord:
			specificBuilder._FeatureRename();
			break;
		case FramesEntityDescriptorEnum.Resources_ord:
			specificBuilder._Resources();
			break;
		case FramesEntityDescriptorEnum.Resource_ord:
			specificBuilder._Resource();
			break;
		case FramesEntityDescriptorEnum.Cardinality_ord:
			specificBuilder._Cardinality();
			break;
		case FramesEntityDescriptorEnum.Annotations_ord:
			specificBuilder._Annotations();
			break;
		case FramesEntityDescriptorEnum.Categories_ord:
			specificBuilder._Categories();
			break;
		case FramesEntityDescriptorEnum.Stakeholders_ord:
			specificBuilder._Stakeholders();
			break;
		case FramesEntityDescriptorEnum.CustomAnnotation_ord:
			specificBuilder._CustomAnnotation();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.Variants_ord:
			specificBuilder.Variants_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Relations_ord:
			specificBuilder.Relations_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.MutuallyRequire_ord:
			specificBuilder.MutuallyRequire_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.MutuallyExclude_ord:
			specificBuilder.MutuallyExclude_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.FeatureNames_ord:
			specificBuilder.FeatureNames_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Advices_ord:
			specificBuilder.Advices_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Features_ord:
			specificBuilder.Features_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Subfeatures_ord:
			specificBuilder.Subfeatures_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.VariableFeatures_ord:
			specificBuilder.VariableFeatures_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.SolitaryFeatures_ord:
			specificBuilder.SolitaryFeatures_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Resources_ord:
			specificBuilder.Resources_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Categories_ord:
			specificBuilder.Categories_(initialCapacity);
			break;
		case FramesEntityDescriptorEnum.Stakeholders_ord:
			specificBuilder.Stakeholders_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.EntityType_ord:
			specificBuilder.EntityType(value);
			break;
		case FramesEntityDescriptorEnum.WorkspacePath_ord:
			specificBuilder.WorkspacePath(value);
			break;
		case FramesEntityDescriptorEnum.FileSystemPath_ord:
			specificBuilder.FileSystemPath(value);
			break;
		case FramesEntityDescriptorEnum.URL_ord:
			specificBuilder.URL(value);
			break;
		case FramesEntityDescriptorEnum.PersistenceId_ord:
			specificBuilder.PersistenceId(value);
			break;
		case FramesEntityDescriptorEnum.StringValue_ord:
			specificBuilder.StringValue(value);
			break;
		case FramesEntityDescriptorEnum.FeatureName_ord:
			specificBuilder.FeatureName(value);
			break;
		case FramesEntityDescriptorEnum.FeatureValue_ord:
			specificBuilder.FeatureValue(value);
			break;
		case FramesEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case FramesEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case FramesEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case FramesEntityDescriptorEnum.Version_ord:
			specificBuilder.Version(value);
			break;
		case FramesEntityDescriptorEnum.Description_ord:
			specificBuilder.Description(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.Domain_ord:
			specificBuilder.Domain((Value) value);
			break;
		case FramesEntityDescriptorEnum.VariableValue_ord:
			specificBuilder
					.VariableValue((org.whole.lang.frames.model.VariableValueEnum.Value) value);
			break;
		case FramesEntityDescriptorEnum.BindingTime_ord:
			specificBuilder
					.BindingTime((org.whole.lang.frames.model.BindingTimeEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.BooleanValue_ord:
			specificBuilder.BooleanValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.ByteValue_ord:
			specificBuilder.ByteValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.ShortValue_ord:
			specificBuilder.ShortValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.IntValue_ord:
			specificBuilder.IntValue(value);
			break;
		case FramesEntityDescriptorEnum.Priority_ord:
			specificBuilder.Priority(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.LongValue_ord:
			specificBuilder.LongValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.FloatValue_ord:
			specificBuilder.FloatValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.DoubleValue_ord:
			specificBuilder.DoubleValue(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		switch (entityDesc.getOrdinal()) {
		case FramesEntityDescriptorEnum.CharValue_ord:
			specificBuilder.CharValue(value);
			break;
		}
	}
}
