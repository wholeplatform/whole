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

import org.whole.lang.patterns.visitors.PatternsIdentityUnaryVisitor;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class PatternsTraverseAllVisitor extends PatternsIdentityUnaryVisitor<IPatternsVisitor> {

    public PatternsTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public PatternsTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(PatternLanguage entity) {
        entity.getUri().accept(wGetVisitor1());
        entity.getNamespace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getVersion().accept(wGetVisitor1());
        entity.getPatterns().accept(wGetVisitor1());
        entity.getDeclarations().accept(wGetVisitor1());
    }

    public void visit(Patterns entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Library entity) {
        entity.getUri().accept(wGetVisitor1());
        entity.getNamespace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getVersion().accept(wGetVisitor1());
        entity.getDeclarations().accept(wGetVisitor1());
    }

    public void visit(Pattern entity) {
        entity.getResultTypes().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(Repetition entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getSupertypes().accept(wGetVisitor1());
    }

    public void visit(Choice entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTypes().accept(wGetVisitor1());
        entity.getSupertypes().accept(wGetVisitor1());
    }

    public void visit(Enumeration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
        entity.getValues().accept(wGetVisitor1());
        entity.getSupertypes().accept(wGetVisitor1());
    }

    public void visit(EnumValues entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(EnumValue entity) {
        entity.getValue().accept(wGetVisitor1());
        entity.getResult().accept(wGetVisitor1());
    }

    public void visit(Data entity) {
        entity.getSupertypes().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getDataType().accept(wGetVisitor1());
    }

    public void visit(PatternApplication entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(Arguments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Binding entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(VariablePoint entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
    }

    public void visit(FunctionPoint entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Slot entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getOptional().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
    }

    public void visit(ResultPoint entity) {
        entity.getResultType().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
        entity.getWeaver().accept(wGetVisitor1());
    }

    public void visit(JoinPoint entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(InsertionPoint entity) {
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(ScopePoint entity) {
        entity.getContext().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(TemplatePoint entity) {
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(DerivationPoint entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
    }

    public void visit(SelectionPoint entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ConditionPoint entity) {
        entity.getCondition().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(VariantSelectionPoint entity) {
        entity.getVariability().accept(wGetVisitor1());
        entity.getVariants().accept(wGetVisitor1());
    }

    public void visit(Variants entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Variant entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(IterationPoint entity) {
        entity.getIterator().accept(wGetVisitor1());
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(SequencePoint entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(InlinePoint entity) {
        entity.getTemplate().accept(wGetVisitor1());
    }

    public void visit(Declarations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionDeclaration entity) {
        entity.getApplicationTypes().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(GoalDeclaration entity) {
        entity.getSubgoals().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(PointcutDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(JoinPointDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(VariableDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getResultType().accept(wGetVisitor1());
    }

    public void visit(VariantSelector entity) {
        entity.getVariability().accept(wGetVisitor1());
        entity.getVariant().accept(wGetVisitor1());
    }

    public void visit(Types entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ResultTypes entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PatternInstance entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(Cut entity) {
        entity.getPath().accept(wGetVisitor1());
    }

    public void visit(Insert entity) {
        entity.getPlacement().accept(wGetVisitor1());
        entity.getPath().accept(wGetVisitor1());
    }
}
