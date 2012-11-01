package org.whole.lang.pojo.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.pojo.model.PrimitiveTypeEnum.Value;

/** 
 * @generator Whole
 */
public class PojoGenericBuilderAdapter extends GenericIdentityBuilder {
	private IPojoBuilder specificBuilder;

	public PojoGenericBuilderAdapter(IPojoBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public PojoGenericBuilderAdapter(IPojoBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case PojoFeatureDescriptorEnum.annotations_ord:
			specificBuilder.annotations();
			break;
		case PojoFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case PojoFeatureDescriptorEnum.languageURI_ord:
			specificBuilder.languageURI();
			break;
		case PojoFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case PojoFeatureDescriptorEnum.template_ord:
			specificBuilder.template();
			break;
		case PojoFeatureDescriptorEnum.values_ord:
			specificBuilder.values();
			break;
		case PojoFeatureDescriptorEnum.properties_ord:
			specificBuilder.properties();
			break;
		case PojoFeatureDescriptorEnum.types_ord:
			specificBuilder.types();
			break;
		case PojoFeatureDescriptorEnum.constructors_ord:
			specificBuilder.constructors();
			break;
		case PojoFeatureDescriptorEnum.prefix_ord:
			specificBuilder.prefix();
			break;
		case PojoFeatureDescriptorEnum.factoryMethods_ord:
			specificBuilder.factoryMethods();
			break;
		case PojoFeatureDescriptorEnum.productType_ord:
			specificBuilder.productType();
			break;
		case PojoFeatureDescriptorEnum.productName_ord:
			specificBuilder.productName();
			break;
		case PojoFeatureDescriptorEnum.parameters_ord:
			specificBuilder.parameters();
			break;
		case PojoFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case PojoFeatureDescriptorEnum.elementType_ord:
			specificBuilder.elementType();
			break;
		case PojoFeatureDescriptorEnum.keyType_ord:
			specificBuilder.keyType();
			break;
		case PojoFeatureDescriptorEnum.valueType_ord:
			specificBuilder.valueType();
			break;
		case PojoFeatureDescriptorEnum.collectionInterface_ord:
			specificBuilder.collectionInterface();
			break;
		case PojoFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case PojoFeatureDescriptorEnum.propertyValuePairs_ord:
			specificBuilder.propertyValuePairs();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.Library_ord:
			specificBuilder.Library();
			break;
		case PojoEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations();
			break;
		case PojoEntityDescriptorEnum.DataTypeDeclaration_ord:
			specificBuilder.DataTypeDeclaration();
			break;
		case PojoEntityDescriptorEnum.EnumDeclaration_ord:
			specificBuilder.EnumDeclaration();
			break;
		case PojoEntityDescriptorEnum.AnnotationDeclaration_ord:
			specificBuilder.AnnotationDeclaration();
			break;
		case PojoEntityDescriptorEnum.PojoDeclaration_ord:
			specificBuilder.PojoDeclaration();
			break;
		case PojoEntityDescriptorEnum.FactoryDeclaration_ord:
			specificBuilder.FactoryDeclaration();
			break;
		case PojoEntityDescriptorEnum.FactoryMethods_ord:
			specificBuilder.FactoryMethods();
			break;
		case PojoEntityDescriptorEnum.FactoryMethod_ord:
			specificBuilder.FactoryMethod();
			break;
		case PojoEntityDescriptorEnum.Constructors_ord:
			specificBuilder.Constructors();
			break;
		case PojoEntityDescriptorEnum.Constructor_ord:
			specificBuilder.Constructor();
			break;
		case PojoEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters();
			break;
		case PojoEntityDescriptorEnum.Parameter_ord:
			specificBuilder.Parameter();
			break;
		case PojoEntityDescriptorEnum.Properties_ord:
			specificBuilder.Properties();
			break;
		case PojoEntityDescriptorEnum.Property_ord:
			specificBuilder.Property();
			break;
		case PojoEntityDescriptorEnum.ReferenceTypes_ord:
			specificBuilder.ReferenceTypes();
			break;
		case PojoEntityDescriptorEnum.ArrayType_ord:
			specificBuilder.ArrayType();
			break;
		case PojoEntityDescriptorEnum.MapType_ord:
			specificBuilder.MapType();
			break;
		case PojoEntityDescriptorEnum.CollectionType_ord:
			specificBuilder.CollectionType();
			break;
		case PojoEntityDescriptorEnum.Names_ord:
			specificBuilder.Names();
			break;
		case PojoEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations();
			break;
		case PojoEntityDescriptorEnum.MarkerAnnotation_ord:
			specificBuilder.MarkerAnnotation();
			break;
		case PojoEntityDescriptorEnum.SinglePropertyAnnotation_ord:
			specificBuilder.SinglePropertyAnnotation();
			break;
		case PojoEntityDescriptorEnum.MultiplePropertiesAnnotation_ord:
			specificBuilder.MultiplePropertiesAnnotation();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePairs_ord:
			specificBuilder.PropertyValuePairs();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePair_ord:
			specificBuilder.PropertyValuePair();
			break;
		case PojoEntityDescriptorEnum.ArrayData_ord:
			specificBuilder.ArrayData();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.Library_ord:
			specificBuilder.Library_();
			break;
		case PojoEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_();
			break;
		case PojoEntityDescriptorEnum.DataTypeDeclaration_ord:
			specificBuilder.DataTypeDeclaration_();
			break;
		case PojoEntityDescriptorEnum.EnumDeclaration_ord:
			specificBuilder.EnumDeclaration_();
			break;
		case PojoEntityDescriptorEnum.AnnotationDeclaration_ord:
			specificBuilder.AnnotationDeclaration_();
			break;
		case PojoEntityDescriptorEnum.PojoDeclaration_ord:
			specificBuilder.PojoDeclaration_();
			break;
		case PojoEntityDescriptorEnum.FactoryDeclaration_ord:
			specificBuilder.FactoryDeclaration_();
			break;
		case PojoEntityDescriptorEnum.FactoryMethods_ord:
			specificBuilder.FactoryMethods_();
			break;
		case PojoEntityDescriptorEnum.FactoryMethod_ord:
			specificBuilder.FactoryMethod_();
			break;
		case PojoEntityDescriptorEnum.Constructors_ord:
			specificBuilder.Constructors_();
			break;
		case PojoEntityDescriptorEnum.Constructor_ord:
			specificBuilder.Constructor_();
			break;
		case PojoEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_();
			break;
		case PojoEntityDescriptorEnum.Parameter_ord:
			specificBuilder.Parameter_();
			break;
		case PojoEntityDescriptorEnum.Properties_ord:
			specificBuilder.Properties_();
			break;
		case PojoEntityDescriptorEnum.Property_ord:
			specificBuilder.Property_();
			break;
		case PojoEntityDescriptorEnum.ReferenceTypes_ord:
			specificBuilder.ReferenceTypes_();
			break;
		case PojoEntityDescriptorEnum.ArrayType_ord:
			specificBuilder.ArrayType_();
			break;
		case PojoEntityDescriptorEnum.MapType_ord:
			specificBuilder.MapType_();
			break;
		case PojoEntityDescriptorEnum.CollectionType_ord:
			specificBuilder.CollectionType_();
			break;
		case PojoEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_();
			break;
		case PojoEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations_();
			break;
		case PojoEntityDescriptorEnum.MarkerAnnotation_ord:
			specificBuilder.MarkerAnnotation_();
			break;
		case PojoEntityDescriptorEnum.SinglePropertyAnnotation_ord:
			specificBuilder.SinglePropertyAnnotation_();
			break;
		case PojoEntityDescriptorEnum.MultiplePropertiesAnnotation_ord:
			specificBuilder.MultiplePropertiesAnnotation_();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePairs_ord:
			specificBuilder.PropertyValuePairs_();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePair_ord:
			specificBuilder.PropertyValuePair_();
			break;
		case PojoEntityDescriptorEnum.ArrayData_ord:
			specificBuilder.ArrayData_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.Library_ord:
			specificBuilder._Library();
			break;
		case PojoEntityDescriptorEnum.Declarations_ord:
			specificBuilder._Declarations();
			break;
		case PojoEntityDescriptorEnum.DataTypeDeclaration_ord:
			specificBuilder._DataTypeDeclaration();
			break;
		case PojoEntityDescriptorEnum.EnumDeclaration_ord:
			specificBuilder._EnumDeclaration();
			break;
		case PojoEntityDescriptorEnum.AnnotationDeclaration_ord:
			specificBuilder._AnnotationDeclaration();
			break;
		case PojoEntityDescriptorEnum.PojoDeclaration_ord:
			specificBuilder._PojoDeclaration();
			break;
		case PojoEntityDescriptorEnum.FactoryDeclaration_ord:
			specificBuilder._FactoryDeclaration();
			break;
		case PojoEntityDescriptorEnum.FactoryMethods_ord:
			specificBuilder._FactoryMethods();
			break;
		case PojoEntityDescriptorEnum.FactoryMethod_ord:
			specificBuilder._FactoryMethod();
			break;
		case PojoEntityDescriptorEnum.Constructors_ord:
			specificBuilder._Constructors();
			break;
		case PojoEntityDescriptorEnum.Constructor_ord:
			specificBuilder._Constructor();
			break;
		case PojoEntityDescriptorEnum.Parameters_ord:
			specificBuilder._Parameters();
			break;
		case PojoEntityDescriptorEnum.Parameter_ord:
			specificBuilder._Parameter();
			break;
		case PojoEntityDescriptorEnum.Properties_ord:
			specificBuilder._Properties();
			break;
		case PojoEntityDescriptorEnum.Property_ord:
			specificBuilder._Property();
			break;
		case PojoEntityDescriptorEnum.ReferenceTypes_ord:
			specificBuilder._ReferenceTypes();
			break;
		case PojoEntityDescriptorEnum.ArrayType_ord:
			specificBuilder._ArrayType();
			break;
		case PojoEntityDescriptorEnum.MapType_ord:
			specificBuilder._MapType();
			break;
		case PojoEntityDescriptorEnum.CollectionType_ord:
			specificBuilder._CollectionType();
			break;
		case PojoEntityDescriptorEnum.Names_ord:
			specificBuilder._Names();
			break;
		case PojoEntityDescriptorEnum.Annotations_ord:
			specificBuilder._Annotations();
			break;
		case PojoEntityDescriptorEnum.MarkerAnnotation_ord:
			specificBuilder._MarkerAnnotation();
			break;
		case PojoEntityDescriptorEnum.SinglePropertyAnnotation_ord:
			specificBuilder._SinglePropertyAnnotation();
			break;
		case PojoEntityDescriptorEnum.MultiplePropertiesAnnotation_ord:
			specificBuilder._MultiplePropertiesAnnotation();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePairs_ord:
			specificBuilder._PropertyValuePairs();
			break;
		case PojoEntityDescriptorEnum.PropertyValuePair_ord:
			specificBuilder._PropertyValuePair();
			break;
		case PojoEntityDescriptorEnum.ArrayData_ord:
			specificBuilder._ArrayData();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.FactoryMethods_ord:
			specificBuilder.FactoryMethods_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.Constructors_ord:
			specificBuilder.Constructors_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.Parameters_ord:
			specificBuilder.Parameters_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.Properties_ord:
			specificBuilder.Properties_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.ReferenceTypes_ord:
			specificBuilder.ReferenceTypes_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.Annotations_ord:
			specificBuilder.Annotations_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.PropertyValuePairs_ord:
			specificBuilder.PropertyValuePairs_(initialCapacity);
			break;
		case PojoEntityDescriptorEnum.ArrayData_ord:
			specificBuilder.ArrayData_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.ReferenceType_ord:
			specificBuilder.ReferenceType(value);
			break;
		case PojoEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case PojoEntityDescriptorEnum.LanguageURI_ord:
			specificBuilder.LanguageURI(value);
			break;
		case PojoEntityDescriptorEnum.StringData_ord:
			specificBuilder.StringData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.PrimitiveType_ord:
			specificBuilder.PrimitiveType((Value) value);
			break;
		case PojoEntityDescriptorEnum.CollectionInterface_ord:
			specificBuilder
					.CollectionInterface((org.whole.lang.pojo.model.CollectionInterfaceEnum.Value) value);
			break;
		case PojoEntityDescriptorEnum.Modifier_ord:
			specificBuilder
					.Modifier((org.whole.lang.pojo.model.ModifierEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.BooleanData_ord:
			specificBuilder.BooleanData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.ByteData_ord:
			specificBuilder.ByteData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, char value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.CharData_ord:
			specificBuilder.CharData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.DoubleData_ord:
			specificBuilder.DoubleData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, float value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.FloatData_ord:
			specificBuilder.FloatData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.IntData_ord:
			specificBuilder.IntData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, long value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.LongData_ord:
			specificBuilder.LongData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, short value) {
		switch (entityDesc.getOrdinal()) {
		case PojoEntityDescriptorEnum.ShortData_ord:
			specificBuilder.ShortData(value);
			break;
		}
	}
}
