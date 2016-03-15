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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SemanticsForwardStrategyVisitor extends GenericForwardStrategyVisitor<ISemanticsVisitor> implements ISemanticsVisitor {

    public SemanticsForwardStrategyVisitor() {
        this(new SemanticsIdentityVisitor());
    }

    public SemanticsForwardStrategyVisitor(ISemanticsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ISemanticsEntity) entity).accept(this);
    }

    public void visit(SemanticTheory entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SemanticFunctions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SemanticFunction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Rules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InferenceRules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnyType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LanguageType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnvType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnvironmentType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LegacyType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SequenceType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubtypeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SupertypeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ProductType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExecutionRule entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InferenceRule entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Premises entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Transition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Configuration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypedVariable entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StructuredVariable entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Variable entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RenameGroup entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Rename entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Environments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BindingsScope entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LocalBindings entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LocalBinding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BindingOp entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnvironmentVariable entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeCast entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionApplication entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StageChange entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OutputBindings entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OutputBinding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InputBindings entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InputBinding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InlineTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ChooseTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhereTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfDefTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ElseTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RuleName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Num entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(URI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Version entity) {
        wGetStrategy().visit(entity);
    }
}
