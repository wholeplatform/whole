package org.whole.lang.types.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypesImplEntityRegistry extends AbstractEntityRegistry {
	public TypesImplEntityRegistry() {
		super(TypesEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TypeSystemImpl());
		put(new TypeRulesImpl());
		put(new TypeRuleImpl());
		put(new AnyTypeImpl());
		put(new LegacyTypeImpl());
		put(new VariableTypeImpl());
		put(new EntityTypeImpl());
		put(new UnionTypeImpl());
		put(new FeatureTypeImpl());
		put(new FeatureTableTypeImpl());
		put(new ArgumentsImpl());
		put(new CasesImpl());
		put(new CaseImpl());
		put(new OrExpressionsImpl());
		put(new TypeExpressionsImpl());
		put(new SubtypeImpl());
		put(new SupertypeImpl());
	}
}
