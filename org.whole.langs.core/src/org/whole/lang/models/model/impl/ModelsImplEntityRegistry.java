package org.whole.lang.models.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ModelsImplEntityRegistry extends AbstractEntityRegistry {
	public ModelsImplEntityRegistry() {
		super(ModelsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ModelImpl());
		put(new ModelDeclarationsImpl());
		put(new SimpleEntityImpl());
		put(new CompositeEntityImpl());
		put(new MapEntityImpl());
		put(new DataEntityImpl());
		put(new EnumEntityImpl());
		put(new EntityModifiersImpl());
		put(new EntityModifierImpl());
		put(new FeaturesImpl());
		put(new FeatureImpl());
		put(new FeatureModifiersImpl());
		put(new FeatureModifierImpl());
		put(new ComponentModifiersImpl());
		put(new ComponentModifierImpl());
		put(new DataTypeImpl());
		put(new EnumValuesImpl());
		put(new EnumValueImpl());
		put(new TypesImpl());
		put(new TypeRelationsImpl());
		put(new SupertypesOfImpl());
		put(new SubtypesOfImpl());
		put(new TypeAliasOfImpl());
		put(new AnyTypeImpl());
		put(new EntityTypeImpl());
		put(new SimpleNameImpl());
		put(new NamespaceImpl());
		put(new VersionImpl());
		put(new URIImpl());
	}
}
