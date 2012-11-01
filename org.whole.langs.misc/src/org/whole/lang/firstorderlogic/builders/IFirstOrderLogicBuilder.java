package org.whole.lang.firstorderlogic.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IFirstOrderLogicBuilder extends IBuilder {
	public void visit();

	public void result();

	public void theoryAlias();

	public void formula();

	public void rightFormula();

	public void leftFormula();

	public void consequent();

	public void antecedent();

	public void rightTerm();

	public void leftTerm();

	public void arguments();

	public void proof();

	public void term();

	public void function();

	public void statement();

	public void predicate();

	public void parameters();

	public void sort();

	public void modelBinding();

	public void type();

	public void superSort();

	public void subSort();

	public void feature();

	public void qualifier();

	public void featurePath();

	public void entityName();

	public void alias();

	public void language();

	public void assertions();

	public void declarations();

	public void imports();

	public void name();

	public void Theory();

	public void Theory_();

	public void _Theory();

	public void ImportTheories();

	public void ImportTheories_();

	public void ImportTheories_(int initialCapacity);

	public void _ImportTheories();

	public void ImportDeclaration();

	public void ImportDeclaration_();

	public void _ImportDeclaration();

	public void Declarations();

	public void Declarations_();

	public void Declarations_(int initialCapacity);

	public void _Declarations();

	public void Assertions();

	public void Assertions_();

	public void Assertions_(int initialCapacity);

	public void _Assertions();

	public void EntityName();

	public void EntityName_();

	public void _EntityName();

	public void FeatureName();

	public void FeatureName_();

	public void _FeatureName();

	public void LanguageName();

	public void LanguageName(String value);

	public void SimpleFeature();

	public void SimpleFeature(String value);

	public void QualifiedFeature();

	public void QualifiedFeature_();

	public void _QualifiedFeature();

	public void SubtypeDeclaration();

	public void SubtypeDeclaration_();

	public void _SubtypeDeclaration();

	public void NameDeclaration();

	public void NameDeclaration_();

	public void _NameDeclaration();

	public void SortType();

	public void SortType_();

	public void _SortType();

	public void VariableType();

	public void VariableType_();

	public void _VariableType();

	public void FunctionType();

	public void FunctionType_();

	public void _FunctionType();

	public void PredicateType();

	public void PredicateType_();

	public void _PredicateType();

	public void Parameters();

	public void Parameters_();

	public void Parameters_(int initialCapacity);

	public void _Parameters();

	public void VariableDeclaration();

	public void VariableDeclaration_();

	public void _VariableDeclaration();

	public void PredicateDefinition();

	public void PredicateDefinition_();

	public void _PredicateDefinition();

	public void FunctionDefinition();

	public void FunctionDefinition_();

	public void _FunctionDefinition();

	public void Axiom();

	public void Axiom_();

	public void _Axiom();

	public void Theorem();

	public void Theorem_();

	public void _Theorem();

	public void Formulae();

	public void Formulae_();

	public void Formulae_(int initialCapacity);

	public void _Formulae();

	public void PredicateApplication();

	public void PredicateApplication_();

	public void _PredicateApplication();

	public void EqualityPredicateApplication();

	public void EqualityPredicateApplication_();

	public void _EqualityPredicateApplication();

	public void Implication();

	public void Implication_();

	public void _Implication();

	public void Coimplication();

	public void Coimplication_();

	public void _Coimplication();

	public void Xor();

	public void Xor_();

	public void _Xor();

	public void And();

	public void And_();

	public void _And();

	public void Or();

	public void Or_();

	public void _Or();

	public void Not();

	public void Not_();

	public void _Not();

	public void ForAll();

	public void ForAll_();

	public void _ForAll();

	public void Exist();

	public void Exist_();

	public void _Exist();

	public void ExistUnique();

	public void ExistUnique_();

	public void _ExistUnique();

	public void Arguments();

	public void Arguments_();

	public void Arguments_(int initialCapacity);

	public void _Arguments();

	public void SimplePredicate();

	public void SimplePredicate(String value);

	public void QualifiedPredicate();

	public void QualifiedPredicate_();

	public void _QualifiedPredicate();

	public void TheoryName();

	public void TheoryName(String value);

	public void Constant();

	public void Constant(String value);

	public void Variable();

	public void Variable(String value);

	public void FunctionApplication();

	public void FunctionApplication_();

	public void _FunctionApplication();

	public void SimpleFunction();

	public void SimpleFunction(String value);

	public void QualifiedFunction();

	public void QualifiedFunction_();

	public void _QualifiedFunction();

	public void Name();

	public void Name(String value);
}
