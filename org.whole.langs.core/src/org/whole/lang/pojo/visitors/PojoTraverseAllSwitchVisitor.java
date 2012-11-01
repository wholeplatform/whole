package org.whole.lang.pojo.visitors;

import org.whole.lang.pojo.visitors.PojoIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.pojo.model.*;

/** 
 * @generator Whole
 */
public class PojoTraverseAllSwitchVisitor extends
		PojoIdentityUnaryVisitor<IVisitor> {
	public PojoTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Library entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getLanguageURI());
		wGetVisitor1().visit(entity.getDeclarations());
	}

	public void visit(Declarations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ProductDeclaration entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getTemplate());
	}

	public void visit(DataTypeDeclaration entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getTemplate());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(EnumDeclaration entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getTemplate());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getValues());
	}

	public void visit(AnnotationDeclaration entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getTemplate());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getProperties());
	}

	public void visit(PojoDeclaration entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getTemplate());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getProperties());
		wGetVisitor1().visit(entity.getConstructors());
	}

	public void visit(FactoryDeclaration entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getPrefix());
		wGetVisitor1().visit(entity.getFactoryMethods());
	}

	public void visit(FactoryMethods entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(FactoryMethod entity) {
		wGetVisitor1().visit(entity.getProductType());
		wGetVisitor1().visit(entity.getProductName());
		wGetVisitor1().visit(entity.getTemplate());
		wGetVisitor1().visit(entity.getParameters());
	}

	public void visit(Constructors entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Constructor entity) {
		wGetVisitor1().visit(entity.getParameters());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Parameter entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTemplate());
	}

	public void visit(Properties entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Property entity) {
		wGetVisitor1().visit(entity.getAnnotations());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTemplate());
	}

	public void visit(ReferenceTypes entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ArrayType entity) {
		wGetVisitor1().visit(entity.getElementType());
	}

	public void visit(MapType entity) {
		wGetVisitor1().visit(entity.getKeyType());
		wGetVisitor1().visit(entity.getValueType());
	}

	public void visit(CollectionType entity) {
		wGetVisitor1().visit(entity.getCollectionInterface());
		wGetVisitor1().visit(entity.getElementType());
	}

	public void visit(Names entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Annotations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(NamedAnnotation entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(MarkerAnnotation entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(SinglePropertyAnnotation entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getPropertyValuePairs());
	}

	public void visit(PropertyValuePairs entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(PropertyValuePair entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(ArrayData entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}
}
