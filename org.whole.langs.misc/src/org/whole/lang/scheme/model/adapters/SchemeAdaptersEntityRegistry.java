package org.whole.lang.scheme.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SchemeAdaptersEntityRegistry extends AbstractEntityRegistry {
	public SchemeAdaptersEntityRegistry() {
		super(SchemeEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DefinitionsAdapter());
		put(new DefinitionAdapter());
		put(new BranchesAdapter());
		put(new BranchAdapter());
		put(new SchemeExpressionsAdapter());
		put(new SchemeExpressionAdapter());
		put(new ApplyExpressionAdapter());
		put(new LambdaExpressionAdapter());
		put(new AndExpressionAdapter());
		put(new OrExpressionAdapter());
		put(new CondExpressionAdapter());
		put(new LocalExpressionAdapter());
		put(new IdExpressionAdapter());
		put(new ConstExpressionAdapter());
		put(new ClosureValueAdapter());
		put(new BuiltinValueAdapter());
		put(new BooleanValueAdapter());
		put(new IntValueAdapter());
		put(new StringValueAdapter());
		put(new PairValueAdapter());
		put(new NamesAdapter());
		put(new NameAdapter());
		put(new SchemeEnvironmentAdapter());
	}
}
