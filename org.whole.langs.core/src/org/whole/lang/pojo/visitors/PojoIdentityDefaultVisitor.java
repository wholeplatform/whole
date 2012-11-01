package org.whole.lang.pojo.visitors;

import org.whole.lang.pojo.model.*;

/** 
 * @generator Whole
 */
public class PojoIdentityDefaultVisitor extends PojoIdentityVisitor {
	public void visit(IPojoEntity entity) {
	}

	public void visit(Library entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Declarations entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Declaration entity) {
	}

	public void visit(ProductDeclaration entity) {
		visit((Declaration) entity);
	}

	public void visit(DataTypeDeclaration entity) {
		visit((IPojoEntity) entity);
		visit((ProductDeclaration) entity);
	}

	public void visit(EnumDeclaration entity) {
		visit((IPojoEntity) entity);
		visit((ProductDeclaration) entity);
	}

	public void visit(AnnotationDeclaration entity) {
		visit((IPojoEntity) entity);
		visit((ProductDeclaration) entity);
	}

	public void visit(PojoDeclaration entity) {
		visit((IPojoEntity) entity);
		visit((ProductDeclaration) entity);
	}

	public void visit(FactoryDeclaration entity) {
		visit((IPojoEntity) entity);
		visit((Declaration) entity);
	}

	public void visit(FactoryMethods entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(FactoryMethod entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Constructors entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Constructor entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Parameters entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Parameter entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Properties entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Property entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(ReferenceTypes entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(ReferenceType entity) {
		visit((IPojoEntity) entity);
		visit((Type) entity);
	}

	public void visit(PrimitiveType entity) {
		visit((IPojoEntity) entity);
		visit((Type) entity);
	}

	public void visit(ArrayType entity) {
		visit((IPojoEntity) entity);
		visit((Type) entity);
	}

	public void visit(MapType entity) {
		visit((IPojoEntity) entity);
		visit((Type) entity);
	}

	public void visit(CollectionType entity) {
		visit((IPojoEntity) entity);
		visit((Type) entity);
	}

	public void visit(CollectionInterface entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Names entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Template entity) {
	}

	public void visit(Name entity) {
		visit((IPojoEntity) entity);
		visit((Template) entity);
	}

	public void visit(LanguageURI entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Annotations entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(Modifier entity) {
		visit((IPojoEntity) entity);
		visit((Annotation) entity);
	}

	public void visit(Annotation entity) {
	}

	public void visit(NamedAnnotation entity) {
		visit((Annotation) entity);
		visit((PropertyValue) entity);
	}

	public void visit(PropertyValue entity) {
	}

	public void visit(MarkerAnnotation entity) {
		visit((IPojoEntity) entity);
		visit((NamedAnnotation) entity);
	}

	public void visit(SinglePropertyAnnotation entity) {
		visit((IPojoEntity) entity);
		visit((NamedAnnotation) entity);
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		visit((IPojoEntity) entity);
		visit((NamedAnnotation) entity);
	}

	public void visit(PropertyValuePairs entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(PropertyValuePair entity) {
		visit((IPojoEntity) entity);
	}

	public void visit(ArrayData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(BooleanData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(ByteData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(CharData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(DoubleData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(FloatData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(IntData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(LongData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(ShortData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}

	public void visit(StringData entity) {
		visit((IPojoEntity) entity);
		visit((PropertyValue) entity);
	}
}
