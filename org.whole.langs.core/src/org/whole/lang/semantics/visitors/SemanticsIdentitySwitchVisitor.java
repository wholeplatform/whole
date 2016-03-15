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
package org.whole.lang.semantics.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class SemanticsIdentitySwitchVisitor extends AbstractVisitor implements ISemanticsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case SemanticsEntityDescriptorEnum.SemanticTheory_ord :
            visit((SemanticTheory) entity);
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunctions_ord :
            visit((SemanticFunctions) entity);
            break;
            case SemanticsEntityDescriptorEnum.SemanticFunction_ord :
            visit((SemanticFunction) entity);
            break;
            case SemanticsEntityDescriptorEnum.Rules_ord :
            visit((Rules) entity);
            break;
            case SemanticsEntityDescriptorEnum.InferenceRules_ord :
            visit((InferenceRules) entity);
            break;
            case SemanticsEntityDescriptorEnum.AnyType_ord :
            visit((AnyType) entity);
            break;
            case SemanticsEntityDescriptorEnum.LanguageType_ord :
            visit((LanguageType) entity);
            break;
            case SemanticsEntityDescriptorEnum.EnvType_ord :
            visit((EnvType) entity);
            break;
            case SemanticsEntityDescriptorEnum.EntityType_ord :
            visit((EntityType) entity);
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentType_ord :
            visit((EnvironmentType) entity);
            break;
            case SemanticsEntityDescriptorEnum.LegacyType_ord :
            visit((LegacyType) entity);
            break;
            case SemanticsEntityDescriptorEnum.UnionType_ord :
            visit((UnionType) entity);
            break;
            case SemanticsEntityDescriptorEnum.FunctionType_ord :
            visit((FunctionType) entity);
            break;
            case SemanticsEntityDescriptorEnum.SequenceType_ord :
            visit((SequenceType) entity);
            break;
            case SemanticsEntityDescriptorEnum.SubtypeType_ord :
            visit((SubtypeType) entity);
            break;
            case SemanticsEntityDescriptorEnum.SupertypeType_ord :
            visit((SupertypeType) entity);
            break;
            case SemanticsEntityDescriptorEnum.ProductType_ord :
            visit((ProductType) entity);
            break;
            case SemanticsEntityDescriptorEnum.ExecutionRule_ord :
            visit((ExecutionRule) entity);
            break;
            case SemanticsEntityDescriptorEnum.InferenceRule_ord :
            visit((InferenceRule) entity);
            break;
            case SemanticsEntityDescriptorEnum.Premises_ord :
            visit((Premises) entity);
            break;
            case SemanticsEntityDescriptorEnum.Transition_ord :
            visit((Transition) entity);
            break;
            case SemanticsEntityDescriptorEnum.Configuration_ord :
            visit((Configuration) entity);
            break;
            case SemanticsEntityDescriptorEnum.TypedVariable_ord :
            visit((TypedVariable) entity);
            break;
            case SemanticsEntityDescriptorEnum.StructuredVariable_ord :
            visit((StructuredVariable) entity);
            break;
            case SemanticsEntityDescriptorEnum.Variable_ord :
            visit((Variable) entity);
            break;
            case SemanticsEntityDescriptorEnum.VariableValue_ord :
            visit((VariableValue) entity);
            break;
            case SemanticsEntityDescriptorEnum.RenameGroup_ord :
            visit((RenameGroup) entity);
            break;
            case SemanticsEntityDescriptorEnum.Rename_ord :
            visit((Rename) entity);
            break;
            case SemanticsEntityDescriptorEnum.Environments_ord :
            visit((Environments) entity);
            break;
            case SemanticsEntityDescriptorEnum.BindingsScope_ord :
            visit((BindingsScope) entity);
            break;
            case SemanticsEntityDescriptorEnum.LocalBindings_ord :
            visit((LocalBindings) entity);
            break;
            case SemanticsEntityDescriptorEnum.LocalBinding_ord :
            visit((LocalBinding) entity);
            break;
            case SemanticsEntityDescriptorEnum.BindingOp_ord :
            visit((BindingOp) entity);
            break;
            case SemanticsEntityDescriptorEnum.EnvironmentVariable_ord :
            visit((EnvironmentVariable) entity);
            break;
            case SemanticsEntityDescriptorEnum.TypeCast_ord :
            visit((TypeCast) entity);
            break;
            case SemanticsEntityDescriptorEnum.FunctionApplication_ord :
            visit((FunctionApplication) entity);
            break;
            case SemanticsEntityDescriptorEnum.StageChange_ord :
            visit((StageChange) entity);
            break;
            case SemanticsEntityDescriptorEnum.OutputBindings_ord :
            visit((OutputBindings) entity);
            break;
            case SemanticsEntityDescriptorEnum.OutputBinding_ord :
            visit((OutputBinding) entity);
            break;
            case SemanticsEntityDescriptorEnum.InputBindings_ord :
            visit((InputBindings) entity);
            break;
            case SemanticsEntityDescriptorEnum.InputBinding_ord :
            visit((InputBinding) entity);
            break;
            case SemanticsEntityDescriptorEnum.InlineTemplate_ord :
            visit((InlineTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.ChooseTemplate_ord :
            visit((ChooseTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.WhereTemplate_ord :
            visit((WhereTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.ForTemplate_ord :
            visit((ForTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.IfTemplate_ord :
            visit((IfTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.IfDefTemplate_ord :
            visit((IfDefTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.ElseTemplate_ord :
            visit((ElseTemplate) entity);
            break;
            case SemanticsEntityDescriptorEnum.RuleName_ord :
            visit((RuleName) entity);
            break;
            case SemanticsEntityDescriptorEnum.Num_ord :
            visit((Num) entity);
            break;
            case SemanticsEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case SemanticsEntityDescriptorEnum.Namespace_ord :
            visit((Namespace) entity);
            break;
            case SemanticsEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case SemanticsEntityDescriptorEnum.Version_ord :
            visit((Version) entity);
            break;
        }
    }
}
