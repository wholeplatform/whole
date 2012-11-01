package org.whole.lang.pojo.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.pojo.model.PrimitiveTypeEnum;
import org.whole.lang.pojo.model.CollectionInterfaceEnum;
import org.whole.lang.pojo.model.ModifierEnum;

/** 
 * @generator Whole
 */
public interface IPojoBuilder extends IBuilder {
	public void visit();

	public void propertyValuePairs();

	public void value();

	public void collectionInterface();

	public void valueType();

	public void keyType();

	public void elementType();

	public void type();

	public void parameters();

	public void productName();

	public void productType();

	public void factoryMethods();

	public void prefix();

	public void constructors();

	public void types();

	public void properties();

	public void values();

	public void template();

	public void declarations();

	public void languageURI();

	public void name();

	public void annotations();

	public void Library();

	public void Library_();

	public void _Library();

	public void Declarations();

	public void Declarations_();

	public void Declarations_(int initialCapacity);

	public void _Declarations();

	public void DataTypeDeclaration();

	public void DataTypeDeclaration_();

	public void _DataTypeDeclaration();

	public void EnumDeclaration();

	public void EnumDeclaration_();

	public void _EnumDeclaration();

	public void AnnotationDeclaration();

	public void AnnotationDeclaration_();

	public void _AnnotationDeclaration();

	public void PojoDeclaration();

	public void PojoDeclaration_();

	public void _PojoDeclaration();

	public void FactoryDeclaration();

	public void FactoryDeclaration_();

	public void _FactoryDeclaration();

	public void FactoryMethods();

	public void FactoryMethods_();

	public void FactoryMethods_(int initialCapacity);

	public void _FactoryMethods();

	public void FactoryMethod();

	public void FactoryMethod_();

	public void _FactoryMethod();

	public void Constructors();

	public void Constructors_();

	public void Constructors_(int initialCapacity);

	public void _Constructors();

	public void Constructor();

	public void Constructor_();

	public void _Constructor();

	public void Parameters();

	public void Parameters_();

	public void Parameters_(int initialCapacity);

	public void _Parameters();

	public void Parameter();

	public void Parameter_();

	public void _Parameter();

	public void Properties();

	public void Properties_();

	public void Properties_(int initialCapacity);

	public void _Properties();

	public void Property();

	public void Property_();

	public void _Property();

	public void ReferenceTypes();

	public void ReferenceTypes_();

	public void ReferenceTypes_(int initialCapacity);

	public void _ReferenceTypes();

	public void ReferenceType();

	public void ReferenceType(String value);

	public void PrimitiveType();

	public void PrimitiveType(PrimitiveTypeEnum.Value value);

	public void PrimitiveType(String value);

	public void ArrayType();

	public void ArrayType_();

	public void _ArrayType();

	public void MapType();

	public void MapType_();

	public void _MapType();

	public void CollectionType();

	public void CollectionType_();

	public void _CollectionType();

	public void CollectionInterface();

	public void CollectionInterface(CollectionInterfaceEnum.Value value);

	public void CollectionInterface(String value);

	public void Names();

	public void Names_();

	public void Names_(int initialCapacity);

	public void _Names();

	public void Name();

	public void Name(String value);

	public void LanguageURI();

	public void LanguageURI(String value);

	public void Annotations();

	public void Annotations_();

	public void Annotations_(int initialCapacity);

	public void _Annotations();

	public void Modifier();

	public void Modifier(ModifierEnum.Value value);

	public void Modifier(String value);

	public void MarkerAnnotation();

	public void MarkerAnnotation_();

	public void _MarkerAnnotation();

	public void SinglePropertyAnnotation();

	public void SinglePropertyAnnotation_();

	public void _SinglePropertyAnnotation();

	public void MultiplePropertiesAnnotation();

	public void MultiplePropertiesAnnotation_();

	public void _MultiplePropertiesAnnotation();

	public void PropertyValuePairs();

	public void PropertyValuePairs_();

	public void PropertyValuePairs_(int initialCapacity);

	public void _PropertyValuePairs();

	public void PropertyValuePair();

	public void PropertyValuePair_();

	public void _PropertyValuePair();

	public void ArrayData();

	public void ArrayData_();

	public void ArrayData_(int initialCapacity);

	public void _ArrayData();

	public void BooleanData();

	public void BooleanData(boolean value);

	public void ByteData();

	public void ByteData(byte value);

	public void CharData();

	public void CharData(char value);

	public void DoubleData();

	public void DoubleData(double value);

	public void FloatData();

	public void FloatData(float value);

	public void IntData();

	public void IntData(int value);

	public void LongData();

	public void LongData(long value);

	public void ShortData();

	public void ShortData(short value);

	public void StringData();

	public void StringData(String value);
}
