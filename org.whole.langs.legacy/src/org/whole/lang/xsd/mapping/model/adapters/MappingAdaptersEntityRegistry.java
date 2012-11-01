package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingAdaptersEntityRegistry extends AbstractEntityRegistry {
	public MappingAdaptersEntityRegistry() {
		super(MappingEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new MappingStrategyAdapter());
		put(new MappingsAdapter());
		put(new TypesAdapter());
		put(new MappingAdapter());
		put(new RootMappingAdapter());
		put(new ContextMappingAdapter());
		put(new ContentMappingAdapter());
		put(new MixedStructuralMappingAdapter());
		put(new AnyMappingAdapter());
		put(new AnyStructuralMappingAdapter());
		put(new AnyElementMappingAdapter());
		put(new AnyAttributeMappingAdapter());
		put(new TypeMappingAdapter());
		put(new StructuralMappingAdapter());
		put(new ElementMappingAdapter());
		put(new AttributeMappingAdapter());
		put(new UnionMappingAdapter());
		put(new DataTypesAdapter());
		put(new DataTypeAdapter());
		put(new EnumDataTypeAdapter());
		put(new EnumValuesAdapter());
		put(new EnumValueAdapter());
		put(new CustomDataTypeAdapter());
		put(new URIAdapter());
		put(new BooleanTypeAdapter());
		put(new NCNameAdapter());
		put(new ValueAdapter());
		put(new BuiltInTypeAdapter());
	}
}
