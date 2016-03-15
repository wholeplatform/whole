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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.semantics.model.LegacyTypeEnum;
import org.whole.lang.semantics.model.BindingOpEnum;
import org.whole.lang.semantics.model.StageChangeEnum;

/**
 *  @generator Whole
 */
public interface ISemanticsBuilder extends IBuilder {


    public void visit();

    public void sup();

    public void sub();

    public void where();

    public void stage();

    public void environments();

    public void arguments();

    public void type();

    public void environment();

    public void expression();

    public void op();

    public void nestedScope();

    public void bindings();

    public void oldIdentifier();

    public void newIdentifier();

    public void identifier();

    public void time();

    public void index();

    public void variable();

    public void targetConfiguration();

    public void sourceConfiguration();

    public void conclusion();

    public void premises();

    public void meaning();

    public void condition();

    public void category();

    public void target();

    public void source();

    public void rules();

    public void signature();

    public void functions();

    public void version();

    public void name();

    public void namespace();

    public void uri();

    public void SemanticTheory();

    public void SemanticTheory_();

    public void _SemanticTheory();

    public void SemanticFunctions();

    public void SemanticFunctions_();

    public void SemanticFunctions_(int initialCapacity);

    public void _SemanticFunctions();

    public void SemanticFunction();

    public void SemanticFunction_();

    public void _SemanticFunction();

    public void Rules();

    public void Rules_();

    public void Rules_(int initialCapacity);

    public void _Rules();

    public void InferenceRules();

    public void InferenceRules_();

    public void InferenceRules_(int initialCapacity);

    public void _InferenceRules();

    public void AnyType();

    public void AnyType_();

    public void _AnyType();

    public void LanguageType();

    public void LanguageType(String value);

    public void EnvType();

    public void EnvType_();

    public void _EnvType();

    public void EntityType();

    public void EntityType(String value);

    public void EnvironmentType();

    public void EnvironmentType(String value);

    public void LegacyType();

    public void LegacyType(LegacyTypeEnum.Value value);

    public void LegacyType(String value);

    public void UnionType();

    public void UnionType_();

    public void UnionType_(int initialCapacity);

    public void _UnionType();

    public void FunctionType();

    public void FunctionType_();

    public void _FunctionType();

    public void SequenceType();

    public void SequenceType_();

    public void _SequenceType();

    public void SubtypeType();

    public void SubtypeType_();

    public void _SubtypeType();

    public void SupertypeType();

    public void SupertypeType_();

    public void _SupertypeType();

    public void ProductType();

    public void ProductType_();

    public void ProductType_(int initialCapacity);

    public void _ProductType();

    public void ExecutionRule();

    public void ExecutionRule_();

    public void _ExecutionRule();

    public void InferenceRule();

    public void InferenceRule_();

    public void _InferenceRule();

    public void Premises();

    public void Premises_();

    public void Premises_(int initialCapacity);

    public void _Premises();

    public void Transition();

    public void Transition_();

    public void _Transition();

    public void Configuration();

    public void Configuration_();

    public void Configuration_(int initialCapacity);

    public void _Configuration();

    public void TypedVariable();

    public void TypedVariable_();

    public void _TypedVariable();

    public void StructuredVariable();

    public void StructuredVariable_();

    public void _StructuredVariable();

    public void Variable();

    public void Variable(String value);

    public void VariableValue();

    public void VariableValue_();

    public void _VariableValue();

    public void RenameGroup();

    public void RenameGroup_();

    public void RenameGroup_(int initialCapacity);

    public void _RenameGroup();

    public void Rename();

    public void Rename_();

    public void _Rename();

    public void Environments();

    public void Environments_();

    public void Environments_(int initialCapacity);

    public void _Environments();

    public void BindingsScope();

    public void BindingsScope_();

    public void _BindingsScope();

    public void LocalBindings();

    public void LocalBindings_();

    public void LocalBindings_(int initialCapacity);

    public void _LocalBindings();

    public void LocalBinding();

    public void LocalBinding_();

    public void _LocalBinding();

    public void BindingOp();

    public void BindingOp(BindingOpEnum.Value value);

    public void BindingOp(String value);

    public void EnvironmentVariable();

    public void EnvironmentVariable_();

    public void _EnvironmentVariable();

    public void TypeCast();

    public void TypeCast_();

    public void _TypeCast();

    public void FunctionApplication();

    public void FunctionApplication_();

    public void _FunctionApplication();

    public void StageChange();

    public void StageChange(StageChangeEnum.Value value);

    public void StageChange(String value);

    public void OutputBindings();

    public void OutputBindings_();

    public void OutputBindings_(int initialCapacity);

    public void _OutputBindings();

    public void OutputBinding();

    public void OutputBinding_();

    public void _OutputBinding();

    public void InputBindings();

    public void InputBindings_();

    public void InputBindings_(int initialCapacity);

    public void _InputBindings();

    public void InputBinding();

    public void InputBinding_();

    public void _InputBinding();

    public void InlineTemplate();

    public void InlineTemplate_();

    public void _InlineTemplate();

    public void ChooseTemplate();

    public void ChooseTemplate_();

    public void ChooseTemplate_(int initialCapacity);

    public void _ChooseTemplate();

    public void WhereTemplate();

    public void WhereTemplate_();

    public void _WhereTemplate();

    public void ForTemplate();

    public void ForTemplate_();

    public void _ForTemplate();

    public void IfTemplate();

    public void IfTemplate_();

    public void _IfTemplate();

    public void IfDefTemplate();

    public void IfDefTemplate_();

    public void _IfDefTemplate();

    public void ElseTemplate();

    public void ElseTemplate_();

    public void _ElseTemplate();

    public void RuleName();

    public void RuleName_();

    public void _RuleName();

    public void Num();

    public void Num(int value);

    public void URI();

    public void URI(String value);

    public void Namespace();

    public void Namespace(String value);

    public void Name();

    public void Name(String value);

    public void Version();

    public void Version(String value);
}
