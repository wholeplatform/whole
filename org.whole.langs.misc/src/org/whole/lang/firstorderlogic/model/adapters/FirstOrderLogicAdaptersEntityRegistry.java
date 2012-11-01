package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FirstOrderLogicAdaptersEntityRegistry extends
		AbstractEntityRegistry {
	public FirstOrderLogicAdaptersEntityRegistry() {
		super(FirstOrderLogicEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TheoryAdapter());
		put(new ImportTheoriesAdapter());
		put(new ImportDeclarationAdapter());
		put(new DeclarationsAdapter());
		put(new AssertionsAdapter());
		put(new EntityNameAdapter());
		put(new FeatureNameAdapter());
		put(new LanguageNameAdapter());
		put(new SimpleFeatureAdapter());
		put(new QualifiedFeatureAdapter());
		put(new SubtypeDeclarationAdapter());
		put(new NameDeclarationAdapter());
		put(new SortTypeAdapter());
		put(new VariableTypeAdapter());
		put(new FunctionTypeAdapter());
		put(new PredicateTypeAdapter());
		put(new ParametersAdapter());
		put(new VariableDeclarationAdapter());
		put(new PredicateDefinitionAdapter());
		put(new FunctionDefinitionAdapter());
		put(new AxiomAdapter());
		put(new TheoremAdapter());
		put(new FormulaeAdapter());
		put(new PredicateApplicationAdapter());
		put(new EqualityPredicateApplicationAdapter());
		put(new ImplicationAdapter());
		put(new CoimplicationAdapter());
		put(new XorAdapter());
		put(new AndAdapter());
		put(new OrAdapter());
		put(new NotAdapter());
		put(new ForAllAdapter());
		put(new ExistAdapter());
		put(new ExistUniqueAdapter());
		put(new ArgumentsAdapter());
		put(new SimplePredicateAdapter());
		put(new QualifiedPredicateAdapter());
		put(new TheoryNameAdapter());
		put(new ConstantAdapter());
		put(new VariableAdapter());
		put(new FunctionApplicationAdapter());
		put(new SimpleFunctionAdapter());
		put(new QualifiedFunctionAdapter());
		put(new NameAdapter());
		put(new FormulaAdapter());
		put(new TypeAdapter());
		put(new FunctionAdapter());
		put(new DeclarationAdapter());
		put(new TermAdapter());
		put(new PathAdapter());
		put(new AssertionAdapter());
		put(new PredicateAdapter());
		put(new FeaturePathAdapter());
	}
}
