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

import org.whole.lang.patterns.model.*;

/**
 *  @generator Whole
 */
public class PatternsIdentityDefaultVisitor extends PatternsIdentityVisitor {

    public void visit(IPatternsEntity entity) {
    }

    public void visit(PatternLanguage entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Patterns entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Library entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(PatternOrTypeDeclaration entity) {
    }

    public void visit(Pattern entity) {
        visit((IPatternsEntity) entity);
        visit((PatternOrTypeDeclaration) entity);
    }

    public void visit(Repetition entity) {
        visit((IPatternsEntity) entity);
        visit((PatternOrTypeDeclaration) entity);
        visit((Type) entity);
    }

    public void visit(Type entity) {
    }

    public void visit(Choice entity) {
        visit((IPatternsEntity) entity);
        visit((PatternOrTypeDeclaration) entity);
        visit((Type) entity);
    }

    public void visit(Enumeration entity) {
        visit((IPatternsEntity) entity);
        visit((PatternOrTypeDeclaration) entity);
        visit((Type) entity);
    }

    public void visit(EnumValues entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(EnumValue entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Data entity) {
        visit((IPatternsEntity) entity);
        visit((PatternOrTypeDeclaration) entity);
    }

    public void visit(DataType entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(StepExpression entity) {
        visit((PathExpression) entity);
    }

    public void visit(VariationPoint entity) {
        visit((StepExpression) entity);
    }

    public void visit(PatternApplication entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(Arguments entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Argument entity) {
    }

    public void visit(Binding entity) {
        visit((IPatternsEntity) entity);
        visit((Argument) entity);
    }

    public void visit(VariablePoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(FunctionPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(Slot entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(ResultPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(JoinPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(InsertionPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(ScopePoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(TemplatePoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(DerivationPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(SelectionPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(ConditionPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(VariantSelectionPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(Variants entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Variant entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(IterationPoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(SequencePoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(InlinePoint entity) {
        visit((IPatternsEntity) entity);
        visit((VariationPoint) entity);
    }

    public void visit(Declarations entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Declaration entity) {
    }

    public void visit(FunctionDeclaration entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(GoalDeclaration entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(PointcutDeclaration entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(JoinPointDeclaration entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(VariableDeclaration entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(VariantSelector entity) {
        visit((IPatternsEntity) entity);
        visit((Declaration) entity);
    }

    public void visit(Types entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(ResultTypes entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(ResultType entity) {
        visit((Type) entity);
        visit((ResultTypeOrPathExpression) entity);
    }

    public void visit(ResultTypeOrPathExpression entity) {
    }

    public void visit(Template entity) {
    }

    public void visit(PathExpression entity) {
        visit((Template) entity);
        visit((ResultTypeOrPathExpression) entity);
    }

    public void visit(Name entity) {
        visit((IPatternsEntity) entity);
        visit((ResultType) entity);
        visit((StepExpression) entity);
    }

    public void visit(PatternJoinPointStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(JoinPointStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(PointcutStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(GoalStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(FunctionStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(SlotStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(OuterDefinitionStep entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(PatternInstance entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Cut entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Insert entity) {
        visit((IPatternsEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Predicate entity) {
    }

    public void visit(SlotsDefined entity) {
        visit((IPatternsEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(PatternTypeTest entity) {
        visit((IPatternsEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(Placement entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(URI entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Namespace entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(Version entity) {
        visit((IPatternsEntity) entity);
    }

    public void visit(BooleanValue entity) {
        visit((IPatternsEntity) entity);
    }
}
