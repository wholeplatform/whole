package org.whole.lang.patterns.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.patterns.model.PlacementEnum.Value;

/** 
 * @generator Whole
 */
public class PatternsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IPatternsBuilder specificBuilder;

	public PatternsGenericBuilderAdapter(IPatternsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public PatternsGenericBuilderAdapter(IPatternsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case PatternsFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case PatternsFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case PatternsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case PatternsFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case PatternsFeatureDescriptorEnum.patterns_ord:
			specificBuilder.patterns();
			break;
		case PatternsFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case PatternsFeatureDescriptorEnum.resultTypes_ord:
			specificBuilder.resultTypes();
			break;
		case PatternsFeatureDescriptorEnum.template_ord:
			specificBuilder.template();
			break;
		case PatternsFeatureDescriptorEnum.arguments_ord:
			specificBuilder.arguments();
			break;
		case PatternsFeatureDescriptorEnum.resultType_ord:
			specificBuilder.resultType();
			break;
		case PatternsFeatureDescriptorEnum.optional_ord:
			specificBuilder.optional();
			break;
		case PatternsFeatureDescriptorEnum.adapter_ord:
			specificBuilder.adapter();
			break;
		case PatternsFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case PatternsFeatureDescriptorEnum.weaver_ord:
			specificBuilder.weaver();
			break;
		case PatternsFeatureDescriptorEnum.context_ord:
			specificBuilder.context();
			break;
		case PatternsFeatureDescriptorEnum.expression_ord:
			specificBuilder.expression();
			break;
		case PatternsFeatureDescriptorEnum.condition_ord:
			specificBuilder.condition();
			break;
		case PatternsFeatureDescriptorEnum.iterator_ord:
			specificBuilder.iterator();
			break;
		case PatternsFeatureDescriptorEnum.applicationTypes_ord:
			specificBuilder.applicationTypes();
			break;
		case PatternsFeatureDescriptorEnum.body_ord:
			specificBuilder.body();
			break;
		case PatternsFeatureDescriptorEnum.types_ord:
			specificBuilder.types();
			break;
		case PatternsFeatureDescriptorEnum.values_ord:
			specificBuilder.values();
			break;
		case PatternsFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case PatternsFeatureDescriptorEnum.result_ord:
			specificBuilder.result();
			break;
		case PatternsFeatureDescriptorEnum.path_ord:
			specificBuilder.path();
			break;
		case PatternsFeatureDescriptorEnum.placement_ord:
			specificBuilder.placement();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.PatternLanguage_ord:
			specificBuilder.PatternLanguage();
			break;
		case PatternsEntityDescriptorEnum.Patterns_ord:
			specificBuilder.Patterns();
			break;
		case PatternsEntityDescriptorEnum.Library_ord:
			specificBuilder.Library();
			break;
		case PatternsEntityDescriptorEnum.Pattern_ord:
			specificBuilder.Pattern();
			break;
		case PatternsEntityDescriptorEnum.PatternApplication_ord:
			specificBuilder.PatternApplication();
			break;
		case PatternsEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments();
			break;
		case PatternsEntityDescriptorEnum.Binding_ord:
			specificBuilder.Binding();
			break;
		case PatternsEntityDescriptorEnum.VariablePoint_ord:
			specificBuilder.VariablePoint();
			break;
		case PatternsEntityDescriptorEnum.FunctionApplicationPoint_ord:
			specificBuilder.FunctionApplicationPoint();
			break;
		case PatternsEntityDescriptorEnum.Slot_ord:
			specificBuilder.Slot();
			break;
		case PatternsEntityDescriptorEnum.ResultPoint_ord:
			specificBuilder.ResultPoint();
			break;
		case PatternsEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder.JoinPoint();
			break;
		case PatternsEntityDescriptorEnum.InsertionPoint_ord:
			specificBuilder.InsertionPoint();
			break;
		case PatternsEntityDescriptorEnum.ScopePoint_ord:
			specificBuilder.ScopePoint();
			break;
		case PatternsEntityDescriptorEnum.TemplatePoint_ord:
			specificBuilder.TemplatePoint();
			break;
		case PatternsEntityDescriptorEnum.DerivationPoint_ord:
			specificBuilder.DerivationPoint();
			break;
		case PatternsEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder.SelectionPoint();
			break;
		case PatternsEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder.ConditionPoint();
			break;
		case PatternsEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder.IterationPoint();
			break;
		case PatternsEntityDescriptorEnum.SequencePoint_ord:
			specificBuilder.SequencePoint();
			break;
		case PatternsEntityDescriptorEnum.InlinePoint_ord:
			specificBuilder.InlinePoint();
			break;
		case PatternsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations();
			break;
		case PatternsEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration();
			break;
		case PatternsEntityDescriptorEnum.PointcutDeclaration_ord:
			specificBuilder.PointcutDeclaration();
			break;
		case PatternsEntityDescriptorEnum.JoinPointDeclaration_ord:
			specificBuilder.JoinPointDeclaration();
			break;
		case PatternsEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration();
			break;
		case PatternsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types();
			break;
		case PatternsEntityDescriptorEnum.ResultTypes_ord:
			specificBuilder.ResultTypes();
			break;
		case PatternsEntityDescriptorEnum.Repetition_ord:
			specificBuilder.Repetition();
			break;
		case PatternsEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice();
			break;
		case PatternsEntityDescriptorEnum.Enumeration_ord:
			specificBuilder.Enumeration();
			break;
		case PatternsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues();
			break;
		case PatternsEntityDescriptorEnum.EnumValue_ord:
			specificBuilder.EnumValue();
			break;
		case PatternsEntityDescriptorEnum.PatternJoinPointStep_ord:
			specificBuilder.PatternJoinPointStep();
			break;
		case PatternsEntityDescriptorEnum.Cut_ord:
			specificBuilder.Cut();
			break;
		case PatternsEntityDescriptorEnum.Insert_ord:
			specificBuilder.Insert();
			break;
		case PatternsEntityDescriptorEnum.SlotsDefined_ord:
			specificBuilder.SlotsDefined();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.PatternLanguage_ord:
			specificBuilder.PatternLanguage_();
			break;
		case PatternsEntityDescriptorEnum.Patterns_ord:
			specificBuilder.Patterns_();
			break;
		case PatternsEntityDescriptorEnum.Library_ord:
			specificBuilder.Library_();
			break;
		case PatternsEntityDescriptorEnum.Pattern_ord:
			specificBuilder.Pattern_();
			break;
		case PatternsEntityDescriptorEnum.PatternApplication_ord:
			specificBuilder.PatternApplication_();
			break;
		case PatternsEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_();
			break;
		case PatternsEntityDescriptorEnum.Binding_ord:
			specificBuilder.Binding_();
			break;
		case PatternsEntityDescriptorEnum.VariablePoint_ord:
			specificBuilder.VariablePoint_();
			break;
		case PatternsEntityDescriptorEnum.FunctionApplicationPoint_ord:
			specificBuilder.FunctionApplicationPoint_();
			break;
		case PatternsEntityDescriptorEnum.Slot_ord:
			specificBuilder.Slot_();
			break;
		case PatternsEntityDescriptorEnum.ResultPoint_ord:
			specificBuilder.ResultPoint_();
			break;
		case PatternsEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder.JoinPoint_();
			break;
		case PatternsEntityDescriptorEnum.InsertionPoint_ord:
			specificBuilder.InsertionPoint_();
			break;
		case PatternsEntityDescriptorEnum.ScopePoint_ord:
			specificBuilder.ScopePoint_();
			break;
		case PatternsEntityDescriptorEnum.TemplatePoint_ord:
			specificBuilder.TemplatePoint_();
			break;
		case PatternsEntityDescriptorEnum.DerivationPoint_ord:
			specificBuilder.DerivationPoint_();
			break;
		case PatternsEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder.SelectionPoint_();
			break;
		case PatternsEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder.ConditionPoint_();
			break;
		case PatternsEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder.IterationPoint_();
			break;
		case PatternsEntityDescriptorEnum.SequencePoint_ord:
			specificBuilder.SequencePoint_();
			break;
		case PatternsEntityDescriptorEnum.InlinePoint_ord:
			specificBuilder.InlinePoint_();
			break;
		case PatternsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_();
			break;
		case PatternsEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration_();
			break;
		case PatternsEntityDescriptorEnum.PointcutDeclaration_ord:
			specificBuilder.PointcutDeclaration_();
			break;
		case PatternsEntityDescriptorEnum.JoinPointDeclaration_ord:
			specificBuilder.JoinPointDeclaration_();
			break;
		case PatternsEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration_();
			break;
		case PatternsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_();
			break;
		case PatternsEntityDescriptorEnum.ResultTypes_ord:
			specificBuilder.ResultTypes_();
			break;
		case PatternsEntityDescriptorEnum.Repetition_ord:
			specificBuilder.Repetition_();
			break;
		case PatternsEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice_();
			break;
		case PatternsEntityDescriptorEnum.Enumeration_ord:
			specificBuilder.Enumeration_();
			break;
		case PatternsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_();
			break;
		case PatternsEntityDescriptorEnum.EnumValue_ord:
			specificBuilder.EnumValue_();
			break;
		case PatternsEntityDescriptorEnum.PatternJoinPointStep_ord:
			specificBuilder.PatternJoinPointStep_();
			break;
		case PatternsEntityDescriptorEnum.Cut_ord:
			specificBuilder.Cut_();
			break;
		case PatternsEntityDescriptorEnum.Insert_ord:
			specificBuilder.Insert_();
			break;
		case PatternsEntityDescriptorEnum.SlotsDefined_ord:
			specificBuilder.SlotsDefined_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.PatternLanguage_ord:
			specificBuilder._PatternLanguage();
			break;
		case PatternsEntityDescriptorEnum.Patterns_ord:
			specificBuilder._Patterns();
			break;
		case PatternsEntityDescriptorEnum.Library_ord:
			specificBuilder._Library();
			break;
		case PatternsEntityDescriptorEnum.Pattern_ord:
			specificBuilder._Pattern();
			break;
		case PatternsEntityDescriptorEnum.PatternApplication_ord:
			specificBuilder._PatternApplication();
			break;
		case PatternsEntityDescriptorEnum.Arguments_ord:
			specificBuilder._Arguments();
			break;
		case PatternsEntityDescriptorEnum.Binding_ord:
			specificBuilder._Binding();
			break;
		case PatternsEntityDescriptorEnum.VariablePoint_ord:
			specificBuilder._VariablePoint();
			break;
		case PatternsEntityDescriptorEnum.FunctionApplicationPoint_ord:
			specificBuilder._FunctionApplicationPoint();
			break;
		case PatternsEntityDescriptorEnum.Slot_ord:
			specificBuilder._Slot();
			break;
		case PatternsEntityDescriptorEnum.ResultPoint_ord:
			specificBuilder._ResultPoint();
			break;
		case PatternsEntityDescriptorEnum.JoinPoint_ord:
			specificBuilder._JoinPoint();
			break;
		case PatternsEntityDescriptorEnum.InsertionPoint_ord:
			specificBuilder._InsertionPoint();
			break;
		case PatternsEntityDescriptorEnum.ScopePoint_ord:
			specificBuilder._ScopePoint();
			break;
		case PatternsEntityDescriptorEnum.TemplatePoint_ord:
			specificBuilder._TemplatePoint();
			break;
		case PatternsEntityDescriptorEnum.DerivationPoint_ord:
			specificBuilder._DerivationPoint();
			break;
		case PatternsEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder._SelectionPoint();
			break;
		case PatternsEntityDescriptorEnum.ConditionPoint_ord:
			specificBuilder._ConditionPoint();
			break;
		case PatternsEntityDescriptorEnum.IterationPoint_ord:
			specificBuilder._IterationPoint();
			break;
		case PatternsEntityDescriptorEnum.SequencePoint_ord:
			specificBuilder._SequencePoint();
			break;
		case PatternsEntityDescriptorEnum.InlinePoint_ord:
			specificBuilder._InlinePoint();
			break;
		case PatternsEntityDescriptorEnum.Declarations_ord:
			specificBuilder._Declarations();
			break;
		case PatternsEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder._FunctionDeclaration();
			break;
		case PatternsEntityDescriptorEnum.PointcutDeclaration_ord:
			specificBuilder._PointcutDeclaration();
			break;
		case PatternsEntityDescriptorEnum.JoinPointDeclaration_ord:
			specificBuilder._JoinPointDeclaration();
			break;
		case PatternsEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder._VariableDeclaration();
			break;
		case PatternsEntityDescriptorEnum.Types_ord:
			specificBuilder._Types();
			break;
		case PatternsEntityDescriptorEnum.ResultTypes_ord:
			specificBuilder._ResultTypes();
			break;
		case PatternsEntityDescriptorEnum.Repetition_ord:
			specificBuilder._Repetition();
			break;
		case PatternsEntityDescriptorEnum.Choice_ord:
			specificBuilder._Choice();
			break;
		case PatternsEntityDescriptorEnum.Enumeration_ord:
			specificBuilder._Enumeration();
			break;
		case PatternsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder._EnumValues();
			break;
		case PatternsEntityDescriptorEnum.EnumValue_ord:
			specificBuilder._EnumValue();
			break;
		case PatternsEntityDescriptorEnum.PatternJoinPointStep_ord:
			specificBuilder._PatternJoinPointStep();
			break;
		case PatternsEntityDescriptorEnum.Cut_ord:
			specificBuilder._Cut();
			break;
		case PatternsEntityDescriptorEnum.Insert_ord:
			specificBuilder._Insert();
			break;
		case PatternsEntityDescriptorEnum.SlotsDefined_ord:
			specificBuilder._SlotsDefined();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.Patterns_ord:
			specificBuilder.Patterns_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.SelectionPoint_ord:
			specificBuilder.SelectionPoint_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.SequencePoint_ord:
			specificBuilder.SequencePoint_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.ResultTypes_ord:
			specificBuilder.ResultTypes_(initialCapacity);
			break;
		case PatternsEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case PatternsEntityDescriptorEnum.JoinPointStep_ord:
			specificBuilder.JoinPointStep(value);
			break;
		case PatternsEntityDescriptorEnum.PointcutStep_ord:
			specificBuilder.PointcutStep(value);
			break;
		case PatternsEntityDescriptorEnum.SlotStep_ord:
			specificBuilder.SlotStep(value);
			break;
		case PatternsEntityDescriptorEnum.OuterDefinitionStep_ord:
			specificBuilder.OuterDefinitionStep(value);
			break;
		case PatternsEntityDescriptorEnum.PatternTypeTest_ord:
			specificBuilder.PatternTypeTest(value);
			break;
		case PatternsEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case PatternsEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case PatternsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.Placement_ord:
			specificBuilder.Placement((Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case PatternsEntityDescriptorEnum.BooleanValue_ord:
			specificBuilder.BooleanValue(value);
			break;
		}
	}
}
