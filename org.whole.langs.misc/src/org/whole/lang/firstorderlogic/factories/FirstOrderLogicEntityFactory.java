package org.whole.lang.firstorderlogic.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FirstOrderLogicEntityFactory extends GenericEntityFactory {
	public static final FirstOrderLogicEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static FirstOrderLogicEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new FirstOrderLogicEntityFactory(provider);
	}

	protected FirstOrderLogicEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Theory createTheory() {
		return create(FirstOrderLogicEntityDescriptorEnum.Theory);
	}

	public Theory createTheory(Name name, ImportTheories imports,
			Declarations declarations, Assertions assertions) {
		return create(FirstOrderLogicEntityDescriptorEnum.Theory, name,
				imports, declarations, assertions);
	}

	public IEntityBuilder<Theory> buildTheory() {
		return new EntityBuilder<Theory>(
				create(FirstOrderLogicEntityDescriptorEnum.Theory));
	}

	public ImportTheories createImportTheories() {
		return create(FirstOrderLogicEntityDescriptorEnum.ImportTheories);
	}

	public ImportTheories createImportTheories(ImportDeclaration... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.ImportTheories,
				(IEntity[]) entities);
	}

	public ImportTheories createImportTheories(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.ImportTheories,
				initialSize);
	}

	public ImportDeclaration createImportDeclaration() {
		return create(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration);
	}

	public ImportDeclaration createImportDeclaration(TheoryName language,
			Name alias) {
		return create(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration,
				language, alias);
	}

	public IEntityBuilder<ImportDeclaration> buildImportDeclaration() {
		return new EntityBuilder<ImportDeclaration>(
				create(FirstOrderLogicEntityDescriptorEnum.ImportDeclaration));
	}

	public Declarations createDeclarations() {
		return create(FirstOrderLogicEntityDescriptorEnum.Declarations);
	}

	public Declarations createDeclarations(Declaration... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.Declarations,
				(IEntity[]) entities);
	}

	public Declarations createDeclarations(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.Declarations,
				initialSize);
	}

	public Assertions createAssertions() {
		return create(FirstOrderLogicEntityDescriptorEnum.Assertions);
	}

	public Assertions createAssertions(Assertion... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.Assertions,
				(IEntity[]) entities);
	}

	public Assertions createAssertions(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.Assertions,
				initialSize);
	}

	public EntityName createEntityName() {
		return create(FirstOrderLogicEntityDescriptorEnum.EntityName);
	}

	public EntityName createEntityName(LanguageName language, Name entityName) {
		return create(FirstOrderLogicEntityDescriptorEnum.EntityName, language,
				entityName);
	}

	public IEntityBuilder<EntityName> buildEntityName() {
		return new EntityBuilder<EntityName>(
				create(FirstOrderLogicEntityDescriptorEnum.EntityName));
	}

	public FeatureName createFeatureName() {
		return create(FirstOrderLogicEntityDescriptorEnum.FeatureName);
	}

	public FeatureName createFeatureName(LanguageName language,
			Name entityName, FeaturePath featurePath) {
		return create(FirstOrderLogicEntityDescriptorEnum.FeatureName,
				language, entityName, featurePath);
	}

	public IEntityBuilder<FeatureName> buildFeatureName() {
		return new EntityBuilder<FeatureName>(
				create(FirstOrderLogicEntityDescriptorEnum.FeatureName));
	}

	public LanguageName createLanguageName() {
		return create(FirstOrderLogicEntityDescriptorEnum.LanguageName);
	}

	public LanguageName createLanguageName(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.LanguageName, value);
	}

	public SimpleFeature createSimpleFeature() {
		return create(FirstOrderLogicEntityDescriptorEnum.SimpleFeature);
	}

	public SimpleFeature createSimpleFeature(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.SimpleFeature, value);
	}

	public QualifiedFeature createQualifiedFeature() {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature);
	}

	public QualifiedFeature createQualifiedFeature(SimpleFeature qualifier,
			FeaturePath feature) {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature,
				qualifier, feature);
	}

	public IEntityBuilder<QualifiedFeature> buildQualifiedFeature() {
		return new EntityBuilder<QualifiedFeature>(
				create(FirstOrderLogicEntityDescriptorEnum.QualifiedFeature));
	}

	public SubtypeDeclaration createSubtypeDeclaration() {
		return create(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration);
	}

	public SubtypeDeclaration createSubtypeDeclaration(Name subSort,
			Name superSort) {
		return create(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration,
				subSort, superSort);
	}

	public IEntityBuilder<SubtypeDeclaration> buildSubtypeDeclaration() {
		return new EntityBuilder<SubtypeDeclaration>(
				create(FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration));
	}

	public NameDeclaration createNameDeclaration() {
		return create(FirstOrderLogicEntityDescriptorEnum.NameDeclaration);
	}

	public NameDeclaration createNameDeclaration(Name name, Type type,
			Path modelBinding) {
		return create(FirstOrderLogicEntityDescriptorEnum.NameDeclaration,
				name, type, modelBinding);
	}

	public IEntityBuilder<NameDeclaration> buildNameDeclaration() {
		return new EntityBuilder<NameDeclaration>(
				create(FirstOrderLogicEntityDescriptorEnum.NameDeclaration));
	}

	public SortType createSortType() {
		return create(FirstOrderLogicEntityDescriptorEnum.SortType);
	}

	public VariableType createVariableType() {
		return create(FirstOrderLogicEntityDescriptorEnum.VariableType);
	}

	public VariableType createVariableType(Name sort) {
		return create(FirstOrderLogicEntityDescriptorEnum.VariableType, sort);
	}

	public FunctionType createFunctionType() {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionType);
	}

	public FunctionType createFunctionType(Parameters parameters, Name sort) {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionType,
				parameters, sort);
	}

	public IEntityBuilder<FunctionType> buildFunctionType() {
		return new EntityBuilder<FunctionType>(
				create(FirstOrderLogicEntityDescriptorEnum.FunctionType));
	}

	public PredicateType createPredicateType() {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateType);
	}

	public PredicateType createPredicateType(Parameters parameters) {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateType,
				parameters);
	}

	public Parameters createParameters() {
		return create(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public Parameters createParameters(VariableDeclaration... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.Parameters,
				(IEntity[]) entities);
	}

	public Parameters createParameters(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.Parameters,
				initialSize);
	}

	public VariableDeclaration createVariableDeclaration() {
		return create(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration);
	}

	public VariableDeclaration createVariableDeclaration(Name name, Name sort) {
		return create(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration,
				name, sort);
	}

	public IEntityBuilder<VariableDeclaration> buildVariableDeclaration() {
		return new EntityBuilder<VariableDeclaration>(
				create(FirstOrderLogicEntityDescriptorEnum.VariableDeclaration));
	}

	public PredicateDefinition createPredicateDefinition() {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition);
	}

	public PredicateDefinition createPredicateDefinition(
			SimplePredicate predicate, Parameters parameters, Formula statement) {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition,
				predicate, parameters, statement);
	}

	public IEntityBuilder<PredicateDefinition> buildPredicateDefinition() {
		return new EntityBuilder<PredicateDefinition>(
				create(FirstOrderLogicEntityDescriptorEnum.PredicateDefinition));
	}

	public FunctionDefinition createFunctionDefinition() {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition);
	}

	public FunctionDefinition createFunctionDefinition(SimpleFunction function,
			Parameters parameters, Term term) {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition,
				function, parameters, term);
	}

	public IEntityBuilder<FunctionDefinition> buildFunctionDefinition() {
		return new EntityBuilder<FunctionDefinition>(
				create(FirstOrderLogicEntityDescriptorEnum.FunctionDefinition));
	}

	public Axiom createAxiom() {
		return create(FirstOrderLogicEntityDescriptorEnum.Axiom);
	}

	public Axiom createAxiom(Name name, Formula statement) {
		return create(FirstOrderLogicEntityDescriptorEnum.Axiom, name,
				statement);
	}

	public IEntityBuilder<Axiom> buildAxiom() {
		return new EntityBuilder<Axiom>(
				create(FirstOrderLogicEntityDescriptorEnum.Axiom));
	}

	public Theorem createTheorem() {
		return create(FirstOrderLogicEntityDescriptorEnum.Theorem);
	}

	public Theorem createTheorem(Name name, Formula statement, Formulae proof) {
		return create(FirstOrderLogicEntityDescriptorEnum.Theorem, name,
				statement, proof);
	}

	public IEntityBuilder<Theorem> buildTheorem() {
		return new EntityBuilder<Theorem>(
				create(FirstOrderLogicEntityDescriptorEnum.Theorem));
	}

	public Formulae createFormulae() {
		return create(FirstOrderLogicEntityDescriptorEnum.Formulae);
	}

	public Formulae createFormulae(Formula... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.Formulae,
				(IEntity[]) entities);
	}

	public Formulae createFormulae(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.Formulae, initialSize);
	}

	public PredicateApplication createPredicateApplication() {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateApplication);
	}

	public PredicateApplication createPredicateApplication(Predicate predicate,
			Arguments arguments) {
		return create(FirstOrderLogicEntityDescriptorEnum.PredicateApplication,
				predicate, arguments);
	}

	public IEntityBuilder<PredicateApplication> buildPredicateApplication() {
		return new EntityBuilder<PredicateApplication>(
				create(FirstOrderLogicEntityDescriptorEnum.PredicateApplication));
	}

	public EqualityPredicateApplication createEqualityPredicateApplication() {
		return create(FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication);
	}

	public EqualityPredicateApplication createEqualityPredicateApplication(
			Term leftTerm, Term rightTerm) {
		return create(
				FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication,
				leftTerm, rightTerm);
	}

	public IEntityBuilder<EqualityPredicateApplication> buildEqualityPredicateApplication() {
		return new EntityBuilder<EqualityPredicateApplication>(
				create(FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication));
	}

	public Implication createImplication() {
		return create(FirstOrderLogicEntityDescriptorEnum.Implication);
	}

	public Implication createImplication(Formula antecedent, Formula consequent) {
		return create(FirstOrderLogicEntityDescriptorEnum.Implication,
				antecedent, consequent);
	}

	public IEntityBuilder<Implication> buildImplication() {
		return new EntityBuilder<Implication>(
				create(FirstOrderLogicEntityDescriptorEnum.Implication));
	}

	public Coimplication createCoimplication() {
		return create(FirstOrderLogicEntityDescriptorEnum.Coimplication);
	}

	public Coimplication createCoimplication(Formula leftFormula,
			Formula rightFormula) {
		return create(FirstOrderLogicEntityDescriptorEnum.Coimplication,
				leftFormula, rightFormula);
	}

	public IEntityBuilder<Coimplication> buildCoimplication() {
		return new EntityBuilder<Coimplication>(
				create(FirstOrderLogicEntityDescriptorEnum.Coimplication));
	}

	public Xor createXor() {
		return create(FirstOrderLogicEntityDescriptorEnum.Xor);
	}

	public Xor createXor(Formula leftFormula, Formula rightFormula) {
		return create(FirstOrderLogicEntityDescriptorEnum.Xor, leftFormula,
				rightFormula);
	}

	public IEntityBuilder<Xor> buildXor() {
		return new EntityBuilder<Xor>(
				create(FirstOrderLogicEntityDescriptorEnum.Xor));
	}

	public And createAnd() {
		return create(FirstOrderLogicEntityDescriptorEnum.And);
	}

	public And createAnd(Formula leftFormula, Formula rightFormula) {
		return create(FirstOrderLogicEntityDescriptorEnum.And, leftFormula,
				rightFormula);
	}

	public IEntityBuilder<And> buildAnd() {
		return new EntityBuilder<And>(
				create(FirstOrderLogicEntityDescriptorEnum.And));
	}

	public Or createOr() {
		return create(FirstOrderLogicEntityDescriptorEnum.Or);
	}

	public Or createOr(Formula leftFormula, Formula rightFormula) {
		return create(FirstOrderLogicEntityDescriptorEnum.Or, leftFormula,
				rightFormula);
	}

	public IEntityBuilder<Or> buildOr() {
		return new EntityBuilder<Or>(
				create(FirstOrderLogicEntityDescriptorEnum.Or));
	}

	public Not createNot() {
		return create(FirstOrderLogicEntityDescriptorEnum.Not);
	}

	public Not createNot(Formula formula) {
		return create(FirstOrderLogicEntityDescriptorEnum.Not, formula);
	}

	public ForAll createForAll() {
		return create(FirstOrderLogicEntityDescriptorEnum.ForAll);
	}

	public ForAll createForAll(Parameters parameters, Formula formula) {
		return create(FirstOrderLogicEntityDescriptorEnum.ForAll, parameters,
				formula);
	}

	public IEntityBuilder<ForAll> buildForAll() {
		return new EntityBuilder<ForAll>(
				create(FirstOrderLogicEntityDescriptorEnum.ForAll));
	}

	public Exist createExist() {
		return create(FirstOrderLogicEntityDescriptorEnum.Exist);
	}

	public Exist createExist(Parameters parameters, Formula formula) {
		return create(FirstOrderLogicEntityDescriptorEnum.Exist, parameters,
				formula);
	}

	public IEntityBuilder<Exist> buildExist() {
		return new EntityBuilder<Exist>(
				create(FirstOrderLogicEntityDescriptorEnum.Exist));
	}

	public ExistUnique createExistUnique() {
		return create(FirstOrderLogicEntityDescriptorEnum.ExistUnique);
	}

	public ExistUnique createExistUnique(Parameters parameters, Formula formula) {
		return create(FirstOrderLogicEntityDescriptorEnum.ExistUnique,
				parameters, formula);
	}

	public IEntityBuilder<ExistUnique> buildExistUnique() {
		return new EntityBuilder<ExistUnique>(
				create(FirstOrderLogicEntityDescriptorEnum.ExistUnique));
	}

	public Arguments createArguments() {
		return create(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public Arguments createArguments(Term... entities) {
		return create(FirstOrderLogicEntityDescriptorEnum.Arguments,
				(IEntity[]) entities);
	}

	public Arguments createArguments(int initialSize) {
		return clone(FirstOrderLogicEntityDescriptorEnum.Arguments, initialSize);
	}

	public SimplePredicate createSimplePredicate() {
		return create(FirstOrderLogicEntityDescriptorEnum.SimplePredicate);
	}

	public SimplePredicate createSimplePredicate(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.SimplePredicate,
				value);
	}

	public QualifiedPredicate createQualifiedPredicate() {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate);
	}

	public QualifiedPredicate createQualifiedPredicate(Name theoryAlias,
			SimplePredicate name) {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate,
				theoryAlias, name);
	}

	public IEntityBuilder<QualifiedPredicate> buildQualifiedPredicate() {
		return new EntityBuilder<QualifiedPredicate>(
				create(FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate));
	}

	public TheoryName createTheoryName() {
		return create(FirstOrderLogicEntityDescriptorEnum.TheoryName);
	}

	public TheoryName createTheoryName(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.TheoryName, value);
	}

	public Constant createConstant() {
		return create(FirstOrderLogicEntityDescriptorEnum.Constant);
	}

	public Constant createConstant(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.Constant, value);
	}

	public Variable createVariable() {
		return create(FirstOrderLogicEntityDescriptorEnum.Variable);
	}

	public Variable createVariable(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.Variable, value);
	}

	public FunctionApplication createFunctionApplication() {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionApplication);
	}

	public FunctionApplication createFunctionApplication(Function function,
			Arguments arguments, Term result) {
		return create(FirstOrderLogicEntityDescriptorEnum.FunctionApplication,
				function, arguments, result);
	}

	public IEntityBuilder<FunctionApplication> buildFunctionApplication() {
		return new EntityBuilder<FunctionApplication>(
				create(FirstOrderLogicEntityDescriptorEnum.FunctionApplication));
	}

	public SimpleFunction createSimpleFunction() {
		return create(FirstOrderLogicEntityDescriptorEnum.SimpleFunction);
	}

	public SimpleFunction createSimpleFunction(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.SimpleFunction, value);
	}

	public QualifiedFunction createQualifiedFunction() {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction);
	}

	public QualifiedFunction createQualifiedFunction(Name theoryAlias,
			SimpleFunction name) {
		return create(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction,
				theoryAlias, name);
	}

	public IEntityBuilder<QualifiedFunction> buildQualifiedFunction() {
		return new EntityBuilder<QualifiedFunction>(
				create(FirstOrderLogicEntityDescriptorEnum.QualifiedFunction));
	}

	public Name createName() {
		return create(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(FirstOrderLogicEntityDescriptorEnum.Name, value);
	}
}
