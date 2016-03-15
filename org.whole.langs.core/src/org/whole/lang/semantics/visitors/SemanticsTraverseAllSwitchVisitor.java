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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.semantics.model.*;

/**
 *  @generator Whole
 */
public class SemanticsTraverseAllSwitchVisitor extends SemanticsIdentityUnaryVisitor<IVisitor> {

    public SemanticsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(SemanticTheory entity) {
        wGetVisitor1().visit(entity.getUri());
        wGetVisitor1().visit(entity.getNamespace());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getVersion());
        wGetVisitor1().visit(entity.getFunctions());
    }

    public void visit(SemanticFunctions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SemanticFunction entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getSignature());
        wGetVisitor1().visit(entity.getRules());
    }

    public void visit(Rules entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(InferenceRules entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(UnionType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionType entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
    }

    public void visit(SequenceType entity) {
        wGetVisitor1().visit(entity.getSignature());
    }

    public void visit(SubtypeType entity) {
        wGetVisitor1().visit(entity.getCategory());
    }

    public void visit(SupertypeType entity) {
        wGetVisitor1().visit(entity.getCategory());
    }

    public void visit(ProductType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ExecutionRule entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getMeaning());
    }

    public void visit(InferenceRule entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getPremises());
        wGetVisitor1().visit(entity.getConclusion());
        wGetVisitor1().visit(entity.getCondition());
    }

    public void visit(Premises entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Transition entity) {
        wGetVisitor1().visit(entity.getSourceConfiguration());
        wGetVisitor1().visit(entity.getTargetConfiguration());
    }

    public void visit(Configuration entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AbstractVariable entity) {
        wGetVisitor1().visit(entity.getVariable());
        wGetVisitor1().visit(entity.getIndex());
        wGetVisitor1().visit(entity.getTime());
    }

    public void visit(TypedVariable entity) {
        wGetVisitor1().visit(entity.getVariable());
        wGetVisitor1().visit(entity.getIndex());
        wGetVisitor1().visit(entity.getTime());
        wGetVisitor1().visit(entity.getSignature());
    }

    public void visit(StructuredVariable entity) {
        wGetVisitor1().visit(entity.getVariable());
        wGetVisitor1().visit(entity.getIndex());
        wGetVisitor1().visit(entity.getTime());
    }

    public void visit(VariableValue entity) {
        wGetVisitor1().visit(entity.getIdentifier());
    }

    public void visit(RenameGroup entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Rename entity) {
        wGetVisitor1().visit(entity.getNewIdentifier());
        wGetVisitor1().visit(entity.getOldIdentifier());
    }

    public void visit(Environments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BindingsScope entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getBindings());
        wGetVisitor1().visit(entity.getNestedScope());
    }

    public void visit(LocalBindings entity) {
        for (LocalBinding child : entity)
            wGetVisitor1().visit(child);
    }

    public void visit(LocalBinding entity) {
        wGetVisitor1().visit(entity.getOp());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(EnvironmentVariable entity) {
        wGetVisitor1().visit(entity.getEnvironment());
        wGetVisitor1().visit(entity.getVariable());
    }

    public void visit(TypeCast entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(FunctionApplication entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getEnvironments());
        wGetVisitor1().visit(entity.getStage());
    }

    public void visit(OutputBindings entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(OutputBinding entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(InputBindings entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(InputBinding entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(InlineTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ChooseTemplate entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Case entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(WhereTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getWhere());
    }

    public void visit(ForTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getCondition());
    }

    public void visit(IfTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getCondition());
    }

    public void visit(IfDefTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ElseTemplate entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(RuleName entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getSub());
        wGetVisitor1().visit(entity.getSup());
    }
}
