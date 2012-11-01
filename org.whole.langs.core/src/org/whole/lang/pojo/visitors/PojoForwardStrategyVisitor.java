package org.whole.lang.pojo.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PojoForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IPojoVisitor> implements IPojoVisitor {
	public PojoForwardStrategyVisitor() {
		this(new PojoIdentityVisitor());
	}

	public PojoForwardStrategyVisitor(IPojoVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IPojoEntity) entity).accept(this);
	}

	public void visit(Library entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Declarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataTypeDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnnotationDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PojoDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FactoryDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FactoryMethods entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FactoryMethod entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Constructors entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Constructor entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Parameters entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Parameter entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Properties entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Property entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReferenceTypes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReferenceType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrimitiveType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MapType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CollectionType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CollectionInterface entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Names entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LanguageURI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Annotations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Modifier entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MarkerAnnotation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SinglePropertyAnnotation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PropertyValuePairs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PropertyValuePair entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByteData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CharData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoubleData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FloatData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LongData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ShortData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringData entity) {
		wGetStrategy().visit(entity);
	}
}
