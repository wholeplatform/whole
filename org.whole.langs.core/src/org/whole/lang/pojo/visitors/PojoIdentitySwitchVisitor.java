package org.whole.lang.pojo.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class PojoIdentitySwitchVisitor extends AbstractVisitor
		implements IPojoVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case PojoEntityDescriptorEnum.Library_ord:
			visit((Library) entity);
			break;
		case PojoEntityDescriptorEnum.Declarations_ord:
			visit((Declarations) entity);
			break;
		case PojoEntityDescriptorEnum.DataTypeDeclaration_ord:
			visit((DataTypeDeclaration) entity);
			break;
		case PojoEntityDescriptorEnum.EnumDeclaration_ord:
			visit((EnumDeclaration) entity);
			break;
		case PojoEntityDescriptorEnum.AnnotationDeclaration_ord:
			visit((AnnotationDeclaration) entity);
			break;
		case PojoEntityDescriptorEnum.PojoDeclaration_ord:
			visit((PojoDeclaration) entity);
			break;
		case PojoEntityDescriptorEnum.FactoryDeclaration_ord:
			visit((FactoryDeclaration) entity);
			break;
		case PojoEntityDescriptorEnum.FactoryMethods_ord:
			visit((FactoryMethods) entity);
			break;
		case PojoEntityDescriptorEnum.FactoryMethod_ord:
			visit((FactoryMethod) entity);
			break;
		case PojoEntityDescriptorEnum.Constructors_ord:
			visit((Constructors) entity);
			break;
		case PojoEntityDescriptorEnum.Constructor_ord:
			visit((Constructor) entity);
			break;
		case PojoEntityDescriptorEnum.Parameters_ord:
			visit((Parameters) entity);
			break;
		case PojoEntityDescriptorEnum.Parameter_ord:
			visit((Parameter) entity);
			break;
		case PojoEntityDescriptorEnum.Properties_ord:
			visit((Properties) entity);
			break;
		case PojoEntityDescriptorEnum.Property_ord:
			visit((Property) entity);
			break;
		case PojoEntityDescriptorEnum.ReferenceTypes_ord:
			visit((ReferenceTypes) entity);
			break;
		case PojoEntityDescriptorEnum.ReferenceType_ord:
			visit((ReferenceType) entity);
			break;
		case PojoEntityDescriptorEnum.PrimitiveType_ord:
			visit((PrimitiveType) entity);
			break;
		case PojoEntityDescriptorEnum.ArrayType_ord:
			visit((ArrayType) entity);
			break;
		case PojoEntityDescriptorEnum.MapType_ord:
			visit((MapType) entity);
			break;
		case PojoEntityDescriptorEnum.CollectionType_ord:
			visit((CollectionType) entity);
			break;
		case PojoEntityDescriptorEnum.CollectionInterface_ord:
			visit((CollectionInterface) entity);
			break;
		case PojoEntityDescriptorEnum.Names_ord:
			visit((Names) entity);
			break;
		case PojoEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case PojoEntityDescriptorEnum.LanguageURI_ord:
			visit((LanguageURI) entity);
			break;
		case PojoEntityDescriptorEnum.Annotations_ord:
			visit((Annotations) entity);
			break;
		case PojoEntityDescriptorEnum.Modifier_ord:
			visit((Modifier) entity);
			break;
		case PojoEntityDescriptorEnum.MarkerAnnotation_ord:
			visit((MarkerAnnotation) entity);
			break;
		case PojoEntityDescriptorEnum.SinglePropertyAnnotation_ord:
			visit((SinglePropertyAnnotation) entity);
			break;
		case PojoEntityDescriptorEnum.MultiplePropertiesAnnotation_ord:
			visit((MultiplePropertiesAnnotation) entity);
			break;
		case PojoEntityDescriptorEnum.PropertyValuePairs_ord:
			visit((PropertyValuePairs) entity);
			break;
		case PojoEntityDescriptorEnum.PropertyValuePair_ord:
			visit((PropertyValuePair) entity);
			break;
		case PojoEntityDescriptorEnum.ArrayData_ord:
			visit((ArrayData) entity);
			break;
		case PojoEntityDescriptorEnum.BooleanData_ord:
			visit((BooleanData) entity);
			break;
		case PojoEntityDescriptorEnum.ByteData_ord:
			visit((ByteData) entity);
			break;
		case PojoEntityDescriptorEnum.CharData_ord:
			visit((CharData) entity);
			break;
		case PojoEntityDescriptorEnum.DoubleData_ord:
			visit((DoubleData) entity);
			break;
		case PojoEntityDescriptorEnum.FloatData_ord:
			visit((FloatData) entity);
			break;
		case PojoEntityDescriptorEnum.IntData_ord:
			visit((IntData) entity);
			break;
		case PojoEntityDescriptorEnum.LongData_ord:
			visit((LongData) entity);
			break;
		case PojoEntityDescriptorEnum.ShortData_ord:
			visit((ShortData) entity);
			break;
		case PojoEntityDescriptorEnum.StringData_ord:
			visit((StringData) entity);
			break;
		}
	}
}
