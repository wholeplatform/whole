/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.firstorderlogic.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.firstorderlogic.model.And;
import org.whole.lang.firstorderlogic.model.Arguments;
import org.whole.lang.firstorderlogic.model.Axiom;
import org.whole.lang.firstorderlogic.model.Coimplication;
import org.whole.lang.firstorderlogic.model.Declarations;
import org.whole.lang.firstorderlogic.model.EntityName;
import org.whole.lang.firstorderlogic.model.EqualityPredicateApplication;
import org.whole.lang.firstorderlogic.model.Exist;
import org.whole.lang.firstorderlogic.model.ExistUnique;
import org.whole.lang.firstorderlogic.model.FeatureName;
import org.whole.lang.firstorderlogic.model.ForAll;
import org.whole.lang.firstorderlogic.model.FunctionApplication;
import org.whole.lang.firstorderlogic.model.FunctionDefinition;
import org.whole.lang.firstorderlogic.model.FunctionType;
import org.whole.lang.firstorderlogic.model.IFirstOrderLogicEntity;
import org.whole.lang.firstorderlogic.model.Implication;
import org.whole.lang.firstorderlogic.model.ImportDeclaration;
import org.whole.lang.firstorderlogic.model.ImportTheories;
import org.whole.lang.firstorderlogic.model.NameDeclaration;
import org.whole.lang.firstorderlogic.model.Not;
import org.whole.lang.firstorderlogic.model.Or;
import org.whole.lang.firstorderlogic.model.Parameters;
import org.whole.lang.firstorderlogic.model.PredicateApplication;
import org.whole.lang.firstorderlogic.model.PredicateDefinition;
import org.whole.lang.firstorderlogic.model.PredicateType;
import org.whole.lang.firstorderlogic.model.QualifiedFeature;
import org.whole.lang.firstorderlogic.model.QualifiedFunction;
import org.whole.lang.firstorderlogic.model.QualifiedPredicate;
import org.whole.lang.firstorderlogic.model.SortType;
import org.whole.lang.firstorderlogic.model.SubtypeDeclaration;
import org.whole.lang.firstorderlogic.model.Theorem;
import org.whole.lang.firstorderlogic.model.Theory;
import org.whole.lang.firstorderlogic.model.VariableDeclaration;
import org.whole.lang.firstorderlogic.model.VariableType;
import org.whole.lang.firstorderlogic.model.Xor;
import org.whole.lang.firstorderlogic.visitors.FirstOrderLogicIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class FirstOrderLogicTextualPartFactoryVisitor extends FirstOrderLogicIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IFirstOrderLogicEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IFirstOrderLogicEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Theory entity) {
		part = new TheoryPart();
	}

	public void visit(Axiom entity) {
		part = new AxiomPart();
	}

	public void visit(Theorem entity) {
		part = new TheoremPart();
	}

	public void visit(Implication entity) {
		part = new ImplicationPart("\u2192");
	}

	public void visit(Coimplication entity) {
		part = new CoimplicationPart("\u2194");
	}

	public void visit(Xor entity) {
		part = new BinaryStatementPart("\u22BB");
	}

	public void visit(And entity) {
		part = new BinaryStatementPart("\u2227");
	}

	public void visit(Or entity) {
		part = new BinaryStatementPart("\u2228");
	}

	public void visit(Not entity) {
		part = new NotPart();
	}

	public void visit(ForAll entity) {
		part = new QuantifierPart("\u2200");
	}

	public void visit(Exist entity) {
		part = new QuantifierPart("\u2203");
	}
	public void visit(ImportDeclaration entity) {
		part = new ImportDeclarationPart();
	}

	public void visit(FunctionApplication entity) {
		part = new FunctionApplicationPart();
	}

	public void visit(PredicateApplication entity) {
		part = new PredicateApplicationPart();
	}

	public void visit(ImportTheories entity) {
		part = new CompositeColumnPart();
	}

	public void visit(Declarations entity) {
		part = new CompositeColumnPart();
	}

	public void visit(Arguments entity) {
		part = new CompositeRowPart();
	}

	public void visit(Parameters entity) {
		part = new CompositeRowPart();
	}

	public void visit(EqualityPredicateApplication entity) {
		part = new EqualityPredicateApplicationPart();
	}

	public void visit(ExistUnique entity) {
		part = new ExistUniquePart();
	}

	public void visit(QualifiedPredicate entity) {
		part = new QualifiedPredicatePart();
	}

	public void visit(QualifiedFunction entity) {
		part = new QualifiedFunctionPart();
	}

	public void visit(EntityName entity) {
		part = new EntityNamePart();
	}

	public void visit(FeatureName entity) {
		part = new FeatureNamePart();
	}

	public void visit(QualifiedFeature entity) {
		part = new QualifiedFeaturePart();
	}

	public void visit(PredicateDefinition entity) {
		part = new PredicateDefinitionPart();
	}

	public void visit(FunctionDefinition entity) {
		part = new FunctionDefinitionPart();
	}

	public void visit(SubtypeDeclaration entity) {
		part = new SubtypeDeclarationPart();
	}

	public void visit(NameDeclaration entity) {
		part = new NameDeclarationPart();
	}

	public void visit(SortType entity) {
		part = new SortTypePart();
	}

	public void visit(VariableType entity) {
		part = new VariableTypePart();
	}

	public void visit(FunctionType entity) {
		part = new FunctionTypePart();
	}

	public void visit(PredicateType entity) {
		part = new PredicateTypePart();
	}

	public void visit(VariableDeclaration entity) {
		part = new VariableDeclarationPart();
	}
}