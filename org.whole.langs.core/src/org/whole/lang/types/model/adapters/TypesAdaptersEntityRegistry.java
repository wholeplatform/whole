package org.whole.lang.types.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypesAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TypesAdaptersEntityRegistry() {
		super(TypesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TypeSystemAdapter());
		put(new TypeRulesAdapter());
		put(new TypeRuleAdapter());
		put(new TypeAdapter());
		put(new ArgumentTypeAdapter());
		put(new BasicTypeAdapter());
		put(new AnyTypeAdapter());
		put(new LegacyTypeAdapter());
		put(new VariableTypeAdapter());
		put(new DomainTypeAdapter());
		put(new EntityTypeAdapter());
		put(new UnionTypeAdapter());
		put(new FeatureTypeAdapter());
		put(new FeatureTableTypeAdapter());
		put(new ArgumentsAdapter());
		put(new CasesAdapter());
		put(new CaseAdapter());
		put(new ExpressionsAdapter());
		put(new OrExpressionsAdapter());
		put(new TypeExpressionsAdapter());
		put(new TypeExpressionAdapter());
		put(new SubtypeAdapter());
		put(new SupertypeAdapter());
		put(new OperationsAdapter());
	}
}
