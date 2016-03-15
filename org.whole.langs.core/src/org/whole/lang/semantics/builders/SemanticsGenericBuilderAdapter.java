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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.semantics.model.LegacyTypeEnum.Value;

/**
 *  @generator Whole
 */
public class SemanticsGenericBuilderAdapter extends GenericIdentityBuilder {
    private ISemanticsBuilder specificBuilder;

    public SemanticsGenericBuilderAdapter(ISemanticsBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public SemanticsGenericBuilderAdapter(ISemanticsBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case SemanticsFeatureDescriptorEnum.uri_ord :
            specificBuilder.uri();
            break;
            case SemanticsFeatureDescriptorEnum.namespace_ord :
            specificBuilder.namespace();
            break;
            case SemanticsFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case SemanticsFeatureDescriptorEnum.version_ord :
            specificBuilder.version();
            break;
            case SemanticsFeatureDescriptorEnum.functions_ord :
            specificBuilder.functions();
            break;
            case SemanticsFeatureDescriptorEnum.signature_ord :
            specificBuilder.signature();
            break;
            case SemanticsFeatureDescriptorEnum.rules_ord :
            specificBuilder.rules();
            break;
            case SemanticsFeatureDescriptorEnum.source_ord :
            specificBuilder.source();
            break;
            case SemanticsFeatureDescriptorEnum.target_ord :
            specificBuilder.target();
            break;
            case SemanticsFeatureDescriptorEnum.category_ord :
            specificBuilder.category();
            break;
            case SemanticsFeatureDescriptorEnum.condition_ord :
            specificBuilder.condition();
            break;
            case SemanticsFeatureDescriptorEnum.meaning_ord :
            specificBuilder.meaning();
            break;
            case SemanticsFeatureDescriptorEnum.premises_ord :
            specificBuilder.premises();
            break;
            case SemanticsFeatureDescriptorEnum.conclusion_ord :
            specificBuilder.conclusion();
            break;
            case SemanticsFeatureDescriptorEnum.sourceConfiguration_ord :
            specificBuilder.sourceConfiguration();
            break;
            case SemanticsFeatureDescriptorEnum.targetConfiguration_ord :
            specificBuilder.targetConfiguration();
            break;
            case SemanticsFeatureDescriptorEnum.variable_ord :
            specificBuilder.variable();
            break;
            case SemanticsFeatureDescriptorEnum.index_ord :
            specificBuilder.index();
            break;
            case SemanticsFeatureDescriptorEnum.time_ord :
            specificBuilder.time();
            break;
            case SemanticsFeatureDescriptorEnum.identifier_ord :
            specificBuilder.identifier();
            break;
            case SemanticsFeatureDescriptorEnum.newIdentifier_ord :
            specificBuilder.newIdentifier();
            break;
            case SemanticsFeatureDescriptorEnum.oldIdentifier_ord :
            specificBuilder.oldIdentifier();
            break;
            case SemanticsFeatureDescriptorEnum.bindings_ord :
            specificBuilder.bindings();
            break;
            case SemanticsFeatureDescriptorEnum.nestedScope_ord :
            specificBuilder.nestedScope();
            break;
            case SemanticsFeatureDescriptorEnum.op_ord :
            specificBuilder.op();
            break;
            case SemanticsFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case SemanticsFeatureDescriptorEnum.environment_ord :
            specificBuilder.environment();
            break;
            case SemanticsFeatureDescriptorEnum.type_ord :
            specificBuilder.type();
            break;
            case SemanticsFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case SemanticsFeatureDescriptorEnum.environments_ord :
            specificBuilder.environments();
            break;
            case SemanticsFeatureDescriptorEnum.stage_ord :
            specificBuilder.stage();
            break;
            case SemanticsFeatureDescriptorEnum.where_ord :
            specificBuilder.where();
            break;
            case SemanticsFeatureDescriptorEnum.sub_ord :
            specificBuilder.sub();
            break;
            case SemanticsFeatureDescriptorEnum.sup_ord :
            specificBuilder.sup();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.SemanticTheory_ord :
            specificBuilder.SemanticTheory();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunctions_ord :
            specificBuilder.SemanticFunctions();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunction_ord :
            specificBuilder.SemanticFunction();
            break;
            case SemanticsEntityDescriptorEnum.Rules_ord :
            specificBuilder.Rules();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRules_ord :
            specificBuilder.InferenceRules();
            break;
            case SemanticsEntityDescriptorEnum.AnyType_ord :
            specificBuilder.AnyType();
            break;
            case SemanticsEntityDescriptorEnum.EnvType_ord :
            specificBuilder.EnvType();
            break;
            case SemanticsEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType();
            break;
            case SemanticsEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType();
            break;
            case SemanticsEntityDescriptorEnum.SequenceType_ord :
            specificBuilder.SequenceType();
            break;
            case SemanticsEntityDescriptorEnum.SubtypeType_ord :
            specificBuilder.SubtypeType();
            break;
            case SemanticsEntityDescriptorEnum.SupertypeType_ord :
            specificBuilder.SupertypeType();
            break;
            case SemanticsEntityDescriptorEnum.ProductType_ord :
            specificBuilder.ProductType();
            break;
            case SemanticsEntityDescriptorEnum.ExecutionRule_ord :
            specificBuilder.ExecutionRule();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRule_ord :
            specificBuilder.InferenceRule();
            break;
            case SemanticsEntityDescriptorEnum.Premises_ord :
            specificBuilder.Premises();
            break;
            case SemanticsEntityDescriptorEnum.Transition_ord :
            specificBuilder.Transition();
            break;
            case SemanticsEntityDescriptorEnum.Configuration_ord :
            specificBuilder.Configuration();
            break;
            case SemanticsEntityDescriptorEnum.TypedVariable_ord :
            specificBuilder.TypedVariable();
            break;
            case SemanticsEntityDescriptorEnum.StructuredVariable_ord :
            specificBuilder.StructuredVariable();
            break;
            case SemanticsEntityDescriptorEnum.VariableValue_ord :
            specificBuilder.VariableValue();
            break;
            case SemanticsEntityDescriptorEnum.RenameGroup_ord :
            specificBuilder.RenameGroup();
            break;
            case SemanticsEntityDescriptorEnum.Rename_ord :
            specificBuilder.Rename();
            break;
            case SemanticsEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments();
            break;
            case SemanticsEntityDescriptorEnum.BindingsScope_ord :
            specificBuilder.BindingsScope();
            break;
            case SemanticsEntityDescriptorEnum.LocalBindings_ord :
            specificBuilder.LocalBindings();
            break;
            case SemanticsEntityDescriptorEnum.LocalBinding_ord :
            specificBuilder.LocalBinding();
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentVariable_ord :
            specificBuilder.EnvironmentVariable();
            break;
            case SemanticsEntityDescriptorEnum.TypeCast_ord :
            specificBuilder.TypeCast();
            break;
            case SemanticsEntityDescriptorEnum.FunctionApplication_ord :
            specificBuilder.FunctionApplication();
            break;
            case SemanticsEntityDescriptorEnum.OutputBindings_ord :
            specificBuilder.OutputBindings();
            break;
            case SemanticsEntityDescriptorEnum.OutputBinding_ord :
            specificBuilder.OutputBinding();
            break;
            case SemanticsEntityDescriptorEnum.InputBindings_ord :
            specificBuilder.InputBindings();
            break;
            case SemanticsEntityDescriptorEnum.InputBinding_ord :
            specificBuilder.InputBinding();
            break;
            case SemanticsEntityDescriptorEnum.InlineTemplate_ord :
            specificBuilder.InlineTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ChooseTemplate_ord :
            specificBuilder.ChooseTemplate();
            break;
            case SemanticsEntityDescriptorEnum.WhereTemplate_ord :
            specificBuilder.WhereTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ForTemplate_ord :
            specificBuilder.ForTemplate();
            break;
            case SemanticsEntityDescriptorEnum.IfTemplate_ord :
            specificBuilder.IfTemplate();
            break;
            case SemanticsEntityDescriptorEnum.IfDefTemplate_ord :
            specificBuilder.IfDefTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ElseTemplate_ord :
            specificBuilder.ElseTemplate();
            break;
            case SemanticsEntityDescriptorEnum.RuleName_ord :
            specificBuilder.RuleName();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.SemanticTheory_ord :
            specificBuilder.SemanticTheory_();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunctions_ord :
            specificBuilder.SemanticFunctions_();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunction_ord :
            specificBuilder.SemanticFunction_();
            break;
            case SemanticsEntityDescriptorEnum.Rules_ord :
            specificBuilder.Rules_();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRules_ord :
            specificBuilder.InferenceRules_();
            break;
            case SemanticsEntityDescriptorEnum.AnyType_ord :
            specificBuilder.AnyType_();
            break;
            case SemanticsEntityDescriptorEnum.EnvType_ord :
            specificBuilder.EnvType_();
            break;
            case SemanticsEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_();
            break;
            case SemanticsEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType_();
            break;
            case SemanticsEntityDescriptorEnum.SequenceType_ord :
            specificBuilder.SequenceType_();
            break;
            case SemanticsEntityDescriptorEnum.SubtypeType_ord :
            specificBuilder.SubtypeType_();
            break;
            case SemanticsEntityDescriptorEnum.SupertypeType_ord :
            specificBuilder.SupertypeType_();
            break;
            case SemanticsEntityDescriptorEnum.ProductType_ord :
            specificBuilder.ProductType_();
            break;
            case SemanticsEntityDescriptorEnum.ExecutionRule_ord :
            specificBuilder.ExecutionRule_();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRule_ord :
            specificBuilder.InferenceRule_();
            break;
            case SemanticsEntityDescriptorEnum.Premises_ord :
            specificBuilder.Premises_();
            break;
            case SemanticsEntityDescriptorEnum.Transition_ord :
            specificBuilder.Transition_();
            break;
            case SemanticsEntityDescriptorEnum.Configuration_ord :
            specificBuilder.Configuration_();
            break;
            case SemanticsEntityDescriptorEnum.TypedVariable_ord :
            specificBuilder.TypedVariable_();
            break;
            case SemanticsEntityDescriptorEnum.StructuredVariable_ord :
            specificBuilder.StructuredVariable_();
            break;
            case SemanticsEntityDescriptorEnum.VariableValue_ord :
            specificBuilder.VariableValue_();
            break;
            case SemanticsEntityDescriptorEnum.RenameGroup_ord :
            specificBuilder.RenameGroup_();
            break;
            case SemanticsEntityDescriptorEnum.Rename_ord :
            specificBuilder.Rename_();
            break;
            case SemanticsEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments_();
            break;
            case SemanticsEntityDescriptorEnum.BindingsScope_ord :
            specificBuilder.BindingsScope_();
            break;
            case SemanticsEntityDescriptorEnum.LocalBindings_ord :
            specificBuilder.LocalBindings_();
            break;
            case SemanticsEntityDescriptorEnum.LocalBinding_ord :
            specificBuilder.LocalBinding_();
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentVariable_ord :
            specificBuilder.EnvironmentVariable_();
            break;
            case SemanticsEntityDescriptorEnum.TypeCast_ord :
            specificBuilder.TypeCast_();
            break;
            case SemanticsEntityDescriptorEnum.FunctionApplication_ord :
            specificBuilder.FunctionApplication_();
            break;
            case SemanticsEntityDescriptorEnum.OutputBindings_ord :
            specificBuilder.OutputBindings_();
            break;
            case SemanticsEntityDescriptorEnum.OutputBinding_ord :
            specificBuilder.OutputBinding_();
            break;
            case SemanticsEntityDescriptorEnum.InputBindings_ord :
            specificBuilder.InputBindings_();
            break;
            case SemanticsEntityDescriptorEnum.InputBinding_ord :
            specificBuilder.InputBinding_();
            break;
            case SemanticsEntityDescriptorEnum.InlineTemplate_ord :
            specificBuilder.InlineTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.ChooseTemplate_ord :
            specificBuilder.ChooseTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.WhereTemplate_ord :
            specificBuilder.WhereTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.ForTemplate_ord :
            specificBuilder.ForTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.IfTemplate_ord :
            specificBuilder.IfTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.IfDefTemplate_ord :
            specificBuilder.IfDefTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.ElseTemplate_ord :
            specificBuilder.ElseTemplate_();
            break;
            case SemanticsEntityDescriptorEnum.RuleName_ord :
            specificBuilder.RuleName_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.SemanticTheory_ord :
            specificBuilder._SemanticTheory();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunctions_ord :
            specificBuilder._SemanticFunctions();
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunction_ord :
            specificBuilder._SemanticFunction();
            break;
            case SemanticsEntityDescriptorEnum.Rules_ord :
            specificBuilder._Rules();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRules_ord :
            specificBuilder._InferenceRules();
            break;
            case SemanticsEntityDescriptorEnum.AnyType_ord :
            specificBuilder._AnyType();
            break;
            case SemanticsEntityDescriptorEnum.EnvType_ord :
            specificBuilder._EnvType();
            break;
            case SemanticsEntityDescriptorEnum.UnionType_ord :
            specificBuilder._UnionType();
            break;
            case SemanticsEntityDescriptorEnum.FunctionType_ord :
            specificBuilder._FunctionType();
            break;
            case SemanticsEntityDescriptorEnum.SequenceType_ord :
            specificBuilder._SequenceType();
            break;
            case SemanticsEntityDescriptorEnum.SubtypeType_ord :
            specificBuilder._SubtypeType();
            break;
            case SemanticsEntityDescriptorEnum.SupertypeType_ord :
            specificBuilder._SupertypeType();
            break;
            case SemanticsEntityDescriptorEnum.ProductType_ord :
            specificBuilder._ProductType();
            break;
            case SemanticsEntityDescriptorEnum.ExecutionRule_ord :
            specificBuilder._ExecutionRule();
            break;
            case SemanticsEntityDescriptorEnum.InferenceRule_ord :
            specificBuilder._InferenceRule();
            break;
            case SemanticsEntityDescriptorEnum.Premises_ord :
            specificBuilder._Premises();
            break;
            case SemanticsEntityDescriptorEnum.Transition_ord :
            specificBuilder._Transition();
            break;
            case SemanticsEntityDescriptorEnum.Configuration_ord :
            specificBuilder._Configuration();
            break;
            case SemanticsEntityDescriptorEnum.TypedVariable_ord :
            specificBuilder._TypedVariable();
            break;
            case SemanticsEntityDescriptorEnum.StructuredVariable_ord :
            specificBuilder._StructuredVariable();
            break;
            case SemanticsEntityDescriptorEnum.VariableValue_ord :
            specificBuilder._VariableValue();
            break;
            case SemanticsEntityDescriptorEnum.RenameGroup_ord :
            specificBuilder._RenameGroup();
            break;
            case SemanticsEntityDescriptorEnum.Rename_ord :
            specificBuilder._Rename();
            break;
            case SemanticsEntityDescriptorEnum.Environments_ord :
            specificBuilder._Environments();
            break;
            case SemanticsEntityDescriptorEnum.BindingsScope_ord :
            specificBuilder._BindingsScope();
            break;
            case SemanticsEntityDescriptorEnum.LocalBindings_ord :
            specificBuilder._LocalBindings();
            break;
            case SemanticsEntityDescriptorEnum.LocalBinding_ord :
            specificBuilder._LocalBinding();
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentVariable_ord :
            specificBuilder._EnvironmentVariable();
            break;
            case SemanticsEntityDescriptorEnum.TypeCast_ord :
            specificBuilder._TypeCast();
            break;
            case SemanticsEntityDescriptorEnum.FunctionApplication_ord :
            specificBuilder._FunctionApplication();
            break;
            case SemanticsEntityDescriptorEnum.OutputBindings_ord :
            specificBuilder._OutputBindings();
            break;
            case SemanticsEntityDescriptorEnum.OutputBinding_ord :
            specificBuilder._OutputBinding();
            break;
            case SemanticsEntityDescriptorEnum.InputBindings_ord :
            specificBuilder._InputBindings();
            break;
            case SemanticsEntityDescriptorEnum.InputBinding_ord :
            specificBuilder._InputBinding();
            break;
            case SemanticsEntityDescriptorEnum.InlineTemplate_ord :
            specificBuilder._InlineTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ChooseTemplate_ord :
            specificBuilder._ChooseTemplate();
            break;
            case SemanticsEntityDescriptorEnum.WhereTemplate_ord :
            specificBuilder._WhereTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ForTemplate_ord :
            specificBuilder._ForTemplate();
            break;
            case SemanticsEntityDescriptorEnum.IfTemplate_ord :
            specificBuilder._IfTemplate();
            break;
            case SemanticsEntityDescriptorEnum.IfDefTemplate_ord :
            specificBuilder._IfDefTemplate();
            break;
            case SemanticsEntityDescriptorEnum.ElseTemplate_ord :
            specificBuilder._ElseTemplate();
            break;
            case SemanticsEntityDescriptorEnum.RuleName_ord :
            specificBuilder._RuleName();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.SemanticFunctions_ord :
            specificBuilder.SemanticFunctions_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.Rules_ord :
            specificBuilder.Rules_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.InferenceRules_ord :
            specificBuilder.InferenceRules_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.ProductType_ord :
            specificBuilder.ProductType_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.Premises_ord :
            specificBuilder.Premises_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.Configuration_ord :
            specificBuilder.Configuration_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.RenameGroup_ord :
            specificBuilder.RenameGroup_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.Environments_ord :
            specificBuilder.Environments_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.LocalBindings_ord :
            specificBuilder.LocalBindings_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.OutputBindings_ord :
            specificBuilder.OutputBindings_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.InputBindings_ord :
            specificBuilder.InputBindings_(initialCapacity);
            break;
            case SemanticsEntityDescriptorEnum.ChooseTemplate_ord :
            specificBuilder.ChooseTemplate_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.LanguageType_ord :
            specificBuilder.LanguageType(value);
            break;
            case SemanticsEntityDescriptorEnum.EntityType_ord :
            specificBuilder.EntityType(value);
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentType_ord :
            specificBuilder.EnvironmentType(value);
            break;
            case SemanticsEntityDescriptorEnum.Variable_ord :
            specificBuilder.Variable(value);
            break;
            case SemanticsEntityDescriptorEnum.URI_ord :
            specificBuilder.URI(value);
            break;
            case SemanticsEntityDescriptorEnum.Namespace_ord :
            specificBuilder.Namespace(value);
            break;
            case SemanticsEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
            case SemanticsEntityDescriptorEnum.Version_ord :
            specificBuilder.Version(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.LegacyType_ord :
            specificBuilder.LegacyType((Value) value);
            break;
            case SemanticsEntityDescriptorEnum.BindingOp_ord :
            specificBuilder.BindingOp((org.whole.lang.semantics.model.BindingOpEnum.Value) value);
            break;
            case SemanticsEntityDescriptorEnum.StageChange_ord :
            specificBuilder.StageChange((org.whole.lang.semantics.model.StageChangeEnum.Value) value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case SemanticsEntityDescriptorEnum.Num_ord :
            specificBuilder.Num(value);
            break;
        }
    }
}
