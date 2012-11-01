package org.whole.lang.pojo.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.pojo.model.*;

/** 
 * @generator Whole
 */
public interface IPojoVisitor extends IVisitor {
	public void visit(Library entity);

	public void visit(Declarations entity);

	public void visit(DataTypeDeclaration entity);

	public void visit(EnumDeclaration entity);

	public void visit(AnnotationDeclaration entity);

	public void visit(PojoDeclaration entity);

	public void visit(FactoryDeclaration entity);

	public void visit(FactoryMethods entity);

	public void visit(FactoryMethod entity);

	public void visit(Constructors entity);

	public void visit(Constructor entity);

	public void visit(Parameters entity);

	public void visit(Parameter entity);

	public void visit(Properties entity);

	public void visit(Property entity);

	public void visit(ReferenceTypes entity);

	public void visit(ReferenceType entity);

	public void visit(PrimitiveType entity);

	public void visit(ArrayType entity);

	public void visit(MapType entity);

	public void visit(CollectionType entity);

	public void visit(CollectionInterface entity);

	public void visit(Names entity);

	public void visit(Name entity);

	public void visit(LanguageURI entity);

	public void visit(Annotations entity);

	public void visit(Modifier entity);

	public void visit(MarkerAnnotation entity);

	public void visit(SinglePropertyAnnotation entity);

	public void visit(MultiplePropertiesAnnotation entity);

	public void visit(PropertyValuePairs entity);

	public void visit(PropertyValuePair entity);

	public void visit(ArrayData entity);

	public void visit(BooleanData entity);

	public void visit(ByteData entity);

	public void visit(CharData entity);

	public void visit(DoubleData entity);

	public void visit(FloatData entity);

	public void visit(IntData entity);

	public void visit(LongData entity);

	public void visit(ShortData entity);

	public void visit(StringData entity);
}
