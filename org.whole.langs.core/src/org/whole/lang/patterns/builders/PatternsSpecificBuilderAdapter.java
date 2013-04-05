package org.whole.lang.patterns.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.model.PlacementEnum;

/** 
 * @generator Whole
 */
public class PatternsSpecificBuilderAdapter extends GenericBuilderContext
		implements IPatternsBuilder {
	public PatternsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public PatternsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void placement() {
		wFeature(PatternsFeatureDescriptorEnum.placement);
	}

	public void path() {
		wFeature(PatternsFeatureDescriptorEnum.path);
	}

	public void result() {
		wFeature(PatternsFeatureDescriptorEnum.result);
	}

	public void value() {
		wFeature(PatternsFeatureDescriptorEnum.value);
	}

	public void values() {
		wFeature(PatternsFeatureDescriptorEnum.values);
	}

	public void types() {
		wFeature(PatternsFeatureDescriptorEnum.types);
	}

	public void body() {
		wFeature(PatternsFeatureDescriptorEnum.body);
	}

	public void applicationTypes() {
		wFeature(PatternsFeatureDescriptorEnum.applicationTypes);
	}

	public void iterator() {
		wFeature(PatternsFeatureDescriptorEnum.iterator);
	}

	public void condition() {
		wFeature(PatternsFeatureDescriptorEnum.condition);
	}

	public void expression() {
		wFeature(PatternsFeatureDescriptorEnum.expression);
	}

	public void context() {
		wFeature(PatternsFeatureDescriptorEnum.context);
	}

	public void weaver() {
		wFeature(PatternsFeatureDescriptorEnum.weaver);
	}

	public void type() {
		wFeature(PatternsFeatureDescriptorEnum.type);
	}

	public void adapter() {
		wFeature(PatternsFeatureDescriptorEnum.adapter);
	}

	public void optional() {
		wFeature(PatternsFeatureDescriptorEnum.optional);
	}

	public void resultType() {
		wFeature(PatternsFeatureDescriptorEnum.resultType);
	}

	public void arguments() {
		wFeature(PatternsFeatureDescriptorEnum.arguments);
	}

	public void template() {
		wFeature(PatternsFeatureDescriptorEnum.template);
	}

	public void resultTypes() {
		wFeature(PatternsFeatureDescriptorEnum.resultTypes);
	}

	public void declarations() {
		wFeature(PatternsFeatureDescriptorEnum.declarations);
	}

	public void patterns() {
		wFeature(PatternsFeatureDescriptorEnum.patterns);
	}

	public void version() {
		wFeature(PatternsFeatureDescriptorEnum.version);
	}

	public void name() {
		wFeature(PatternsFeatureDescriptorEnum.name);
	}

	public void namespace() {
		wFeature(PatternsFeatureDescriptorEnum.namespace);
	}

	public void uri() {
		wFeature(PatternsFeatureDescriptorEnum.uri);
	}

	public void visit() {
	}

	public void PatternLanguage() {
		wEntity(PatternsEntityDescriptorEnum.PatternLanguage);
	}

	public void PatternLanguage_() {
		wEntity_(PatternsEntityDescriptorEnum.PatternLanguage);
	}

	public void _PatternLanguage() {
		_wEntity(PatternsEntityDescriptorEnum.PatternLanguage);
	}

	public void Patterns() {
		wEntity(PatternsEntityDescriptorEnum.Patterns);
	}

	public void Patterns_() {
		wEntity_(PatternsEntityDescriptorEnum.Patterns);
	}

	public void Patterns_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.Patterns, initialCapacity);
	}

	public void _Patterns() {
		_wEntity(PatternsEntityDescriptorEnum.Patterns);
	}

	public void Library() {
		wEntity(PatternsEntityDescriptorEnum.Library);
	}

	public void Library_() {
		wEntity_(PatternsEntityDescriptorEnum.Library);
	}

	public void _Library() {
		_wEntity(PatternsEntityDescriptorEnum.Library);
	}

	public void Pattern() {
		wEntity(PatternsEntityDescriptorEnum.Pattern);
	}

	public void Pattern_() {
		wEntity_(PatternsEntityDescriptorEnum.Pattern);
	}

	public void _Pattern() {
		_wEntity(PatternsEntityDescriptorEnum.Pattern);
	}

	public void PatternApplication() {
		wEntity(PatternsEntityDescriptorEnum.PatternApplication);
	}

	public void PatternApplication_() {
		wEntity_(PatternsEntityDescriptorEnum.PatternApplication);
	}

	public void _PatternApplication() {
		_wEntity(PatternsEntityDescriptorEnum.PatternApplication);
	}

	public void Arguments() {
		wEntity(PatternsEntityDescriptorEnum.Arguments);
	}

	public void Arguments_() {
		wEntity_(PatternsEntityDescriptorEnum.Arguments);
	}

	public void Arguments_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.Arguments, initialCapacity);
	}

	public void _Arguments() {
		_wEntity(PatternsEntityDescriptorEnum.Arguments);
	}

	public void Binding() {
		wEntity(PatternsEntityDescriptorEnum.Binding);
	}

	public void Binding_() {
		wEntity_(PatternsEntityDescriptorEnum.Binding);
	}

	public void _Binding() {
		_wEntity(PatternsEntityDescriptorEnum.Binding);
	}

	public void VariablePoint() {
		wEntity(PatternsEntityDescriptorEnum.VariablePoint);
	}

	public void VariablePoint_() {
		wEntity_(PatternsEntityDescriptorEnum.VariablePoint);
	}

	public void _VariablePoint() {
		_wEntity(PatternsEntityDescriptorEnum.VariablePoint);
	}

	public void FunctionApplicationPoint() {
		wEntity(PatternsEntityDescriptorEnum.FunctionApplicationPoint);
	}

	public void FunctionApplicationPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.FunctionApplicationPoint);
	}

	public void _FunctionApplicationPoint() {
		_wEntity(PatternsEntityDescriptorEnum.FunctionApplicationPoint);
	}

	public void Slot() {
		wEntity(PatternsEntityDescriptorEnum.Slot);
	}

	public void Slot_() {
		wEntity_(PatternsEntityDescriptorEnum.Slot);
	}

	public void _Slot() {
		_wEntity(PatternsEntityDescriptorEnum.Slot);
	}

	public void ResultPoint() {
		wEntity(PatternsEntityDescriptorEnum.ResultPoint);
	}

	public void ResultPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.ResultPoint);
	}

	public void _ResultPoint() {
		_wEntity(PatternsEntityDescriptorEnum.ResultPoint);
	}

	public void JoinPoint() {
		wEntity(PatternsEntityDescriptorEnum.JoinPoint);
	}

	public void JoinPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.JoinPoint);
	}

	public void _JoinPoint() {
		_wEntity(PatternsEntityDescriptorEnum.JoinPoint);
	}

	public void InsertionPoint() {
		wEntity(PatternsEntityDescriptorEnum.InsertionPoint);
	}

	public void InsertionPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.InsertionPoint);
	}

	public void _InsertionPoint() {
		_wEntity(PatternsEntityDescriptorEnum.InsertionPoint);
	}

	public void ScopePoint() {
		wEntity(PatternsEntityDescriptorEnum.ScopePoint);
	}

	public void ScopePoint_() {
		wEntity_(PatternsEntityDescriptorEnum.ScopePoint);
	}

	public void _ScopePoint() {
		_wEntity(PatternsEntityDescriptorEnum.ScopePoint);
	}

	public void TemplatePoint() {
		wEntity(PatternsEntityDescriptorEnum.TemplatePoint);
	}

	public void TemplatePoint_() {
		wEntity_(PatternsEntityDescriptorEnum.TemplatePoint);
	}

	public void _TemplatePoint() {
		_wEntity(PatternsEntityDescriptorEnum.TemplatePoint);
	}

	public void DerivationPoint() {
		wEntity(PatternsEntityDescriptorEnum.DerivationPoint);
	}

	public void DerivationPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.DerivationPoint);
	}

	public void _DerivationPoint() {
		_wEntity(PatternsEntityDescriptorEnum.DerivationPoint);
	}

	public void SelectionPoint() {
		wEntity(PatternsEntityDescriptorEnum.SelectionPoint);
	}

	public void SelectionPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.SelectionPoint);
	}

	public void SelectionPoint_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.SelectionPoint, initialCapacity);
	}

	public void _SelectionPoint() {
		_wEntity(PatternsEntityDescriptorEnum.SelectionPoint);
	}

	public void ConditionPoint() {
		wEntity(PatternsEntityDescriptorEnum.ConditionPoint);
	}

	public void ConditionPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.ConditionPoint);
	}

	public void _ConditionPoint() {
		_wEntity(PatternsEntityDescriptorEnum.ConditionPoint);
	}

	public void IterationPoint() {
		wEntity(PatternsEntityDescriptorEnum.IterationPoint);
	}

	public void IterationPoint_() {
		wEntity_(PatternsEntityDescriptorEnum.IterationPoint);
	}

	public void _IterationPoint() {
		_wEntity(PatternsEntityDescriptorEnum.IterationPoint);
	}

	public void SequencePoint() {
		wEntity(PatternsEntityDescriptorEnum.SequencePoint);
	}

	public void SequencePoint_() {
		wEntity_(PatternsEntityDescriptorEnum.SequencePoint);
	}

	public void SequencePoint_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.SequencePoint, initialCapacity);
	}

	public void _SequencePoint() {
		_wEntity(PatternsEntityDescriptorEnum.SequencePoint);
	}

	public void InlinePoint() {
		wEntity(PatternsEntityDescriptorEnum.InlinePoint);
	}

	public void InlinePoint_() {
		wEntity_(PatternsEntityDescriptorEnum.InlinePoint);
	}

	public void _InlinePoint() {
		_wEntity(PatternsEntityDescriptorEnum.InlinePoint);
	}

	public void Declarations() {
		wEntity(PatternsEntityDescriptorEnum.Declarations);
	}

	public void Declarations_() {
		wEntity_(PatternsEntityDescriptorEnum.Declarations);
	}

	public void Declarations_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.Declarations, initialCapacity);
	}

	public void _Declarations() {
		_wEntity(PatternsEntityDescriptorEnum.Declarations);
	}

	public void FunctionDeclaration() {
		wEntity(PatternsEntityDescriptorEnum.FunctionDeclaration);
	}

	public void FunctionDeclaration_() {
		wEntity_(PatternsEntityDescriptorEnum.FunctionDeclaration);
	}

	public void _FunctionDeclaration() {
		_wEntity(PatternsEntityDescriptorEnum.FunctionDeclaration);
	}

	public void PointcutDeclaration() {
		wEntity(PatternsEntityDescriptorEnum.PointcutDeclaration);
	}

	public void PointcutDeclaration_() {
		wEntity_(PatternsEntityDescriptorEnum.PointcutDeclaration);
	}

	public void _PointcutDeclaration() {
		_wEntity(PatternsEntityDescriptorEnum.PointcutDeclaration);
	}

	public void JoinPointDeclaration() {
		wEntity(PatternsEntityDescriptorEnum.JoinPointDeclaration);
	}

	public void JoinPointDeclaration_() {
		wEntity_(PatternsEntityDescriptorEnum.JoinPointDeclaration);
	}

	public void _JoinPointDeclaration() {
		_wEntity(PatternsEntityDescriptorEnum.JoinPointDeclaration);
	}

	public void VariableDeclaration() {
		wEntity(PatternsEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclaration_() {
		wEntity_(PatternsEntityDescriptorEnum.VariableDeclaration);
	}

	public void _VariableDeclaration() {
		_wEntity(PatternsEntityDescriptorEnum.VariableDeclaration);
	}

	public void Types() {
		wEntity(PatternsEntityDescriptorEnum.Types);
	}

	public void Types_() {
		wEntity_(PatternsEntityDescriptorEnum.Types);
	}

	public void Types_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.Types, initialCapacity);
	}

	public void _Types() {
		_wEntity(PatternsEntityDescriptorEnum.Types);
	}

	public void ResultTypes() {
		wEntity(PatternsEntityDescriptorEnum.ResultTypes);
	}

	public void ResultTypes_() {
		wEntity_(PatternsEntityDescriptorEnum.ResultTypes);
	}

	public void ResultTypes_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.ResultTypes, initialCapacity);
	}

	public void _ResultTypes() {
		_wEntity(PatternsEntityDescriptorEnum.ResultTypes);
	}

	public void Repetition() {
		wEntity(PatternsEntityDescriptorEnum.Repetition);
	}

	public void Repetition_() {
		wEntity_(PatternsEntityDescriptorEnum.Repetition);
	}

	public void _Repetition() {
		_wEntity(PatternsEntityDescriptorEnum.Repetition);
	}

	public void Choice() {
		wEntity(PatternsEntityDescriptorEnum.Choice);
	}

	public void Choice_() {
		wEntity_(PatternsEntityDescriptorEnum.Choice);
	}

	public void _Choice() {
		_wEntity(PatternsEntityDescriptorEnum.Choice);
	}

	public void Enumeration() {
		wEntity(PatternsEntityDescriptorEnum.Enumeration);
	}

	public void Enumeration_() {
		wEntity_(PatternsEntityDescriptorEnum.Enumeration);
	}

	public void _Enumeration() {
		_wEntity(PatternsEntityDescriptorEnum.Enumeration);
	}

	public void EnumValues() {
		wEntity(PatternsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_() {
		wEntity_(PatternsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_(int initialCapacity) {
		wEntity_(PatternsEntityDescriptorEnum.EnumValues, initialCapacity);
	}

	public void _EnumValues() {
		_wEntity(PatternsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValue() {
		wEntity(PatternsEntityDescriptorEnum.EnumValue);
	}

	public void EnumValue_() {
		wEntity_(PatternsEntityDescriptorEnum.EnumValue);
	}

	public void _EnumValue() {
		_wEntity(PatternsEntityDescriptorEnum.EnumValue);
	}

	public void Name() {
		wEntity(PatternsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(PatternsEntityDescriptorEnum.Name, value);
	}

	public void PatternJoinPointStep() {
		wEntity(PatternsEntityDescriptorEnum.PatternJoinPointStep);
	}

	public void PatternJoinPointStep_() {
		wEntity_(PatternsEntityDescriptorEnum.PatternJoinPointStep);
	}

	public void _PatternJoinPointStep() {
		_wEntity(PatternsEntityDescriptorEnum.PatternJoinPointStep);
	}

	public void JoinPointStep() {
		wEntity(PatternsEntityDescriptorEnum.JoinPointStep);
	}

	public void JoinPointStep(String value) {
		wEntity(PatternsEntityDescriptorEnum.JoinPointStep, value);
	}

	public void PointcutStep() {
		wEntity(PatternsEntityDescriptorEnum.PointcutStep);
	}

	public void PointcutStep(String value) {
		wEntity(PatternsEntityDescriptorEnum.PointcutStep, value);
	}

	public void SlotStep() {
		wEntity(PatternsEntityDescriptorEnum.SlotStep);
	}

	public void SlotStep(String value) {
		wEntity(PatternsEntityDescriptorEnum.SlotStep, value);
	}

	public void OuterDefinitionStep() {
		wEntity(PatternsEntityDescriptorEnum.OuterDefinitionStep);
	}

	public void OuterDefinitionStep(String value) {
		wEntity(PatternsEntityDescriptorEnum.OuterDefinitionStep, value);
	}

	public void Cut() {
		wEntity(PatternsEntityDescriptorEnum.Cut);
	}

	public void Cut_() {
		wEntity_(PatternsEntityDescriptorEnum.Cut);
	}

	public void _Cut() {
		_wEntity(PatternsEntityDescriptorEnum.Cut);
	}

	public void Insert() {
		wEntity(PatternsEntityDescriptorEnum.Insert);
	}

	public void Insert_() {
		wEntity_(PatternsEntityDescriptorEnum.Insert);
	}

	public void _Insert() {
		_wEntity(PatternsEntityDescriptorEnum.Insert);
	}

	public void SlotsDefined() {
		wEntity(PatternsEntityDescriptorEnum.SlotsDefined);
	}

	public void SlotsDefined_() {
		wEntity_(PatternsEntityDescriptorEnum.SlotsDefined);
	}

	public void _SlotsDefined() {
		_wEntity(PatternsEntityDescriptorEnum.SlotsDefined);
	}

	public void PatternTypeTest() {
		wEntity(PatternsEntityDescriptorEnum.PatternTypeTest);
	}

	public void PatternTypeTest(String value) {
		wEntity(PatternsEntityDescriptorEnum.PatternTypeTest, value);
	}

	public void Placement() {
		wEntity(PatternsEntityDescriptorEnum.Placement);
	}

	public void Placement(PlacementEnum.Value value) {
		wEntity(PatternsEntityDescriptorEnum.Placement, value);
	}

	public void Placement(String value) {
		wEntity(PatternsEntityDescriptorEnum.Placement, value);
	}

	public void URI() {
		wEntity(PatternsEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(PatternsEntityDescriptorEnum.URI, value);
	}

	public void Namespace() {
		wEntity(PatternsEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(PatternsEntityDescriptorEnum.Namespace, value);
	}

	public void Version() {
		wEntity(PatternsEntityDescriptorEnum.Version);
	}

	public void Version(String value) {
		wEntity(PatternsEntityDescriptorEnum.Version, value);
	}

	public void BooleanValue() {
		wEntity(PatternsEntityDescriptorEnum.BooleanValue);
	}

	public void BooleanValue(boolean value) {
		wEntity(PatternsEntityDescriptorEnum.BooleanValue, value);
	}
}
