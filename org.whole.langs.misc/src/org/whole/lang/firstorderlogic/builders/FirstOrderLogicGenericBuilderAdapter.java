package org.whole.lang.firstorderlogic.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FirstOrderLogicGenericBuilderAdapter extends
		GenericIdentityBuilder {
	private IFirstOrderLogicBuilder specificBuilder;

	public FirstOrderLogicGenericBuilderAdapter(
			IFirstOrderLogicBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public FirstOrderLogicGenericBuilderAdapter(
			IFirstOrderLogicBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case FirstOrderLogicFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.imports_ord:
			specificBuilder.imports();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.assertions_ord:
			specificBuilder.assertions();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.language_ord:
			specificBuilder.language();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.alias_ord:
			specificBuilder.alias();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.entityName_ord:
			specificBuilder.entityName();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.featurePath_ord:
			specificBuilder.featurePath();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.qualifier_ord:
			specificBuilder.qualifier();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.feature_ord:
			specificBuilder.feature();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.subSort_ord:
			specificBuilder.subSort();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.superSort_ord:
			specificBuilder.superSort();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.modelBinding_ord:
			specificBuilder.modelBinding();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.sort_ord:
			specificBuilder.sort();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.parameters_ord:
			specificBuilder.parameters();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.predicate_ord:
			specificBuilder.predicate();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.statement_ord:
			specificBuilder.statement();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.function_ord:
			specificBuilder.function();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.term_ord:
			specificBuilder.term();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.proof_ord:
			specificBuilder.proof();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.arguments_ord:
			specificBuilder.arguments();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.leftTerm_ord:
			specificBuilder.leftTerm();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.rightTerm_ord:
			specificBuilder.rightTerm();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.antecedent_ord:
			specificBuilder.antecedent();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.consequent_ord:
			specificBuilder.consequent();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.leftFormula_ord:
			specificBuilder.leftFormula();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.rightFormula_ord:
			specificBuilder.rightFormula();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.formula_ord:
			specificBuilder.formula();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.theoryAlias_ord:
			specificBuilder.theoryAlias();
			break;
		case FirstOrderLogicFeatureDescriptorEnum.result_ord:
			specificBuilder.result();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FirstOrderLogicEntityDescriptorEnum.Theory_ord:
			specificBuilder.Theory();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord:
			specificBuilder.ImportTheories();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportDeclaration_ord:
			specificBuilder.ImportDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Assertions_ord:
			specificBuilder.Assertions();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EntityName_ord:
			specificBuilder.EntityName();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FeatureName_ord:
			specificBuilder.FeatureName();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFeature_ord:
			specificBuilder.QualifiedFeature();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration_ord:
			specificBuilder.SubtypeDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.NameDeclaration_ord:
			specificBuilder.NameDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SortType_ord:
			specificBuilder.SortType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableType_ord:
			specificBuilder.VariableType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionType_ord:
			specificBuilder.FunctionType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateType_ord:
			specificBuilder.PredicateType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateDefinition_ord:
			specificBuilder.PredicateDefinition();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionDefinition_ord:
			specificBuilder.FunctionDefinition();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Axiom_ord:
			specificBuilder.Axiom();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Theorem_ord:
			specificBuilder.Theorem();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Formulae_ord:
			specificBuilder.Formulae();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateApplication_ord:
			specificBuilder.PredicateApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord:
			specificBuilder.EqualityPredicateApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Implication_ord:
			specificBuilder.Implication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Coimplication_ord:
			specificBuilder.Coimplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Xor_ord:
			specificBuilder.Xor();
			break;
		case FirstOrderLogicEntityDescriptorEnum.And_ord:
			specificBuilder.And();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Or_ord:
			specificBuilder.Or();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Not_ord:
			specificBuilder.Not();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ForAll_ord:
			specificBuilder.ForAll();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Exist_ord:
			specificBuilder.Exist();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ExistUnique_ord:
			specificBuilder.ExistUnique();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate_ord:
			specificBuilder.QualifiedPredicate();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionApplication_ord:
			specificBuilder.FunctionApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFunction_ord:
			specificBuilder.QualifiedFunction();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FirstOrderLogicEntityDescriptorEnum.Theory_ord:
			specificBuilder.Theory_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord:
			specificBuilder.ImportTheories_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportDeclaration_ord:
			specificBuilder.ImportDeclaration_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Assertions_ord:
			specificBuilder.Assertions_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EntityName_ord:
			specificBuilder.EntityName_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FeatureName_ord:
			specificBuilder.FeatureName_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFeature_ord:
			specificBuilder.QualifiedFeature_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration_ord:
			specificBuilder.SubtypeDeclaration_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.NameDeclaration_ord:
			specificBuilder.NameDeclaration_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SortType_ord:
			specificBuilder.SortType_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableType_ord:
			specificBuilder.VariableType_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionType_ord:
			specificBuilder.FunctionType_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateType_ord:
			specificBuilder.PredicateType_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateDefinition_ord:
			specificBuilder.PredicateDefinition_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionDefinition_ord:
			specificBuilder.FunctionDefinition_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Axiom_ord:
			specificBuilder.Axiom_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Theorem_ord:
			specificBuilder.Theorem_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Formulae_ord:
			specificBuilder.Formulae_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateApplication_ord:
			specificBuilder.PredicateApplication_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord:
			specificBuilder.EqualityPredicateApplication_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Implication_ord:
			specificBuilder.Implication_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Coimplication_ord:
			specificBuilder.Coimplication_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Xor_ord:
			specificBuilder.Xor_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.And_ord:
			specificBuilder.And_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Or_ord:
			specificBuilder.Or_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Not_ord:
			specificBuilder.Not_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ForAll_ord:
			specificBuilder.ForAll_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Exist_ord:
			specificBuilder.Exist_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ExistUnique_ord:
			specificBuilder.ExistUnique_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate_ord:
			specificBuilder.QualifiedPredicate_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionApplication_ord:
			specificBuilder.FunctionApplication_();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFunction_ord:
			specificBuilder.QualifiedFunction_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FirstOrderLogicEntityDescriptorEnum.Theory_ord:
			specificBuilder._Theory();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord:
			specificBuilder._ImportTheories();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportDeclaration_ord:
			specificBuilder._ImportDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Declarations_ord:
			specificBuilder._Declarations();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Assertions_ord:
			specificBuilder._Assertions();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EntityName_ord:
			specificBuilder._EntityName();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FeatureName_ord:
			specificBuilder._FeatureName();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFeature_ord:
			specificBuilder._QualifiedFeature();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration_ord:
			specificBuilder._SubtypeDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.NameDeclaration_ord:
			specificBuilder._NameDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.SortType_ord:
			specificBuilder._SortType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableType_ord:
			specificBuilder._VariableType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionType_ord:
			specificBuilder._FunctionType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateType_ord:
			specificBuilder._PredicateType();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Parameters_ord:
			specificBuilder._Parameters();
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder._VariableDeclaration();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateDefinition_ord:
			specificBuilder._PredicateDefinition();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionDefinition_ord:
			specificBuilder._FunctionDefinition();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Axiom_ord:
			specificBuilder._Axiom();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Theorem_ord:
			specificBuilder._Theorem();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Formulae_ord:
			specificBuilder._Formulae();
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateApplication_ord:
			specificBuilder._PredicateApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord:
			specificBuilder._EqualityPredicateApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Implication_ord:
			specificBuilder._Implication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Coimplication_ord:
			specificBuilder._Coimplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Xor_ord:
			specificBuilder._Xor();
			break;
		case FirstOrderLogicEntityDescriptorEnum.And_ord:
			specificBuilder._And();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Or_ord:
			specificBuilder._Or();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Not_ord:
			specificBuilder._Not();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ForAll_ord:
			specificBuilder._ForAll();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Exist_ord:
			specificBuilder._Exist();
			break;
		case FirstOrderLogicEntityDescriptorEnum.ExistUnique_ord:
			specificBuilder._ExistUnique();
			break;
		case FirstOrderLogicEntityDescriptorEnum.Arguments_ord:
			specificBuilder._Arguments();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate_ord:
			specificBuilder._QualifiedPredicate();
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionApplication_ord:
			specificBuilder._FunctionApplication();
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFunction_ord:
			specificBuilder._QualifiedFunction();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord:
			specificBuilder.ImportTheories_(initialCapacity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_(initialCapacity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Assertions_ord:
			specificBuilder.Assertions_(initialCapacity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_(initialCapacity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Formulae_ord:
			specificBuilder.Formulae_(initialCapacity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Arguments_ord:
			specificBuilder.Arguments_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case FirstOrderLogicEntityDescriptorEnum.LanguageName_ord:
			specificBuilder.LanguageName(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimpleFeature_ord:
			specificBuilder.SimpleFeature(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimplePredicate_ord:
			specificBuilder.SimplePredicate(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.TheoryName_ord:
			specificBuilder.TheoryName(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Constant_ord:
			specificBuilder.Constant(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Variable_ord:
			specificBuilder.Variable(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimpleFunction_ord:
			specificBuilder.SimpleFunction(value);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		}
	}
}
