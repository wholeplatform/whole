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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SemanticsIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements ISemanticsVisitor {

    public SemanticsIdentityUnaryVisitor() {
        super(null);
    }

    public SemanticsIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((ISemanticsEntity) entity).accept(this);
    }

    public void visit(SemanticTheory entity) {
    }

    public void visit(SemanticFunctions entity) {
    }

    public void visit(SemanticFunction entity) {
    }

    public void visit(Rules entity) {
    }

    public void visit(InferenceRules entity) {
    }

    public void visit(AnyType entity) {
    }

    public void visit(LanguageType entity) {
    }

    public void visit(EnvType entity) {
    }

    public void visit(EntityType entity) {
    }

    public void visit(EnvironmentType entity) {
    }

    public void visit(LegacyType entity) {
    }

    public void visit(UnionType entity) {
    }

    public void visit(FunctionType entity) {
    }

    public void visit(SequenceType entity) {
    }

    public void visit(SubtypeType entity) {
    }

    public void visit(SupertypeType entity) {
    }

    public void visit(ProductType entity) {
    }

    public void visit(ExecutionRule entity) {
    }

    public void visit(InferenceRule entity) {
    }

    public void visit(Premises entity) {
    }

    public void visit(Transition entity) {
    }

    public void visit(Configuration entity) {
    }

    public void visit(TypedVariable entity) {
    }

    public void visit(StructuredVariable entity) {
    }

    public void visit(Variable entity) {
    }

    public void visit(VariableValue entity) {
    }

    public void visit(RenameGroup entity) {
    }

    public void visit(Rename entity) {
    }

    public void visit(Environments entity) {
    }

    public void visit(BindingsScope entity) {
    }

    public void visit(LocalBindings entity) {
    }

    public void visit(LocalBinding entity) {
    }

    public void visit(BindingOp entity) {
    }

    public void visit(EnvironmentVariable entity) {
    }

    public void visit(TypeCast entity) {
    }

    public void visit(FunctionApplication entity) {
    }

    public void visit(StageChange entity) {
    }

    public void visit(OutputBindings entity) {
    }

    public void visit(OutputBinding entity) {
    }

    public void visit(InputBindings entity) {
    }

    public void visit(InputBinding entity) {
    }

    public void visit(InlineTemplate entity) {
    }

    public void visit(ChooseTemplate entity) {
    }

    public void visit(WhereTemplate entity) {
    }

    public void visit(ForTemplate entity) {
    }

    public void visit(IfTemplate entity) {
    }

    public void visit(IfDefTemplate entity) {
    }

    public void visit(ElseTemplate entity) {
    }

    public void visit(RuleName entity) {
    }

    public void visit(Num entity) {
    }

    public void visit(URI entity) {
    }

    public void visit(Namespace entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(Version entity) {
    }
}
