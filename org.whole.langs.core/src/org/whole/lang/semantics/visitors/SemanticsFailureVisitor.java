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

import org.whole.lang.semantics.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class SemanticsFailureVisitor extends SemanticsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(SemanticTheory entity) {
        throw new VisitException();
    }

    public void visit(SemanticFunctions entity) {
        throw new VisitException();
    }

    public void visit(SemanticFunction entity) {
        throw new VisitException();
    }

    public void visit(Rules entity) {
        throw new VisitException();
    }

    public void visit(InferenceRules entity) {
        throw new VisitException();
    }

    public void visit(AnyType entity) {
        throw new VisitException();
    }

    public void visit(LanguageType entity) {
        throw new VisitException();
    }

    public void visit(EnvType entity) {
        throw new VisitException();
    }

    public void visit(EntityType entity) {
        throw new VisitException();
    }

    public void visit(EnvironmentType entity) {
        throw new VisitException();
    }

    public void visit(LegacyType entity) {
        throw new VisitException();
    }

    public void visit(UnionType entity) {
        throw new VisitException();
    }

    public void visit(FunctionType entity) {
        throw new VisitException();
    }

    public void visit(SequenceType entity) {
        throw new VisitException();
    }

    public void visit(SubtypeType entity) {
        throw new VisitException();
    }

    public void visit(SupertypeType entity) {
        throw new VisitException();
    }

    public void visit(ProductType entity) {
        throw new VisitException();
    }

    public void visit(ExecutionRule entity) {
        throw new VisitException();
    }

    public void visit(InferenceRule entity) {
        throw new VisitException();
    }

    public void visit(Premises entity) {
        throw new VisitException();
    }

    public void visit(Transition entity) {
        throw new VisitException();
    }

    public void visit(Configuration entity) {
        throw new VisitException();
    }

    public void visit(TypedVariable entity) {
        throw new VisitException();
    }

    public void visit(StructuredVariable entity) {
        throw new VisitException();
    }

    public void visit(Variable entity) {
        throw new VisitException();
    }

    public void visit(VariableValue entity) {
        throw new VisitException();
    }

    public void visit(RenameGroup entity) {
        throw new VisitException();
    }

    public void visit(Rename entity) {
        throw new VisitException();
    }

    public void visit(Environments entity) {
        throw new VisitException();
    }

    public void visit(BindingsScope entity) {
        throw new VisitException();
    }

    public void visit(LocalBindings entity) {
        throw new VisitException();
    }

    public void visit(LocalBinding entity) {
        throw new VisitException();
    }

    public void visit(BindingOp entity) {
        throw new VisitException();
    }

    public void visit(EnvironmentVariable entity) {
        throw new VisitException();
    }

    public void visit(TypeCast entity) {
        throw new VisitException();
    }

    public void visit(FunctionApplication entity) {
        throw new VisitException();
    }

    public void visit(StageChange entity) {
        throw new VisitException();
    }

    public void visit(OutputBindings entity) {
        throw new VisitException();
    }

    public void visit(OutputBinding entity) {
        throw new VisitException();
    }

    public void visit(InputBindings entity) {
        throw new VisitException();
    }

    public void visit(InputBinding entity) {
        throw new VisitException();
    }

    public void visit(InlineTemplate entity) {
        throw new VisitException();
    }

    public void visit(ChooseTemplate entity) {
        throw new VisitException();
    }

    public void visit(WhereTemplate entity) {
        throw new VisitException();
    }

    public void visit(ForTemplate entity) {
        throw new VisitException();
    }

    public void visit(IfTemplate entity) {
        throw new VisitException();
    }

    public void visit(IfDefTemplate entity) {
        throw new VisitException();
    }

    public void visit(ElseTemplate entity) {
        throw new VisitException();
    }

    public void visit(RuleName entity) {
        throw new VisitException();
    }

    public void visit(Num entity) {
        throw new VisitException();
    }

    public void visit(URI entity) {
        throw new VisitException();
    }

    public void visit(Namespace entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Version entity) {
        throw new VisitException();
    }
}
