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
package org.whole.lang.semantics.visitors;

import org.whole.lang.semantics.visitors.SemanticsIdentityUnaryVisitor;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class SemanticsTraverseAllVisitor extends SemanticsIdentityUnaryVisitor<ISemanticsVisitor> {

    public SemanticsTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public SemanticsTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(SemanticTheory entity) {
        entity.getUri().accept(wGetVisitor1());
        entity.getNamespace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getVersion().accept(wGetVisitor1());
        entity.getFunctions().accept(wGetVisitor1());
    }

    public void visit(SemanticFunctions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SemanticFunction entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getSignature().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
    }

    public void visit(Rules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(InferenceRules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(UnionType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionType entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
    }

    public void visit(SequenceType entity) {
        entity.getSignature().accept(wGetVisitor1());
    }

    public void visit(SubtypeType entity) {
        entity.getCategory().accept(wGetVisitor1());
    }

    public void visit(SupertypeType entity) {
        entity.getCategory().accept(wGetVisitor1());
    }

    public void visit(ProductType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ExecutionRule entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
        entity.getMeaning().accept(wGetVisitor1());
    }

    public void visit(InferenceRule entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getPremises().accept(wGetVisitor1());
        entity.getConclusion().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
    }

    public void visit(Premises entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Transition entity) {
        entity.getSourceConfiguration().accept(wGetVisitor1());
        entity.getTargetConfiguration().accept(wGetVisitor1());
    }

    public void visit(Configuration entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AbstractVariable entity) {
        entity.getVariable().accept(wGetVisitor1());
        entity.getIndex().accept(wGetVisitor1());
        entity.getTime().accept(wGetVisitor1());
    }

    public void visit(TypedVariable entity) {
        entity.getVariable().accept(wGetVisitor1());
        entity.getIndex().accept(wGetVisitor1());
        entity.getTime().accept(wGetVisitor1());
        entity.getSignature().accept(wGetVisitor1());
    }

    public void visit(StructuredVariable entity) {
        entity.getVariable().accept(wGetVisitor1());
        entity.getIndex().accept(wGetVisitor1());
        entity.getTime().accept(wGetVisitor1());
    }

    public void visit(VariableValue entity) {
        entity.getIdentifier().accept(wGetVisitor1());
    }

    public void visit(RenameGroup entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Rename entity) {
        entity.getNewIdentifier().accept(wGetVisitor1());
        entity.getOldIdentifier().accept(wGetVisitor1());
    }

    public void visit(Environments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BindingsScope entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getBindings().accept(wGetVisitor1());
        entity.getNestedScope().accept(wGetVisitor1());
    }

    public void visit(LocalBindings entity) {
        for (LocalBinding child : entity)
            child.accept(wGetVisitor1());
    }

    public void visit(LocalBinding entity) {
        entity.getOp().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(EnvironmentVariable entity) {
        entity.getEnvironment().accept(wGetVisitor1());
        entity.getVariable().accept(wGetVisitor1());
    }

    public void visit(TypeCast entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(FunctionApplication entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getEnvironments().accept(wGetVisitor1());
        entity.getStage().accept(wGetVisitor1());
    }

    public void visit(OutputBindings entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(OutputBinding entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(InputBindings entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(InputBinding entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(InlineTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ChooseTemplate entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Case entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(WhereTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getWhere().accept(wGetVisitor1());
    }

    public void visit(ForTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
    }

    public void visit(IfTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
    }

    public void visit(IfDefTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ElseTemplate entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(RuleName entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getSub().accept(wGetVisitor1());
        entity.getSup().accept(wGetVisitor1());
    }
}
