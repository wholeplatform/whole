package org.whole.lang.frames.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.frames.model.DomainEnum;
import org.whole.lang.frames.model.VariableValueEnum;
import org.whole.lang.frames.model.BindingTimeEnum;

/** 
 * @generator Whole
 */
public interface IFramesBuilder extends IBuilder {
	public void visit();

	public void max();

	public void min();

	public void persistence();

	public void location();

	public void newName();

	public void type();

	public void annotations();

	public void value();

	public void features();

	public void cardinality();

	public void excludedFeatures();

	public void requiredFeatures();

	public void feature();

	public void resource();

	public void advices();

	public void configuration();

	public void frame();

	public void variants();

	public void selector();

	public void iterator();

	public void enabler();

	public void joinpoints();

	public void content();

	public void relations();

	public void variability();

	public void imports();

	public void version();

	public void name();

	public void namespace();

	public void uri();

	public void Frame();

	public void Frame_();

	public void _Frame();

	public void Variants();

	public void Variants_();

	public void Variants_(int initialCapacity);

	public void _Variants();

	public void Empty();

	public void Empty_();

	public void _Empty();

	public void Proceed();

	public void Proceed_();

	public void _Proceed();

	public void InlineContent();

	public void InlineContent_();

	public void _InlineContent();

	public void JoinPoint();

	public void JoinPoint_();

	public void _JoinPoint();

	public void ConditionPoint();

	public void ConditionPoint_();

	public void _ConditionPoint();

	public void IterationPoint();

	public void IterationPoint_();

	public void _IterationPoint();

	public void SelectionPoint();

	public void SelectionPoint_();

	public void _SelectionPoint();

	public void ReusePoint();

	public void ReusePoint_();

	public void _ReusePoint();

	public void IncludePoint();

	public void IncludePoint_();

	public void _IncludePoint();

	public void Relations();

	public void Relations_();

	public void Relations_(int initialCapacity);

	public void _Relations();

	public void Pointcut();

	public void Pointcut_();

	public void _Pointcut();

	public void Require();

	public void Require_();

	public void _Require();

	public void Exclude();

	public void Exclude_();

	public void _Exclude();

	public void MutuallyRequire();

	public void MutuallyRequire_();

	public void MutuallyRequire_(int initialCapacity);

	public void _MutuallyRequire();

	public void MutuallyExclude();

	public void MutuallyExclude_();

	public void MutuallyExclude_(int initialCapacity);

	public void _MutuallyExclude();

	public void FeatureNames();

	public void FeatureNames_();

	public void FeatureNames_(int initialCapacity);

	public void _FeatureNames();

	public void Advices();

	public void Advices_();

	public void Advices_(int initialCapacity);

	public void _Advices();

	public void Before();

	public void Before_();

	public void _Before();

	public void After();

	public void After_();

	public void _After();

	public void Into();

	public void Into_();

	public void _Into();

	public void Around();

	public void Around_();

	public void _Around();

	public void Features();

	public void Features_();

	public void Features_(int initialCapacity);

	public void _Features();

	public void Subfeatures();

	public void Subfeatures_();

	public void Subfeatures_(int initialCapacity);

	public void _Subfeatures();

	public void VariableFeatures();

	public void VariableFeatures_();

	public void VariableFeatures_(int initialCapacity);

	public void _VariableFeatures();

	public void SolitaryFeatures();

	public void SolitaryFeatures_();

	public void SolitaryFeatures_(int initialCapacity);

	public void _SolitaryFeatures();

	public void SubsetGroup();

	public void SubsetGroup_();

	public void _SubsetGroup();

	public void CloneGroup();

	public void CloneGroup_();

	public void _CloneGroup();

	public void VariableFeature();

	public void VariableFeature_();

	public void _VariableFeature();

	public void Feature();

	public void Feature_();

	public void _Feature();

	public void Attribute();

	public void Attribute_();

	public void _Attribute();

	public void FeatureReference();

	public void FeatureReference_();

	public void _FeatureReference();

	public void FeatureRename();

	public void FeatureRename_();

	public void _FeatureRename();

	public void EntityType();

	public void EntityType(String value);

	public void Domain();

	public void Domain(DomainEnum.Value value);

	public void Domain(String value);

	public void VariableValue();

	public void VariableValue(VariableValueEnum.Value value);

	public void VariableValue(String value);

	public void Resources();

	public void Resources_();

	public void Resources_(int initialCapacity);

	public void _Resources();

	public void Resource();

	public void Resource_();

	public void _Resource();

	public void WorkspacePath();

	public void WorkspacePath(String value);

	public void FileSystemPath();

	public void FileSystemPath(String value);

	public void URL();

	public void URL(String value);

	public void PersistenceId();

	public void PersistenceId(String value);

	public void BooleanValue();

	public void BooleanValue(boolean value);

	public void ByteValue();

	public void ByteValue(byte value);

	public void ShortValue();

	public void ShortValue(short value);

	public void IntValue();

	public void IntValue(int value);

	public void LongValue();

	public void LongValue(long value);

	public void FloatValue();

	public void FloatValue(float value);

	public void DoubleValue();

	public void DoubleValue(double value);

	public void CharValue();

	public void CharValue(char value);

	public void StringValue();

	public void StringValue(String value);

	public void FeatureName();

	public void FeatureName(String value);

	public void FeatureValue();

	public void FeatureValue(String value);

	public void URI();

	public void URI(String value);

	public void Namespace();

	public void Namespace(String value);

	public void Name();

	public void Name(String value);

	public void Version();

	public void Version(String value);

	public void Cardinality();

	public void Cardinality_();

	public void _Cardinality();

	public void Annotations();

	public void Annotations_();

	public void Annotations_(int initialCapacity);

	public void _Annotations();

	public void Description();

	public void Description(String value);

	public void Categories();

	public void Categories_();

	public void Categories_(int initialCapacity);

	public void _Categories();

	public void Stakeholders();

	public void Stakeholders_();

	public void Stakeholders_(int initialCapacity);

	public void _Stakeholders();

	public void Priority();

	public void Priority(int value);

	public void BindingTime();

	public void BindingTime(BindingTimeEnum.Value value);

	public void BindingTime(String value);

	public void CustomAnnotation();

	public void CustomAnnotation_();

	public void _CustomAnnotation();
}
