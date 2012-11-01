package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.model.*;

/** 
 * @generator Whole
 */
public class MappingForwardStagedVisitor extends MappingIdentityVisitor {
	public void visit(MappingStrategy entity) {
		stagedVisit(entity);
	}

	public void visit(Mappings entity) {
		stagedVisit(entity);
	}

	public void visit(Types entity) {
		stagedVisit(entity);
	}

	public void visit(RootMapping entity) {
		stagedVisit(entity);
	}

	public void visit(ContentMapping entity) {
		stagedVisit(entity);
	}

	public void visit(MixedStructuralMapping entity) {
		stagedVisit(entity);
	}

	public void visit(AnyStructuralMapping entity) {
		stagedVisit(entity);
	}

	public void visit(AnyElementMapping entity) {
		stagedVisit(entity);
	}

	public void visit(AnyAttributeMapping entity) {
		stagedVisit(entity);
	}

	public void visit(StructuralMapping entity) {
		stagedVisit(entity);
	}

	public void visit(ElementMapping entity) {
		stagedVisit(entity);
	}

	public void visit(AttributeMapping entity) {
		stagedVisit(entity);
	}

	public void visit(UnionMapping entity) {
		stagedVisit(entity);
	}

	public void visit(DataTypes entity) {
		stagedVisit(entity);
	}

	public void visit(EnumDataType entity) {
		stagedVisit(entity);
	}

	public void visit(EnumValues entity) {
		stagedVisit(entity);
	}

	public void visit(EnumValue entity) {
		stagedVisit(entity);
	}

	public void visit(CustomDataType entity) {
		stagedVisit(entity);
	}

	public void visit(URI entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanType entity) {
		stagedVisit(entity);
	}

	public void visit(NCName entity) {
		stagedVisit(entity);
	}

	public void visit(Value entity) {
		stagedVisit(entity);
	}

	public void visit(BuiltInType entity) {
		stagedVisit(entity);
	}
}
