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
public class PatternsForwardStagedVisitor extends PatternsIdentityVisitor {

    public void visit(PatternLanguage entity) {
        stagedVisit(entity);
    }

    public void visit(Patterns entity) {
        stagedVisit(entity);
    }

    public void visit(Library entity) {
        stagedVisit(entity);
    }

    public void visit(Pattern entity) {
        stagedVisit(entity);
    }

    public void visit(Repetition entity) {
        stagedVisit(entity);
    }

    public void visit(Choice entity) {
        stagedVisit(entity);
    }

    public void visit(Enumeration entity) {
        stagedVisit(entity);
    }

    public void visit(EnumValues entity) {
        stagedVisit(entity);
    }

    public void visit(EnumValue entity) {
        stagedVisit(entity);
    }

    public void visit(Data entity) {
        stagedVisit(entity);
    }

    public void visit(DataType entity) {
        stagedVisit(entity);
    }

    public void visit(PatternApplication entity) {
        stagedVisit(entity);
    }

    public void visit(Arguments entity) {
        stagedVisit(entity);
    }

    public void visit(Binding entity) {
        stagedVisit(entity);
    }

    public void visit(VariablePoint entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionPoint entity) {
        stagedVisit(entity);
    }

    public void visit(Slot entity) {
        stagedVisit(entity);
    }

    public void visit(ResultPoint entity) {
        stagedVisit(entity);
    }

    public void visit(JoinPoint entity) {
        stagedVisit(entity);
    }

    public void visit(InsertionPoint entity) {
        stagedVisit(entity);
    }

    public void visit(ScopePoint entity) {
        stagedVisit(entity);
    }

    public void visit(TemplatePoint entity) {
        stagedVisit(entity);
    }

    public void visit(DerivationPoint entity) {
        stagedVisit(entity);
    }

    public void visit(SelectionPoint entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionPoint entity) {
        stagedVisit(entity);
    }

    public void visit(VariantSelectionPoint entity) {
        stagedVisit(entity);
    }

    public void visit(Variants entity) {
        stagedVisit(entity);
    }

    public void visit(Variant entity) {
        stagedVisit(entity);
    }

    public void visit(IterationPoint entity) {
        stagedVisit(entity);
    }

    public void visit(SequencePoint entity) {
        stagedVisit(entity);
    }

    public void visit(InlinePoint entity) {
        stagedVisit(entity);
    }

    public void visit(Declarations entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(GoalDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(PointcutDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(JoinPointDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(VariantSelector entity) {
        stagedVisit(entity);
    }

    public void visit(Types entity) {
        stagedVisit(entity);
    }

    public void visit(ResultTypes entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(PatternJoinPointStep entity) {
        stagedVisit(entity);
    }

    public void visit(JoinPointStep entity) {
        stagedVisit(entity);
    }

    public void visit(PointcutStep entity) {
        stagedVisit(entity);
    }

    public void visit(GoalStep entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionStep entity) {
        stagedVisit(entity);
    }

    public void visit(SlotStep entity) {
        stagedVisit(entity);
    }

    public void visit(OuterDefinitionStep entity) {
        stagedVisit(entity);
    }

    public void visit(PatternInstance entity) {
        stagedVisit(entity);
    }

    public void visit(Cut entity) {
        stagedVisit(entity);
    }

    public void visit(Insert entity) {
        stagedVisit(entity);
    }

    public void visit(SlotsDefined entity) {
        stagedVisit(entity);
    }

    public void visit(PatternTypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(Placement entity) {
        stagedVisit(entity);
    }

    public void visit(URI entity) {
        stagedVisit(entity);
    }

    public void visit(Namespace entity) {
        stagedVisit(entity);
    }

    public void visit(Version entity) {
        stagedVisit(entity);
    }

    public void visit(BooleanValue entity) {
        stagedVisit(entity);
    }
}
