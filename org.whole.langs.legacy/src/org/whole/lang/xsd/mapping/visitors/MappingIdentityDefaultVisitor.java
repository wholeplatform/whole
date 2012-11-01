package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.model.*;

/** 
 * @generator Whole
 */
public class MappingIdentityDefaultVisitor extends MappingIdentityVisitor {
	public void visit(IMappingEntity entity) {
	}

	public void visit(MappingStrategy entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(Mappings entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(Types entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(Mapping entity) {
	}

	public void visit(RootMapping entity) {
		visit((IMappingEntity) entity);
		visit((Mapping) entity);
	}

	public void visit(ContextMapping entity) {
		visit((Mapping) entity);
	}

	public void visit(ContentMapping entity) {
		visit((IMappingEntity) entity);
		visit((ContextMapping) entity);
	}

	public void visit(MixedStructuralMapping entity) {
		visit((IMappingEntity) entity);
		visit((ContextMapping) entity);
	}

	public void visit(AnyMapping entity) {
		visit((ContextMapping) entity);
	}

	public void visit(AnyStructuralMapping entity) {
		visit((IMappingEntity) entity);
		visit((AnyMapping) entity);
	}

	public void visit(AnyElementMapping entity) {
		visit((IMappingEntity) entity);
		visit((AnyMapping) entity);
	}

	public void visit(AnyAttributeMapping entity) {
		visit((IMappingEntity) entity);
		visit((AnyMapping) entity);
	}

	public void visit(TypeMapping entity) {
		visit((ContextMapping) entity);
	}

	public void visit(StructuralMapping entity) {
		visit((IMappingEntity) entity);
		visit((TypeMapping) entity);
	}

	public void visit(ElementMapping entity) {
		visit((IMappingEntity) entity);
		visit((TypeMapping) entity);
	}

	public void visit(AttributeMapping entity) {
		visit((IMappingEntity) entity);
		visit((TypeMapping) entity);
	}

	public void visit(UnionMapping entity) {
		visit((IMappingEntity) entity);
		visit((ContextMapping) entity);
	}

	public void visit(DataTypes entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(DataType entity) {
	}

	public void visit(EnumDataType entity) {
		visit((IMappingEntity) entity);
		visit((DataType) entity);
	}

	public void visit(EnumValues entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(EnumValue entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(CustomDataType entity) {
		visit((IMappingEntity) entity);
		visit((DataType) entity);
	}

	public void visit(URI entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(BooleanType entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(NCName entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(Value entity) {
		visit((IMappingEntity) entity);
	}

	public void visit(BuiltInType entity) {
		visit((IMappingEntity) entity);
	}
}
