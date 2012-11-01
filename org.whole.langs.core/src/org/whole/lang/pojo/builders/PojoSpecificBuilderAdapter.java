package org.whole.lang.pojo.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.model.PrimitiveTypeEnum;
import org.whole.lang.pojo.model.CollectionInterfaceEnum;
import org.whole.lang.pojo.model.ModifierEnum;

/** 
 * @generator Whole
 */
public class PojoSpecificBuilderAdapter extends GenericBuilderContext implements
		IPojoBuilder {
	public PojoSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public PojoSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void propertyValuePairs() {
		wFeature(PojoFeatureDescriptorEnum.propertyValuePairs);
	}

	public void value() {
		wFeature(PojoFeatureDescriptorEnum.value);
	}

	public void collectionInterface() {
		wFeature(PojoFeatureDescriptorEnum.collectionInterface);
	}

	public void valueType() {
		wFeature(PojoFeatureDescriptorEnum.valueType);
	}

	public void keyType() {
		wFeature(PojoFeatureDescriptorEnum.keyType);
	}

	public void elementType() {
		wFeature(PojoFeatureDescriptorEnum.elementType);
	}

	public void type() {
		wFeature(PojoFeatureDescriptorEnum.type);
	}

	public void parameters() {
		wFeature(PojoFeatureDescriptorEnum.parameters);
	}

	public void productName() {
		wFeature(PojoFeatureDescriptorEnum.productName);
	}

	public void productType() {
		wFeature(PojoFeatureDescriptorEnum.productType);
	}

	public void factoryMethods() {
		wFeature(PojoFeatureDescriptorEnum.factoryMethods);
	}

	public void prefix() {
		wFeature(PojoFeatureDescriptorEnum.prefix);
	}

	public void constructors() {
		wFeature(PojoFeatureDescriptorEnum.constructors);
	}

	public void types() {
		wFeature(PojoFeatureDescriptorEnum.types);
	}

	public void properties() {
		wFeature(PojoFeatureDescriptorEnum.properties);
	}

	public void values() {
		wFeature(PojoFeatureDescriptorEnum.values);
	}

	public void template() {
		wFeature(PojoFeatureDescriptorEnum.template);
	}

	public void declarations() {
		wFeature(PojoFeatureDescriptorEnum.declarations);
	}

	public void languageURI() {
		wFeature(PojoFeatureDescriptorEnum.languageURI);
	}

	public void name() {
		wFeature(PojoFeatureDescriptorEnum.name);
	}

	public void annotations() {
		wFeature(PojoFeatureDescriptorEnum.annotations);
	}

	public void visit() {
	}

	public void Library() {
		wEntity(PojoEntityDescriptorEnum.Library);
	}

	public void Library_() {
		wEntity_(PojoEntityDescriptorEnum.Library);
	}

	public void _Library() {
		_wEntity(PojoEntityDescriptorEnum.Library);
	}

	public void Declarations() {
		wEntity(PojoEntityDescriptorEnum.Declarations);
	}

	public void Declarations_() {
		wEntity_(PojoEntityDescriptorEnum.Declarations);
	}

	public void Declarations_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Declarations, initialCapacity);
	}

	public void _Declarations() {
		_wEntity(PojoEntityDescriptorEnum.Declarations);
	}

	public void DataTypeDeclaration() {
		wEntity(PojoEntityDescriptorEnum.DataTypeDeclaration);
	}

	public void DataTypeDeclaration_() {
		wEntity_(PojoEntityDescriptorEnum.DataTypeDeclaration);
	}

	public void _DataTypeDeclaration() {
		_wEntity(PojoEntityDescriptorEnum.DataTypeDeclaration);
	}

	public void EnumDeclaration() {
		wEntity(PojoEntityDescriptorEnum.EnumDeclaration);
	}

	public void EnumDeclaration_() {
		wEntity_(PojoEntityDescriptorEnum.EnumDeclaration);
	}

	public void _EnumDeclaration() {
		_wEntity(PojoEntityDescriptorEnum.EnumDeclaration);
	}

	public void AnnotationDeclaration() {
		wEntity(PojoEntityDescriptorEnum.AnnotationDeclaration);
	}

	public void AnnotationDeclaration_() {
		wEntity_(PojoEntityDescriptorEnum.AnnotationDeclaration);
	}

	public void _AnnotationDeclaration() {
		_wEntity(PojoEntityDescriptorEnum.AnnotationDeclaration);
	}

	public void PojoDeclaration() {
		wEntity(PojoEntityDescriptorEnum.PojoDeclaration);
	}

	public void PojoDeclaration_() {
		wEntity_(PojoEntityDescriptorEnum.PojoDeclaration);
	}

	public void _PojoDeclaration() {
		_wEntity(PojoEntityDescriptorEnum.PojoDeclaration);
	}

	public void FactoryDeclaration() {
		wEntity(PojoEntityDescriptorEnum.FactoryDeclaration);
	}

	public void FactoryDeclaration_() {
		wEntity_(PojoEntityDescriptorEnum.FactoryDeclaration);
	}

	public void _FactoryDeclaration() {
		_wEntity(PojoEntityDescriptorEnum.FactoryDeclaration);
	}

	public void FactoryMethods() {
		wEntity(PojoEntityDescriptorEnum.FactoryMethods);
	}

	public void FactoryMethods_() {
		wEntity_(PojoEntityDescriptorEnum.FactoryMethods);
	}

	public void FactoryMethods_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.FactoryMethods, initialCapacity);
	}

	public void _FactoryMethods() {
		_wEntity(PojoEntityDescriptorEnum.FactoryMethods);
	}

	public void FactoryMethod() {
		wEntity(PojoEntityDescriptorEnum.FactoryMethod);
	}

	public void FactoryMethod_() {
		wEntity_(PojoEntityDescriptorEnum.FactoryMethod);
	}

	public void _FactoryMethod() {
		_wEntity(PojoEntityDescriptorEnum.FactoryMethod);
	}

	public void Constructors() {
		wEntity(PojoEntityDescriptorEnum.Constructors);
	}

	public void Constructors_() {
		wEntity_(PojoEntityDescriptorEnum.Constructors);
	}

	public void Constructors_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Constructors, initialCapacity);
	}

	public void _Constructors() {
		_wEntity(PojoEntityDescriptorEnum.Constructors);
	}

	public void Constructor() {
		wEntity(PojoEntityDescriptorEnum.Constructor);
	}

	public void Constructor_() {
		wEntity_(PojoEntityDescriptorEnum.Constructor);
	}

	public void _Constructor() {
		_wEntity(PojoEntityDescriptorEnum.Constructor);
	}

	public void Parameters() {
		wEntity(PojoEntityDescriptorEnum.Parameters);
	}

	public void Parameters_() {
		wEntity_(PojoEntityDescriptorEnum.Parameters);
	}

	public void Parameters_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Parameters, initialCapacity);
	}

	public void _Parameters() {
		_wEntity(PojoEntityDescriptorEnum.Parameters);
	}

	public void Parameter() {
		wEntity(PojoEntityDescriptorEnum.Parameter);
	}

	public void Parameter_() {
		wEntity_(PojoEntityDescriptorEnum.Parameter);
	}

	public void _Parameter() {
		_wEntity(PojoEntityDescriptorEnum.Parameter);
	}

	public void Properties() {
		wEntity(PojoEntityDescriptorEnum.Properties);
	}

	public void Properties_() {
		wEntity_(PojoEntityDescriptorEnum.Properties);
	}

	public void Properties_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Properties, initialCapacity);
	}

	public void _Properties() {
		_wEntity(PojoEntityDescriptorEnum.Properties);
	}

	public void Property() {
		wEntity(PojoEntityDescriptorEnum.Property);
	}

	public void Property_() {
		wEntity_(PojoEntityDescriptorEnum.Property);
	}

	public void _Property() {
		_wEntity(PojoEntityDescriptorEnum.Property);
	}

	public void ReferenceTypes() {
		wEntity(PojoEntityDescriptorEnum.ReferenceTypes);
	}

	public void ReferenceTypes_() {
		wEntity_(PojoEntityDescriptorEnum.ReferenceTypes);
	}

	public void ReferenceTypes_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.ReferenceTypes, initialCapacity);
	}

	public void _ReferenceTypes() {
		_wEntity(PojoEntityDescriptorEnum.ReferenceTypes);
	}

	public void ReferenceType() {
		wEntity(PojoEntityDescriptorEnum.ReferenceType);
	}

	public void ReferenceType(String value) {
		wEntity(PojoEntityDescriptorEnum.ReferenceType, value);
	}

	public void PrimitiveType() {
		wEntity(PojoEntityDescriptorEnum.PrimitiveType);
	}

	public void PrimitiveType(PrimitiveTypeEnum.Value value) {
		wEntity(PojoEntityDescriptorEnum.PrimitiveType, value);
	}

	public void PrimitiveType(String value) {
		wEntity(PojoEntityDescriptorEnum.PrimitiveType, value);
	}

	public void ArrayType() {
		wEntity(PojoEntityDescriptorEnum.ArrayType);
	}

	public void ArrayType_() {
		wEntity_(PojoEntityDescriptorEnum.ArrayType);
	}

	public void _ArrayType() {
		_wEntity(PojoEntityDescriptorEnum.ArrayType);
	}

	public void MapType() {
		wEntity(PojoEntityDescriptorEnum.MapType);
	}

	public void MapType_() {
		wEntity_(PojoEntityDescriptorEnum.MapType);
	}

	public void _MapType() {
		_wEntity(PojoEntityDescriptorEnum.MapType);
	}

	public void CollectionType() {
		wEntity(PojoEntityDescriptorEnum.CollectionType);
	}

	public void CollectionType_() {
		wEntity_(PojoEntityDescriptorEnum.CollectionType);
	}

	public void _CollectionType() {
		_wEntity(PojoEntityDescriptorEnum.CollectionType);
	}

	public void CollectionInterface() {
		wEntity(PojoEntityDescriptorEnum.CollectionInterface);
	}

	public void CollectionInterface(CollectionInterfaceEnum.Value value) {
		wEntity(PojoEntityDescriptorEnum.CollectionInterface, value);
	}

	public void CollectionInterface(String value) {
		wEntity(PojoEntityDescriptorEnum.CollectionInterface, value);
	}

	public void Names() {
		wEntity(PojoEntityDescriptorEnum.Names);
	}

	public void Names_() {
		wEntity_(PojoEntityDescriptorEnum.Names);
	}

	public void Names_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Names, initialCapacity);
	}

	public void _Names() {
		_wEntity(PojoEntityDescriptorEnum.Names);
	}

	public void Name() {
		wEntity(PojoEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(PojoEntityDescriptorEnum.Name, value);
	}

	public void LanguageURI() {
		wEntity(PojoEntityDescriptorEnum.LanguageURI);
	}

	public void LanguageURI(String value) {
		wEntity(PojoEntityDescriptorEnum.LanguageURI, value);
	}

	public void Annotations() {
		wEntity(PojoEntityDescriptorEnum.Annotations);
	}

	public void Annotations_() {
		wEntity_(PojoEntityDescriptorEnum.Annotations);
	}

	public void Annotations_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.Annotations, initialCapacity);
	}

	public void _Annotations() {
		_wEntity(PojoEntityDescriptorEnum.Annotations);
	}

	public void Modifier() {
		wEntity(PojoEntityDescriptorEnum.Modifier);
	}

	public void Modifier(ModifierEnum.Value value) {
		wEntity(PojoEntityDescriptorEnum.Modifier, value);
	}

	public void Modifier(String value) {
		wEntity(PojoEntityDescriptorEnum.Modifier, value);
	}

	public void MarkerAnnotation() {
		wEntity(PojoEntityDescriptorEnum.MarkerAnnotation);
	}

	public void MarkerAnnotation_() {
		wEntity_(PojoEntityDescriptorEnum.MarkerAnnotation);
	}

	public void _MarkerAnnotation() {
		_wEntity(PojoEntityDescriptorEnum.MarkerAnnotation);
	}

	public void SinglePropertyAnnotation() {
		wEntity(PojoEntityDescriptorEnum.SinglePropertyAnnotation);
	}

	public void SinglePropertyAnnotation_() {
		wEntity_(PojoEntityDescriptorEnum.SinglePropertyAnnotation);
	}

	public void _SinglePropertyAnnotation() {
		_wEntity(PojoEntityDescriptorEnum.SinglePropertyAnnotation);
	}

	public void MultiplePropertiesAnnotation() {
		wEntity(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation);
	}

	public void MultiplePropertiesAnnotation_() {
		wEntity_(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation);
	}

	public void _MultiplePropertiesAnnotation() {
		_wEntity(PojoEntityDescriptorEnum.MultiplePropertiesAnnotation);
	}

	public void PropertyValuePairs() {
		wEntity(PojoEntityDescriptorEnum.PropertyValuePairs);
	}

	public void PropertyValuePairs_() {
		wEntity_(PojoEntityDescriptorEnum.PropertyValuePairs);
	}

	public void PropertyValuePairs_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.PropertyValuePairs, initialCapacity);
	}

	public void _PropertyValuePairs() {
		_wEntity(PojoEntityDescriptorEnum.PropertyValuePairs);
	}

	public void PropertyValuePair() {
		wEntity(PojoEntityDescriptorEnum.PropertyValuePair);
	}

	public void PropertyValuePair_() {
		wEntity_(PojoEntityDescriptorEnum.PropertyValuePair);
	}

	public void _PropertyValuePair() {
		_wEntity(PojoEntityDescriptorEnum.PropertyValuePair);
	}

	public void ArrayData() {
		wEntity(PojoEntityDescriptorEnum.ArrayData);
	}

	public void ArrayData_() {
		wEntity_(PojoEntityDescriptorEnum.ArrayData);
	}

	public void ArrayData_(int initialCapacity) {
		wEntity_(PojoEntityDescriptorEnum.ArrayData, initialCapacity);
	}

	public void _ArrayData() {
		_wEntity(PojoEntityDescriptorEnum.ArrayData);
	}

	public void BooleanData() {
		wEntity(PojoEntityDescriptorEnum.BooleanData);
	}

	public void BooleanData(boolean value) {
		wEntity(PojoEntityDescriptorEnum.BooleanData, value);
	}

	public void ByteData() {
		wEntity(PojoEntityDescriptorEnum.ByteData);
	}

	public void ByteData(byte value) {
		wEntity(PojoEntityDescriptorEnum.ByteData, value);
	}

	public void CharData() {
		wEntity(PojoEntityDescriptorEnum.CharData);
	}

	public void CharData(char value) {
		wEntity(PojoEntityDescriptorEnum.CharData, value);
	}

	public void DoubleData() {
		wEntity(PojoEntityDescriptorEnum.DoubleData);
	}

	public void DoubleData(double value) {
		wEntity(PojoEntityDescriptorEnum.DoubleData, value);
	}

	public void FloatData() {
		wEntity(PojoEntityDescriptorEnum.FloatData);
	}

	public void FloatData(float value) {
		wEntity(PojoEntityDescriptorEnum.FloatData, value);
	}

	public void IntData() {
		wEntity(PojoEntityDescriptorEnum.IntData);
	}

	public void IntData(int value) {
		wEntity(PojoEntityDescriptorEnum.IntData, value);
	}

	public void LongData() {
		wEntity(PojoEntityDescriptorEnum.LongData);
	}

	public void LongData(long value) {
		wEntity(PojoEntityDescriptorEnum.LongData, value);
	}

	public void ShortData() {
		wEntity(PojoEntityDescriptorEnum.ShortData);
	}

	public void ShortData(short value) {
		wEntity(PojoEntityDescriptorEnum.ShortData, value);
	}

	public void StringData() {
		wEntity(PojoEntityDescriptorEnum.StringData);
	}

	public void StringData(String value) {
		wEntity(PojoEntityDescriptorEnum.StringData, value);
	}
}
