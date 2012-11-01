package org.whole.lang.firstorderlogic.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FirstOrderLogicSpecificBuilderAdapter extends
		GenericBuilderContext implements IFirstOrderLogicBuilder {
	public FirstOrderLogicSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public FirstOrderLogicSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void result() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.result);
	}

	public void theoryAlias() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.theoryAlias);
	}

	public void formula() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.formula);
	}

	public void rightFormula() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.rightFormula);
	}

	public void leftFormula() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.leftFormula);
	}

	public void consequent() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.consequent);
	}

	public void antecedent() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.antecedent);
	}

	public void rightTerm() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.rightTerm);
	}

	public void leftTerm() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.leftTerm);
	}

	public void arguments() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.arguments);
	}

	public void proof() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.proof);
	}

	public void term() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.term);
	}

	public void function() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.function);
	}

	public void statement() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.statement);
	}

	public void predicate() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.predicate);
	}

	public void parameters() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.parameters);
	}

	public void sort() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.sort);
	}

	public void modelBinding() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.modelBinding);
	}

	public void type() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.type);
	}

	public void superSort() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.superSort);
	}

	public void subSort() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.subSort);
	}

	public void feature() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.feature);
	}

	public void qualifier() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.qualifier);
	}

	public void featurePath() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.featurePath);
	}

	public void entityName() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.entityName);
	}

	public void alias() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.alias);
	}

	public void language() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.language);
	}

	public void assertions() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.assertions);
	}

	public void declarations() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.declarations);
	}

	public void imports() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.imports);
	}

	public void name() {
		wFeature(FirstOrderLogicFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Theory() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Theory);
	}

	public void Theory_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Theory);
	}

	public void _Theory() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Theory);
	}

	public void ImportTheories() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.ImportTheories);
	}

	public void ImportTheories_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.ImportTheories);
	}

	public void ImportTheories_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.ImportTheories,
				initialCapacity);
	}

	public void _ImportTheories() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.ImportTheories);
	}

	public void ImportDeclaration() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration);
	}

	public void ImportDeclaration_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration);
	}

	public void _ImportDeclaration() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration);
	}

	public void Declarations() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Declarations);
	}

	public void Declarations_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Declarations);
	}

	public void Declarations_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Declarations,
				initialCapacity);
	}

	public void _Declarations() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Declarations);
	}

	public void Assertions() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Assertions);
	}

	public void Assertions_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Assertions);
	}

	public void Assertions_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Assertions,
				initialCapacity);
	}

	public void _Assertions() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Assertions);
	}

	public void EntityName() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.EntityName);
	}

	public void EntityName_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.EntityName);
	}

	public void _EntityName() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.EntityName);
	}

	public void FeatureName() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.FeatureName);
	}

	public void FeatureName_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.FeatureName);
	}

	public void _FeatureName() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.FeatureName);
	}

	public void LanguageName() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.LanguageName);
	}

	public void LanguageName(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.LanguageName, value);
	}

	public void SimpleFeature() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimpleFeature);
	}

	public void SimpleFeature(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimpleFeature, value);
	}

	public void QualifiedFeature() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature);
	}

	public void QualifiedFeature_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature);
	}

	public void _QualifiedFeature() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature);
	}

	public void SubtypeDeclaration() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration);
	}

	public void SubtypeDeclaration_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration);
	}

	public void _SubtypeDeclaration() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration);
	}

	public void NameDeclaration() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.NameDeclaration);
	}

	public void NameDeclaration_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.NameDeclaration);
	}

	public void _NameDeclaration() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.NameDeclaration);
	}

	public void SortType() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SortType);
	}

	public void SortType_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.SortType);
	}

	public void _SortType() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.SortType);
	}

	public void VariableType() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.VariableType);
	}

	public void VariableType_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.VariableType);
	}

	public void _VariableType() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.VariableType);
	}

	public void FunctionType() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionType);
	}

	public void FunctionType_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.FunctionType);
	}

	public void _FunctionType() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionType);
	}

	public void PredicateType() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateType);
	}

	public void PredicateType_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.PredicateType);
	}

	public void _PredicateType() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateType);
	}

	public void Parameters() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void Parameters_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void Parameters_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Parameters,
				initialCapacity);
	}

	public void _Parameters() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void VariableDeclaration() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclaration_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration);
	}

	public void _VariableDeclaration() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration);
	}

	public void PredicateDefinition() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition);
	}

	public void PredicateDefinition_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition);
	}

	public void _PredicateDefinition() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition);
	}

	public void FunctionDefinition() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition);
	}

	public void FunctionDefinition_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition);
	}

	public void _FunctionDefinition() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition);
	}

	public void Axiom() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Axiom);
	}

	public void Axiom_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Axiom);
	}

	public void _Axiom() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Axiom);
	}

	public void Theorem() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Theorem);
	}

	public void Theorem_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Theorem);
	}

	public void _Theorem() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Theorem);
	}

	public void Formulae() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Formulae);
	}

	public void Formulae_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Formulae);
	}

	public void Formulae_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Formulae, initialCapacity);
	}

	public void _Formulae() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Formulae);
	}

	public void PredicateApplication() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateApplication);
	}

	public void PredicateApplication_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.PredicateApplication);
	}

	public void _PredicateApplication() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.PredicateApplication);
	}

	public void EqualityPredicateApplication() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication);
	}

	public void EqualityPredicateApplication_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication);
	}

	public void _EqualityPredicateApplication() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication);
	}

	public void Implication() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Implication);
	}

	public void Implication_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Implication);
	}

	public void _Implication() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Implication);
	}

	public void Coimplication() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Coimplication);
	}

	public void Coimplication_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Coimplication);
	}

	public void _Coimplication() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Coimplication);
	}

	public void Xor() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Xor);
	}

	public void Xor_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Xor);
	}

	public void _Xor() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Xor);
	}

	public void And() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.And);
	}

	public void And_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.And);
	}

	public void _And() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.And);
	}

	public void Or() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Or);
	}

	public void Or_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Or);
	}

	public void _Or() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Or);
	}

	public void Not() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Not);
	}

	public void Not_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Not);
	}

	public void _Not() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Not);
	}

	public void ForAll() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.ForAll);
	}

	public void ForAll_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.ForAll);
	}

	public void _ForAll() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.ForAll);
	}

	public void Exist() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Exist);
	}

	public void Exist_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Exist);
	}

	public void _Exist() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Exist);
	}

	public void ExistUnique() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.ExistUnique);
	}

	public void ExistUnique_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.ExistUnique);
	}

	public void _ExistUnique() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.ExistUnique);
	}

	public void Arguments() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public void Arguments_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public void Arguments_(int initialCapacity) {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.Arguments, initialCapacity);
	}

	public void _Arguments() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public void SimplePredicate() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimplePredicate);
	}

	public void SimplePredicate(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimplePredicate, value);
	}

	public void QualifiedPredicate() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate);
	}

	public void QualifiedPredicate_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate);
	}

	public void _QualifiedPredicate() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate);
	}

	public void TheoryName() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.TheoryName);
	}

	public void TheoryName(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.TheoryName, value);
	}

	public void Constant() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Constant);
	}

	public void Constant(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Constant, value);
	}

	public void Variable() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Variable);
	}

	public void Variable(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Variable, value);
	}

	public void FunctionApplication() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionApplication);
	}

	public void FunctionApplication_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.FunctionApplication);
	}

	public void _FunctionApplication() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.FunctionApplication);
	}

	public void SimpleFunction() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimpleFunction);
	}

	public void SimpleFunction(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.SimpleFunction, value);
	}

	public void QualifiedFunction() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction);
	}

	public void QualifiedFunction_() {
		wEntity_(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction);
	}

	public void _QualifiedFunction() {
		_wEntity(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction);
	}

	public void Name() {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(FirstOrderLogicEntityDescriptorEnum.Name, value);
	}
}
