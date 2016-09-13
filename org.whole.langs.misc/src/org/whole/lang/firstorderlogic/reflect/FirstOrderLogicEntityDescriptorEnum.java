package org.whole.lang.firstorderlogic.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class FirstOrderLogicEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Theory_ord = 0;
	public static final int ImportTheories_ord = 1;
	public static final int ImportDeclaration_ord = 2;
	public static final int Declarations_ord = 3;
	public static final int Assertions_ord = 4;
	public static final int EntityName_ord = 5;
	public static final int FeatureName_ord = 6;
	public static final int LanguageName_ord = 7;
	public static final int SimpleFeature_ord = 8;
	public static final int QualifiedFeature_ord = 9;
	public static final int SubtypeDeclaration_ord = 10;
	public static final int NameDeclaration_ord = 11;
	public static final int SortType_ord = 12;
	public static final int VariableType_ord = 13;
	public static final int FunctionType_ord = 14;
	public static final int PredicateType_ord = 15;
	public static final int Parameters_ord = 16;
	public static final int VariableDeclaration_ord = 17;
	public static final int PredicateDefinition_ord = 18;
	public static final int FunctionDefinition_ord = 19;
	public static final int Axiom_ord = 20;
	public static final int Theorem_ord = 21;
	public static final int Formulae_ord = 22;
	public static final int PredicateApplication_ord = 23;
	public static final int EqualityPredicateApplication_ord = 24;
	public static final int Implication_ord = 25;
	public static final int Coimplication_ord = 26;
	public static final int Xor_ord = 27;
	public static final int And_ord = 28;
	public static final int Or_ord = 29;
	public static final int Not_ord = 30;
	public static final int ForAll_ord = 31;
	public static final int Exist_ord = 32;
	public static final int ExistUnique_ord = 33;
	public static final int Arguments_ord = 34;
	public static final int SimplePredicate_ord = 35;
	public static final int QualifiedPredicate_ord = 36;
	public static final int TheoryName_ord = 37;
	public static final int Constant_ord = 38;
	public static final int Variable_ord = 39;
	public static final int FunctionApplication_ord = 40;
	public static final int SimpleFunction_ord = 41;
	public static final int QualifiedFunction_ord = 42;
	public static final int Name_ord = 43;
	public static final int Formula_ord = 44;
	public static final int Type_ord = 45;
	public static final int Function_ord = 46;
	public static final int Declaration_ord = 47;
	public static final int Term_ord = 48;
	public static final int Path_ord = 49;
	public static final int Assertion_ord = 50;
	public static final int Predicate_ord = 51;
	public static final int FeaturePath_ord = 52;
	public static final FirstOrderLogicEntityDescriptorEnum instance = new FirstOrderLogicEntityDescriptorEnum();
	public static final EntityDescriptor<Theory> Theory = (EntityDescriptor<Theory>) instance
			.valueOf(Theory_ord);
	public static final EntityDescriptor<ImportTheories> ImportTheories = (EntityDescriptor<ImportTheories>) instance
			.valueOf(ImportTheories_ord);
	public static final EntityDescriptor<ImportDeclaration> ImportDeclaration = (EntityDescriptor<ImportDeclaration>) instance
			.valueOf(ImportDeclaration_ord);
	public static final EntityDescriptor<Declarations> Declarations = (EntityDescriptor<Declarations>) instance
			.valueOf(Declarations_ord);
	public static final EntityDescriptor<Assertions> Assertions = (EntityDescriptor<Assertions>) instance
			.valueOf(Assertions_ord);
	public static final EntityDescriptor<EntityName> EntityName = (EntityDescriptor<EntityName>) instance
			.valueOf(EntityName_ord);
	public static final EntityDescriptor<FeatureName> FeatureName = (EntityDescriptor<FeatureName>) instance
			.valueOf(FeatureName_ord);
	public static final EntityDescriptor<LanguageName> LanguageName = (EntityDescriptor<LanguageName>) instance
			.valueOf(LanguageName_ord);
	public static final EntityDescriptor<SimpleFeature> SimpleFeature = (EntityDescriptor<SimpleFeature>) instance
			.valueOf(SimpleFeature_ord);
	public static final EntityDescriptor<QualifiedFeature> QualifiedFeature = (EntityDescriptor<QualifiedFeature>) instance
			.valueOf(QualifiedFeature_ord);
	public static final EntityDescriptor<SubtypeDeclaration> SubtypeDeclaration = (EntityDescriptor<SubtypeDeclaration>) instance
			.valueOf(SubtypeDeclaration_ord);
	public static final EntityDescriptor<NameDeclaration> NameDeclaration = (EntityDescriptor<NameDeclaration>) instance
			.valueOf(NameDeclaration_ord);
	public static final EntityDescriptor<SortType> SortType = (EntityDescriptor<SortType>) instance
			.valueOf(SortType_ord);
	public static final EntityDescriptor<VariableType> VariableType = (EntityDescriptor<VariableType>) instance
			.valueOf(VariableType_ord);
	public static final EntityDescriptor<FunctionType> FunctionType = (EntityDescriptor<FunctionType>) instance
			.valueOf(FunctionType_ord);
	public static final EntityDescriptor<PredicateType> PredicateType = (EntityDescriptor<PredicateType>) instance
			.valueOf(PredicateType_ord);
	public static final EntityDescriptor<Parameters> Parameters = (EntityDescriptor<Parameters>) instance
			.valueOf(Parameters_ord);
	public static final EntityDescriptor<VariableDeclaration> VariableDeclaration = (EntityDescriptor<VariableDeclaration>) instance
			.valueOf(VariableDeclaration_ord);
	public static final EntityDescriptor<PredicateDefinition> PredicateDefinition = (EntityDescriptor<PredicateDefinition>) instance
			.valueOf(PredicateDefinition_ord);
	public static final EntityDescriptor<FunctionDefinition> FunctionDefinition = (EntityDescriptor<FunctionDefinition>) instance
			.valueOf(FunctionDefinition_ord);
	public static final EntityDescriptor<Axiom> Axiom = (EntityDescriptor<Axiom>) instance
			.valueOf(Axiom_ord);
	public static final EntityDescriptor<Theorem> Theorem = (EntityDescriptor<Theorem>) instance
			.valueOf(Theorem_ord);
	public static final EntityDescriptor<Formulae> Formulae = (EntityDescriptor<Formulae>) instance
			.valueOf(Formulae_ord);
	public static final EntityDescriptor<PredicateApplication> PredicateApplication = (EntityDescriptor<PredicateApplication>) instance
			.valueOf(PredicateApplication_ord);
	public static final EntityDescriptor<EqualityPredicateApplication> EqualityPredicateApplication = (EntityDescriptor<EqualityPredicateApplication>) instance
			.valueOf(EqualityPredicateApplication_ord);
	public static final EntityDescriptor<Implication> Implication = (EntityDescriptor<Implication>) instance
			.valueOf(Implication_ord);
	public static final EntityDescriptor<Coimplication> Coimplication = (EntityDescriptor<Coimplication>) instance
			.valueOf(Coimplication_ord);
	public static final EntityDescriptor<Xor> Xor = (EntityDescriptor<Xor>) instance
			.valueOf(Xor_ord);
	public static final EntityDescriptor<And> And = (EntityDescriptor<And>) instance
			.valueOf(And_ord);
	public static final EntityDescriptor<Or> Or = (EntityDescriptor<Or>) instance
			.valueOf(Or_ord);
	public static final EntityDescriptor<Not> Not = (EntityDescriptor<Not>) instance
			.valueOf(Not_ord);
	public static final EntityDescriptor<ForAll> ForAll = (EntityDescriptor<ForAll>) instance
			.valueOf(ForAll_ord);
	public static final EntityDescriptor<Exist> Exist = (EntityDescriptor<Exist>) instance
			.valueOf(Exist_ord);
	public static final EntityDescriptor<ExistUnique> ExistUnique = (EntityDescriptor<ExistUnique>) instance
			.valueOf(ExistUnique_ord);
	public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance
			.valueOf(Arguments_ord);
	public static final EntityDescriptor<SimplePredicate> SimplePredicate = (EntityDescriptor<SimplePredicate>) instance
			.valueOf(SimplePredicate_ord);
	public static final EntityDescriptor<QualifiedPredicate> QualifiedPredicate = (EntityDescriptor<QualifiedPredicate>) instance
			.valueOf(QualifiedPredicate_ord);
	public static final EntityDescriptor<TheoryName> TheoryName = (EntityDescriptor<TheoryName>) instance
			.valueOf(TheoryName_ord);
	public static final EntityDescriptor<Constant> Constant = (EntityDescriptor<Constant>) instance
			.valueOf(Constant_ord);
	public static final EntityDescriptor<Variable> Variable = (EntityDescriptor<Variable>) instance
			.valueOf(Variable_ord);
	public static final EntityDescriptor<FunctionApplication> FunctionApplication = (EntityDescriptor<FunctionApplication>) instance
			.valueOf(FunctionApplication_ord);
	public static final EntityDescriptor<SimpleFunction> SimpleFunction = (EntityDescriptor<SimpleFunction>) instance
			.valueOf(SimpleFunction_ord);
	public static final EntityDescriptor<QualifiedFunction> QualifiedFunction = (EntityDescriptor<QualifiedFunction>) instance
			.valueOf(QualifiedFunction_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<Formula> Formula = (EntityDescriptor<Formula>) instance
			.valueOf(Formula_ord);
	public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance
			.valueOf(Type_ord);
	public static final EntityDescriptor<Function> Function = (EntityDescriptor<Function>) instance
			.valueOf(Function_ord);
	public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance
			.valueOf(Declaration_ord);
	public static final EntityDescriptor<Term> Term = (EntityDescriptor<Term>) instance
			.valueOf(Term_ord);
	public static final EntityDescriptor<Path> Path = (EntityDescriptor<Path>) instance
			.valueOf(Path_ord);
	public static final EntityDescriptor<Assertion> Assertion = (EntityDescriptor<Assertion>) instance
			.valueOf(Assertion_ord);
	public static final EntityDescriptor<Predicate> Predicate = (EntityDescriptor<Predicate>) instance
			.valueOf(Predicate_ord);
	public static final EntityDescriptor<FeaturePath> FeaturePath = (EntityDescriptor<FeaturePath>) instance
			.valueOf(FeaturePath_ord);

	private FirstOrderLogicEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Theory_ord, "Theory", Theory.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.imports,
						ImportTheories_ord, true, false, false, false, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.declarations,
						Declarations_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.assertions,
						Assertions_ord);
		putCompositeEntity(
		ImportTheories_ord, "ImportTheories", ImportTheories.class, false, ImportDeclaration_ord, true, false);
		putSimpleEntity(ImportDeclaration_ord, "ImportDeclaration",
				ImportDeclaration.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.language, TheoryName_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.alias,
						Name_ord, true, false, false, false, false);
		putCompositeEntity(
		Declarations_ord, "Declarations", Declarations.class, false, Declaration_ord, true, false);
		putCompositeEntity(
		Assertions_ord, "Assertions", Assertions.class, false, Assertion_ord, true, false);
		putSimpleEntity(EntityName_ord, "EntityName", EntityName.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.language,
						LanguageName_ord).withFeature(
						FirstOrderLogicFeatureDescriptorEnum.entityName,
						Name_ord);
		putSimpleEntity(FeatureName_ord, "FeatureName", FeatureName.class,
				false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.language,
						LanguageName_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.entityName,
						Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.featurePath,
						FeaturePath_ord);
		putDataEntity(LanguageName_ord, "LanguageName", LanguageName.class,
				false, String.class);
		putDataEntity(SimpleFeature_ord, "SimpleFeature", SimpleFeature.class,
				false, String.class);
		putSimpleEntity(QualifiedFeature_ord, "QualifiedFeature",
				QualifiedFeature.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.qualifier,
				SimpleFeature_ord).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.feature, FeaturePath_ord);
		putSimpleEntity(SubtypeDeclaration_ord, "SubtypeDeclaration",
				SubtypeDeclaration.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.subSort, Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.superSort,
						Name_ord);
		putSimpleEntity(NameDeclaration_ord, "NameDeclaration",
				NameDeclaration.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.type,
						Type_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.modelBinding,
						Path_ord);
		putSimpleEntity(SortType_ord, "SortType", SortType.class, false);
		putSimpleEntity(VariableType_ord, "VariableType", VariableType.class,
				false).withFeature(FirstOrderLogicFeatureDescriptorEnum.sort,
				Name_ord);
		putSimpleEntity(FunctionType_ord, "FunctionType", FunctionType.class,
				false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.parameters,
				Parameters_ord, true, false, false, false, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.sort, Name_ord);
		putSimpleEntity(PredicateType_ord, "PredicateType",
				PredicateType.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.parameters,
				Parameters_ord, true, false, false, false, false);
		putCompositeEntity(
		Parameters_ord, "Parameters", Parameters.class, false, VariableDeclaration_ord, true, false);
		putSimpleEntity(VariableDeclaration_ord, "VariableDeclaration",
				VariableDeclaration.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.name, Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.sort,
						Name_ord, true, false, false, false, false);
		putSimpleEntity(PredicateDefinition_ord, "PredicateDefinition",
				PredicateDefinition.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.predicate,
						SimplePredicate_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.parameters,
						Parameters_ord, true, false, false, false, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.statement,
						Formula_ord);
		putSimpleEntity(FunctionDefinition_ord, "FunctionDefinition",
				FunctionDefinition.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.function,
						SimpleFunction_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.parameters,
						Parameters_ord, true, false, false, false, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.term,
						Term_ord);
		putSimpleEntity(Axiom_ord, "Axiom", Axiom.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.name, Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.statement,
						Formula_ord);
		putSimpleEntity(Theorem_ord, "Theorem", Theorem.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.statement,
						Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.proof,
						Formulae_ord);
		putCompositeEntity(
		Formulae_ord, "Formulae", Formulae.class, false, Formula_ord, true, false);
		putSimpleEntity(PredicateApplication_ord, "PredicateApplication",
				PredicateApplication.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.predicate, Predicate_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.arguments,
						Arguments_ord);
		putSimpleEntity(EqualityPredicateApplication_ord,
				"EqualityPredicateApplication",
				EqualityPredicateApplication.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.leftTerm, Term_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.rightTerm,
						Term_ord);
		putSimpleEntity(Implication_ord, "Implication", Implication.class,
				false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.antecedent, Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.consequent,
						Formula_ord);
		putSimpleEntity(Coimplication_ord, "Coimplication",
				Coimplication.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.leftFormula, Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.rightFormula,
						Formula_ord);
		putSimpleEntity(Xor_ord, "Xor", Xor.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.leftFormula, Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.rightFormula,
						Formula_ord);
		putSimpleEntity(And_ord, "And", And.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.leftFormula, Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.rightFormula,
						Formula_ord);
		putSimpleEntity(Or_ord, "Or", Or.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.leftFormula, Formula_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.rightFormula,
						Formula_ord);
		putSimpleEntity(Not_ord, "Not", Not.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.formula, Formula_ord);
		putSimpleEntity(ForAll_ord, "ForAll", ForAll.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.parameters,
						Parameters_ord).withFeature(
						FirstOrderLogicFeatureDescriptorEnum.formula,
						Formula_ord);
		putSimpleEntity(Exist_ord, "Exist", Exist.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.parameters,
						Parameters_ord).withFeature(
						FirstOrderLogicFeatureDescriptorEnum.formula,
						Formula_ord);
		putSimpleEntity(ExistUnique_ord, "ExistUnique", ExistUnique.class,
				false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.parameters,
						Parameters_ord).withFeature(
						FirstOrderLogicFeatureDescriptorEnum.formula,
						Formula_ord);
		putCompositeEntity(
		Arguments_ord, "Arguments", Arguments.class, false, Term_ord, true, false);
		putDataEntity(SimplePredicate_ord, "SimplePredicate",
				SimplePredicate.class, false, String.class);
		putSimpleEntity(QualifiedPredicate_ord, "QualifiedPredicate",
				QualifiedPredicate.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.theoryAlias, Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.name,
						SimplePredicate_ord);
		putDataEntity(TheoryName_ord, "TheoryName", TheoryName.class, false,
				String.class);
		putDataEntity(Constant_ord, "Constant", Constant.class, false,
				String.class);
		putDataEntity(Variable_ord, "Variable", Variable.class, false,
				String.class);
		putSimpleEntity(FunctionApplication_ord, "FunctionApplication",
				FunctionApplication.class, false)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.function,
						Function_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.arguments,
						Arguments_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.result,
						Term_ord, false, false, false, true, false);
		putDataEntity(SimpleFunction_ord, "SimpleFunction",
				SimpleFunction.class, false, String.class);
		putSimpleEntity(QualifiedFunction_ord, "QualifiedFunction",
				QualifiedFunction.class, false).withFeature(
				FirstOrderLogicFeatureDescriptorEnum.theoryAlias, Name_ord)
				.withFeature(FirstOrderLogicFeatureDescriptorEnum.name,
						SimpleFunction_ord);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putSimpleEntity(Formula_ord, "Formula", Formula.class, true,
				Implication_ord, Or_ord, Exist_ord, Coimplication_ord,
				ExistUnique_ord, EqualityPredicateApplication_ord, Xor_ord,
				ForAll_ord, And_ord, PredicateApplication_ord, Not_ord);
		putSimpleEntity(Type_ord, "Type", Type.class, true, PredicateType_ord,
				SortType_ord, VariableType_ord, FunctionType_ord);
		putSimpleEntity(Function_ord, "Function", Function.class, true,
				QualifiedFunction_ord, SimpleFunction_ord);
		putSimpleEntity(Declaration_ord, "Declaration", Declaration.class,
				true, SubtypeDeclaration_ord, NameDeclaration_ord);
		putSimpleEntity(Term_ord, "Term", Term.class, true, Variable_ord,
				Constant_ord, FunctionApplication_ord);
		putSimpleEntity(Path_ord, "Path", Path.class, true, FeatureName_ord,
				EntityName_ord);
		putSimpleEntity(Assertion_ord, "Assertion", Assertion.class, true,
				Theorem_ord, PredicateDefinition_ord, Axiom_ord,
				FunctionDefinition_ord);
		putSimpleEntity(Predicate_ord, "Predicate", Predicate.class, true,
				QualifiedPredicate_ord, SimplePredicate_ord);
		putSimpleEntity(FeaturePath_ord, "FeaturePath", FeaturePath.class,
				true, QualifiedFeature_ord, SimpleFeature_ord);
	}
}
