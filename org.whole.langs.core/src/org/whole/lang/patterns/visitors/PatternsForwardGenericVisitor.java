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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PatternsForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IPatternsVisitor {

    public PatternsForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternLanguage entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Patterns entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Library entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Pattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Repetition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Choice entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumValues entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Data entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DataType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternApplication entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Binding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariablePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Slot entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ResultPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InsertionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ScopePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TemplatePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DerivationPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SelectionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ConditionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariantSelectionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Variants entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Variant entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IterationPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SequencePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InlinePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GoalDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointcutDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPointDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariantSelector entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Types entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ResultTypes entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternJoinPointStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPointStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointcutStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GoalStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SlotStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OuterDefinitionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternInstance entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Cut entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Insert entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SlotsDefined entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternTypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Placement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Version entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BooleanValue entity) {
        wGetVisitor1().visit(entity);
    }
}
