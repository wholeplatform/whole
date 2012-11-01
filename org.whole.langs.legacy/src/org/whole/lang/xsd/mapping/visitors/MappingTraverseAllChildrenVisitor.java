package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.visitors.MappingIdentityUnaryVisitor;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class MappingTraverseAllChildrenVisitor extends
		MappingIdentityUnaryVisitor<IMappingVisitor> {
	public MappingTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public MappingTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(MappingStrategy entity) {
		entity.getNamespace().accept(wGetVisitor1());
		entity.getSchemaLocation().accept(wGetVisitor1());
		entity.getSynthesized().accept(wGetVisitor1());
		entity.getElementsFormQualified().accept(wGetVisitor1());
		entity.getAttributesFormQualified().accept(wGetVisitor1());
		entity.getMixedDataType().accept(wGetVisitor1());
		entity.getMixedTypes().accept(wGetVisitor1());
		entity.getMappings().accept(wGetVisitor1());
		entity.getDataTypes().accept(wGetVisitor1());
	}

	public void visit(Mappings entity) {
		for (Mapping child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Types entity) {
		for (URI child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(RootMapping entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
	}

	public void visit(ContextMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
	}

	public void visit(ContentMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(MixedStructuralMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(AnyMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(AnyStructuralMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(AnyElementMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(AnyAttributeMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(TypeMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(StructuralMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(ElementMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(AttributeMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getEntityType().accept(wGetVisitor1());
		entity.getFeatureType().accept(wGetVisitor1());
	}

	public void visit(UnionMapping entity) {
		entity.getContextEntityType().accept(wGetVisitor1());
		entity.getUnionTypes().accept(wGetVisitor1());
	}

	public void visit(DataTypes entity) {
		for (DataType child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(DataType entity) {
		entity.getEntityType().accept(wGetVisitor1());
	}

	public void visit(EnumDataType entity) {
		entity.getEntityType().accept(wGetVisitor1());
		entity.getEnumValues().accept(wGetVisitor1());
	}

	public void visit(EnumValues entity) {
		for (EnumValue child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(EnumValue entity) {
		entity.getEnumValue().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}

	public void visit(CustomDataType entity) {
		entity.getEntityType().accept(wGetVisitor1());
		entity.getBuiltInType().accept(wGetVisitor1());
	}
}
