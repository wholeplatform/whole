package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FirstOrderLogicImplEntityRegistry extends AbstractEntityRegistry {
	public FirstOrderLogicImplEntityRegistry() {
		super(FirstOrderLogicEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TheoryImpl());
		put(new ImportTheoriesImpl());
		put(new ImportDeclarationImpl());
		put(new DeclarationsImpl());
		put(new AssertionsImpl());
		put(new EntityNameImpl());
		put(new FeatureNameImpl());
		put(new LanguageNameImpl());
		put(new SimpleFeatureImpl());
		put(new QualifiedFeatureImpl());
		put(new SubtypeDeclarationImpl());
		put(new NameDeclarationImpl());
		put(new SortTypeImpl());
		put(new VariableTypeImpl());
		put(new FunctionTypeImpl());
		put(new PredicateTypeImpl());
		put(new ParametersImpl());
		put(new VariableDeclarationImpl());
		put(new PredicateDefinitionImpl());
		put(new FunctionDefinitionImpl());
		put(new AxiomImpl());
		put(new TheoremImpl());
		put(new FormulaeImpl());
		put(new PredicateApplicationImpl());
		put(new EqualityPredicateApplicationImpl());
		put(new ImplicationImpl());
		put(new CoimplicationImpl());
		put(new XorImpl());
		put(new AndImpl());
		put(new OrImpl());
		put(new NotImpl());
		put(new ForAllImpl());
		put(new ExistImpl());
		put(new ExistUniqueImpl());
		put(new ArgumentsImpl());
		put(new SimplePredicateImpl());
		put(new QualifiedPredicateImpl());
		put(new TheoryNameImpl());
		put(new ConstantImpl());
		put(new VariableImpl());
		put(new FunctionApplicationImpl());
		put(new SimpleFunctionImpl());
		put(new QualifiedFunctionImpl());
		put(new NameImpl());
	}
}
