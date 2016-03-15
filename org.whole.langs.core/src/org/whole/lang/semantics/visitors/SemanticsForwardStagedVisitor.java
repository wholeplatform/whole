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

/**
 *  @generator Whole
 */
public class SemanticsForwardStagedVisitor extends SemanticsIdentityVisitor {

    public void visit(SemanticTheory entity) {
        stagedVisit(entity);
    }

    public void visit(SemanticFunctions entity) {
        stagedVisit(entity);
    }

    public void visit(SemanticFunction entity) {
        stagedVisit(entity);
    }

    public void visit(Rules entity) {
        stagedVisit(entity);
    }

    public void visit(InferenceRules entity) {
        stagedVisit(entity);
    }

    public void visit(AnyType entity) {
        stagedVisit(entity);
    }

    public void visit(LanguageType entity) {
        stagedVisit(entity);
    }

    public void visit(EnvType entity) {
        stagedVisit(entity);
    }

    public void visit(EntityType entity) {
        stagedVisit(entity);
    }

    public void visit(EnvironmentType entity) {
        stagedVisit(entity);
    }

    public void visit(LegacyType entity) {
        stagedVisit(entity);
    }

    public void visit(UnionType entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionType entity) {
        stagedVisit(entity);
    }

    public void visit(SequenceType entity) {
        stagedVisit(entity);
    }

    public void visit(SubtypeType entity) {
        stagedVisit(entity);
    }

    public void visit(SupertypeType entity) {
        stagedVisit(entity);
    }

    public void visit(ProductType entity) {
        stagedVisit(entity);
    }

    public void visit(ExecutionRule entity) {
        stagedVisit(entity);
    }

    public void visit(InferenceRule entity) {
        stagedVisit(entity);
    }

    public void visit(Premises entity) {
        stagedVisit(entity);
    }

    public void visit(Transition entity) {
        stagedVisit(entity);
    }

    public void visit(Configuration entity) {
        stagedVisit(entity);
    }

    public void visit(TypedVariable entity) {
        stagedVisit(entity);
    }

    public void visit(StructuredVariable entity) {
        stagedVisit(entity);
    }

    public void visit(Variable entity) {
        stagedVisit(entity);
    }

    public void visit(VariableValue entity) {
        stagedVisit(entity);
    }

    public void visit(RenameGroup entity) {
        stagedVisit(entity);
    }

    public void visit(Rename entity) {
        stagedVisit(entity);
    }

    public void visit(Environments entity) {
        stagedVisit(entity);
    }

    public void visit(BindingsScope entity) {
        stagedVisit(entity);
    }

    public void visit(LocalBindings entity) {
        stagedVisit(entity);
    }

    public void visit(LocalBinding entity) {
        stagedVisit(entity);
    }

    public void visit(BindingOp entity) {
        stagedVisit(entity);
    }

    public void visit(EnvironmentVariable entity) {
        stagedVisit(entity);
    }

    public void visit(TypeCast entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionApplication entity) {
        stagedVisit(entity);
    }

    public void visit(StageChange entity) {
        stagedVisit(entity);
    }

    public void visit(OutputBindings entity) {
        stagedVisit(entity);
    }

    public void visit(OutputBinding entity) {
        stagedVisit(entity);
    }

    public void visit(InputBindings entity) {
        stagedVisit(entity);
    }

    public void visit(InputBinding entity) {
        stagedVisit(entity);
    }

    public void visit(InlineTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(ChooseTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(WhereTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(ForTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(IfTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(IfDefTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(ElseTemplate entity) {
        stagedVisit(entity);
    }

    public void visit(RuleName entity) {
        stagedVisit(entity);
    }

    public void visit(Num entity) {
        stagedVisit(entity);
    }

    public void visit(URI entity) {
        stagedVisit(entity);
    }

    public void visit(Namespace entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(Version entity) {
        stagedVisit(entity);
    }
}
