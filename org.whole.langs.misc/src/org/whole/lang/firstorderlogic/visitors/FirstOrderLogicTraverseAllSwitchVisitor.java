package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.visitors.FirstOrderLogicIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.firstorderlogic.model.*;

/** 
 * @generator Whole
 */
public class FirstOrderLogicTraverseAllSwitchVisitor extends
		FirstOrderLogicIdentityUnaryVisitor<IVisitor> {
	public FirstOrderLogicTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Theory entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getImports());
		wGetVisitor1().visit(entity.getDeclarations());
		wGetVisitor1().visit(entity.getAssertions());
	}

	public void visit(ImportTheories entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ImportDeclaration entity) {
		wGetVisitor1().visit(entity.getLanguage());
		wGetVisitor1().visit(entity.getAlias());
	}

	public void visit(Declarations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Assertions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(EntityName entity) {
		wGetVisitor1().visit(entity.getLanguage());
		wGetVisitor1().visit(entity.getEntityName());
	}

	public void visit(FeatureName entity) {
		wGetVisitor1().visit(entity.getLanguage());
		wGetVisitor1().visit(entity.getEntityName());
		wGetVisitor1().visit(entity.getFeaturePath());
	}

	public void visit(QualifiedFeature entity) {
		wGetVisitor1().visit(entity.getQualifier());
		wGetVisitor1().visit(entity.getFeature());
	}

	public void visit(SubtypeDeclaration entity) {
		wGetVisitor1().visit(entity.getSubSort());
		wGetVisitor1().visit(entity.getSuperSort());
	}

	public void visit(NameDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getModelBinding());
	}

	public void visit(VariableType entity) {
		wGetVisitor1().visit(entity.getSort());
	}

	public void visit(FunctionType entity) {
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getSort());
	}

	public void visit(PredicateType entity) {
		wGetVisitor1().visit(entity.getParameters());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getSort());
	}

	public void visit(PredicateDefinition entity) {
		wGetVisitor1().visit(entity.getPredicate());
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getStatement());
	}

	public void visit(FunctionDefinition entity) {
		wGetVisitor1().visit(entity.getFunction());
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getTerm());
	}

	public void visit(Axiom entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getStatement());
	}

	public void visit(Theorem entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getStatement());
		wGetVisitor1().visit(entity.getProof());
	}

	public void visit(Formulae entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(PredicateApplication entity) {
		wGetVisitor1().visit(entity.getPredicate());
		wGetVisitor1().visit(entity.getArguments());
	}

	public void visit(EqualityPredicateApplication entity) {
		wGetVisitor1().visit(entity.getLeftTerm());
		wGetVisitor1().visit(entity.getRightTerm());
	}

	public void visit(Implication entity) {
		wGetVisitor1().visit(entity.getAntecedent());
		wGetVisitor1().visit(entity.getConsequent());
	}

	public void visit(Coimplication entity) {
		wGetVisitor1().visit(entity.getLeftFormula());
		wGetVisitor1().visit(entity.getRightFormula());
	}

	public void visit(Xor entity) {
		wGetVisitor1().visit(entity.getLeftFormula());
		wGetVisitor1().visit(entity.getRightFormula());
	}

	public void visit(And entity) {
		wGetVisitor1().visit(entity.getLeftFormula());
		wGetVisitor1().visit(entity.getRightFormula());
	}

	public void visit(Or entity) {
		wGetVisitor1().visit(entity.getLeftFormula());
		wGetVisitor1().visit(entity.getRightFormula());
	}

	public void visit(Not entity) {
		wGetVisitor1().visit(entity.getFormula());
	}

	public void visit(ForAll entity) {
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getFormula());
	}

	public void visit(Exist entity) {
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getFormula());
	}

	public void visit(ExistUnique entity) {
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getFormula());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(QualifiedPredicate entity) {
		wGetVisitor1().visit(entity.getTheoryAlias());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(FunctionApplication entity) {
		wGetVisitor1().visit(entity.getFunction());
		wGetVisitor1().visit(entity.getArguments());
		wGetVisitor1().visit(entity.getResult());
	}

	public void visit(QualifiedFunction entity) {
		wGetVisitor1().visit(entity.getTheoryAlias());
		wGetVisitor1().visit(entity.getName());
	}
}
