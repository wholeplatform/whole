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
package org.whole.lang.semantics.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class SemanticsEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int SemanticTheory_ord = 0;
    public static final int SemanticFunctions_ord = 1;
    public static final int SemanticFunction_ord = 2;
    public static final int FunctionBody_ord = 3;
    public static final int Rules_ord = 4;
    public static final int InferenceRules_ord = 5;
    public static final int SignatureOrSequence_ord = 6;
    public static final int Signature_ord = 7;
    public static final int Category_ord = 8;
    public static final int AnyType_ord = 9;
    public static final int LanguageType_ord = 10;
    public static final int CastType_ord = 11;
    public static final int EnvType_ord = 12;
    public static final int EntityType_ord = 13;
    public static final int EnvironmentType_ord = 14;
    public static final int LegacyType_ord = 15;
    public static final int UnionType_ord = 16;
    public static final int FunctionType_ord = 17;
    public static final int SequenceType_ord = 18;
    public static final int SubtypeType_ord = 19;
    public static final int SupertypeType_ord = 20;
    public static final int ProductType_ord = 21;
    public static final int Rule_ord = 22;
    public static final int ExecutionRule_ord = 23;
    public static final int InferenceRule_ord = 24;
    public static final int Premises_ord = 25;
    public static final int Premise_ord = 26;
    public static final int ConfigurationOrTransition_ord = 27;
    public static final int Transition_ord = 28;
    public static final int Predicate_ord = 29;
    public static final int Configuration_ord = 30;
    public static final int ConfigurationItem_ord = 31;
    public static final int BindingSubject_ord = 32;
    public static final int Term_ord = 33;
    public static final int Expression_ord = 34;
    public static final int Identifier_ord = 35;
    public static final int LocalIdentifier_ord = 36;
    public static final int Template_ord = 37;
    public static final int AbstractVariable_ord = 38;
    public static final int TypedVariable_ord = 39;
    public static final int StructuredVariable_ord = 40;
    public static final int Variable_ord = 41;
    public static final int VariableValue_ord = 42;
    public static final int RenameGroup_ord = 43;
    public static final int Rename_ord = 44;
    public static final int Environments_ord = 45;
    public static final int Environment_ord = 46;
    public static final int BindingsScope_ord = 47;
    public static final int LocalBindings_ord = 48;
    public static final int LocalBinding_ord = 49;
    public static final int BindingOp_ord = 50;
    public static final int EnvironmentVariable_ord = 51;
    public static final int TypeCast_ord = 52;
    public static final int FunctionApplication_ord = 53;
    public static final int StageChange_ord = 54;
    public static final int OutputBindings_ord = 55;
    public static final int OutputBinding_ord = 56;
    public static final int InputBindings_ord = 57;
    public static final int InputBinding_ord = 58;
    public static final int InlineTemplate_ord = 59;
    public static final int ChooseTemplate_ord = 60;
    public static final int Case_ord = 61;
    public static final int WhereTemplate_ord = 62;
    public static final int ForTemplate_ord = 63;
    public static final int IfTemplate_ord = 64;
    public static final int IfDefTemplate_ord = 65;
    public static final int ElseTemplate_ord = 66;
    public static final int RuleName_ord = 67;
    public static final int Num_ord = 68;
    public static final int URI_ord = 69;
    public static final int Namespace_ord = 70;
    public static final int Name_ord = 71;
    public static final int Version_ord = 72;
    public static final SemanticsEntityDescriptorEnum instance = new SemanticsEntityDescriptorEnum();
    public static final EntityDescriptor<SemanticTheory> SemanticTheory = (EntityDescriptor<SemanticTheory>) instance.valueOf(SemanticTheory_ord);
    public static final EntityDescriptor<SemanticFunctions> SemanticFunctions = (EntityDescriptor<SemanticFunctions>) instance.valueOf(SemanticFunctions_ord);
    public static final EntityDescriptor<SemanticFunction> SemanticFunction = (EntityDescriptor<SemanticFunction>) instance.valueOf(SemanticFunction_ord);
    public static final EntityDescriptor<FunctionBody> FunctionBody = (EntityDescriptor<FunctionBody>) instance.valueOf(FunctionBody_ord);
    public static final EntityDescriptor<Rules> Rules = (EntityDescriptor<Rules>) instance.valueOf(Rules_ord);
    public static final EntityDescriptor<InferenceRules> InferenceRules = (EntityDescriptor<InferenceRules>) instance.valueOf(InferenceRules_ord);
    public static final EntityDescriptor<SignatureOrSequence> SignatureOrSequence = (EntityDescriptor<SignatureOrSequence>) instance.valueOf(SignatureOrSequence_ord);
    public static final EntityDescriptor<Signature> Signature = (EntityDescriptor<Signature>) instance.valueOf(Signature_ord);
    public static final EntityDescriptor<Category> Category = (EntityDescriptor<Category>) instance.valueOf(Category_ord);
    public static final EntityDescriptor<AnyType> AnyType = (EntityDescriptor<AnyType>) instance.valueOf(AnyType_ord);
    public static final EntityDescriptor<LanguageType> LanguageType = (EntityDescriptor<LanguageType>) instance.valueOf(LanguageType_ord);
    public static final EntityDescriptor<CastType> CastType = (EntityDescriptor<CastType>) instance.valueOf(CastType_ord);
    public static final EntityDescriptor<EnvType> EnvType = (EntityDescriptor<EnvType>) instance.valueOf(EnvType_ord);
    public static final EntityDescriptor<EntityType> EntityType = (EntityDescriptor<EntityType>) instance.valueOf(EntityType_ord);
    public static final EntityDescriptor<EnvironmentType> EnvironmentType = (EntityDescriptor<EnvironmentType>) instance.valueOf(EnvironmentType_ord);
    public static final EntityDescriptor<LegacyType> LegacyType = (EntityDescriptor<LegacyType>) instance.valueOf(LegacyType_ord);
    public static final EntityDescriptor<UnionType> UnionType = (EntityDescriptor<UnionType>) instance.valueOf(UnionType_ord);
    public static final EntityDescriptor<FunctionType> FunctionType = (EntityDescriptor<FunctionType>) instance.valueOf(FunctionType_ord);
    public static final EntityDescriptor<SequenceType> SequenceType = (EntityDescriptor<SequenceType>) instance.valueOf(SequenceType_ord);
    public static final EntityDescriptor<SubtypeType> SubtypeType = (EntityDescriptor<SubtypeType>) instance.valueOf(SubtypeType_ord);
    public static final EntityDescriptor<SupertypeType> SupertypeType = (EntityDescriptor<SupertypeType>) instance.valueOf(SupertypeType_ord);
    public static final EntityDescriptor<ProductType> ProductType = (EntityDescriptor<ProductType>) instance.valueOf(ProductType_ord);
    public static final EntityDescriptor<Rule> Rule = (EntityDescriptor<Rule>) instance.valueOf(Rule_ord);
    public static final EntityDescriptor<ExecutionRule> ExecutionRule = (EntityDescriptor<ExecutionRule>) instance.valueOf(ExecutionRule_ord);
    public static final EntityDescriptor<InferenceRule> InferenceRule = (EntityDescriptor<InferenceRule>) instance.valueOf(InferenceRule_ord);
    public static final EntityDescriptor<Premises> Premises = (EntityDescriptor<Premises>) instance.valueOf(Premises_ord);
    public static final EntityDescriptor<Premise> Premise = (EntityDescriptor<Premise>) instance.valueOf(Premise_ord);
    public static final EntityDescriptor<ConfigurationOrTransition> ConfigurationOrTransition = (EntityDescriptor<ConfigurationOrTransition>) instance.valueOf(ConfigurationOrTransition_ord);
    public static final EntityDescriptor<Transition> Transition = (EntityDescriptor<Transition>) instance.valueOf(Transition_ord);
    public static final EntityDescriptor<Predicate> Predicate = (EntityDescriptor<Predicate>) instance.valueOf(Predicate_ord);
    public static final EntityDescriptor<Configuration> Configuration = (EntityDescriptor<Configuration>) instance.valueOf(Configuration_ord);
    public static final EntityDescriptor<ConfigurationItem> ConfigurationItem = (EntityDescriptor<ConfigurationItem>) instance.valueOf(ConfigurationItem_ord);
    public static final EntityDescriptor<BindingSubject> BindingSubject = (EntityDescriptor<BindingSubject>) instance.valueOf(BindingSubject_ord);
    public static final EntityDescriptor<Term> Term = (EntityDescriptor<Term>) instance.valueOf(Term_ord);
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<Identifier> Identifier = (EntityDescriptor<Identifier>) instance.valueOf(Identifier_ord);
    public static final EntityDescriptor<LocalIdentifier> LocalIdentifier = (EntityDescriptor<LocalIdentifier>) instance.valueOf(LocalIdentifier_ord);
    public static final EntityDescriptor<Template> Template = (EntityDescriptor<Template>) instance.valueOf(Template_ord);
    public static final EntityDescriptor<AbstractVariable> AbstractVariable = (EntityDescriptor<AbstractVariable>) instance.valueOf(AbstractVariable_ord);
    public static final EntityDescriptor<TypedVariable> TypedVariable = (EntityDescriptor<TypedVariable>) instance.valueOf(TypedVariable_ord);
    public static final EntityDescriptor<StructuredVariable> StructuredVariable = (EntityDescriptor<StructuredVariable>) instance.valueOf(StructuredVariable_ord);
    public static final EntityDescriptor<Variable> Variable = (EntityDescriptor<Variable>) instance.valueOf(Variable_ord);
    public static final EntityDescriptor<VariableValue> VariableValue = (EntityDescriptor<VariableValue>) instance.valueOf(VariableValue_ord);
    public static final EntityDescriptor<RenameGroup> RenameGroup = (EntityDescriptor<RenameGroup>) instance.valueOf(RenameGroup_ord);
    public static final EntityDescriptor<Rename> Rename = (EntityDescriptor<Rename>) instance.valueOf(Rename_ord);
    public static final EntityDescriptor<Environments> Environments = (EntityDescriptor<Environments>) instance.valueOf(Environments_ord);
    public static final EntityDescriptor<Environment> Environment = (EntityDescriptor<Environment>) instance.valueOf(Environment_ord);
    public static final EntityDescriptor<BindingsScope> BindingsScope = (EntityDescriptor<BindingsScope>) instance.valueOf(BindingsScope_ord);
    public static final EntityDescriptor<LocalBindings> LocalBindings = (EntityDescriptor<LocalBindings>) instance.valueOf(LocalBindings_ord);
    public static final EntityDescriptor<LocalBinding> LocalBinding = (EntityDescriptor<LocalBinding>) instance.valueOf(LocalBinding_ord);
    public static final EntityDescriptor<BindingOp> BindingOp = (EntityDescriptor<BindingOp>) instance.valueOf(BindingOp_ord);
    public static final EntityDescriptor<EnvironmentVariable> EnvironmentVariable = (EntityDescriptor<EnvironmentVariable>) instance.valueOf(EnvironmentVariable_ord);
    public static final EntityDescriptor<TypeCast> TypeCast = (EntityDescriptor<TypeCast>) instance.valueOf(TypeCast_ord);
    public static final EntityDescriptor<FunctionApplication> FunctionApplication = (EntityDescriptor<FunctionApplication>) instance.valueOf(FunctionApplication_ord);
    public static final EntityDescriptor<StageChange> StageChange = (EntityDescriptor<StageChange>) instance.valueOf(StageChange_ord);
    public static final EntityDescriptor<OutputBindings> OutputBindings = (EntityDescriptor<OutputBindings>) instance.valueOf(OutputBindings_ord);
    public static final EntityDescriptor<OutputBinding> OutputBinding = (EntityDescriptor<OutputBinding>) instance.valueOf(OutputBinding_ord);
    public static final EntityDescriptor<InputBindings> InputBindings = (EntityDescriptor<InputBindings>) instance.valueOf(InputBindings_ord);
    public static final EntityDescriptor<InputBinding> InputBinding = (EntityDescriptor<InputBinding>) instance.valueOf(InputBinding_ord);
    public static final EntityDescriptor<InlineTemplate> InlineTemplate = (EntityDescriptor<InlineTemplate>) instance.valueOf(InlineTemplate_ord);
    public static final EntityDescriptor<ChooseTemplate> ChooseTemplate = (EntityDescriptor<ChooseTemplate>) instance.valueOf(ChooseTemplate_ord);
    public static final EntityDescriptor<Case> Case = (EntityDescriptor<Case>) instance.valueOf(Case_ord);
    public static final EntityDescriptor<WhereTemplate> WhereTemplate = (EntityDescriptor<WhereTemplate>) instance.valueOf(WhereTemplate_ord);
    public static final EntityDescriptor<ForTemplate> ForTemplate = (EntityDescriptor<ForTemplate>) instance.valueOf(ForTemplate_ord);
    public static final EntityDescriptor<IfTemplate> IfTemplate = (EntityDescriptor<IfTemplate>) instance.valueOf(IfTemplate_ord);
    public static final EntityDescriptor<IfDefTemplate> IfDefTemplate = (EntityDescriptor<IfDefTemplate>) instance.valueOf(IfDefTemplate_ord);
    public static final EntityDescriptor<ElseTemplate> ElseTemplate = (EntityDescriptor<ElseTemplate>) instance.valueOf(ElseTemplate_ord);
    public static final EntityDescriptor<RuleName> RuleName = (EntityDescriptor<RuleName>) instance.valueOf(RuleName_ord);
    public static final EntityDescriptor<Num> Num = (EntityDescriptor<Num>) instance.valueOf(Num_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Namespace> Namespace = (EntityDescriptor<Namespace>) instance.valueOf(Namespace_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<Version> Version = (EntityDescriptor<Version>) instance.valueOf(Version_ord);

    private SemanticsEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(SemanticTheory_ord, "SemanticTheory", SemanticTheory.class, false).withFeature(SemanticsFeatureDescriptorEnum.uri, URI_ord).withFeature(SemanticsFeatureDescriptorEnum.namespace, Namespace_ord).withFeature(SemanticsFeatureDescriptorEnum.name, Name_ord).withFeature(SemanticsFeatureDescriptorEnum.version, Version_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.functions, SemanticFunctions_ord);
        putCompositeEntity(
		SemanticFunctions_ord, "SemanticFunctions", SemanticFunctions.class, false, SemanticFunction_ord, true, false);
        putSimpleEntity(SemanticFunction_ord, "SemanticFunction", SemanticFunction.class, false).withFeature(SemanticsFeatureDescriptorEnum.name, Name_ord).withFeature(SemanticsFeatureDescriptorEnum.signature, FunctionType_ord).withFeature(SemanticsFeatureDescriptorEnum.rules, FunctionBody_ord);
        putSimpleEntity(FunctionBody_ord, "FunctionBody", FunctionBody.class, true, InferenceRules_ord, Rules_ord);
        putCompositeEntity(
		Rules_ord, "Rules", Rules.class, false, Rule_ord, true, false);
        putCompositeEntity(
		InferenceRules_ord, "InferenceRules", InferenceRules.class, false, InferenceRule_ord, true, false);
        putSimpleEntity(SignatureOrSequence_ord, "SignatureOrSequence", SignatureOrSequence.class, true, LegacyType_ord, UnionType_ord, Category_ord, FunctionType_ord, ProductType_ord, SequenceType_ord, SubtypeType_ord, LanguageType_ord, EntityType_ord, TypedVariable_ord, SupertypeType_ord, EnvironmentType_ord, Signature_ord, AnyType_ord);
        putSimpleEntity(Signature_ord, "Signature", Signature.class, true, LegacyType_ord, EntityType_ord, UnionType_ord, TypedVariable_ord, SupertypeType_ord, Category_ord, EnvironmentType_ord, FunctionType_ord, ProductType_ord, SubtypeType_ord, AnyType_ord, LanguageType_ord);
        putSimpleEntity(Category_ord, "Category", Category.class, true, EntityType_ord, LegacyType_ord, UnionType_ord, SupertypeType_ord, EnvironmentType_ord, AnyType_ord, SubtypeType_ord, LanguageType_ord);
        putSimpleEntity(AnyType_ord, "AnyType", AnyType.class, false);
        putDataEntity(LanguageType_ord, "LanguageType", LanguageType.class, false, String.class);
        putSimpleEntity(CastType_ord, "CastType", CastType.class, true, EntityType_ord, EnvType_ord);
        putSimpleEntity(EnvType_ord, "EnvType", EnvType.class, false);
        putDataEntity(EntityType_ord, "EntityType", EntityType.class, false, String.class);
        putDataEntity(EnvironmentType_ord, "EnvironmentType", EnvironmentType.class, false, String.class);
        putDataEntity(LegacyType_ord, "LegacyType", LegacyType.class, false, LegacyTypeEnum.Value.class);
        putCompositeEntity(
		UnionType_ord, "UnionType", UnionType.class, false, Category_ord, true, false);
        putSimpleEntity(FunctionType_ord, "FunctionType", FunctionType.class, false).withFeature(SemanticsFeatureDescriptorEnum.source, SignatureOrSequence_ord).withFeature(SemanticsFeatureDescriptorEnum.target, SignatureOrSequence_ord);
        putSimpleEntity(SequenceType_ord, "SequenceType", SequenceType.class, false).withFeature(SemanticsFeatureDescriptorEnum.signature, Signature_ord);
        putSimpleEntity(SubtypeType_ord, "SubtypeType", SubtypeType.class, false).withFeature(SemanticsFeatureDescriptorEnum.category, EntityType_ord);
        putSimpleEntity(SupertypeType_ord, "SupertypeType", SupertypeType.class, false).withFeature(SemanticsFeatureDescriptorEnum.category, Category_ord);
        putCompositeEntity(
		ProductType_ord, "ProductType", ProductType.class, false, Signature_ord, true, false);
        putSimpleEntity(Rule_ord, "Rule", Rule.class, true, ExecutionRule_ord);
        putSimpleEntity(ExecutionRule_ord, "ExecutionRule", ExecutionRule.class, false).withFeature(SemanticsFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.condition, Predicate_ord).withFeature(SemanticsFeatureDescriptorEnum.meaning, Expression_ord);
        putSimpleEntity(InferenceRule_ord, "InferenceRule", InferenceRule.class, false).withFeature(SemanticsFeatureDescriptorEnum.name, RuleName_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.premises, Premises_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.conclusion, Transition_ord).withFeature(SemanticsFeatureDescriptorEnum.condition, Predicate_ord, true, false, false, false, false);
        putCompositeEntity(
		Premises_ord, "Premises", Premises.class, false, Premise_ord, true, false);
        putSimpleEntity(Premise_ord, "Premise", Premise.class, true, Transition_ord, InferenceRule_ord);
        putSimpleEntity(ConfigurationOrTransition_ord, "ConfigurationOrTransition", ConfigurationOrTransition.class, true, Configuration_ord, Transition_ord);
        putSimpleEntity(Transition_ord, "Transition", Transition.class, false).withFeature(SemanticsFeatureDescriptorEnum.sourceConfiguration, Configuration_ord).withFeature(SemanticsFeatureDescriptorEnum.targetConfiguration, ConfigurationOrTransition_ord);
        putSimpleEntity(Predicate_ord, "Predicate", Predicate.class, true, LegacyType_ord, EntityType_ord, UnionType_ord, TypedVariable_ord, SupertypeType_ord, Category_ord, EnvironmentType_ord, AbstractVariable_ord, StructuredVariable_ord, SubtypeType_ord, AnyType_ord, LanguageType_ord);
        putCompositeEntity(
		Configuration_ord, "Configuration", Configuration.class, false, ConfigurationItem_ord, true, false);
        putSimpleEntity(ConfigurationItem_ord, "ConfigurationItem", ConfigurationItem.class, true, UnionType_ord, Category_ord, Variable_ord, FunctionApplication_ord, AbstractVariable_ord, LocalIdentifier_ord, StructuredVariable_ord, BindingsScope_ord, LanguageType_ord, Template_ord, Identifier_ord, IfDefTemplate_ord, WhereTemplate_ord, ChooseTemplate_ord, OutputBindings_ord, AnyType_ord, IfTemplate_ord, LegacyType_ord, VariableValue_ord, Term_ord, ForTemplate_ord, SubtypeType_ord, EntityType_ord, TypedVariable_ord, SupertypeType_ord, EnvironmentType_ord, Expression_ord, Environment_ord, EnvironmentVariable_ord, TypeCast_ord, InlineTemplate_ord);
        putSimpleEntity(BindingSubject_ord, "BindingSubject", BindingSubject.class, true, RenameGroup_ord, Identifier_ord, Variable_ord, VariableValue_ord, EnvironmentVariable_ord, LocalIdentifier_ord, StructuredVariable_ord);
        putSimpleEntity(Term_ord, "Term", Term.class, true, Variable_ord, VariableValue_ord, FunctionApplication_ord, LocalIdentifier_ord, ForTemplate_ord, StructuredVariable_ord, BindingsScope_ord, Template_ord, Identifier_ord, Expression_ord, IfDefTemplate_ord, WhereTemplate_ord, ChooseTemplate_ord, Environment_ord, OutputBindings_ord, EnvironmentVariable_ord, TypeCast_ord, IfTemplate_ord, InlineTemplate_ord);
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, Variable_ord, VariableValue_ord, FunctionApplication_ord, LocalIdentifier_ord, ForTemplate_ord, StructuredVariable_ord, BindingsScope_ord, Template_ord, Identifier_ord, IfDefTemplate_ord, WhereTemplate_ord, ChooseTemplate_ord, Environment_ord, OutputBindings_ord, EnvironmentVariable_ord, TypeCast_ord, IfTemplate_ord, InlineTemplate_ord);
        putSimpleEntity(Identifier_ord, "Identifier", Identifier.class, true, EnvironmentVariable_ord, Variable_ord, LocalIdentifier_ord, StructuredVariable_ord, VariableValue_ord);
        putSimpleEntity(LocalIdentifier_ord, "LocalIdentifier", LocalIdentifier.class, true, StructuredVariable_ord, VariableValue_ord, Variable_ord);
        putSimpleEntity(Template_ord, "Template", Template.class, true, ChooseTemplate_ord, ForTemplate_ord, IfDefTemplate_ord, IfTemplate_ord, InlineTemplate_ord, WhereTemplate_ord);
        putSimpleEntity(AbstractVariable_ord, "AbstractVariable", AbstractVariable.class, true, StructuredVariable_ord, TypedVariable_ord).withFeature(SemanticsFeatureDescriptorEnum.variable, Variable_ord).withFeature(SemanticsFeatureDescriptorEnum.index, Num_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.time, Num_ord, true, false, false, false, false);
        putSimpleEntity(TypedVariable_ord, "TypedVariable", TypedVariable.class, false).withFeature(SemanticsFeatureDescriptorEnum.variable, Variable_ord).withFeature(SemanticsFeatureDescriptorEnum.index, Num_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.time, Num_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.signature, Signature_ord);
        putSimpleEntity(StructuredVariable_ord, "StructuredVariable", StructuredVariable.class, false).withFeature(SemanticsFeatureDescriptorEnum.variable, Variable_ord).withFeature(SemanticsFeatureDescriptorEnum.index, Num_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.time, Num_ord, true, false, false, false, false);
        putDataEntity(Variable_ord, "Variable", Variable.class, false, String.class);
        putSimpleEntity(VariableValue_ord, "VariableValue", VariableValue.class, false).withFeature(SemanticsFeatureDescriptorEnum.identifier, Identifier_ord);
        putCompositeEntity(
		RenameGroup_ord, "RenameGroup", RenameGroup.class, false, Rename_ord, true, false);
        putSimpleEntity(Rename_ord, "Rename", Rename.class, false).withFeature(SemanticsFeatureDescriptorEnum.newIdentifier, LocalIdentifier_ord).withFeature(SemanticsFeatureDescriptorEnum.oldIdentifier, LocalIdentifier_ord);
        putCompositeEntity(
		Environments_ord, "Environments", Environments.class, false, Environment_ord, true, false);
        putSimpleEntity(Environment_ord, "Environment", Environment.class, true, BindingsScope_ord);
        putSimpleEntity(BindingsScope_ord, "BindingsScope", BindingsScope.class, false).withFeature(SemanticsFeatureDescriptorEnum.identifier, LocalIdentifier_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.bindings, LocalBindings_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.nestedScope, BindingsScope_ord, true, false, false, false, false);
        putCompositeEntity(
		LocalBindings_ord, "LocalBindings", LocalBindings.class, false, LocalBinding_ord, false, true);
        putSimpleEntity(LocalBinding_ord, "LocalBinding", LocalBinding.class, false).withFeature(SemanticsFeatureDescriptorEnum.op, BindingOp_ord).withFeature(SemanticsFeatureDescriptorEnum.identifier, LocalIdentifier_ord, false, true, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false);
        putDataEntity(BindingOp_ord, "BindingOp", BindingOp.class, false, BindingOpEnum.Value.class);
        putSimpleEntity(EnvironmentVariable_ord, "EnvironmentVariable", EnvironmentVariable.class, false).withFeature(SemanticsFeatureDescriptorEnum.environment, LocalIdentifier_ord).withFeature(SemanticsFeatureDescriptorEnum.variable, LocalIdentifier_ord);
        putSimpleEntity(TypeCast_ord, "TypeCast", TypeCast.class, false).withFeature(SemanticsFeatureDescriptorEnum.type, CastType_ord).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord, true, false, false, false, false);
        putSimpleEntity(FunctionApplication_ord, "FunctionApplication", FunctionApplication.class, false).withFeature(SemanticsFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.arguments, Expression_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.environments, Environments_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.stage, StageChange_ord, true, false, false, false, false);
        putDataEntity(StageChange_ord, "StageChange", StageChange.class, false, StageChangeEnum.Value.class);
        putCompositeEntity(
		OutputBindings_ord, "OutputBindings", OutputBindings.class, false, OutputBinding_ord, true, false);
        putSimpleEntity(OutputBinding_ord, "OutputBinding", OutputBinding.class, false).withFeature(SemanticsFeatureDescriptorEnum.identifier, BindingSubject_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Expression_ord);
        putCompositeEntity(
		InputBindings_ord, "InputBindings", InputBindings.class, false, InputBinding_ord, true, false);
        putSimpleEntity(InputBinding_ord, "InputBinding", InputBinding.class, false).withFeature(SemanticsFeatureDescriptorEnum.identifier, BindingSubject_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(InlineTemplate_ord, "InlineTemplate", InlineTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord);
        putCompositeEntity(
		ChooseTemplate_ord, "ChooseTemplate", ChooseTemplate.class, false, Case_ord, true, false);
        putSimpleEntity(Case_ord, "Case", Case.class, true, ForTemplate_ord, ElseTemplate_ord, IfDefTemplate_ord, IfTemplate_ord, WhereTemplate_ord).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord);
        putSimpleEntity(WhereTemplate_ord, "WhereTemplate", WhereTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord).withFeature(SemanticsFeatureDescriptorEnum.where, InputBindings_ord);
        putSimpleEntity(ForTemplate_ord, "ForTemplate", ForTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord).withFeature(SemanticsFeatureDescriptorEnum.condition, Expression_ord);
        putSimpleEntity(IfTemplate_ord, "IfTemplate", IfTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord).withFeature(SemanticsFeatureDescriptorEnum.condition, Predicate_ord);
        putSimpleEntity(IfDefTemplate_ord, "IfDefTemplate", IfDefTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord);
        putSimpleEntity(ElseTemplate_ord, "ElseTemplate", ElseTemplate.class, false).withFeature(SemanticsFeatureDescriptorEnum.expression, Term_ord);
        putSimpleEntity(RuleName_ord, "RuleName", RuleName.class, false).withFeature(SemanticsFeatureDescriptorEnum.name, Name_ord).withFeature(SemanticsFeatureDescriptorEnum.sub, Name_ord, true, false, false, false, false).withFeature(SemanticsFeatureDescriptorEnum.sup, Name_ord, true, false, false, false, false);
        putDataEntity(Num_ord, "Num", Num.class, false, int.class);
        putDataEntity(URI_ord, "URI", URI.class, false, String.class);
        putDataEntity(Namespace_ord, "Namespace", Namespace.class, false, String.class);
        putDataEntity(Name_ord, "Name", Name.class, false, String.class);
        putDataEntity(Version_ord, "Version", Version.class, false, String.class);
    }

    protected void initForeignTypeRelations() {
        setAssignableFromAll(true, Term_ord);
        setAssignableFromForeignType(true, "http://lang.whole.org/Queries#PathExpressionOrPredicate", Predicate_ord);
        setAssignableFromForeignType(true, "http://lang.whole.org/Queries#PathExpression", Expression_ord, FunctionBody_ord);
        setAssignableToAll(true, Identifier_ord, TypedVariable_ord, FunctionApplication_ord, TypeCast_ord, BindingsScope_ord, Template_ord);
    }
}
