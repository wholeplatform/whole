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
package org.whole.lang.patterns.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.patterns.model.PlacementEnum;

/**
 *  @generator Whole
 */
public interface IPatternsBuilder extends IBuilder {


    public void visit();

    public void placement();

    public void path();

    public void variant();

    public void subgoals();

    public void body();

    public void applicationTypes();

    public void iterator();

    public void variants();

    public void variability();

    public void condition();

    public void context();

    public void weaver();

    public void adapter();

    public void optional();

    public void expression();

    public void arguments();

    public void dataType();

    public void result();

    public void value();

    public void values();

    public void resultType();

    public void types();

    public void supertypes();

    public void type();

    public void template();

    public void resultTypes();

    public void declarations();

    public void patterns();

    public void version();

    public void name();

    public void namespace();

    public void uri();

    public void PatternLanguage();

    public void PatternLanguage_();

    public void _PatternLanguage();

    public void Patterns();

    public void Patterns_();

    public void Patterns_(int initialCapacity);

    public void _Patterns();

    public void Library();

    public void Library_();

    public void _Library();

    public void Pattern();

    public void Pattern_();

    public void _Pattern();

    public void Repetition();

    public void Repetition_();

    public void _Repetition();

    public void Choice();

    public void Choice_();

    public void _Choice();

    public void Enumeration();

    public void Enumeration_();

    public void _Enumeration();

    public void EnumValues();

    public void EnumValues_();

    public void EnumValues_(int initialCapacity);

    public void _EnumValues();

    public void EnumValue();

    public void EnumValue_();

    public void _EnumValue();

    public void Data();

    public void Data_();

    public void _Data();

    public void DataType();

    public void DataType(String value);

    public void PatternApplication();

    public void PatternApplication_();

    public void _PatternApplication();

    public void Arguments();

    public void Arguments_();

    public void Arguments_(int initialCapacity);

    public void _Arguments();

    public void Binding();

    public void Binding_();

    public void _Binding();

    public void VariablePoint();

    public void VariablePoint_();

    public void _VariablePoint();

    public void FunctionPoint();

    public void FunctionPoint_();

    public void _FunctionPoint();

    public void Slot();

    public void Slot_();

    public void _Slot();

    public void ResultPoint();

    public void ResultPoint_();

    public void _ResultPoint();

    public void JoinPoint();

    public void JoinPoint_();

    public void _JoinPoint();

    public void InsertionPoint();

    public void InsertionPoint_();

    public void _InsertionPoint();

    public void ScopePoint();

    public void ScopePoint_();

    public void _ScopePoint();

    public void TemplatePoint();

    public void TemplatePoint_();

    public void _TemplatePoint();

    public void DerivationPoint();

    public void DerivationPoint_();

    public void _DerivationPoint();

    public void SelectionPoint();

    public void SelectionPoint_();

    public void SelectionPoint_(int initialCapacity);

    public void _SelectionPoint();

    public void ConditionPoint();

    public void ConditionPoint_();

    public void _ConditionPoint();

    public void VariantSelectionPoint();

    public void VariantSelectionPoint_();

    public void _VariantSelectionPoint();

    public void Variants();

    public void Variants_();

    public void Variants_(int initialCapacity);

    public void _Variants();

    public void Variant();

    public void Variant_();

    public void _Variant();

    public void IterationPoint();

    public void IterationPoint_();

    public void _IterationPoint();

    public void SequencePoint();

    public void SequencePoint_();

    public void SequencePoint_(int initialCapacity);

    public void _SequencePoint();

    public void InlinePoint();

    public void InlinePoint_();

    public void _InlinePoint();

    public void Declarations();

    public void Declarations_();

    public void Declarations_(int initialCapacity);

    public void _Declarations();

    public void FunctionDeclaration();

    public void FunctionDeclaration_();

    public void _FunctionDeclaration();

    public void GoalDeclaration();

    public void GoalDeclaration_();

    public void _GoalDeclaration();

    public void PointcutDeclaration();

    public void PointcutDeclaration_();

    public void _PointcutDeclaration();

    public void JoinPointDeclaration();

    public void JoinPointDeclaration_();

    public void _JoinPointDeclaration();

    public void VariableDeclaration();

    public void VariableDeclaration_();

    public void _VariableDeclaration();

    public void VariantSelector();

    public void VariantSelector_();

    public void _VariantSelector();

    public void Types();

    public void Types_();

    public void Types_(int initialCapacity);

    public void _Types();

    public void ResultTypes();

    public void ResultTypes_();

    public void ResultTypes_(int initialCapacity);

    public void _ResultTypes();

    public void Name();

    public void Name(String value);

    public void PatternJoinPointStep();

    public void PatternJoinPointStep_();

    public void _PatternJoinPointStep();

    public void JoinPointStep();

    public void JoinPointStep(String value);

    public void PointcutStep();

    public void PointcutStep(String value);

    public void GoalStep();

    public void GoalStep(String value);

    public void FunctionStep();

    public void FunctionStep(String value);

    public void SlotStep();

    public void SlotStep(String value);

    public void OuterDefinitionStep();

    public void OuterDefinitionStep(String value);

    public void PatternInstance();

    public void PatternInstance_();

    public void _PatternInstance();

    public void Cut();

    public void Cut_();

    public void _Cut();

    public void Insert();

    public void Insert_();

    public void _Insert();

    public void SlotsDefined();

    public void SlotsDefined_();

    public void _SlotsDefined();

    public void PatternTypeTest();

    public void PatternTypeTest(String value);

    public void Placement();

    public void Placement(PlacementEnum.Value value);

    public void Placement(String value);

    public void URI();

    public void URI(String value);

    public void Namespace();

    public void Namespace(String value);

    public void Version();

    public void Version(String value);

    public void BooleanValue();

    public void BooleanValue(boolean value);
}
