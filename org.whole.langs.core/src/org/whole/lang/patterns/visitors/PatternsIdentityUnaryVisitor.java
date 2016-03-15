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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PatternsIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IPatternsVisitor {

    public PatternsIdentityUnaryVisitor() {
        super(null);
    }

    public PatternsIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IPatternsEntity) entity).accept(this);
    }

    public void visit(PatternLanguage entity) {
    }

    public void visit(Patterns entity) {
    }

    public void visit(Library entity) {
    }

    public void visit(Pattern entity) {
    }

    public void visit(Repetition entity) {
    }

    public void visit(Choice entity) {
    }

    public void visit(Enumeration entity) {
    }

    public void visit(EnumValues entity) {
    }

    public void visit(EnumValue entity) {
    }

    public void visit(Data entity) {
    }

    public void visit(DataType entity) {
    }

    public void visit(PatternApplication entity) {
    }

    public void visit(Arguments entity) {
    }

    public void visit(Binding entity) {
    }

    public void visit(VariablePoint entity) {
    }

    public void visit(FunctionPoint entity) {
    }

    public void visit(Slot entity) {
    }

    public void visit(ResultPoint entity) {
    }

    public void visit(JoinPoint entity) {
    }

    public void visit(InsertionPoint entity) {
    }

    public void visit(ScopePoint entity) {
    }

    public void visit(TemplatePoint entity) {
    }

    public void visit(DerivationPoint entity) {
    }

    public void visit(SelectionPoint entity) {
    }

    public void visit(ConditionPoint entity) {
    }

    public void visit(VariantSelectionPoint entity) {
    }

    public void visit(Variants entity) {
    }

    public void visit(Variant entity) {
    }

    public void visit(IterationPoint entity) {
    }

    public void visit(SequencePoint entity) {
    }

    public void visit(InlinePoint entity) {
    }

    public void visit(Declarations entity) {
    }

    public void visit(FunctionDeclaration entity) {
    }

    public void visit(GoalDeclaration entity) {
    }

    public void visit(PointcutDeclaration entity) {
    }

    public void visit(JoinPointDeclaration entity) {
    }

    public void visit(VariableDeclaration entity) {
    }

    public void visit(VariantSelector entity) {
    }

    public void visit(Types entity) {
    }

    public void visit(ResultTypes entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(PatternJoinPointStep entity) {
    }

    public void visit(JoinPointStep entity) {
    }

    public void visit(PointcutStep entity) {
    }

    public void visit(GoalStep entity) {
    }

    public void visit(FunctionStep entity) {
    }

    public void visit(SlotStep entity) {
    }

    public void visit(OuterDefinitionStep entity) {
    }

    public void visit(PatternInstance entity) {
    }

    public void visit(Cut entity) {
    }

    public void visit(Insert entity) {
    }

    public void visit(SlotsDefined entity) {
    }

    public void visit(PatternTypeTest entity) {
    }

    public void visit(Placement entity) {
    }

    public void visit(URI entity) {
    }

    public void visit(Namespace entity) {
    }

    public void visit(Version entity) {
    }

    public void visit(BooleanValue entity) {
    }
}
