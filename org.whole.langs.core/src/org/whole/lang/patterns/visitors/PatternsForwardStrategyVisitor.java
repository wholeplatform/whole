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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PatternsForwardStrategyVisitor extends GenericForwardStrategyVisitor<IPatternsVisitor> implements IPatternsVisitor {

    public PatternsForwardStrategyVisitor() {
        this(new PatternsIdentityVisitor());
    }

    public PatternsForwardStrategyVisitor(IPatternsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IPatternsEntity) entity).accept(this);
    }

    public void visit(PatternLanguage entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Patterns entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Library entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Pattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Repetition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Choice entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumValues entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Data entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DataType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternApplication entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Binding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariablePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Slot entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResultPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InsertionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ScopePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TemplatePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DerivationPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SelectionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariantSelectionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Variants entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Variant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IterationPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SequencePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InlinePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GoalDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointcutDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPointDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariantSelector entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Types entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResultTypes entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternJoinPointStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPointStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointcutStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GoalStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SlotStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OuterDefinitionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternInstance entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cut entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Insert entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SlotsDefined entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternTypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Placement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(URI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Version entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanValue entity) {
        wGetStrategy().visit(entity);
    }
}
