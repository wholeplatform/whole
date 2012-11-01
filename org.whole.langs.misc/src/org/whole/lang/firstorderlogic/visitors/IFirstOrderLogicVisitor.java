package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.firstorderlogic.model.*;

/** 
 * @generator Whole
 */
public interface IFirstOrderLogicVisitor extends IVisitor {
	public void visit(Theory entity);

	public void visit(ImportTheories entity);

	public void visit(ImportDeclaration entity);

	public void visit(Declarations entity);

	public void visit(Assertions entity);

	public void visit(EntityName entity);

	public void visit(FeatureName entity);

	public void visit(LanguageName entity);

	public void visit(SimpleFeature entity);

	public void visit(QualifiedFeature entity);

	public void visit(SubtypeDeclaration entity);

	public void visit(NameDeclaration entity);

	public void visit(SortType entity);

	public void visit(VariableType entity);

	public void visit(FunctionType entity);

	public void visit(PredicateType entity);

	public void visit(Parameters entity);

	public void visit(VariableDeclaration entity);

	public void visit(PredicateDefinition entity);

	public void visit(FunctionDefinition entity);

	public void visit(Axiom entity);

	public void visit(Theorem entity);

	public void visit(Formulae entity);

	public void visit(PredicateApplication entity);

	public void visit(EqualityPredicateApplication entity);

	public void visit(Implication entity);

	public void visit(Coimplication entity);

	public void visit(Xor entity);

	public void visit(And entity);

	public void visit(Or entity);

	public void visit(Not entity);

	public void visit(ForAll entity);

	public void visit(Exist entity);

	public void visit(ExistUnique entity);

	public void visit(Arguments entity);

	public void visit(SimplePredicate entity);

	public void visit(QualifiedPredicate entity);

	public void visit(TheoryName entity);

	public void visit(Constant entity);

	public void visit(Variable entity);

	public void visit(FunctionApplication entity);

	public void visit(SimpleFunction entity);

	public void visit(QualifiedFunction entity);

	public void visit(Name entity);
}
