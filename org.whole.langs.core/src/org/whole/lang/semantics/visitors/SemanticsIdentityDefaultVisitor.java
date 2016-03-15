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
public class SemanticsIdentityDefaultVisitor extends SemanticsIdentityVisitor {

    public void visit(ISemanticsEntity entity) {
    }

    public void visit(SemanticTheory entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(SemanticFunctions entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(SemanticFunction entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(FunctionBody entity) {
    }

    public void visit(Rules entity) {
        visit((ISemanticsEntity) entity);
        visit((FunctionBody) entity);
    }

    public void visit(InferenceRules entity) {
        visit((ISemanticsEntity) entity);
        visit((FunctionBody) entity);
    }

    public void visit(SignatureOrSequence entity) {
    }

    public void visit(Signature entity) {
        visit((SignatureOrSequence) entity);
    }

    public void visit(Category entity) {
        visit((Signature) entity);
        visit((ConfigurationItem) entity);
        visit((Predicate) entity);
    }

    public void visit(ConfigurationItem entity) {
    }

    public void visit(Predicate entity) {
    }

    public void visit(AnyType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(LanguageType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(CastType entity) {
    }

    public void visit(EnvType entity) {
        visit((ISemanticsEntity) entity);
        visit((CastType) entity);
    }

    public void visit(EntityType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
        visit((CastType) entity);
    }

    public void visit(EnvironmentType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(LegacyType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(UnionType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(FunctionType entity) {
        visit((ISemanticsEntity) entity);
        visit((Signature) entity);
    }

    public void visit(SequenceType entity) {
        visit((ISemanticsEntity) entity);
        visit((SignatureOrSequence) entity);
    }

    public void visit(SubtypeType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(SupertypeType entity) {
        visit((ISemanticsEntity) entity);
        visit((Category) entity);
    }

    public void visit(ProductType entity) {
        visit((ISemanticsEntity) entity);
        visit((Signature) entity);
    }

    public void visit(Rule entity) {
    }

    public void visit(ExecutionRule entity) {
        visit((ISemanticsEntity) entity);
        visit((Rule) entity);
    }

    public void visit(Premise entity) {
    }

    public void visit(InferenceRule entity) {
        visit((ISemanticsEntity) entity);
        visit((Premise) entity);
    }

    public void visit(Premises entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Transition entity) {
        visit((ISemanticsEntity) entity);
        visit((Premise) entity);
        visit((ConfigurationOrTransition) entity);
    }

    public void visit(ConfigurationOrTransition entity) {
    }

    public void visit(Configuration entity) {
        visit((ISemanticsEntity) entity);
        visit((ConfigurationOrTransition) entity);
    }

    public void visit(Term entity) {
        visit((ConfigurationItem) entity);
    }

    public void visit(Expression entity) {
        visit((Term) entity);
    }

    public void visit(Identifier entity) {
        visit((Expression) entity);
        visit((BindingSubject) entity);
    }

    public void visit(BindingSubject entity) {
    }

    public void visit(LocalIdentifier entity) {
        visit((Identifier) entity);
    }

    public void visit(Template entity) {
        visit((Expression) entity);
    }

    public void visit(AbstractVariable entity) {
        visit((ConfigurationItem) entity);
        visit((Predicate) entity);
    }

    public void visit(TypedVariable entity) {
        visit((ISemanticsEntity) entity);
        visit((AbstractVariable) entity);
        visit((Signature) entity);
    }

    public void visit(StructuredVariable entity) {
        visit((ISemanticsEntity) entity);
        visit((AbstractVariable) entity);
        visit((LocalIdentifier) entity);
    }

    public void visit(Variable entity) {
        visit((ISemanticsEntity) entity);
        visit((LocalIdentifier) entity);
    }

    public void visit(VariableValue entity) {
        visit((ISemanticsEntity) entity);
        visit((LocalIdentifier) entity);
    }

    public void visit(RenameGroup entity) {
        visit((ISemanticsEntity) entity);
        visit((BindingSubject) entity);
    }

    public void visit(Rename entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Environments entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Environment entity) {
        visit((Expression) entity);
        visit((ConfigurationItem) entity);
    }

    public void visit(BindingsScope entity) {
        visit((ISemanticsEntity) entity);
        visit((Environment) entity);
    }

    public void visit(LocalBindings entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(LocalBinding entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(BindingOp entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(EnvironmentVariable entity) {
        visit((ISemanticsEntity) entity);
        visit((Identifier) entity);
    }

    public void visit(TypeCast entity) {
        visit((ISemanticsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(FunctionApplication entity) {
        visit((ISemanticsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(StageChange entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(OutputBindings entity) {
        visit((ISemanticsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(OutputBinding entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(InputBindings entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(InputBinding entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(InlineTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Template) entity);
    }

    public void visit(ChooseTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Template) entity);
    }

    public void visit(Case entity) {
    }

    public void visit(WhereTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Case) entity);
        visit((Template) entity);
    }

    public void visit(ForTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Case) entity);
        visit((Template) entity);
    }

    public void visit(IfTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Case) entity);
        visit((Template) entity);
    }

    public void visit(IfDefTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Case) entity);
        visit((Template) entity);
    }

    public void visit(ElseTemplate entity) {
        visit((ISemanticsEntity) entity);
        visit((Case) entity);
    }

    public void visit(RuleName entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Num entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(URI entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Namespace entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Name entity) {
        visit((ISemanticsEntity) entity);
    }

    public void visit(Version entity) {
        visit((ISemanticsEntity) entity);
    }
}
