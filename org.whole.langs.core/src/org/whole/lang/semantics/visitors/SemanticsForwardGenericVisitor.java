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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SemanticsForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ISemanticsVisitor {

    public SemanticsForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SemanticTheory entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SemanticFunctions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SemanticFunction entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Rules entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InferenceRules entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AnyType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LanguageType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnvType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnvironmentType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LegacyType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(UnionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SequenceType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SubtypeType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SupertypeType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ProductType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExecutionRule entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InferenceRule entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Premises entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Transition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Configuration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypedVariable entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StructuredVariable entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Variable entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RenameGroup entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Rename entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Environments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BindingsScope entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LocalBindings entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LocalBinding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BindingOp entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnvironmentVariable entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeCast entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionApplication entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StageChange entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OutputBindings entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OutputBinding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InputBindings entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InputBinding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InlineTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ChooseTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(WhereTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ForTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IfTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IfDefTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ElseTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RuleName entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Num entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Version entity) {
        wGetVisitor1().visit(entity);
    }
}
