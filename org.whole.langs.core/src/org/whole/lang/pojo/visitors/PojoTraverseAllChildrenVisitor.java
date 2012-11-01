package org.whole.lang.pojo.visitors;

import org.whole.lang.pojo.visitors.PojoIdentityUnaryVisitor;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class PojoTraverseAllChildrenVisitor extends
		PojoIdentityUnaryVisitor<IPojoVisitor> {
	public PojoTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public PojoTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Library entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getLanguageURI().accept(wGetVisitor1());
		entity.getDeclarations().accept(wGetVisitor1());
	}

	public void visit(Declarations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ProductDeclaration entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
	}

	public void visit(DataTypeDeclaration entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(EnumDeclaration entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getValues().accept(wGetVisitor1());
	}

	public void visit(AnnotationDeclaration entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getProperties().accept(wGetVisitor1());
	}

	public void visit(PojoDeclaration entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getProperties().accept(wGetVisitor1());
		entity.getConstructors().accept(wGetVisitor1());
	}

	public void visit(FactoryDeclaration entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getPrefix().accept(wGetVisitor1());
		entity.getFactoryMethods().accept(wGetVisitor1());
	}

	public void visit(FactoryMethods entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(FactoryMethod entity) {
		entity.getProductType().accept(wGetVisitor1());
		entity.getProductName().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getParameters().accept(wGetVisitor1());
	}

	public void visit(Constructors entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Constructor entity) {
		entity.getParameters().accept(wGetVisitor1());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Parameter entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
	}

	public void visit(Properties entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Property entity) {
		entity.getAnnotations().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
	}

	public void visit(ReferenceTypes entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ArrayType entity) {
		entity.getElementType().accept(wGetVisitor1());
	}

	public void visit(MapType entity) {
		entity.getKeyType().accept(wGetVisitor1());
		entity.getValueType().accept(wGetVisitor1());
	}

	public void visit(CollectionType entity) {
		entity.getCollectionInterface().accept(wGetVisitor1());
		entity.getElementType().accept(wGetVisitor1());
	}

	public void visit(Names entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Annotations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(NamedAnnotation entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(MarkerAnnotation entity) {
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(SinglePropertyAnnotation entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getPropertyValuePairs().accept(wGetVisitor1());
	}

	public void visit(PropertyValuePairs entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(PropertyValuePair entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(ArrayData entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
