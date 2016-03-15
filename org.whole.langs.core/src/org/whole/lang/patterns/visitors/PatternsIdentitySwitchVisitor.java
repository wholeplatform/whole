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
package org.whole.lang.patterns.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class PatternsIdentitySwitchVisitor extends AbstractVisitor implements IPatternsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case PatternsEntityDescriptorEnum.PatternLanguage_ord :
            visit((PatternLanguage) entity);
            break;
            case PatternsEntityDescriptorEnum.Patterns_ord :
            visit((Patterns) entity);
            break;
            case PatternsEntityDescriptorEnum.Library_ord :
            visit((Library) entity);
            break;
            case PatternsEntityDescriptorEnum.Pattern_ord :
            visit((Pattern) entity);
            break;
            case PatternsEntityDescriptorEnum.Repetition_ord :
            visit((Repetition) entity);
            break;
            case PatternsEntityDescriptorEnum.Choice_ord :
            visit((Choice) entity);
            break;
            case PatternsEntityDescriptorEnum.Enumeration_ord :
            visit((Enumeration) entity);
            break;
            case PatternsEntityDescriptorEnum.EnumValues_ord :
            visit((EnumValues) entity);
            break;
            case PatternsEntityDescriptorEnum.EnumValue_ord :
            visit((EnumValue) entity);
            break;
            case PatternsEntityDescriptorEnum.Data_ord :
            visit((Data) entity);
            break;
            case PatternsEntityDescriptorEnum.DataType_ord :
            visit((DataType) entity);
            break;
            case PatternsEntityDescriptorEnum.PatternApplication_ord :
            visit((PatternApplication) entity);
            break;
            case PatternsEntityDescriptorEnum.Arguments_ord :
            visit((Arguments) entity);
            break;
            case PatternsEntityDescriptorEnum.Binding_ord :
            visit((Binding) entity);
            break;
            case PatternsEntityDescriptorEnum.VariablePoint_ord :
            visit((VariablePoint) entity);
            break;
            case PatternsEntityDescriptorEnum.FunctionPoint_ord :
            visit((FunctionPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.Slot_ord :
            visit((Slot) entity);
            break;
            case PatternsEntityDescriptorEnum.ResultPoint_ord :
            visit((ResultPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.JoinPoint_ord :
            visit((JoinPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.InsertionPoint_ord :
            visit((InsertionPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.ScopePoint_ord :
            visit((ScopePoint) entity);
            break;
            case PatternsEntityDescriptorEnum.TemplatePoint_ord :
            visit((TemplatePoint) entity);
            break;
            case PatternsEntityDescriptorEnum.DerivationPoint_ord :
            visit((DerivationPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.SelectionPoint_ord :
            visit((SelectionPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.ConditionPoint_ord :
            visit((ConditionPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.VariantSelectionPoint_ord :
            visit((VariantSelectionPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.Variants_ord :
            visit((Variants) entity);
            break;
            case PatternsEntityDescriptorEnum.Variant_ord :
            visit((Variant) entity);
            break;
            case PatternsEntityDescriptorEnum.IterationPoint_ord :
            visit((IterationPoint) entity);
            break;
            case PatternsEntityDescriptorEnum.SequencePoint_ord :
            visit((SequencePoint) entity);
            break;
            case PatternsEntityDescriptorEnum.InlinePoint_ord :
            visit((InlinePoint) entity);
            break;
            case PatternsEntityDescriptorEnum.Declarations_ord :
            visit((Declarations) entity);
            break;
            case PatternsEntityDescriptorEnum.FunctionDeclaration_ord :
            visit((FunctionDeclaration) entity);
            break;
            case PatternsEntityDescriptorEnum.GoalDeclaration_ord :
            visit((GoalDeclaration) entity);
            break;
            case PatternsEntityDescriptorEnum.PointcutDeclaration_ord :
            visit((PointcutDeclaration) entity);
            break;
            case PatternsEntityDescriptorEnum.JoinPointDeclaration_ord :
            visit((JoinPointDeclaration) entity);
            break;
            case PatternsEntityDescriptorEnum.VariableDeclaration_ord :
            visit((VariableDeclaration) entity);
            break;
            case PatternsEntityDescriptorEnum.VariantSelector_ord :
            visit((VariantSelector) entity);
            break;
            case PatternsEntityDescriptorEnum.Types_ord :
            visit((Types) entity);
            break;
            case PatternsEntityDescriptorEnum.ResultTypes_ord :
            visit((ResultTypes) entity);
            break;
            case PatternsEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case PatternsEntityDescriptorEnum.PatternJoinPointStep_ord :
            visit((PatternJoinPointStep) entity);
            break;
            case PatternsEntityDescriptorEnum.JoinPointStep_ord :
            visit((JoinPointStep) entity);
            break;
            case PatternsEntityDescriptorEnum.PointcutStep_ord :
            visit((PointcutStep) entity);
            break;
            case PatternsEntityDescriptorEnum.GoalStep_ord :
            visit((GoalStep) entity);
            break;
            case PatternsEntityDescriptorEnum.FunctionStep_ord :
            visit((FunctionStep) entity);
            break;
            case PatternsEntityDescriptorEnum.SlotStep_ord :
            visit((SlotStep) entity);
            break;
            case PatternsEntityDescriptorEnum.OuterDefinitionStep_ord :
            visit((OuterDefinitionStep) entity);
            break;
            case PatternsEntityDescriptorEnum.PatternInstance_ord :
            visit((PatternInstance) entity);
            break;
            case PatternsEntityDescriptorEnum.Cut_ord :
            visit((Cut) entity);
            break;
            case PatternsEntityDescriptorEnum.Insert_ord :
            visit((Insert) entity);
            break;
            case PatternsEntityDescriptorEnum.SlotsDefined_ord :
            visit((SlotsDefined) entity);
            break;
            case PatternsEntityDescriptorEnum.PatternTypeTest_ord :
            visit((PatternTypeTest) entity);
            break;
            case PatternsEntityDescriptorEnum.Placement_ord :
            visit((Placement) entity);
            break;
            case PatternsEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case PatternsEntityDescriptorEnum.Namespace_ord :
            visit((Namespace) entity);
            break;
            case PatternsEntityDescriptorEnum.Version_ord :
            visit((Version) entity);
            break;
            case PatternsEntityDescriptorEnum.BooleanValue_ord :
            visit((BooleanValue) entity);
            break;
        }
    }
}
