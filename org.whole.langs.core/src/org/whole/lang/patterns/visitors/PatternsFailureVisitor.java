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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class PatternsFailureVisitor extends PatternsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(PatternLanguage entity) {
        throw new VisitException();
    }

    public void visit(Patterns entity) {
        throw new VisitException();
    }

    public void visit(Library entity) {
        throw new VisitException();
    }

    public void visit(Pattern entity) {
        throw new VisitException();
    }

    public void visit(Repetition entity) {
        throw new VisitException();
    }

    public void visit(Choice entity) {
        throw new VisitException();
    }

    public void visit(Enumeration entity) {
        throw new VisitException();
    }

    public void visit(EnumValues entity) {
        throw new VisitException();
    }

    public void visit(EnumValue entity) {
        throw new VisitException();
    }

    public void visit(Data entity) {
        throw new VisitException();
    }

    public void visit(DataType entity) {
        throw new VisitException();
    }

    public void visit(PatternApplication entity) {
        throw new VisitException();
    }

    public void visit(Arguments entity) {
        throw new VisitException();
    }

    public void visit(Binding entity) {
        throw new VisitException();
    }

    public void visit(VariablePoint entity) {
        throw new VisitException();
    }

    public void visit(FunctionPoint entity) {
        throw new VisitException();
    }

    public void visit(Slot entity) {
        throw new VisitException();
    }

    public void visit(ResultPoint entity) {
        throw new VisitException();
    }

    public void visit(JoinPoint entity) {
        throw new VisitException();
    }

    public void visit(InsertionPoint entity) {
        throw new VisitException();
    }

    public void visit(ScopePoint entity) {
        throw new VisitException();
    }

    public void visit(TemplatePoint entity) {
        throw new VisitException();
    }

    public void visit(DerivationPoint entity) {
        throw new VisitException();
    }

    public void visit(SelectionPoint entity) {
        throw new VisitException();
    }

    public void visit(ConditionPoint entity) {
        throw new VisitException();
    }

    public void visit(VariantSelectionPoint entity) {
        throw new VisitException();
    }

    public void visit(Variants entity) {
        throw new VisitException();
    }

    public void visit(Variant entity) {
        throw new VisitException();
    }

    public void visit(IterationPoint entity) {
        throw new VisitException();
    }

    public void visit(SequencePoint entity) {
        throw new VisitException();
    }

    public void visit(InlinePoint entity) {
        throw new VisitException();
    }

    public void visit(Declarations entity) {
        throw new VisitException();
    }

    public void visit(FunctionDeclaration entity) {
        throw new VisitException();
    }

    public void visit(GoalDeclaration entity) {
        throw new VisitException();
    }

    public void visit(PointcutDeclaration entity) {
        throw new VisitException();
    }

    public void visit(JoinPointDeclaration entity) {
        throw new VisitException();
    }

    public void visit(VariableDeclaration entity) {
        throw new VisitException();
    }

    public void visit(VariantSelector entity) {
        throw new VisitException();
    }

    public void visit(Types entity) {
        throw new VisitException();
    }

    public void visit(ResultTypes entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(PatternJoinPointStep entity) {
        throw new VisitException();
    }

    public void visit(JoinPointStep entity) {
        throw new VisitException();
    }

    public void visit(PointcutStep entity) {
        throw new VisitException();
    }

    public void visit(GoalStep entity) {
        throw new VisitException();
    }

    public void visit(FunctionStep entity) {
        throw new VisitException();
    }

    public void visit(SlotStep entity) {
        throw new VisitException();
    }

    public void visit(OuterDefinitionStep entity) {
        throw new VisitException();
    }

    public void visit(PatternInstance entity) {
        throw new VisitException();
    }

    public void visit(Cut entity) {
        throw new VisitException();
    }

    public void visit(Insert entity) {
        throw new VisitException();
    }

    public void visit(SlotsDefined entity) {
        throw new VisitException();
    }

    public void visit(PatternTypeTest entity) {
        throw new VisitException();
    }

    public void visit(Placement entity) {
        throw new VisitException();
    }

    public void visit(URI entity) {
        throw new VisitException();
    }

    public void visit(Namespace entity) {
        throw new VisitException();
    }

    public void visit(Version entity) {
        throw new VisitException();
    }

    public void visit(BooleanValue entity) {
        throw new VisitException();
    }
}
