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
package org.whole.lang.semantics.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.model.LegacyTypeEnum;
import org.whole.lang.semantics.model.BindingOpEnum;
import org.whole.lang.semantics.model.StageChangeEnum;

/**
 *  @generator Whole
 */
public class SemanticsSpecificBuilderAdapter extends GenericBuilderContext implements ISemanticsBuilder {

    public SemanticsSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public SemanticsSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void sup() {
        wFeature(SemanticsFeatureDescriptorEnum.sup);
    }

    public void sub() {
        wFeature(SemanticsFeatureDescriptorEnum.sub);
    }

    public void where() {
        wFeature(SemanticsFeatureDescriptorEnum.where);
    }

    public void stage() {
        wFeature(SemanticsFeatureDescriptorEnum.stage);
    }

    public void environments() {
        wFeature(SemanticsFeatureDescriptorEnum.environments);
    }

    public void arguments() {
        wFeature(SemanticsFeatureDescriptorEnum.arguments);
    }

    public void type() {
        wFeature(SemanticsFeatureDescriptorEnum.type);
    }

    public void environment() {
        wFeature(SemanticsFeatureDescriptorEnum.environment);
    }

    public void expression() {
        wFeature(SemanticsFeatureDescriptorEnum.expression);
    }

    public void op() {
        wFeature(SemanticsFeatureDescriptorEnum.op);
    }

    public void nestedScope() {
        wFeature(SemanticsFeatureDescriptorEnum.nestedScope);
    }

    public void bindings() {
        wFeature(SemanticsFeatureDescriptorEnum.bindings);
    }

    public void oldIdentifier() {
        wFeature(SemanticsFeatureDescriptorEnum.oldIdentifier);
    }

    public void newIdentifier() {
        wFeature(SemanticsFeatureDescriptorEnum.newIdentifier);
    }

    public void identifier() {
        wFeature(SemanticsFeatureDescriptorEnum.identifier);
    }

    public void time() {
        wFeature(SemanticsFeatureDescriptorEnum.time);
    }

    public void index() {
        wFeature(SemanticsFeatureDescriptorEnum.index);
    }

    public void variable() {
        wFeature(SemanticsFeatureDescriptorEnum.variable);
    }

    public void targetConfiguration() {
        wFeature(SemanticsFeatureDescriptorEnum.targetConfiguration);
    }

    public void sourceConfiguration() {
        wFeature(SemanticsFeatureDescriptorEnum.sourceConfiguration);
    }

    public void conclusion() {
        wFeature(SemanticsFeatureDescriptorEnum.conclusion);
    }

    public void premises() {
        wFeature(SemanticsFeatureDescriptorEnum.premises);
    }

    public void meaning() {
        wFeature(SemanticsFeatureDescriptorEnum.meaning);
    }

    public void condition() {
        wFeature(SemanticsFeatureDescriptorEnum.condition);
    }

    public void category() {
        wFeature(SemanticsFeatureDescriptorEnum.category);
    }

    public void target() {
        wFeature(SemanticsFeatureDescriptorEnum.target);
    }

    public void source() {
        wFeature(SemanticsFeatureDescriptorEnum.source);
    }

    public void rules() {
        wFeature(SemanticsFeatureDescriptorEnum.rules);
    }

    public void signature() {
        wFeature(SemanticsFeatureDescriptorEnum.signature);
    }

    public void functions() {
        wFeature(SemanticsFeatureDescriptorEnum.functions);
    }

    public void version() {
        wFeature(SemanticsFeatureDescriptorEnum.version);
    }

    public void name() {
        wFeature(SemanticsFeatureDescriptorEnum.name);
    }

    public void namespace() {
        wFeature(SemanticsFeatureDescriptorEnum.namespace);
    }

    public void uri() {
        wFeature(SemanticsFeatureDescriptorEnum.uri);
    }

    public void visit() {
    }

    public void SemanticTheory() {
        wEntity(SemanticsEntityDescriptorEnum.SemanticTheory);
    }

    public void SemanticTheory_() {
        wEntity_(SemanticsEntityDescriptorEnum.SemanticTheory);
    }

    public void _SemanticTheory() {
        _wEntity(SemanticsEntityDescriptorEnum.SemanticTheory);
    }

