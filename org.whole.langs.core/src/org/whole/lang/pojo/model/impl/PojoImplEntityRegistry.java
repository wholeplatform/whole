package org.whole.lang.pojo.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PojoImplEntityRegistry extends AbstractEntityRegistry {
	public PojoImplEntityRegistry() {
		super(PojoEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new LibraryImpl());
		put(new DeclarationsImpl());
		put(new DataTypeDeclarationImpl());
		put(new EnumDeclarationImpl());
		put(new AnnotationDeclarationImpl());
		put(new PojoDeclarationImpl());
		put(new FactoryDeclarationImpl());
		put(new FactoryMethodsImpl());
		put(new FactoryMethodImpl());
		put(new ConstructorsImpl());
		put(new ConstructorImpl());
		put(new ParametersImpl());
		put(new ParameterImpl());
		put(new PropertiesImpl());
		put(new PropertyImpl());
		put(new ReferenceTypesImpl());
		put(new ReferenceTypeImpl());
		put(new PrimitiveTypeImpl());
		put(new ArrayTypeImpl());
		put(new MapTypeImpl());
		put(new CollectionTypeImpl());
		put(new CollectionInterfaceImpl());
		put(new NamesImpl());
		put(new NameImpl());
		put(new LanguageURIImpl());
		put(new AnnotationsImpl());
		put(new ModifierImpl());
		put(new MarkerAnnotationImpl());
		put(new SinglePropertyAnnotationImpl());
		put(new MultiplePropertiesAnnotationImpl());
		put(new PropertyValuePairsImpl());
		put(new PropertyValuePairImpl());
		put(new ArrayDataImpl());
		put(new BooleanDataImpl());
		put(new ByteDataImpl());
		put(new CharDataImpl());
		put(new DoubleDataImpl());
		put(new FloatDataImpl());
		put(new IntDataImpl());
		put(new LongDataImpl());
		put(new ShortDataImpl());
		put(new StringDataImpl());
	}
}
