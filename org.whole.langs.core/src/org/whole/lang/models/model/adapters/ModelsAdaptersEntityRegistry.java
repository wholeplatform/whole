package org.whole.lang.models.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ModelsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public ModelsAdaptersEntityRegistry() {
		super(ModelsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ModelAdapter());
		put(new ModelDeclarationsAdapter());
		put(new ModelDeclarationAdapter());
		put(new SimpleEntityAdapter());
		put(new CompositeEntityAdapter());
		put(new MapEntityAdapter());
		put(new DataEntityAdapter());
		put(new EnumEntityAdapter());
		put(new EntityModifiersAdapter());
		put(new EntityModifierAdapter());
		put(new FeaturesAdapter());
		put(new FeatureAdapter());
		put(new FeatureModifiersAdapter());
		put(new FeatureModifierAdapter());
		put(new ComponentModifiersAdapter());
		put(new ComponentModifierAdapter());
		put(new DataTypeAdapter());
		put(new EnumValuesAdapter());
		put(new EnumValueAdapter());
		put(new TypesAdapter());
		put(new TypeRelationsAdapter());
		put(new TypeRelationAdapter());
		put(new SupertypesOfAdapter());
		put(new SubtypesOfAdapter());
		put(new TypeAliasOfAdapter());
		put(new ForeignTypeAdapter());
		put(new AnyTypeAdapter());
		put(new EntityTypeAdapter());
		put(new TypeAdapter());
		put(new SimpleNameAdapter());
		put(new NamespaceAdapter());
		put(new VersionAdapter());
		put(new URIAdapter());
	}
}
