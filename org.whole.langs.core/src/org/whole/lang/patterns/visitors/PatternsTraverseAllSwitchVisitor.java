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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.patterns.model.*;

/**
 *  @generator Whole
 */
public class PatternsTraverseAllSwitchVisitor extends PatternsIdentityUnaryVisitor<IVisitor> {

    public PatternsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(PatternLanguage entity) {
        wGetVisitor1().visit(entity.getUri());
        wGetVisitor1().visit(entity.getNamespace());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getVersion());
        wGetVisitor1().visit(entity.getPatterns());
        wGetVisitor1().visit(entity.getDeclarations());
    }

    public void visit(Patterns entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Library entity) {
        wGetVisitor1().visit(entity.getUri());
        wGetVisitor1().visit(entity.getNamespace());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getVersion());
        wGetVisitor1().visit(entity.getDeclarations());
    }

    public void visit(Pattern entity) {
        wGetVisitor1().visit(entity.getResultTypes());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(Repetition entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getSupertypes());
    }

    public void visit(Choice entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTypes());
        wGetVisitor1().visit(entity.getSupertypes());
    }

    public void visit(Enumeration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getResultType());
        wGetVisitor1().visit(entity.getValues());
        wGetVisitor1().visit(entity.getSupertypes());
    }

    public void visit(EnumValues entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EnumValue entity) {
        wGetVisitor1().visit(entity.getValue());
        wGetVisitor1().visit(entity.getResult());
    }

    public void visit(Data entity) {
        wGetVisitor1().visit(entity.getSupertypes());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDataType());
    }

    public void visit(PatternApplication entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(Arguments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Binding entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(VariablePoint entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getResultType());
    }

    public void visit(FunctionPoint entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getResultType());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Slot entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getOptional());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getResultType());
    }

    public void visit(ResultPoint entity) {
        wGetVisitor1().visit(entity.getResultType());
        wGetVisitor1().visit(entity.getTemplate());
        wGetVisitor1().visit(entity.getWeaver());
    }

    public void visit(JoinPoint entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(InsertionPoint entity) {
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(ScopePoint entity) {
        wGetVisitor1().visit(entity.getContext());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(TemplatePoint entity) {
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(DerivationPoint entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getResultType());
    }

    public void visit(SelectionPoint entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ConditionPoint entity) {
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(VariantSelectionPoint entity) {
        wGetVisitor1().visit(entity.getVariability());
        wGetVisitor1().visit(entity.getVariants());
    }

    public void visit(Variants entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Variant entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(IterationPoint entity) {
        wGetVisitor1().visit(entity.getIterator());
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(SequencePoint entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(InlinePoint entity) {
        wGetVisitor1().visit(entity.getTemplate());
    }

    public void visit(Declarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionDeclaration entity) {
        wGetVisitor1().visit(entity.getApplicationTypes());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(GoalDeclaration entity) {
        wGetVisitor1().visit(entity.getSubgoals());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(PointcutDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(JoinPointDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(VariableDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getResultType());
    }

    public void visit(VariantSelector entity) {
        wGetVisitor1().visit(entity.getVariability());
        wGetVisitor1().visit(entity.getVariant());
    }

    public void visit(Types entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ResultTypes entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PatternInstance entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(Cut entity) {
        wGetVisitor1().visit(entity.getPath());
    }

    public void visit(Insert entity) {
        wGetVisitor1().visit(entity.getPlacement());
        wGetVisitor1().visit(entity.getPath());
    }
}
