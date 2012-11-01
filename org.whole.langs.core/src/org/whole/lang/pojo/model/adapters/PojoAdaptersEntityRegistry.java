package org.whole.lang.pojo.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PojoAdaptersEntityRegistry extends AbstractEntityRegistry {
	public PojoAdaptersEntityRegistry() {
		super(PojoEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new LibraryAdapter());
		put(new DeclarationsAdapter());
		put(new DeclarationAdapter());
		put(new ProductDeclarationAdapter());
		put(new DataTypeDeclarationAdapter());
		put(new EnumDeclarationAdapter());
		put(new AnnotationDeclarationAdapter());
		put(new PojoDeclarationAdapter());
		put(new FactoryDeclarationAdapter());
		put(new FactoryMethodsAdapter());
		put(new FactoryMethodAdapter());
		put(new ConstructorsAdapter());
		put(new ConstructorAdapter());
		put(new ParametersAdapter());
		put(new ParameterAdapter());
		put(new PropertiesAdapter());
		put(new PropertyAdapter());
		put(new ReferenceTypesAdapter());
		put(new ReferenceTypeAdapter());
		put(new PrimitiveTypeAdapter());
		put(new ArrayTypeAdapter());
		put(new MapTypeAdapter());
		put(new CollectionTypeAdapter());
		put(new CollectionInterfaceAdapter());
		put(new NamesAdapter());
		put(new NameAdapter());
		put(new LanguageURIAdapter());
		put(new AnnotationsAdapter());
		put(new AnnotationAdapter());
		put(new ModifierAdapter());
		put(new NamedAnnotationAdapter());
		put(new MarkerAnnotationAdapter());
		put(new SinglePropertyAnnotationAdapter());
		put(new MultiplePropertiesAnnotationAdapter());
		put(new PropertyValuePairsAdapter());
		put(new PropertyValuePairAdapter());
		put(new ArrayDataAdapter());
		put(new BooleanDataAdapter());
		put(new ByteDataAdapter());
		put(new CharDataAdapter());
		put(new DoubleDataAdapter());
		put(new FloatDataAdapter());
		put(new IntDataAdapter());
		put(new LongDataAdapter());
		put(new ShortDataAdapter());
		put(new StringDataAdapter());
		put(new TemplateAdapter());
		put(new TypeAdapter());
		put(new PropertyValueAdapter());
	}
}
