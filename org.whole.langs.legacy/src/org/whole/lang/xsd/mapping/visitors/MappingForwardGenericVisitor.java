package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MappingForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IMappingVisitor {
	public MappingForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MappingStrategy entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Mappings entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Types entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RootMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ContentMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MixedStructuralMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnyStructuralMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnyElementMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnyAttributeMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StructuralMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ElementMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AttributeMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UnionMapping entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DataTypes entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumDataType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumValues entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CustomDataType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NCName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Value entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BuiltInType entity) {
		wGetVisitor1().visit(entity);
	}
}
