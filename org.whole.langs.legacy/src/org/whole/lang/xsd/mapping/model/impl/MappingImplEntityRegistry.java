package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingImplEntityRegistry extends AbstractEntityRegistry {
	public MappingImplEntityRegistry() {
		super(MappingEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new MappingStrategyImpl());
		put(new MappingsImpl());
		put(new TypesImpl());
		put(new RootMappingImpl());
		put(new ContentMappingImpl());
		put(new MixedStructuralMappingImpl());
		put(new AnyStructuralMappingImpl());
		put(new AnyElementMappingImpl());
		put(new AnyAttributeMappingImpl());
		put(new StructuralMappingImpl());
		put(new ElementMappingImpl());
		put(new AttributeMappingImpl());
		put(new UnionMappingImpl());
		put(new DataTypesImpl());
		put(new EnumDataTypeImpl());
		put(new EnumValuesImpl());
		put(new EnumValueImpl());
		put(new CustomDataTypeImpl());
		put(new URIImpl());
		put(new BooleanTypeImpl());
		put(new NCNameImpl());
		put(new ValueImpl());
		put(new BuiltInTypeImpl());
	}
}
