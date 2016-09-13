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
package org.whole.lang.patterns.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class PatternsEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int PatternLanguage_ord = 0;
    public static final int Patterns_ord = 1;
    public static final int PatternOrTypeDeclaration_ord = 2;
    public static final int Library_ord = 3;
    public static final int Template_ord = 4;
    public static final int Pattern_ord = 5;
    public static final int Repetition_ord = 6;
    public static final int Choice_ord = 7;
    public static final int Enumeration_ord = 8;
    public static final int EnumValues_ord = 9;
    public static final int EnumValue_ord = 10;
    public static final int Data_ord = 11;
    public static final int DataType_ord = 12;
    public static final int VariationPoint_ord = 13;
    public static final int PatternApplication_ord = 14;
    public static final int Arguments_ord = 15;
    public static final int Binding_ord = 16;
    public static final int VariablePoint_ord = 17;
    public static final int FunctionPoint_ord = 18;
    public static final int Slot_ord = 19;
    public static final int ResultPoint_ord = 20;
    public static final int JoinPoint_ord = 21;
    public static final int InsertionPoint_ord = 22;
    public static final int ScopePoint_ord = 23;
    public static final int TemplatePoint_ord = 24;
    public static final int DerivationPoint_ord = 25;
    public static final int SelectionPoint_ord = 26;
    public static final int ConditionPoint_ord = 27;
    public static final int VariantSelectionPoint_ord = 28;
    public static final int Variants_ord = 29;
    public static final int Variant_ord = 30;
    public static final int IterationPoint_ord = 31;
    public static final int SequencePoint_ord = 32;
    public static final int InlinePoint_ord = 33;
    public static final int Declarations_ord = 34;
    public static final int FunctionDeclaration_ord = 35;
    public static final int GoalDeclaration_ord = 36;
    public static final int PointcutDeclaration_ord = 37;
    public static final int JoinPointDeclaration_ord = 38;
    public static final int VariableDeclaration_ord = 39;
    public static final int VariantSelector_ord = 40;
    public static final int Types_ord = 41;
    public static final int ResultTypes_ord = 42;
    public static final int Type_ord = 43;
    public static final int ResultTypeOrPathExpression_ord = 44;
    public static final int ResultType_ord = 45;
    public static final int PathExpression_ord = 46;
    public static final int StepExpression_ord = 47;
    public static final int Name_ord = 48;
    public static final int PatternJoinPointStep_ord = 49;
    public static final int JoinPointStep_ord = 50;
    public static final int PointcutStep_ord = 51;
    public static final int GoalStep_ord = 52;
    public static final int FunctionStep_ord = 53;
    public static final int SlotStep_ord = 54;
    public static final int OuterDefinitionStep_ord = 55;
    public static final int PatternInstance_ord = 56;
    public static final int Cut_ord = 57;
    public static final int Insert_ord = 58;
    public static final int SlotsDefined_ord = 59;
    public static final int PatternTypeTest_ord = 60;
    public static final int Placement_ord = 61;
    public static final int URI_ord = 62;
    public static final int Namespace_ord = 63;
    public static final int Version_ord = 64;
    public static final int BooleanValue_ord = 65;
    public static final int GoalExpression_ord = 66;
    public static final int Argument_ord = 67;
    public static final int Predicate_ord = 68;
    public static final int Declaration_ord = 69;
    public static final PatternsEntityDescriptorEnum instance = new PatternsEntityDescriptorEnum();
    public static final EntityDescriptor<PatternLanguage> PatternLanguage = (EntityDescriptor<PatternLanguage>) instance.valueOf(PatternLanguage_ord);
    public static final EntityDescriptor<Patterns> Patterns = (EntityDescriptor<Patterns>) instance.valueOf(Patterns_ord);
    public static final EntityDescriptor<PatternOrTypeDeclaration> PatternOrTypeDeclaration = (EntityDescriptor<PatternOrTypeDeclaration>) instance.valueOf(PatternOrTypeDeclaration_ord);
    public static final EntityDescriptor<Library> Library = (EntityDescriptor<Library>) instance.valueOf(Library_ord);
    public static final EntityDescriptor<Template> Template = (EntityDescriptor<Template>) instance.valueOf(Template_ord);
    public static final EntityDescriptor<Pattern> Pattern = (EntityDescriptor<Pattern>) instance.valueOf(Pattern_ord);
    public static final EntityDescriptor<Repetition> Repetition = (EntityDescriptor<Repetition>) instance.valueOf(Repetition_ord);
    public static final EntityDescriptor<Choice> Choice = (EntityDescriptor<Choice>) instance.valueOf(Choice_ord);
    public static final EntityDescriptor<Enumeration> Enumeration = (EntityDescriptor<Enumeration>) instance.valueOf(Enumeration_ord);
    public static final EntityDescriptor<EnumValues> EnumValues = (EntityDescriptor<EnumValues>) instance.valueOf(EnumValues_ord);
    public static final EntityDescriptor<EnumValue> EnumValue = (EntityDescriptor<EnumValue>) instance.valueOf(EnumValue_ord);
    public static final EntityDescriptor<Data> Data = (EntityDescriptor<Data>) instance.valueOf(Data_ord);
    public static final EntityDescriptor<DataType> DataType = (EntityDescriptor<DataType>) instance.valueOf(DataType_ord);
    public static final EntityDescriptor<VariationPoint> VariationPoint = (EntityDescriptor<VariationPoint>) instance.valueOf(VariationPoint_ord);
    public static final EntityDescriptor<PatternApplication> PatternApplication = (EntityDescriptor<PatternApplication>) instance.valueOf(PatternApplication_ord);
    public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance.valueOf(Arguments_ord);
    public static final EntityDescriptor<Binding> Binding = (EntityDescriptor<Binding>) instance.valueOf(Binding_ord);
    public static final EntityDescriptor<VariablePoint> VariablePoint = (EntityDescriptor<VariablePoint>) instance.valueOf(VariablePoint_ord);
    public static final EntityDescriptor<FunctionPoint> FunctionPoint = (EntityDescriptor<FunctionPoint>) instance.valueOf(FunctionPoint_ord);
    public static final EntityDescriptor<Slot> Slot = (EntityDescriptor<Slot>) instance.valueOf(Slot_ord);
    public static final EntityDescriptor<ResultPoint> ResultPoint = (EntityDescriptor<ResultPoint>) instance.valueOf(ResultPoint_ord);
    public static final EntityDescriptor<JoinPoint> JoinPoint = (EntityDescriptor<JoinPoint>) instance.valueOf(JoinPoint_ord);
    public static final EntityDescriptor<InsertionPoint> InsertionPoint = (EntityDescriptor<InsertionPoint>) instance.valueOf(InsertionPoint_ord);
    public static final EntityDescriptor<ScopePoint> ScopePoint = (EntityDescriptor<ScopePoint>) instance.valueOf(ScopePoint_ord);
    public static final EntityDescriptor<TemplatePoint> TemplatePoint = (EntityDescriptor<TemplatePoint>) instance.valueOf(TemplatePoint_ord);
    public static final EntityDescriptor<DerivationPoint> DerivationPoint = (EntityDescriptor<DerivationPoint>) instance.valueOf(DerivationPoint_ord);
    public static final EntityDescriptor<SelectionPoint> SelectionPoint = (EntityDescriptor<SelectionPoint>) instance.valueOf(SelectionPoint_ord);
    public static final EntityDescriptor<ConditionPoint> ConditionPoint = (EntityDescriptor<ConditionPoint>) instance.valueOf(ConditionPoint_ord);
    public static final EntityDescriptor<VariantSelectionPoint> VariantSelectionPoint = (EntityDescriptor<VariantSelectionPoint>) instance.valueOf(VariantSelectionPoint_ord);
    public static final EntityDescriptor<Variants> Variants = (EntityDescriptor<Variants>) instance.valueOf(Variants_ord);
    public static final EntityDescriptor<Variant> Variant = (EntityDescriptor<Variant>) instance.valueOf(Variant_ord);
    public static final EntityDescriptor<IterationPoint> IterationPoint = (EntityDescriptor<IterationPoint>) instance.valueOf(IterationPoint_ord);
    public static final EntityDescriptor<SequencePoint> SequencePoint = (EntityDescriptor<SequencePoint>) instance.valueOf(SequencePoint_ord);
    public static final EntityDescriptor<InlinePoint> InlinePoint = (EntityDescriptor<InlinePoint>) instance.valueOf(InlinePoint_ord);
    public static final EntityDescriptor<Declarations> Declarations = (EntityDescriptor<Declarations>) instance.valueOf(Declarations_ord);
    public static final EntityDescriptor<FunctionDeclaration> FunctionDeclaration = (EntityDescriptor<FunctionDeclaration>) instance.valueOf(FunctionDeclaration_ord);
    public static final EntityDescriptor<GoalDeclaration> GoalDeclaration = (EntityDescriptor<GoalDeclaration>) instance.valueOf(GoalDeclaration_ord);
    public static final EntityDescriptor<PointcutDeclaration> PointcutDeclaration = (EntityDescriptor<PointcutDeclaration>) instance.valueOf(PointcutDeclaration_ord);
    public static final EntityDescriptor<JoinPointDeclaration> JoinPointDeclaration = (EntityDescriptor<JoinPointDeclaration>) instance.valueOf(JoinPointDeclaration_ord);
    public static final EntityDescriptor<VariableDeclaration> VariableDeclaration = (EntityDescriptor<VariableDeclaration>) instance.valueOf(VariableDeclaration_ord);
    public static final EntityDescriptor<VariantSelector> VariantSelector = (EntityDescriptor<VariantSelector>) instance.valueOf(VariantSelector_ord);
    public static final EntityDescriptor<Types> Types = (EntityDescriptor<Types>) instance.valueOf(Types_ord);
    public static final EntityDescriptor<ResultTypes> ResultTypes = (EntityDescriptor<ResultTypes>) instance.valueOf(ResultTypes_ord);
    public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance.valueOf(Type_ord);
    public static final EntityDescriptor<ResultTypeOrPathExpression> ResultTypeOrPathExpression = (EntityDescriptor<ResultTypeOrPathExpression>) instance.valueOf(ResultTypeOrPathExpression_ord);
    public static final EntityDescriptor<ResultType> ResultType = (EntityDescriptor<ResultType>) instance.valueOf(ResultType_ord);
    public static final EntityDescriptor<PathExpression> PathExpression = (EntityDescriptor<PathExpression>) instance.valueOf(PathExpression_ord);
    public static final EntityDescriptor<StepExpression> StepExpression = (EntityDescriptor<StepExpression>) instance.valueOf(StepExpression_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<PatternJoinPointStep> PatternJoinPointStep = (EntityDescriptor<PatternJoinPointStep>) instance.valueOf(PatternJoinPointStep_ord);
    public static final EntityDescriptor<JoinPointStep> JoinPointStep = (EntityDescriptor<JoinPointStep>) instance.valueOf(JoinPointStep_ord);
    public static final EntityDescriptor<PointcutStep> PointcutStep = (EntityDescriptor<PointcutStep>) instance.valueOf(PointcutStep_ord);
    public static final EntityDescriptor<GoalStep> GoalStep = (EntityDescriptor<GoalStep>) instance.valueOf(GoalStep_ord);
    public static final EntityDescriptor<FunctionStep> FunctionStep = (EntityDescriptor<FunctionStep>) instance.valueOf(FunctionStep_ord);
    public static final EntityDescriptor<SlotStep> SlotStep = (EntityDescriptor<SlotStep>) instance.valueOf(SlotStep_ord);
    public static final EntityDescriptor<OuterDefinitionStep> OuterDefinitionStep = (EntityDescriptor<OuterDefinitionStep>) instance.valueOf(OuterDefinitionStep_ord);
    public static final EntityDescriptor<PatternInstance> PatternInstance = (EntityDescriptor<PatternInstance>) instance.valueOf(PatternInstance_ord);
    public static final EntityDescriptor<Cut> Cut = (EntityDescriptor<Cut>) instance.valueOf(Cut_ord);
    public static final EntityDescriptor<Insert> Insert = (EntityDescriptor<Insert>) instance.valueOf(Insert_ord);
    public static final EntityDescriptor<SlotsDefined> SlotsDefined = (EntityDescriptor<SlotsDefined>) instance.valueOf(SlotsDefined_ord);
    public static final EntityDescriptor<PatternTypeTest> PatternTypeTest = (EntityDescriptor<PatternTypeTest>) instance.valueOf(PatternTypeTest_ord);
    public static final EntityDescriptor<Placement> Placement = (EntityDescriptor<Placement>) instance.valueOf(Placement_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Namespace> Namespace = (EntityDescriptor<Namespace>) instance.valueOf(Namespace_ord);
    public static final EntityDescriptor<Version> Version = (EntityDescriptor<Version>) instance.valueOf(Version_ord);
    public static final EntityDescriptor<BooleanValue> BooleanValue = (EntityDescriptor<BooleanValue>) instance.valueOf(BooleanValue_ord);
    public static final EntityDescriptor<GoalExpression> GoalExpression = (EntityDescriptor<GoalExpression>) instance.valueOf(GoalExpression_ord);
    public static final EntityDescriptor<Argument> Argument = (EntityDescriptor<Argument>) instance.valueOf(Argument_ord);
    public static final EntityDescriptor<Predicate> Predicate = (EntityDescriptor<Predicate>) instance.valueOf(Predicate_ord);
    public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance.valueOf(Declaration_ord);

    private PatternsEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(PatternLanguage_ord, "PatternLanguage", PatternLanguage.class, false).withFeature(PatternsFeatureDescriptorEnum.uri, URI_ord).withFeature(PatternsFeatureDescriptorEnum.namespace, Namespace_ord).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.version, Version_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.patterns, Patterns_ord).withFeature(PatternsFeatureDescriptorEnum.declarations, Declarations_ord, true, false, false, false, false);
        putCompositeEntity(
		Patterns_ord, "Patterns", Patterns.class, false, PatternOrTypeDeclaration_ord, true, false);
        putSimpleEntity(PatternOrTypeDeclaration_ord, "PatternOrTypeDeclaration", PatternOrTypeDeclaration.class, true, Pattern_ord, Data_ord, Choice_ord, Enumeration_ord, Repetition_ord);
        putSimpleEntity(Library_ord, "Library", Library.class, false).withFeature(PatternsFeatureDescriptorEnum.uri, URI_ord).withFeature(PatternsFeatureDescriptorEnum.namespace, Namespace_ord).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.version, Version_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.declarations, Declarations_ord);
        putSimpleEntity(Template_ord, "Template", Template.class, true, ResultPoint_ord, DerivationPoint_ord, PointcutStep_ord, InsertionPoint_ord, FunctionPoint_ord, Insert_ord, Name_ord, JoinPoint_ord, FunctionStep_ord, PathExpression_ord, VariablePoint_ord, TemplatePoint_ord, PatternJoinPointStep_ord, OuterDefinitionStep_ord, SlotStep_ord, StepExpression_ord, Cut_ord, PatternInstance_ord, VariantSelectionPoint_ord, JoinPointStep_ord, SelectionPoint_ord, ScopePoint_ord, ConditionPoint_ord, IterationPoint_ord, PatternApplication_ord, InlinePoint_ord, VariationPoint_ord, GoalStep_ord, Slot_ord, SequencePoint_ord);
        putSimpleEntity(Pattern_ord, "Pattern", Pattern.class, false).withFeature(PatternsFeatureDescriptorEnum.resultTypes, ResultTypes_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(Repetition_ord, "Repetition", Repetition.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.type, Type_ord).withFeature(PatternsFeatureDescriptorEnum.supertypes, ResultTypes_ord, true, false, false, false, false);
        putSimpleEntity(Choice_ord, "Choice", Choice.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.types, Types_ord).withFeature(PatternsFeatureDescriptorEnum.supertypes, ResultTypes_ord, true, false, false, false, false);
        putSimpleEntity(Enumeration_ord, "Enumeration", Enumeration.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.resultType, Type_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.values, EnumValues_ord).withFeature(PatternsFeatureDescriptorEnum.supertypes, ResultTypes_ord, true, false, false, false, false);
        putCompositeEntity(
		EnumValues_ord, "EnumValues", EnumValues.class, false, EnumValue_ord, true, false);
        putSimpleEntity(EnumValue_ord, "EnumValue", EnumValue.class, false).withFeature(PatternsFeatureDescriptorEnum.value, Name_ord).withFeature(PatternsFeatureDescriptorEnum.result, Name_ord, true, false, false, false, false);
        putSimpleEntity(Data_ord, "Data", Data.class, false).withFeature(PatternsFeatureDescriptorEnum.supertypes, ResultTypes_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.dataType, DataType_ord);
        putDataEntity(DataType_ord, "DataType", DataType.class, false, String.class);
        putSimpleEntity(VariationPoint_ord, "VariationPoint", VariationPoint.class, true, ResultPoint_ord, VariantSelectionPoint_ord, DerivationPoint_ord, InsertionPoint_ord, FunctionPoint_ord, SelectionPoint_ord, ScopePoint_ord, JoinPoint_ord, ConditionPoint_ord, IterationPoint_ord, PatternApplication_ord, VariablePoint_ord, InlinePoint_ord, TemplatePoint_ord, Slot_ord, SequencePoint_ord);
        putSimpleEntity(PatternApplication_ord, "PatternApplication", PatternApplication.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.arguments, Arguments_ord);
        putCompositeEntity(
		Arguments_ord, "Arguments", Arguments.class, false, Argument_ord, true, false);
        putSimpleEntity(Binding_ord, "Binding", Binding.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(VariablePoint_ord, "VariablePoint", VariablePoint.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.resultType, ResultType_ord, true, false, false, false, false);
        putSimpleEntity(FunctionPoint_ord, "FunctionPoint", FunctionPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.resultType, ResultType_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.expression, PathExpression_ord, true, false, false, false, false);
        putSimpleEntity(Slot_ord, "Slot", Slot.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.optional, BooleanValue_ord).withFeature(PatternsFeatureDescriptorEnum.adapter, PathExpression_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.type, Type_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.resultType, Type_ord, true, false, false, false, false);
        putSimpleEntity(ResultPoint_ord, "ResultPoint", ResultPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.resultType, Type_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord).withFeature(PatternsFeatureDescriptorEnum.weaver, PathExpression_ord, true, false, false, false, false);
        putSimpleEntity(JoinPoint_ord, "JoinPoint", JoinPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord, true, false, false, false, false);
        putSimpleEntity(InsertionPoint_ord, "InsertionPoint", InsertionPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord);
        putSimpleEntity(ScopePoint_ord, "ScopePoint", ScopePoint.class, false).withFeature(PatternsFeatureDescriptorEnum.context, Declarations_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(TemplatePoint_ord, "TemplatePoint", TemplatePoint.class, false).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(DerivationPoint_ord, "DerivationPoint", DerivationPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.expression, PathExpression_ord).withFeature(PatternsFeatureDescriptorEnum.resultType, ResultType_ord, true, false, false, false, false);
        putCompositeEntity(
		SelectionPoint_ord, "SelectionPoint", SelectionPoint.class, false, ConditionPoint_ord, true, false);
        putSimpleEntity(ConditionPoint_ord, "ConditionPoint", ConditionPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.condition, Predicate_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(VariantSelectionPoint_ord, "VariantSelectionPoint", VariantSelectionPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.variability, Name_ord).withFeature(PatternsFeatureDescriptorEnum.variants, Variants_ord);
        putCompositeEntity(
		Variants_ord, "Variants", Variants.class, false, Variant_ord, true, false);
        putSimpleEntity(Variant_ord, "Variant", Variant.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putSimpleEntity(IterationPoint_ord, "IterationPoint", IterationPoint.class, false).withFeature(PatternsFeatureDescriptorEnum.iterator, PathExpression_ord).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putCompositeEntity(
		SequencePoint_ord, "SequencePoint", SequencePoint.class, false, Template_ord, true, false);
        putSimpleEntity(InlinePoint_ord, "InlinePoint", InlinePoint.class, false).withFeature(PatternsFeatureDescriptorEnum.template, Template_ord);
        putCompositeEntity(
		Declarations_ord, "Declarations", Declarations.class, false, Declaration_ord, true, false);
        putSimpleEntity(FunctionDeclaration_ord, "FunctionDeclaration", FunctionDeclaration.class, false).withFeature(PatternsFeatureDescriptorEnum.applicationTypes, ResultTypes_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.body, PathExpression_ord);
        putSimpleEntity(GoalDeclaration_ord, "GoalDeclaration", GoalDeclaration.class, false).withFeature(PatternsFeatureDescriptorEnum.subgoals, GoalExpression_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.body, PathExpression_ord);
        putSimpleEntity(PointcutDeclaration_ord, "PointcutDeclaration", PointcutDeclaration.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.expression, PathExpression_ord);
        putSimpleEntity(JoinPointDeclaration_ord, "JoinPointDeclaration", JoinPointDeclaration.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.expression, PathExpression_ord, true, false, false, false, false);
        putSimpleEntity(VariableDeclaration_ord, "VariableDeclaration", VariableDeclaration.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.expression, PathExpression_ord, true, false, false, false, false).withFeature(PatternsFeatureDescriptorEnum.resultType, Type_ord, true, false, false, false, false);
        putSimpleEntity(VariantSelector_ord, "VariantSelector", VariantSelector.class, false).withFeature(PatternsFeatureDescriptorEnum.variability, Name_ord).withFeature(PatternsFeatureDescriptorEnum.variant, PathExpression_ord);
        putCompositeEntity(
		Types_ord, "Types", Types.class, false, Type_ord, true, false);
        putCompositeEntity(
		ResultTypes_ord, "ResultTypes", ResultTypes.class, false, ResultType_ord, true, false);
        putSimpleEntity(Type_ord, "Type", Type.class, true, Choice_ord, Enumeration_ord, ResultType_ord, Repetition_ord, Name_ord);
        putSimpleEntity(ResultTypeOrPathExpression_ord, "ResultTypeOrPathExpression", ResultTypeOrPathExpression.class, true, ResultPoint_ord, DerivationPoint_ord, PointcutStep_ord, InsertionPoint_ord, FunctionPoint_ord, Insert_ord, Name_ord, JoinPoint_ord, FunctionStep_ord, PathExpression_ord, VariablePoint_ord, TemplatePoint_ord, PatternJoinPointStep_ord, OuterDefinitionStep_ord, SlotStep_ord, StepExpression_ord, Cut_ord, PatternInstance_ord, VariantSelectionPoint_ord, JoinPointStep_ord, SelectionPoint_ord, ResultType_ord, ScopePoint_ord, ConditionPoint_ord, IterationPoint_ord, PatternApplication_ord, InlinePoint_ord, VariationPoint_ord, GoalStep_ord, Slot_ord, SequencePoint_ord);
        putSimpleEntity(ResultType_ord, "ResultType", ResultType.class, true, Name_ord);
        putSimpleEntity(PathExpression_ord, "PathExpression", PathExpression.class, true, ResultPoint_ord, DerivationPoint_ord, PointcutStep_ord, InsertionPoint_ord, FunctionPoint_ord, Insert_ord, Name_ord, JoinPoint_ord, FunctionStep_ord, VariablePoint_ord, TemplatePoint_ord, PatternJoinPointStep_ord, OuterDefinitionStep_ord, SlotStep_ord, StepExpression_ord, Cut_ord, PatternInstance_ord, VariantSelectionPoint_ord, JoinPointStep_ord, SelectionPoint_ord, ScopePoint_ord, ConditionPoint_ord, IterationPoint_ord, PatternApplication_ord, InlinePoint_ord, VariationPoint_ord, GoalStep_ord, Slot_ord, SequencePoint_ord);
        putSimpleEntity(StepExpression_ord, "StepExpression", StepExpression.class, true, ResultPoint_ord, DerivationPoint_ord, PointcutStep_ord, InsertionPoint_ord, FunctionPoint_ord, Insert_ord, Name_ord, JoinPoint_ord, FunctionStep_ord, VariablePoint_ord, TemplatePoint_ord, PatternJoinPointStep_ord, OuterDefinitionStep_ord, SlotStep_ord, Cut_ord, PatternInstance_ord, VariantSelectionPoint_ord, JoinPointStep_ord, SelectionPoint_ord, ScopePoint_ord, ConditionPoint_ord, IterationPoint_ord, PatternApplication_ord, InlinePoint_ord, VariationPoint_ord, GoalStep_ord, Slot_ord, SequencePoint_ord);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putSimpleEntity(PatternJoinPointStep_ord, "PatternJoinPointStep", PatternJoinPointStep.class, false);
        putDataEntity(JoinPointStep_ord, "JoinPointStep", JoinPointStep.class, false, String.class);
        putDataEntity(PointcutStep_ord, "PointcutStep", PointcutStep.class, false, String.class);
        putDataEntity(GoalStep_ord, "GoalStep", GoalStep.class, false, String.class);
        putDataEntity(FunctionStep_ord, "FunctionStep", FunctionStep.class, false, String.class);
        putDataEntity(SlotStep_ord, "SlotStep", SlotStep.class, false, String.class);
        putDataEntity(OuterDefinitionStep_ord, "OuterDefinitionStep", OuterDefinitionStep.class, false, String.class);
        putSimpleEntity(PatternInstance_ord, "PatternInstance", PatternInstance.class, false).withFeature(PatternsFeatureDescriptorEnum.name, Name_ord).withFeature(PatternsFeatureDescriptorEnum.arguments, Arguments_ord);
        putSimpleEntity(Cut_ord, "Cut", Cut.class, false).withFeature(PatternsFeatureDescriptorEnum.path, PathExpression_ord);
        putSimpleEntity(Insert_ord, "Insert", Insert.class, false).withFeature(PatternsFeatureDescriptorEnum.placement, Placement_ord).withFeature(PatternsFeatureDescriptorEnum.path, PathExpression_ord);
        putSimpleEntity(SlotsDefined_ord, "SlotsDefined", SlotsDefined.class, false);
        putDataEntity(PatternTypeTest_ord, "PatternTypeTest", PatternTypeTest.class, false, String.class);
        putDataEntity(Placement_ord, "Placement", Placement.class, false, PlacementEnum.Value.class);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putDataEntity(Namespace_ord, "Namespace", Namespace.class, false, String.class);
        putDataEntity(Version_ord, "Version", Version.class, false, String.class);
        putDataEntity(BooleanValue_ord, "BooleanValue", BooleanValue.class, false, boolean.class);
        putSimpleEntity(GoalExpression_ord, "GoalExpression", GoalExpression.class, true);
        putSimpleEntity(Argument_ord, "Argument", Argument.class, true, Binding_ord);
        putSimpleEntity(Predicate_ord, "Predicate", Predicate.class, true, SlotsDefined_ord, PatternTypeTest_ord);
        putSimpleEntity(Declaration_ord, "Declaration", Declaration.class, true, FunctionDeclaration_ord, VariantSelector_ord, GoalDeclaration_ord, VariableDeclaration_ord, PointcutDeclaration_ord, JoinPointDeclaration_ord);
    }

    protected void initForeignTypeRelations() {
        setAliasOf(true, "http://lang.whole.org/Queries#PathExpression", PathExpression_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#StepExpression", StepExpression_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#Predicate", Predicate_ord);
        setAssignableFromForeignType(true, "http://lang.whole.org/Models#EntityType", ResultType_ord);
        setAssignableFromForeignType(true, "http://lang.whole.org/Models#AnyType", ResultType_ord);
        setAssignableFromAll(true, Template_ord);
        setAssignableToAll(true, VariationPoint_ord);
    }
}
