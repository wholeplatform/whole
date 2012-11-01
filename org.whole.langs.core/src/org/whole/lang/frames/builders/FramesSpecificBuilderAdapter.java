package org.whole.lang.frames.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.model.DomainEnum;
import org.whole.lang.frames.model.VariableValueEnum;
import org.whole.lang.frames.model.BindingTimeEnum;

/** 
 * @generator Whole
 */
public class FramesSpecificBuilderAdapter extends GenericBuilderContext
		implements IFramesBuilder {
	public FramesSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public FramesSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void max() {
		wFeature(FramesFeatureDescriptorEnum.max);
	}

	public void min() {
		wFeature(FramesFeatureDescriptorEnum.min);
	}

	public void persistence() {
		wFeature(FramesFeatureDescriptorEnum.persistence);
	}

	public void location() {
		wFeature(FramesFeatureDescriptorEnum.location);
	}

	public void newName() {
		wFeature(FramesFeatureDescriptorEnum.newName);
	}

	public void type() {
		wFeature(FramesFeatureDescriptorEnum.type);
	}

	public void annotations() {
		wFeature(FramesFeatureDescriptorEnum.annotations);
	}

	public void value() {
		wFeature(FramesFeatureDescriptorEnum.value);
	}

	public void features() {
		wFeature(FramesFeatureDescriptorEnum.features);
	}

	public void cardinality() {
		wFeature(FramesFeatureDescriptorEnum.cardinality);
	}

	public void excludedFeatures() {
		wFeature(FramesFeatureDescriptorEnum.excludedFeatures);
	}

	public void requiredFeatures() {
		wFeature(FramesFeatureDescriptorEnum.requiredFeatures);
	}

	public void feature() {
		wFeature(FramesFeatureDescriptorEnum.feature);
	}

	public void resource() {
		wFeature(FramesFeatureDescriptorEnum.resource);
	}

	public void advices() {
		wFeature(FramesFeatureDescriptorEnum.advices);
	}

	public void configuration() {
		wFeature(FramesFeatureDescriptorEnum.configuration);
	}

	public void frame() {
		wFeature(FramesFeatureDescriptorEnum.frame);
	}

	public void variants() {
		wFeature(FramesFeatureDescriptorEnum.variants);
	}

	public void selector() {
		wFeature(FramesFeatureDescriptorEnum.selector);
	}

	public void iterator() {
		wFeature(FramesFeatureDescriptorEnum.iterator);
	}

	public void enabler() {
		wFeature(FramesFeatureDescriptorEnum.enabler);
	}

	public void joinpoints() {
		wFeature(FramesFeatureDescriptorEnum.joinpoints);
	}

	public void content() {
		wFeature(FramesFeatureDescriptorEnum.content);
	}

	public void relations() {
		wFeature(FramesFeatureDescriptorEnum.relations);
	}

	public void variability() {
		wFeature(FramesFeatureDescriptorEnum.variability);
	}

	public void imports() {
		wFeature(FramesFeatureDescriptorEnum.imports);
	}

	public void version() {
		wFeature(FramesFeatureDescriptorEnum.version);
	}

	public void name() {
		wFeature(FramesFeatureDescriptorEnum.name);
	}

	public void namespace() {
		wFeature(FramesFeatureDescriptorEnum.namespace);
	}

	public void uri() {
		wFeature(FramesFeatureDescriptorEnum.uri);
	}

	public void visit() {
	}

	public void Frame() {
		wEntity(FramesEntityDescriptorEnum.Frame);
	}

	public void Frame_() {
		wEntity_(FramesEntityDescriptorEnum.Frame);
	}

	public void _Frame() {
		_wEntity(FramesEntityDescriptorEnum.Frame);
	}

	public void Variants() {
		wEntity(FramesEntityDescriptorEnum.Variants);
	}

	public void Variants_() {
		wEntity_(FramesEntityDescriptorEnum.Variants);
	}

	public void Variants_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Variants, initialCapacity);
	}

	public void _Variants() {
		_wEntity(FramesEntityDescriptorEnum.Variants);
	}

	public void Empty() {
		wEntity(FramesEntityDescriptorEnum.Empty);
	}

	public void Empty_() {
		wEntity_(FramesEntityDescriptorEnum.Empty);
	}

	public void _Empty() {
		_wEntity(FramesEntityDescriptorEnum.Empty);
	}

	public void Proceed() {
		wEntity(FramesEntityDescriptorEnum.Proceed);
	}

	public void Proceed_() {
		wEntity_(FramesEntityDescriptorEnum.Proceed);
	}

	public void _Proceed() {
		_wEntity(FramesEntityDescriptorEnum.Proceed);
	}

	public void InlineContent() {
		wEntity(FramesEntityDescriptorEnum.InlineContent);
	}

	public void InlineContent_() {
		wEntity_(FramesEntityDescriptorEnum.InlineContent);
	}

	public void _InlineContent() {
		_wEntity(FramesEntityDescriptorEnum.InlineContent);
	}

	public void JoinPoint() {
		wEntity(FramesEntityDescriptorEnum.JoinPoint);
	}

	public void JoinPoint_() {
		wEntity_(FramesEntityDescriptorEnum.JoinPoint);
	}

	public void _JoinPoint() {
		_wEntity(FramesEntityDescriptorEnum.JoinPoint);
	}

	public void ConditionPoint() {
		wEntity(FramesEntityDescriptorEnum.ConditionPoint);
	}

	public void ConditionPoint_() {
		wEntity_(FramesEntityDescriptorEnum.ConditionPoint);
	}

	public void _ConditionPoint() {
		_wEntity(FramesEntityDescriptorEnum.ConditionPoint);
	}

	public void IterationPoint() {
		wEntity(FramesEntityDescriptorEnum.IterationPoint);
	}

	public void IterationPoint_() {
		wEntity_(FramesEntityDescriptorEnum.IterationPoint);
	}

	public void _IterationPoint() {
		_wEntity(FramesEntityDescriptorEnum.IterationPoint);
	}

	public void SelectionPoint() {
		wEntity(FramesEntityDescriptorEnum.SelectionPoint);
	}

	public void SelectionPoint_() {
		wEntity_(FramesEntityDescriptorEnum.SelectionPoint);
	}

	public void _SelectionPoint() {
		_wEntity(FramesEntityDescriptorEnum.SelectionPoint);
	}

	public void ReusePoint() {
		wEntity(FramesEntityDescriptorEnum.ReusePoint);
	}

	public void ReusePoint_() {
		wEntity_(FramesEntityDescriptorEnum.ReusePoint);
	}

	public void _ReusePoint() {
		_wEntity(FramesEntityDescriptorEnum.ReusePoint);
	}

	public void IncludePoint() {
		wEntity(FramesEntityDescriptorEnum.IncludePoint);
	}

	public void IncludePoint_() {
		wEntity_(FramesEntityDescriptorEnum.IncludePoint);
	}

	public void _IncludePoint() {
		_wEntity(FramesEntityDescriptorEnum.IncludePoint);
	}

	public void Relations() {
		wEntity(FramesEntityDescriptorEnum.Relations);
	}

	public void Relations_() {
		wEntity_(FramesEntityDescriptorEnum.Relations);
	}

	public void Relations_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Relations, initialCapacity);
	}

	public void _Relations() {
		_wEntity(FramesEntityDescriptorEnum.Relations);
	}

	public void Pointcut() {
		wEntity(FramesEntityDescriptorEnum.Pointcut);
	}

	public void Pointcut_() {
		wEntity_(FramesEntityDescriptorEnum.Pointcut);
	}

	public void _Pointcut() {
		_wEntity(FramesEntityDescriptorEnum.Pointcut);
	}

	public void Require() {
		wEntity(FramesEntityDescriptorEnum.Require);
	}

	public void Require_() {
		wEntity_(FramesEntityDescriptorEnum.Require);
	}

	public void _Require() {
		_wEntity(FramesEntityDescriptorEnum.Require);
	}

	public void Exclude() {
		wEntity(FramesEntityDescriptorEnum.Exclude);
	}

	public void Exclude_() {
		wEntity_(FramesEntityDescriptorEnum.Exclude);
	}

	public void _Exclude() {
		_wEntity(FramesEntityDescriptorEnum.Exclude);
	}

	public void MutuallyRequire() {
		wEntity(FramesEntityDescriptorEnum.MutuallyRequire);
	}

	public void MutuallyRequire_() {
		wEntity_(FramesEntityDescriptorEnum.MutuallyRequire);
	}

	public void MutuallyRequire_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.MutuallyRequire, initialCapacity);
	}

	public void _MutuallyRequire() {
		_wEntity(FramesEntityDescriptorEnum.MutuallyRequire);
	}

	public void MutuallyExclude() {
		wEntity(FramesEntityDescriptorEnum.MutuallyExclude);
	}

	public void MutuallyExclude_() {
		wEntity_(FramesEntityDescriptorEnum.MutuallyExclude);
	}

	public void MutuallyExclude_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.MutuallyExclude, initialCapacity);
	}

	public void _MutuallyExclude() {
		_wEntity(FramesEntityDescriptorEnum.MutuallyExclude);
	}

	public void FeatureNames() {
		wEntity(FramesEntityDescriptorEnum.FeatureNames);
	}

	public void FeatureNames_() {
		wEntity_(FramesEntityDescriptorEnum.FeatureNames);
	}

	public void FeatureNames_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.FeatureNames, initialCapacity);
	}

	public void _FeatureNames() {
		_wEntity(FramesEntityDescriptorEnum.FeatureNames);
	}

	public void Advices() {
		wEntity(FramesEntityDescriptorEnum.Advices);
	}

	public void Advices_() {
		wEntity_(FramesEntityDescriptorEnum.Advices);
	}

	public void Advices_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Advices, initialCapacity);
	}

	public void _Advices() {
		_wEntity(FramesEntityDescriptorEnum.Advices);
	}

	public void Before() {
		wEntity(FramesEntityDescriptorEnum.Before);
	}

	public void Before_() {
		wEntity_(FramesEntityDescriptorEnum.Before);
	}

	public void _Before() {
		_wEntity(FramesEntityDescriptorEnum.Before);
	}

	public void After() {
		wEntity(FramesEntityDescriptorEnum.After);
	}

	public void After_() {
		wEntity_(FramesEntityDescriptorEnum.After);
	}

	public void _After() {
		_wEntity(FramesEntityDescriptorEnum.After);
	}

	public void Into() {
		wEntity(FramesEntityDescriptorEnum.Into);
	}

	public void Into_() {
		wEntity_(FramesEntityDescriptorEnum.Into);
	}

	public void _Into() {
		_wEntity(FramesEntityDescriptorEnum.Into);
	}

	public void Around() {
		wEntity(FramesEntityDescriptorEnum.Around);
	}

	public void Around_() {
		wEntity_(FramesEntityDescriptorEnum.Around);
	}

	public void _Around() {
		_wEntity(FramesEntityDescriptorEnum.Around);
	}

	public void Features() {
		wEntity(FramesEntityDescriptorEnum.Features);
	}

	public void Features_() {
		wEntity_(FramesEntityDescriptorEnum.Features);
	}

	public void Features_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Features, initialCapacity);
	}

	public void _Features() {
		_wEntity(FramesEntityDescriptorEnum.Features);
	}

	public void Subfeatures() {
		wEntity(FramesEntityDescriptorEnum.Subfeatures);
	}

	public void Subfeatures_() {
		wEntity_(FramesEntityDescriptorEnum.Subfeatures);
	}

	public void Subfeatures_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Subfeatures, initialCapacity);
	}

	public void _Subfeatures() {
		_wEntity(FramesEntityDescriptorEnum.Subfeatures);
	}

	public void VariableFeatures() {
		wEntity(FramesEntityDescriptorEnum.VariableFeatures);
	}

	public void VariableFeatures_() {
		wEntity_(FramesEntityDescriptorEnum.VariableFeatures);
	}

	public void VariableFeatures_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.VariableFeatures, initialCapacity);
	}

	public void _VariableFeatures() {
		_wEntity(FramesEntityDescriptorEnum.VariableFeatures);
	}

	public void SolitaryFeatures() {
		wEntity(FramesEntityDescriptorEnum.SolitaryFeatures);
	}

	public void SolitaryFeatures_() {
		wEntity_(FramesEntityDescriptorEnum.SolitaryFeatures);
	}

	public void SolitaryFeatures_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.SolitaryFeatures, initialCapacity);
	}

	public void _SolitaryFeatures() {
		_wEntity(FramesEntityDescriptorEnum.SolitaryFeatures);
	}

	public void SubsetGroup() {
		wEntity(FramesEntityDescriptorEnum.SubsetGroup);
	}

	public void SubsetGroup_() {
		wEntity_(FramesEntityDescriptorEnum.SubsetGroup);
	}

	public void _SubsetGroup() {
		_wEntity(FramesEntityDescriptorEnum.SubsetGroup);
	}

	public void CloneGroup() {
		wEntity(FramesEntityDescriptorEnum.CloneGroup);
	}

	public void CloneGroup_() {
		wEntity_(FramesEntityDescriptorEnum.CloneGroup);
	}

	public void _CloneGroup() {
		_wEntity(FramesEntityDescriptorEnum.CloneGroup);
	}

	public void VariableFeature() {
		wEntity(FramesEntityDescriptorEnum.VariableFeature);
	}

	public void VariableFeature_() {
		wEntity_(FramesEntityDescriptorEnum.VariableFeature);
	}

	public void _VariableFeature() {
		_wEntity(FramesEntityDescriptorEnum.VariableFeature);
	}

	public void Feature() {
		wEntity(FramesEntityDescriptorEnum.Feature);
	}

	public void Feature_() {
		wEntity_(FramesEntityDescriptorEnum.Feature);
	}

	public void _Feature() {
		_wEntity(FramesEntityDescriptorEnum.Feature);
	}

	public void Attribute() {
		wEntity(FramesEntityDescriptorEnum.Attribute);
	}

	public void Attribute_() {
		wEntity_(FramesEntityDescriptorEnum.Attribute);
	}

	public void _Attribute() {
		_wEntity(FramesEntityDescriptorEnum.Attribute);
	}

	public void FeatureReference() {
		wEntity(FramesEntityDescriptorEnum.FeatureReference);
	}

	public void FeatureReference_() {
		wEntity_(FramesEntityDescriptorEnum.FeatureReference);
	}

	public void _FeatureReference() {
		_wEntity(FramesEntityDescriptorEnum.FeatureReference);
	}

	public void FeatureRename() {
		wEntity(FramesEntityDescriptorEnum.FeatureRename);
	}

	public void FeatureRename_() {
		wEntity_(FramesEntityDescriptorEnum.FeatureRename);
	}

	public void _FeatureRename() {
		_wEntity(FramesEntityDescriptorEnum.FeatureRename);
	}

	public void EntityType() {
		wEntity(FramesEntityDescriptorEnum.EntityType);
	}

	public void EntityType(String value) {
		wEntity(FramesEntityDescriptorEnum.EntityType, value);
	}

	public void Domain() {
		wEntity(FramesEntityDescriptorEnum.Domain);
	}

	public void Domain(DomainEnum.Value value) {
		wEntity(FramesEntityDescriptorEnum.Domain, value);
	}

	public void Domain(String value) {
		wEntity(FramesEntityDescriptorEnum.Domain, value);
	}

	public void VariableValue() {
		wEntity(FramesEntityDescriptorEnum.VariableValue);
	}

	public void VariableValue(VariableValueEnum.Value value) {
		wEntity(FramesEntityDescriptorEnum.VariableValue, value);
	}

	public void VariableValue(String value) {
		wEntity(FramesEntityDescriptorEnum.VariableValue, value);
	}

	public void Resources() {
		wEntity(FramesEntityDescriptorEnum.Resources);
	}

	public void Resources_() {
		wEntity_(FramesEntityDescriptorEnum.Resources);
	}

	public void Resources_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Resources, initialCapacity);
	}

	public void _Resources() {
		_wEntity(FramesEntityDescriptorEnum.Resources);
	}

	public void Resource() {
		wEntity(FramesEntityDescriptorEnum.Resource);
	}

	public void Resource_() {
		wEntity_(FramesEntityDescriptorEnum.Resource);
	}

	public void _Resource() {
		_wEntity(FramesEntityDescriptorEnum.Resource);
	}

	public void WorkspacePath() {
		wEntity(FramesEntityDescriptorEnum.WorkspacePath);
	}

	public void WorkspacePath(String value) {
		wEntity(FramesEntityDescriptorEnum.WorkspacePath, value);
	}

	public void FileSystemPath() {
		wEntity(FramesEntityDescriptorEnum.FileSystemPath);
	}

	public void FileSystemPath(String value) {
		wEntity(FramesEntityDescriptorEnum.FileSystemPath, value);
	}

	public void URL() {
		wEntity(FramesEntityDescriptorEnum.URL);
	}

	public void URL(String value) {
		wEntity(FramesEntityDescriptorEnum.URL, value);
	}

	public void PersistenceId() {
		wEntity(FramesEntityDescriptorEnum.PersistenceId);
	}

	public void PersistenceId(String value) {
		wEntity(FramesEntityDescriptorEnum.PersistenceId, value);
	}

	public void BooleanValue() {
		wEntity(FramesEntityDescriptorEnum.BooleanValue);
	}

	public void BooleanValue(boolean value) {
		wEntity(FramesEntityDescriptorEnum.BooleanValue, value);
	}

	public void ByteValue() {
		wEntity(FramesEntityDescriptorEnum.ByteValue);
	}

	public void ByteValue(byte value) {
		wEntity(FramesEntityDescriptorEnum.ByteValue, value);
	}

	public void ShortValue() {
		wEntity(FramesEntityDescriptorEnum.ShortValue);
	}

	public void ShortValue(short value) {
		wEntity(FramesEntityDescriptorEnum.ShortValue, value);
	}

	public void IntValue() {
		wEntity(FramesEntityDescriptorEnum.IntValue);
	}

	public void IntValue(int value) {
		wEntity(FramesEntityDescriptorEnum.IntValue, value);
	}

	public void LongValue() {
		wEntity(FramesEntityDescriptorEnum.LongValue);
	}

	public void LongValue(long value) {
		wEntity(FramesEntityDescriptorEnum.LongValue, value);
	}

	public void FloatValue() {
		wEntity(FramesEntityDescriptorEnum.FloatValue);
	}

	public void FloatValue(float value) {
		wEntity(FramesEntityDescriptorEnum.FloatValue, value);
	}

	public void DoubleValue() {
		wEntity(FramesEntityDescriptorEnum.DoubleValue);
	}

	public void DoubleValue(double value) {
		wEntity(FramesEntityDescriptorEnum.DoubleValue, value);
	}

	public void CharValue() {
		wEntity(FramesEntityDescriptorEnum.CharValue);
	}

	public void CharValue(char value) {
		wEntity(FramesEntityDescriptorEnum.CharValue, value);
	}

	public void StringValue() {
		wEntity(FramesEntityDescriptorEnum.StringValue);
	}

	public void StringValue(String value) {
		wEntity(FramesEntityDescriptorEnum.StringValue, value);
	}

	public void FeatureName() {
		wEntity(FramesEntityDescriptorEnum.FeatureName);
	}

	public void FeatureName(String value) {
		wEntity(FramesEntityDescriptorEnum.FeatureName, value);
	}

	public void FeatureValue() {
		wEntity(FramesEntityDescriptorEnum.FeatureValue);
	}

	public void FeatureValue(String value) {
		wEntity(FramesEntityDescriptorEnum.FeatureValue, value);
	}

	public void URI() {
		wEntity(FramesEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(FramesEntityDescriptorEnum.URI, value);
	}

	public void Namespace() {
		wEntity(FramesEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(FramesEntityDescriptorEnum.Namespace, value);
	}

	public void Name() {
		wEntity(FramesEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(FramesEntityDescriptorEnum.Name, value);
	}

	public void Version() {
		wEntity(FramesEntityDescriptorEnum.Version);
	}

	public void Version(String value) {
		wEntity(FramesEntityDescriptorEnum.Version, value);
	}

	public void Cardinality() {
		wEntity(FramesEntityDescriptorEnum.Cardinality);
	}

	public void Cardinality_() {
		wEntity_(FramesEntityDescriptorEnum.Cardinality);
	}

	public void _Cardinality() {
		_wEntity(FramesEntityDescriptorEnum.Cardinality);
	}

	public void Annotations() {
		wEntity(FramesEntityDescriptorEnum.Annotations);
	}

	public void Annotations_() {
		wEntity_(FramesEntityDescriptorEnum.Annotations);
	}

	public void Annotations_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Annotations, initialCapacity);
	}

	public void _Annotations() {
		_wEntity(FramesEntityDescriptorEnum.Annotations);
	}

	public void Description() {
		wEntity(FramesEntityDescriptorEnum.Description);
	}

	public void Description(String value) {
		wEntity(FramesEntityDescriptorEnum.Description, value);
	}

	public void Categories() {
		wEntity(FramesEntityDescriptorEnum.Categories);
	}

	public void Categories_() {
		wEntity_(FramesEntityDescriptorEnum.Categories);
	}

	public void Categories_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Categories, initialCapacity);
	}

	public void _Categories() {
		_wEntity(FramesEntityDescriptorEnum.Categories);
	}

	public void Stakeholders() {
		wEntity(FramesEntityDescriptorEnum.Stakeholders);
	}

	public void Stakeholders_() {
		wEntity_(FramesEntityDescriptorEnum.Stakeholders);
	}

	public void Stakeholders_(int initialCapacity) {
		wEntity_(FramesEntityDescriptorEnum.Stakeholders, initialCapacity);
	}

	public void _Stakeholders() {
		_wEntity(FramesEntityDescriptorEnum.Stakeholders);
	}

	public void Priority() {
		wEntity(FramesEntityDescriptorEnum.Priority);
	}

	public void Priority(int value) {
		wEntity(FramesEntityDescriptorEnum.Priority, value);
	}

	public void BindingTime() {
		wEntity(FramesEntityDescriptorEnum.BindingTime);
	}

	public void BindingTime(BindingTimeEnum.Value value) {
		wEntity(FramesEntityDescriptorEnum.BindingTime, value);
	}

	public void BindingTime(String value) {
		wEntity(FramesEntityDescriptorEnum.BindingTime, value);
	}

	public void CustomAnnotation() {
		wEntity(FramesEntityDescriptorEnum.CustomAnnotation);
	}

	public void CustomAnnotation_() {
		wEntity_(FramesEntityDescriptorEnum.CustomAnnotation);
	}

	public void _CustomAnnotation() {
		_wEntity(FramesEntityDescriptorEnum.CustomAnnotation);
	}
}
