package org.whole.lang.pojo.visitors;

import org.whole.lang.pojo.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class PojoFailureVisitor extends PojoIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Library entity) {
		throw new VisitException();
	}

	public void visit(Declarations entity) {
		throw new VisitException();
	}

	public void visit(DataTypeDeclaration entity) {
		throw new VisitException();
	}

	public void visit(EnumDeclaration entity) {
		throw new VisitException();
	}

	public void visit(AnnotationDeclaration entity) {
		throw new VisitException();
	}

	public void visit(PojoDeclaration entity) {
		throw new VisitException();
	}

	public void visit(FactoryDeclaration entity) {
		throw new VisitException();
	}

	public void visit(FactoryMethods entity) {
		throw new VisitException();
	}

	public void visit(FactoryMethod entity) {
		throw new VisitException();
	}

	public void visit(Constructors entity) {
		throw new VisitException();
	}

	public void visit(Constructor entity) {
		throw new VisitException();
	}

	public void visit(Parameters entity) {
		throw new VisitException();
	}

	public void visit(Parameter entity) {
		throw new VisitException();
	}

	public void visit(Properties entity) {
		throw new VisitException();
	}

	public void visit(Property entity) {
		throw new VisitException();
	}

	public void visit(ReferenceTypes entity) {
		throw new VisitException();
	}

	public void visit(ReferenceType entity) {
		throw new VisitException();
	}

	public void visit(PrimitiveType entity) {
		throw new VisitException();
	}

	public void visit(ArrayType entity) {
		throw new VisitException();
	}

	public void visit(MapType entity) {
		throw new VisitException();
	}

	public void visit(CollectionType entity) {
		throw new VisitException();
	}

	public void visit(CollectionInterface entity) {
		throw new VisitException();
	}

	public void visit(Names entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(LanguageURI entity) {
		throw new VisitException();
	}

	public void visit(Annotations entity) {
		throw new VisitException();
	}

	public void visit(Modifier entity) {
		throw new VisitException();
	}

	public void visit(MarkerAnnotation entity) {
		throw new VisitException();
	}

	public void visit(SinglePropertyAnnotation entity) {
		throw new VisitException();
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		throw new VisitException();
	}

	public void visit(PropertyValuePairs entity) {
		throw new VisitException();
	}

	public void visit(PropertyValuePair entity) {
		throw new VisitException();
	}

	public void visit(ArrayData entity) {
		throw new VisitException();
	}

	public void visit(BooleanData entity) {
		throw new VisitException();
	}

	public void visit(ByteData entity) {
		throw new VisitException();
	}

	public void visit(CharData entity) {
		throw new VisitException();
	}

	public void visit(DoubleData entity) {
		throw new VisitException();
	}

	public void visit(FloatData entity) {
		throw new VisitException();
	}

	public void visit(IntData entity) {
		throw new VisitException();
	}

	public void visit(LongData entity) {
		throw new VisitException();
	}

	public void visit(ShortData entity) {
		throw new VisitException();
	}

	public void visit(StringData entity) {
		throw new VisitException();
	}
}
