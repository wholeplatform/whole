package org.whole.lang.pojo.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.pojo.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PojoEntityFactory extends GenericEntityFactory {
	public static final PojoEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static PojoEntityFactory instance(IEntityRegistryProvider provider) {
		return new PojoEntityFactory(provider);
	}

	protected PojoEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Library createLibrary() {
		return create(PojoEntityDescriptorEnum.Library);
	}

	public Library createLibrary(Annotations annotations, Name name,
			LanguageURI languageURI, Declarations declarations) {
		return create(PojoEntityDescriptorEnum.Library, annotations, name,
				languageURI, declarations);
	}

	public IEntityBuilder<Library> buildLibrary() {
		return new EntityBuilder<Library>(
				create(PojoEntityDescriptorEnum.Library));
	}

	public Declarations createDeclarations() {
		return create(PojoEntityDescriptorEnum.Declarations);
	}

	public Declarations createDeclarations(Declaration... entities) {
		return create(PojoEntityDescriptorEnum.Declarations,
				(IEntity[]) entities);
	}

	public Declarations createDeclarations(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Declarations, initialSize);
	}

	public DataTypeDeclaration createDataTypeDeclaration() {
		return create(PojoEntityDescriptorEnum.DataTypeDeclaration);
	}

	public DataTypeDeclaration createDataTypeDeclaration(
			Annotations annotations, Template template, Type name) {
		return create(PojoEntityDescriptorEnum.DataTypeDeclaration,
				annotations, template, name);
	}

	public IEntityBuilder<DataTypeDeclaration> buildDataTypeDeclaration() {
		return new EntityBuilder<DataTypeDeclaration>(
				create(PojoEntityDescriptorEnum.DataTypeDeclaration));
	}

	public EnumDeclaration createEnumDeclaration() {
		return create(PojoEntityDescriptorEnum.EnumDeclaration);
	}

	public EnumDeclaration createEnumDeclaration(Annotations annotations,
			Template template, ReferenceType name, Names values) {
		return create(PojoEntityDescriptorEnum.EnumDeclaration, annotations,
				template, name, values);
	}

	public IEntityBuilder<EnumDeclaration> buildEnumDeclaration() {
		return new EntityBuilder<EnumDeclaration>(
				create(PojoEntityDescriptorEnum.EnumDeclaration));
	}

	public AnnotationDeclaration createAnnotationDeclaration() {
		return create(PojoEntityDescriptorEnum.AnnotationDeclaration);
	}

	public AnnotationDeclaration createAnnotationDeclaration(
			Annotations annotations, Template template, ReferenceType name,
			Properties properties) {
		return create(PojoEntityDescriptorEnum.AnnotationDeclaration,
				annotations, template, name, properties);
	}

	public IEntityBuilder<AnnotationDeclaration> buildAnnotationDeclaration() {
		return new EntityBuilder<AnnotationDeclaration>(
				create(PojoEntityDescriptorEnum.AnnotationDeclaration));
	}

	public PojoDeclaration createPojoDeclaration() {
		return create(PojoEntityDescriptorEnum.PojoDeclaration);
	}

	public PojoDeclaration createPojoDeclaration(Annotations annotations,
			Template template, ReferenceType name, ReferenceTypes types,
			Properties properties, Constructors constructors) {
		return create(PojoEntityDescriptorEnum.PojoDeclaration, annotations,
				template, name, types, properties, constructors);
	}

	public IEntityBuilder<PojoDeclaration> buildPojoDeclaration() {
		return new EntityBuilder<PojoDeclaration>(
				create(PojoEntityDescriptorEnum.PojoDeclaration));
	}

	public FactoryDeclaration createFactoryDeclaration() {
		return create(PojoEntityDescriptorEnum.FactoryDeclaration);
	}

	public FactoryDeclaration createFactoryDeclaration(ReferenceType name,
			Name prefix, FactoryMethods factoryMethods) {
		return create(PojoEntityDescriptorEnum.FactoryDeclaration, name,
				prefix, factoryMethods);
	}

	public IEntityBuilder<FactoryDeclaration> buildFactoryDeclaration() {
		return new EntityBuilder<FactoryDeclaration>(
				create(PojoEntityDescriptorEnum.FactoryDeclaration));
	}

	public FactoryMethods createFactoryMethods() {
		return create(PojoEntityDescriptorEnum.FactoryMethods);
	}

	public FactoryMethods createFactoryMethods(FactoryMethod... entities) {
		return create(PojoEntityDescriptorEnum.FactoryMethods,
				(IEntity[]) entities);
	}

	public FactoryMethods createFactoryMethods(int initialSize) {
		return clone(PojoEntityDescriptorEnum.FactoryMethods, initialSize);
	}

	public FactoryMethod createFactoryMethod() {
		return create(PojoEntityDescriptorEnum.FactoryMethod);
	}

	public FactoryMethod createFactoryMethod(ReferenceType productType,
			Name productName, Name template, Parameters parameters) {
		return create(PojoEntityDescriptorEnum.FactoryMethod, productType,
				productName, template, parameters);
	}

	public IEntityBuilder<FactoryMethod> buildFactoryMethod() {
		return new EntityBuilder<FactoryMethod>(
				create(PojoEntityDescriptorEnum.FactoryMethod));
	}

	public Constructors createConstructors() {
		return create(PojoEntityDescriptorEnum.Constructors);
	}

	public Constructors createConstructors(Constructor... entities) {
		return create(PojoEntityDescriptorEnum.Constructors,
				(IEntity[]) entities);
	}

	public Constructors createConstructors(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Constructors, initialSize);
	}

	public Constructor createConstructor() {
		return create(PojoEntityDescriptorEnum.Constructor);
	}

	public Constructor createConstructor(Parameters parameters) {
		return create(PojoEntityDescriptorEnum.Constructor, parameters);
	}

	public Parameters createParameters() {
		return create(PojoEntityDescriptorEnum.Parameters);
	}

	public Parameters createParameters(Parameter... entities) {
		return create(PojoEntityDescriptorEnum.Parameters, (IEntity[]) entities);
	}

	public Parameters createParameters(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Parameters, initialSize);
	}

	public Parameter createParameter() {
		return create(PojoEntityDescriptorEnum.Parameter);
	}

	public Parameter createParameter(Annotations annotations, Type type,
			Name name, Name template) {
		return create(PojoEntityDescriptorEnum.Parameter, annotations, type,
				name, template);
	}

	public IEntityBuilder<Parameter> buildParameter() {
		return new EntityBuilder<Parameter>(
				create(PojoEntityDescriptorEnum.Parameter));
	}

	public Properties createProperties() {
		return create(PojoEntityDescriptorEnum.Properties);
	}

	public Properties createProperties(Property... entities) {
		return create(PojoEntityDescriptorEnum.Properties, (IEntity[]) entities);
	}

	public Properties createProperties(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Properties, initialSize);
	}

	public Property createProperty() {
		return create(PojoEntityDescriptorEnum.Property);
	}

	public Property createProperty(Annotations annotations, Type type,
			Name name, Name template) {
		return create(PojoEntityDescriptorEnum.Property, annotations, type,
				name, template);
	}

	public IEntityBuilder<Property> buildProperty() {
		return new EntityBuilder<Property>(
				create(PojoEntityDescriptorEnum.Property));
	}

	public ReferenceTypes createReferenceTypes() {
		return create(PojoEntityDescriptorEnum.ReferenceTypes);
	}

	public ReferenceTypes createReferenceTypes(ReferenceType... entities) {
		return create(PojoEntityDescriptorEnum.ReferenceTypes,
				(IEntity[]) entities);
	}

	public ReferenceTypes createReferenceTypes(int initialSize) {
		return clone(PojoEntityDescriptorEnum.ReferenceTypes, initialSize);
	}

	public ReferenceType createReferenceType() {
		return create(PojoEntityDescriptorEnum.ReferenceType);
	}

	public ReferenceType createReferenceType(String value) {
		return create(PojoEntityDescriptorEnum.ReferenceType, value);
	}

	public PrimitiveType createPrimitiveType() {
		return create(PojoEntityDescriptorEnum.PrimitiveType);
	}

	public PrimitiveType createPrimitiveType(PrimitiveTypeEnum.Value value) {
		return create(PojoEntityDescriptorEnum.PrimitiveType, value);
	}

	public ArrayType createArrayType() {
		return create(PojoEntityDescriptorEnum.ArrayType);
	}

	public ArrayType createArrayType(Type elementType) {
		return create(PojoEntityDescriptorEnum.ArrayType, elementType);
	}

	public MapType createMapType() {
		return create(PojoEntityDescriptorEnum.MapType);
	}

	public MapType createMapType(Type keyType, Type valueType) {
		return create(PojoEntityDescriptorEnum.MapType, keyType, valueType);
	}

	public IEntityBuilder<MapType> buildMapType() {
		return new EntityBuilder<MapType>(
				create(PojoEntityDescriptorEnum.MapType));
	}

	public CollectionType createCollectionType() {
		return create(PojoEntityDescriptorEnum.CollectionType);
	}

	public CollectionType createCollectionType(
			CollectionInterface collectionInterface, Type elementType) {
		return create(PojoEntityDescriptorEnum.CollectionType,
				collectionInterface, elementType);
	}

	public IEntityBuilder<CollectionType> buildCollectionType() {
		return new EntityBuilder<CollectionType>(
				create(PojoEntityDescriptorEnum.CollectionType));
	}

	public CollectionInterface createCollectionInterface() {
		return create(PojoEntityDescriptorEnum.CollectionInterface);
	}

	public CollectionInterface createCollectionInterface(
			CollectionInterfaceEnum.Value value) {
		return create(PojoEntityDescriptorEnum.CollectionInterface, value);
	}

	public Names createNames() {
		return create(PojoEntityDescriptorEnum.Names);
	}

	public Names createNames(Name... entities) {
		return create(PojoEntityDescriptorEnum.Names, (IEntity[]) entities);
	}

	public Names createNames(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Names, initialSize);
	}

	public Name createName() {
		return create(PojoEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(PojoEntityDescriptorEnum.Name, value);
	}

	public LanguageURI createLanguageURI() {
		return create(PojoEntityDescriptorEnum.LanguageURI);
	}

	public LanguageURI createLanguageURI(String value) {
		return create(PojoEntityDescriptorEnum.LanguageURI, value);
	}

	public Annotations createAnnotations() {
		return create(PojoEntityDescriptorEnum.Annotations);
	}

	public Annotations createAnnotations(Annotation... entities) {
		return create(PojoEntityDescriptorEnum.Annotations,
				(IEntity[]) entities);
	}

	public Annotations createAnnotations(int initialSize) {
		return clone(PojoEntityDescriptorEnum.Annotations, initialSize);
	}

	public Modifier createModifier() {
		return create(PojoEntityDescriptorEnum.Modifier);
	}

	public Modifier createModifier(ModifierEnum.Value value) {
		return create(PojoEntityDescriptorEnum.Modifier, value);
	}

	public MarkerAnnotation createMarkerAnnotation() {
		return create(PojoEntityDescriptorEnum.MarkerAnnotation);
	}

	public MarkerAnnotation createMarkerAnnotation(Name name) {
		return create(PojoEntityDescriptorEnum.MarkerAnnotation, name);
	}

	public SinglePropertyAnnotation createSinglePropertyAnnotation() {
		return create(PojoEntityDescriptorEnum.SinglePropertyAnnotation);
	}

	public SinglePropertyAnnotation createSinglePropertyAnnotation(Name name,
			PropertyValue value) {
		return create(PojoEntityDescriptorEnum.SinglePropertyAnnotation, name,
				value);
	}

	public IEntityBuilder<SinglePropertyAnnotation> buildSinglePropertyAnnotation() {
		return new EntityBuilder<SinglePropertyAnnotation>(
				create(PojoEntityDescriptorEnum.SinglePropertyAnnotation));
	}

	public MultiplePropertiesAnnotation createMultiplePropertiesAnnotation() {
		return create(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation);
	}

	public MultiplePropertiesAnnotation createMultiplePropertiesAnnotation(
			Name name, PropertyValuePairs propertyValuePairs) {
		return create(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation,
				name, propertyValuePairs);
	}

	public IEntityBuilder<MultiplePropertiesAnnotation> buildMultiplePropertiesAnnotation() {
		return new EntityBuilder<MultiplePropertiesAnnotation>(
				create(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation));
	}

	public PropertyValuePairs createPropertyValuePairs() {
		return create(PojoEntityDescriptorEnum.PropertyValuePairs);
	}

	public PropertyValuePairs createPropertyValuePairs(Constructors... entities) {
		return create(PojoEntityDescriptorEnum.PropertyValuePairs,
				(IEntity[]) entities);
	}

	public PropertyValuePairs createPropertyValuePairs(int initialSize) {
		return clone(PojoEntityDescriptorEnum.PropertyValuePairs, initialSize);
	}

	public PropertyValuePair createPropertyValuePair() {
		return create(PojoEntityDescriptorEnum.PropertyValuePair);
	}

	public PropertyValuePair createPropertyValuePair(Name name,
			PropertyValue value) {
		return create(PojoEntityDescriptorEnum.PropertyValuePair, name, value);
	}

	public IEntityBuilder<PropertyValuePair> buildPropertyValuePair() {
		return new EntityBuilder<PropertyValuePair>(
				create(PojoEntityDescriptorEnum.PropertyValuePair));
	}

	public ArrayData createArrayData() {
		return create(PojoEntityDescriptorEnum.ArrayData);
	}

	public ArrayData createArrayData(PropertyValue... entities) {
		return create(PojoEntityDescriptorEnum.ArrayData, (IEntity[]) entities);
	}

	public ArrayData createArrayData(int initialSize) {
		return clone(PojoEntityDescriptorEnum.ArrayData, initialSize);
	}

	public BooleanData createBooleanData() {
		return create(PojoEntityDescriptorEnum.BooleanData);
	}

	public BooleanData createBooleanData(boolean value) {
		return create(PojoEntityDescriptorEnum.BooleanData, value);
	}

	public ByteData createByteData() {
		return create(PojoEntityDescriptorEnum.ByteData);
	}

	public ByteData createByteData(byte value) {
		return create(PojoEntityDescriptorEnum.ByteData, value);
	}

	public CharData createCharData() {
		return create(PojoEntityDescriptorEnum.CharData);
	}

	public CharData createCharData(char value) {
		return create(PojoEntityDescriptorEnum.CharData, value);
	}

	public DoubleData createDoubleData() {
		return create(PojoEntityDescriptorEnum.DoubleData);
	}

	public DoubleData createDoubleData(double value) {
		return create(PojoEntityDescriptorEnum.DoubleData, value);
	}

	public FloatData createFloatData() {
		return create(PojoEntityDescriptorEnum.FloatData);
	}

	public FloatData createFloatData(float value) {
		return create(PojoEntityDescriptorEnum.FloatData, value);
	}

	public IntData createIntData() {
		return create(PojoEntityDescriptorEnum.IntData);
	}

	public IntData createIntData(int value) {
		return create(PojoEntityDescriptorEnum.IntData, value);
	}

	public LongData createLongData() {
		return create(PojoEntityDescriptorEnum.LongData);
	}

	public LongData createLongData(long value) {
		return create(PojoEntityDescriptorEnum.LongData, value);
	}

	public ShortData createShortData() {
		return create(PojoEntityDescriptorEnum.ShortData);
	}

	public ShortData createShortData(short value) {
		return create(PojoEntityDescriptorEnum.ShortData, value);
	}

	public StringData createStringData() {
		return create(PojoEntityDescriptorEnum.StringData);
	}

	public StringData createStringData(String value) {
		return create(PojoEntityDescriptorEnum.StringData, value);
	}
}
