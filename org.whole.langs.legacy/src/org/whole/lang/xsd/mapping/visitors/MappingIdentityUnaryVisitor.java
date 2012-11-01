package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MappingIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IMappingVisitor {
	public MappingIdentityUnaryVisitor() {
		super(null);
	}

	public MappingIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IMappingEntity) entity).accept(this);
	}

	public void visit(MappingStrategy entity) {
	}

	public void visit(Mappings entity) {
	}

	public void visit(Types entity) {
	}

	public void visit(RootMapping entity) {
	}

	public void visit(ContentMapping entity) {
	}

	public void visit(MixedStructuralMapping entity) {
	}

	public void visit(AnyStructuralMapping entity) {
	}

	public void visit(AnyElementMapping entity) {
	}

	public void visit(AnyAttributeMapping entity) {
	}

	public void visit(StructuralMapping entity) {
	}

	public void visit(ElementMapping entity) {
	}

	public void visit(AttributeMapping entity) {
	}

	public void visit(UnionMapping entity) {
	}

	public void visit(DataTypes entity) {
	}

	public void visit(EnumDataType entity) {
	}

	public void visit(EnumValues entity) {
	}

	public void visit(EnumValue entity) {
	}

	public void visit(CustomDataType entity) {
	}

	public void visit(URI entity) {
	}

	public void visit(BooleanType entity) {
	}

	public void visit(NCName entity) {
	}

	public void visit(Value entity) {
	}

	public void visit(BuiltInType entity) {
	}
}
