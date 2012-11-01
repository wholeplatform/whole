package org.whole.lang.scheme.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SchemeImplEntityRegistry extends AbstractEntityRegistry {
	public SchemeImplEntityRegistry() {
		super(SchemeEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DefinitionsImpl());
		put(new DefinitionImpl());
		put(new BranchesImpl());
		put(new BranchImpl());
		put(new SchemeExpressionsImpl());
		put(new ApplyExpressionImpl());
		put(new LambdaExpressionImpl());
		put(new AndExpressionImpl());
		put(new OrExpressionImpl());
		put(new CondExpressionImpl());
		put(new LocalExpressionImpl());
		put(new IdExpressionImpl());
		put(new ClosureValueImpl());
		put(new BuiltinValueImpl());
		put(new BooleanValueImpl());
		put(new IntValueImpl());
		put(new StringValueImpl());
		put(new PairValueImpl());
		put(new NamesImpl());
		put(new NameImpl());
		put(new SchemeEnvironmentImpl());
	}
}
