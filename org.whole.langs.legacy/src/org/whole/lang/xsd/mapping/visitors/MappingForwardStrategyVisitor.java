package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MappingForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IMappingVisitor> implements
		IMappingVisitor {
	public MappingForwardStrategyVisitor() {
		this(new MappingIdentityVisitor());
	}

	public MappingForwardStrategyVisitor(IMappingVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IMappingEntity) entity).accept(this);
	}

	public void visit(MappingStrategy entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Mappings entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Types entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RootMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ContentMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MixedStructuralMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyStructuralMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyElementMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyAttributeMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StructuralMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ElementMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UnionMapping entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataTypes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumDataType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumValues entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CustomDataType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NCName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Value entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BuiltInType entity) {
		wGetStrategy().visit(entity);
	}
}