    public void SemanticFunctions() {
        wEntity(SemanticsEntityDescriptorEnum.SemanticFunctions);
    }

    public void SemanticFunctions_() {
        wEntity_(SemanticsEntityDescriptorEnum.SemanticFunctions);
    }

    public void SemanticFunctions_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.SemanticFunctions, initialCapacity);
    }

    public void _SemanticFunctions() {
        _wEntity(SemanticsEntityDescriptorEnum.SemanticFunctions);
    }

    public void SemanticFunction() {
        wEntity(SemanticsEntityDescriptorEnum.SemanticFunction);
    }

    public void SemanticFunction_() {
        wEntity_(SemanticsEntityDescriptorEnum.SemanticFunction);
    }

    public void _SemanticFunction() {
        _wEntity(SemanticsEntityDescriptorEnum.SemanticFunction);
    }

    public void Rules() {
        wEntity(SemanticsEntityDescriptorEnum.Rules);
    }

    public void Rules_() {
        wEntity_(SemanticsEntityDescriptorEnum.Rules);
    }

    public void Rules_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.Rules, initialCapacity);
    }

    public void _Rules() {
        _wEntity(SemanticsEntityDescriptorEnum.Rules);
    }

    public void InferenceRules() {
        wEntity(SemanticsEntityDescriptorEnum.InferenceRules);
    }

    public void InferenceRules_() {
        wEntity_(SemanticsEntityDescriptorEnum.InferenceRules);
    }

    public void InferenceRules_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.InferenceRules, initialCapacity);
    }

    public void _InferenceRules() {
        _wEntity(SemanticsEntityDescriptorEnum.InferenceRules);
    }

    public void AnyType() {
        wEntity(SemanticsEntityDescriptorEnum.AnyType);
    }

    public void AnyType_() {
        wEntity_(SemanticsEntityDescriptorEnum.AnyType);
    }

    public void _AnyType() {
        _wEntity(SemanticsEntityDescriptorEnum.AnyType);
    }

    public void LanguageType() {
        wEntity(SemanticsEntityDescriptorEnum.LanguageType);
    }

    public void LanguageType(String value) {
        wEntity(SemanticsEntityDescriptorEnum.LanguageType, value);
    }

    public void EnvType() {
        wEntity(SemanticsEntityDescriptorEnum.EnvType);
    }

    public void EnvType_() {
        wEntity_(SemanticsEntityDescriptorEnum.EnvType);
    }

    public void _EnvType() {
        _wEntity(SemanticsEntityDescriptorEnum.EnvType);
    }

    public void EntityType() {
        wEntity(SemanticsEntityDescriptorEnum.EntityType);
    }

    public void EntityType(String value) {
        wEntity(SemanticsEntityDescriptorEnum.EntityType, value);
    }

    public void EnvironmentType() {
        wEntity(SemanticsEntityDescriptorEnum.EnvironmentType);
    }

    public void EnvironmentType(String value) {
        wEntity(SemanticsEntityDescriptorEnum.EnvironmentType, value);
    }

    public void LegacyType() {
        wEntity(SemanticsEntityDescriptorEnum.LegacyType);
    }

    public void LegacyType(LegacyTypeEnum.Value value) {
        wEntity(SemanticsEntityDescriptorEnum.LegacyType, value);
    }

    public void LegacyType(String value) {
        wEntity(SemanticsEntityDescriptorEnum.LegacyType, value);
    }

    public void UnionType() {
        wEntity(SemanticsEntityDescriptorEnum.UnionType);
    }

    public void UnionType_() {
        wEntity_(SemanticsEntityDescriptorEnum.UnionType);
    }

    public void UnionType_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.UnionType, initialCapacity);
    }

    public void _UnionType() {
        _wEntity(SemanticsEntityDescriptorEnum.UnionType);
    }

    public void FunctionType() {
        wEntity(SemanticsEntityDescriptorEnum.FunctionType);
    }

    public void FunctionType_() {
        wEntity_(SemanticsEntityDescriptorEnum.FunctionType);
    }

    public void _FunctionType() {
        _wEntity(SemanticsEntityDescriptorEnum.FunctionType);
    }

    public void SequenceType() {
        wEntity(SemanticsEntityDescriptorEnum.SequenceType);
    }

    public void SequenceType_() {
        wEntity_(SemanticsEntityDescriptorEnum.SequenceType);
    }

    public void _SequenceType() {
        _wEntity(SemanticsEntityDescriptorEnum.SequenceType);
    }

    public void SubtypeType() {
        wEntity(SemanticsEntityDescriptorEnum.SubtypeType);
    }

    public void SubtypeType_() {
        wEntity_(SemanticsEntityDescriptorEnum.SubtypeType);
    }

    public void _SubtypeType() {
        _wEntity(SemanticsEntityDescriptorEnum.SubtypeType);
    }

    public void SupertypeType() {
        wEntity(SemanticsEntityDescriptorEnum.SupertypeType);
    }

    public void SupertypeType_() {
        wEntity_(SemanticsEntityDescriptorEnum.SupertypeType);
    }

    public void _SupertypeType() {
        _wEntity(SemanticsEntityDescriptorEnum.SupertypeType);
    }

    public void ProductType() {
        wEntity(SemanticsEntityDescriptorEnum.ProductType);
    }

    public void ProductType_() {
        wEntity_(SemanticsEntityDescriptorEnum.ProductType);
    }

    public void ProductType_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.ProductType, initialCapacity);
    }

    public void _ProductType() {
        _wEntity(SemanticsEntityDescriptorEnum.ProductType);
    }

    public void ExecutionRule() {
        wEntity(SemanticsEntityDescriptorEnum.ExecutionRule);
    }

    public void ExecutionRule_() {
        wEntity_(SemanticsEntityDescriptorEnum.ExecutionRule);
    }

    public void _ExecutionRule() {
        _wEntity(SemanticsEntityDescriptorEnum.ExecutionRule);
    }

    public void InferenceRule() {
        wEntity(SemanticsEntityDescriptorEnum.InferenceRule);
    }

    public void InferenceRule_() {
        wEntity_(SemanticsEntityDescriptorEnum.InferenceRule);
    }

    public void _InferenceRule() {
        _wEntity(SemanticsEntityDescriptorEnum.InferenceRule);
    }

    public void Premises() {
        wEntity(SemanticsEntityDescriptorEnum.Premises);
    }

    public void Premises_() {
        wEntity_(SemanticsEntityDescriptorEnum.Premises);
    }

    public void Premises_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.Premises, initialCapacity);
    }

    public void _Premises() {
        _wEntity(SemanticsEntityDescriptorEnum.Premises);
    }

    public void Transition() {
        wEntity(SemanticsEntityDescriptorEnum.Transition);
    }

    public void Transition_() {
        wEntity_(SemanticsEntityDescriptorEnum.Transition);
    }

    public void _Transition() {
        _wEntity(SemanticsEntityDescriptorEnum.Transition);
    }

    public void Configuration() {
        wEntity(SemanticsEntityDescriptorEnum.Configuration);
    }

    public void Configuration_() {
        wEntity_(SemanticsEntityDescriptorEnum.Configuration);
    }

    public void Configuration_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.Configuration, initialCapacity);
    }

    public void _Configuration() {
        _wEntity(SemanticsEntityDescriptorEnum.Configuration);
    }

    public void TypedVariable() {
        wEntity(SemanticsEntityDescriptorEnum.TypedVariable);
    }

    public void TypedVariable_() {
        wEntity_(SemanticsEntityDescriptorEnum.TypedVariable);
    }

    public void _TypedVariable() {
        _wEntity(SemanticsEntityDescriptorEnum.TypedVariable);
    }

    public void StructuredVariable() {
        wEntity(SemanticsEntityDescriptorEnum.StructuredVariable);
    }

    public void StructuredVariable_() {
        wEntity_(SemanticsEntityDescriptorEnum.StructuredVariable);
    }

    public void _StructuredVariable() {
        _wEntity(SemanticsEntityDescriptorEnum.StructuredVariable);
    }

    public void Variable() {
        wEntity(SemanticsEntityDescriptorEnum.Variable);
    }

    public void Variable(String value) {
        wEntity(SemanticsEntityDescriptorEnum.Variable, value);
    }

    public void VariableValue() {
        wEntity(SemanticsEntityDescriptorEnum.VariableValue);
    }

    public void VariableValue_() {
        wEntity_(SemanticsEntityDescriptorEnum.VariableValue);
    }

    public void _VariableValue() {
        _wEntity(SemanticsEntityDescriptorEnum.VariableValue);
    }

    public void RenameGroup() {
        wEntity(SemanticsEntityDescriptorEnum.RenameGroup);
    }

    public void RenameGroup_() {
        wEntity_(SemanticsEntityDescriptorEnum.RenameGroup);
    }

    public void RenameGroup_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.RenameGroup, initialCapacity);
    }

    public void _RenameGroup() {
        _wEntity(SemanticsEntityDescriptorEnum.RenameGroup);
    }

    public void Rename() {
        wEntity(SemanticsEntityDescriptorEnum.Rename);
    }

    public void Rename_() {
        wEntity_(SemanticsEntityDescriptorEnum.Rename);
    }

    public void _Rename() {
        _wEntity(SemanticsEntityDescriptorEnum.Rename);
    }

    public void Environments() {
        wEntity(SemanticsEntityDescriptorEnum.Environments);
    }

    public void Environments_() {
        wEntity_(SemanticsEntityDescriptorEnum.Environments);
    }

    public void Environments_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.Environments, initialCapacity);
    }

    public void _Environments() {
        _wEntity(SemanticsEntityDescriptorEnum.Environments);
    }

    public void BindingsScope() {
        wEntity(SemanticsEntityDescriptorEnum.BindingsScope);
    }

    public void BindingsScope_() {
        wEntity_(SemanticsEntityDescriptorEnum.BindingsScope);
    }

    public void _BindingsScope() {
        _wEntity(SemanticsEntityDescriptorEnum.BindingsScope);
    }

    public void LocalBindings() {
        wEntity(SemanticsEntityDescriptorEnum.LocalBindings);
    }

    public void LocalBindings_() {
        wEntity_(SemanticsEntityDescriptorEnum.LocalBindings);
    }

    public void LocalBindings_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.LocalBindings, initialCapacity);
    }

    public void _LocalBindings() {
        _wEntity(SemanticsEntityDescriptorEnum.LocalBindings);
    }

    public void LocalBinding() {
        wEntity(SemanticsEntityDescriptorEnum.LocalBinding);
    }

    public void LocalBinding_() {
        wEntity_(SemanticsEntityDescriptorEnum.LocalBinding);
    }

    public void _LocalBinding() {
        _wEntity(SemanticsEntityDescriptorEnum.LocalBinding);
    }

    public void BindingOp() {
        wEntity(SemanticsEntityDescriptorEnum.BindingOp);
    }

    public void BindingOp(BindingOpEnum.Value value) {
        wEntity(SemanticsEntityDescriptorEnum.BindingOp, value);
    }

    public void BindingOp(String value) {
        wEntity(SemanticsEntityDescriptorEnum.BindingOp, value);
    }

    public void EnvironmentVariable() {
        wEntity(SemanticsEntityDescriptorEnum.EnvironmentVariable);
    }

    public void EnvironmentVariable_() {
        wEntity_(SemanticsEntityDescriptorEnum.EnvironmentVariable);
    }

    public void _EnvironmentVariable() {
        _wEntity(SemanticsEntityDescriptorEnum.EnvironmentVariable);
    }

    public void TypeCast() {
        wEntity(SemanticsEntityDescriptorEnum.TypeCast);
    }

    public void TypeCast_() {
        wEntity_(SemanticsEntityDescriptorEnum.TypeCast);
    }

    public void _TypeCast() {
        _wEntity(SemanticsEntityDescriptorEnum.TypeCast);
    }

    public void FunctionApplication() {
        wEntity(SemanticsEntityDescriptorEnum.FunctionApplication);
    }

    public void FunctionApplication_() {
        wEntity_(SemanticsEntityDescriptorEnum.FunctionApplication);
    }

    public void _FunctionApplication() {
        _wEntity(SemanticsEntityDescriptorEnum.FunctionApplication);
    }

    public void StageChange() {
        wEntity(SemanticsEntityDescriptorEnum.StageChange);
    }

    public void StageChange(StageChangeEnum.Value value) {
        wEntity(SemanticsEntityDescriptorEnum.StageChange, value);
    }

    public void StageChange(String value) {
        wEntity(SemanticsEntityDescriptorEnum.StageChange, value);
    }

    public void OutputBindings() {
        wEntity(SemanticsEntityDescriptorEnum.OutputBindings);
    }

    public void OutputBindings_() {
        wEntity_(SemanticsEntityDescriptorEnum.OutputBindings);
    }

    public void OutputBindings_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.OutputBindings, initialCapacity);
    }

    public void _OutputBindings() {
        _wEntity(SemanticsEntityDescriptorEnum.OutputBindings);
    }

    public void OutputBinding() {
        wEntity(SemanticsEntityDescriptorEnum.OutputBinding);
    }

    public void OutputBinding_() {
        wEntity_(SemanticsEntityDescriptorEnum.OutputBinding);
    }

    public void _OutputBinding() {
        _wEntity(SemanticsEntityDescriptorEnum.OutputBinding);
    }

    public void InputBindings() {
        wEntity(SemanticsEntityDescriptorEnum.InputBindings);
    }

    public void InputBindings_() {
        wEntity_(SemanticsEntityDescriptorEnum.InputBindings);
    }

    public void InputBindings_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.InputBindings, initialCapacity);
    }

    public void _InputBindings() {
        _wEntity(SemanticsEntityDescriptorEnum.InputBindings);
    }

    public void InputBinding() {
        wEntity(SemanticsEntityDescriptorEnum.InputBinding);
    }

    public void InputBinding_() {
        wEntity_(SemanticsEntityDescriptorEnum.InputBinding);
    }

    public void _InputBinding() {
        _wEntity(SemanticsEntityDescriptorEnum.InputBinding);
    }

    public void InlineTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.InlineTemplate);
    }

    public void InlineTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.InlineTemplate);
    }

    public void _InlineTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.InlineTemplate);
    }

    public void ChooseTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.ChooseTemplate);
    }

    public void ChooseTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.ChooseTemplate);
    }

    public void ChooseTemplate_(int initialCapacity) {
        wEntity_(SemanticsEntityDescriptorEnum.ChooseTemplate, initialCapacity);
    }

    public void _ChooseTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.ChooseTemplate);
    }

    public void WhereTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.WhereTemplate);
    }

    public void WhereTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.WhereTemplate);
    }

    public void _WhereTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.WhereTemplate);
    }

    public void ForTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.ForTemplate);
    }

    public void ForTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.ForTemplate);
    }

    public void _ForTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.ForTemplate);
    }

    public void IfTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.IfTemplate);
    }

    public void IfTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.IfTemplate);
    }

    public void _IfTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.IfTemplate);
    }

    public void IfDefTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.IfDefTemplate);
    }

    public void IfDefTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.IfDefTemplate);
    }

    public void _IfDefTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.IfDefTemplate);
    }

    public void ElseTemplate() {
        wEntity(SemanticsEntityDescriptorEnum.ElseTemplate);
    }

    public void ElseTemplate_() {
        wEntity_(SemanticsEntityDescriptorEnum.ElseTemplate);
    }

    public void _ElseTemplate() {
        _wEntity(SemanticsEntityDescriptorEnum.ElseTemplate);
    }

    public void RuleName() {
        wEntity(SemanticsEntityDescriptorEnum.RuleName);
    }

    public void RuleName_() {
        wEntity_(SemanticsEntityDescriptorEnum.RuleName);
    }

    public void _RuleName() {
        _wEntity(SemanticsEntityDescriptorEnum.RuleName);
    }

    public void Num() {
        wEntity(SemanticsEntityDescriptorEnum.Num);
    }

    public void Num(int value) {
        wEntity(SemanticsEntityDescriptorEnum.Num, value);
    }

    public void URI() {
        wEntity(SemanticsEntityDescriptorEnum.URI);
    }

    public void URI(String value) {
        wEntity(SemanticsEntityDescriptorEnum.URI, value);
    }

    public void Namespace() {
        wEntity(SemanticsEntityDescriptorEnum.Namespace);
    }

    public void Namespace(String value) {
        wEntity(SemanticsEntityDescriptorEnum.Namespace, value);
    }

    public void Name() {
        wEntity(SemanticsEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(SemanticsEntityDescriptorEnum.Name, value);
    }

    public void Version() {
        wEntity(SemanticsEntityDescriptorEnum.Version);
    }

    public void Version(String value) {
        wEntity(SemanticsEntityDescriptorEnum.Version, value);
    }
}
