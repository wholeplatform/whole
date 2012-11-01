package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.visitors.FirstOrderLogicIdentityUnaryVisitor;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FirstOrderLogicTraverseAllVisitor extends
		FirstOrderLogicIdentityUnaryVisitor<IFirstOrderLogicVisitor> {
	public FirstOrderLogicTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public FirstOrderLogicTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Theory entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getImports().accept(wGetVisitor1());
		entity.getDeclarations().accept(wGetVisitor1());
		entity.getAssertions().accept(wGetVisitor1());
	}

	public void visit(ImportTheories entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ImportDeclaration entity) {
		entity.getLanguage().accept(wGetVisitor1());
		entity.getAlias().accept(wGetVisitor1());
	}

	public void visit(Declarations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Assertions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(EntityName entity) {
		entity.getLanguage().accept(wGetVisitor1());
		entity.getEntityName().accept(wGetVisitor1());
	}

	public void visit(FeatureName entity) {
		entity.getLanguage().accept(wGetVisitor1());
		entity.getEntityName().accept(wGetVisitor1());
		entity.getFeaturePath().accept(wGetVisitor1());
	}

	public void visit(QualifiedFeature entity) {
		entity.getQualifier().accept(wGetVisitor1());
		entity.getFeature().accept(wGetVisitor1());
	}

	public void visit(SubtypeDeclaration entity) {
		entity.getSubSort().accept(wGetVisitor1());
		entity.getSuperSort().accept(wGetVisitor1());
	}

	public void visit(NameDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getModelBinding().accept(wGetVisitor1());
	}

	public void visit(VariableType entity) {
		entity.getSort().accept(wGetVisitor1());
	}

	public void visit(FunctionType entity) {
		entity.getParameters().accept(wGetVisitor1());
		entity.getSort().accept(wGetVisitor1());
	}

	public void visit(PredicateType entity) {
		entity.getParameters().accept(wGetVisitor1());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(VariableDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getSort().accept(wGetVisitor1());
	}

	public void visit(PredicateDefinition entity) {
		entity.getPredicate().accept(wGetVisitor1());
		entity.getParameters().accept(wGetVisitor1());
		entity.getStatement().accept(wGetVisitor1());
	}

	public void visit(FunctionDefinition entity) {
		entity.getFunction().accept(wGetVisitor1());
		entity.getParameters().accept(wGetVisitor1());
		entity.getTerm().accept(wGetVisitor1());
	}

	public void visit(Axiom entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getStatement().accept(wGetVisitor1());
	}

	public void visit(Theorem entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getStatement().accept(wGetVisitor1());
		entity.getProof().accept(wGetVisitor1());
	}

	public void visit(Formulae entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(PredicateApplication entity) {
		entity.getPredicate().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(EqualityPredicateApplication entity) {
		entity.getLeftTerm().accept(wGetVisitor1());
		entity.getRightTerm().accept(wGetVisitor1());
	}

	public void visit(Implication entity) {
		entity.getAntecedent().accept(wGetVisitor1());
		entity.getConsequent().accept(wGetVisitor1());
	}

	public void visit(Coimplication entity) {
		entity.getLeftFormula().accept(wGetVisitor1());
		entity.getRightFormula().accept(wGetVisitor1());
	}

	public void visit(Xor entity) {
		entity.getLeftFormula().accept(wGetVisitor1());
		entity.getRightFormula().accept(wGetVisitor1());
	}

	public void visit(And entity) {
		entity.getLeftFormula().accept(wGetVisitor1());
		entity.getRightFormula().accept(wGetVisitor1());
	}

	public void visit(Or entity) {
		entity.getLeftFormula().accept(wGetVisitor1());
		entity.getRightFormula().accept(wGetVisitor1());
	}

	public void visit(Not entity) {
		entity.getFormula().accept(wGetVisitor1());
	}

	public void visit(ForAll entity) {
		entity.getParameters().accept(wGetVisitor1());
		entity.getFormula().accept(wGetVisitor1());
	}

	public void visit(Exist entity) {
		entity.getParameters().accept(wGetVisitor1());
		entity.getFormula().accept(wGetVisitor1());
	}

	public void visit(ExistUnique entity) {
		entity.getParameters().accept(wGetVisitor1());
		entity.getFormula().accept(wGetVisitor1());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(QualifiedPredicate entity) {
		entity.getTheoryAlias().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(FunctionApplication entity) {
		entity.getFunction().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
	}

	public void visit(QualifiedFunction entity) {
		entity.getTheoryAlias().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}
}
